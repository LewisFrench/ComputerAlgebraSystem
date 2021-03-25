package expression;

import java.util.ArrayList;
import java.util.HashMap;

import Arithmetic.ArithmeticBaseVisitor;
import Arithmetic.ArithmeticLexer;
import Arithmetic.ArithmeticParser;

public class BuildLhsVisitor extends ArithmeticBaseVisitor<ExpressionNode> {
	HashMap<String, ExpressionNode> variables;

	public BuildLhsVisitor(HashMap<String, ExpressionNode> variables) {
		this.variables = variables;
	}

	@Override
	public ExpressionNode visitCompileUnit(ArithmeticParser.CompileUnitContext context) {
		return visit(context.expression());

	}

	@Override
	public ExpressionNode visitNumber(ArithmeticParser.NumberContext context) {
		this.variables.put(context.value.getText(), new NumberNode(Double.valueOf(context.value.getText())));
		return new NumberNode(Double.valueOf(context.value.getText()));
	}

	@Override
	public ExpressionNode visitParenthetical(ArithmeticParser.ParentheticalContext context) {
		return new ParentheticalNode(visit(context.expression()));
	}

	@Override
	public ExpressionNode visitOperation(ArithmeticParser.OperationContext context) {

		OperationNode node = null;
		switch (context.op.getType()) {

		case ArithmeticLexer.OP_POW:
			node = new PowerNode();
			break;
		case ArithmeticLexer.OP_ADD:
			node = new AdditionNode();

			break;

		case ArithmeticLexer.OP_SUB:
			node = new SubtractionNode();

			break;

		case ArithmeticLexer.OP_MUL:
			node = new MultiplicationNode();
			break;

		case ArithmeticLexer.OP_DIV:
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
	public ExpressionNode visitUnaryExpression(ArithmeticParser.UnaryExpressionContext context) {

		ExpressionNode node = null;
		switch (context.op.getType()) {
		case ArithmeticLexer.OP_ADD:
			node = visit(context.expression());
			break;

		case ArithmeticLexer.OP_SUB:

			node = new UnaryNode(visit(context.expression()));
			break;

		default:
			System.out.println("Unary Number");
		}
		return node;
	}

	@Override
	public ExpressionNode visitRuleVariable(ArithmeticParser.RuleVariableContext context) {
		variables.put(context.getText(), null);

		return new RuleVariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitVariable(ArithmeticParser.VariableContext context) {
		return new VariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitFunctionExpression(ArithmeticParser.FunctionExpressionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}

		FunctionNode f = new FunctionNode(context.func.getText(), arguments);
		return f;

	}

}
