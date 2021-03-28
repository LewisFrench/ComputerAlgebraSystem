package expression;

import java.util.ArrayList;
import java.util.HashMap;

import RuleAlgebra.RuleAlgebraBaseVisitor;
import RuleAlgebra.RuleAlgebraLexer;
import RuleAlgebra.RuleAlgebraParser;

public class BuildLhsVisitor extends RuleAlgebraBaseVisitor<ExpressionNode> {
	HashMap<String, ExpressionNode> variables;

	public BuildLhsVisitor(HashMap<String, ExpressionNode> variables) {
		this.variables = variables;
	}

	@Override
	public ExpressionNode visitRuleTerm(RuleAlgebraParser.RuleTermContext context) {
		return visit(context.expression());
	}

	@Override
	public ExpressionNode visitNumber(RuleAlgebraParser.NumberContext context) {
		this.variables.put(context.value.getText(), new NumberNode(Double.valueOf(context.value.getText())));
		return new NumberNode(Double.valueOf(context.value.getText()));
	}

	@Override
	public ExpressionNode visitParenthetical(RuleAlgebraParser.ParentheticalContext context) {
		return new ParentheticalNode(visit(context.expression()));
	}

	@Override
	public ExpressionNode visitOperation(RuleAlgebraParser.OperationContext context) {

		OperationNode node = null;
		switch (context.op.getType()) {

		case RuleAlgebraLexer.OP_POW:
			node = new PowerNode();
			break;
		case RuleAlgebraLexer.OP_ADD:
			node = new AdditionNode();

			break;

		case RuleAlgebraLexer.OP_SUB:
			node = new SubtractionNode();

			break;

		case RuleAlgebraLexer.OP_MUL:
			node = new MultiplicationNode();
			break;

		case RuleAlgebraLexer.OP_DIV:
			node = new DivisionNode();
			break;

		default:
			System.out.println("FAIL");
		}

		node.Left = visit(context.left);
		node.Right = visit(context.right);

		return node;
	}

	@Override
	public ExpressionNode visitUnaryExpression(RuleAlgebraParser.UnaryExpressionContext context) {

		ExpressionNode node = null;
		switch (context.op.getType()) {
		case RuleAlgebraLexer.OP_ADD:
			node = visit(context.expression());
			break;

		case RuleAlgebraLexer.OP_SUB:

			node = new UnaryNode(visit(context.expression()));
			break;

		default:
			System.out.println("Unary Number");
		}
		return node;
	}

	@Override
	public ExpressionNode visitRuleVariable(RuleAlgebraParser.RuleVariableContext context) {
		variables.put(context.getText(), null);

		return new RuleVariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitVariable(RuleAlgebraParser.VariableContext context) {
		return new VariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitFunctionExpression(RuleAlgebraParser.FunctionExpressionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}

		FunctionNode f = new FunctionNode(context.func.getText(), arguments);
		return f;

	}

}
