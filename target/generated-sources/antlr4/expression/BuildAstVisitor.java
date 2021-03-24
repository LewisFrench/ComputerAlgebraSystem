package expression;

import java.util.ArrayList;
import Arithmetic.ArithmeticBaseVisitor;
import Arithmetic.ArithmeticLexer;
import Arithmetic.ArithmeticParser;

public class BuildAstVisitor extends ArithmeticBaseVisitor<ExpressionNode> {

	@Override
	public ExpressionNode visitCompileUnit(ArithmeticParser.CompileUnitContext context) {
		return visit(context.expression());

	}

	@Override
	public ExpressionNode visitNumber(ArithmeticParser.NumberContext context) {
		NumberNode node = new NumberNode(Double.valueOf(context.value.getText()));
		return node;
	}

	@Override
	public ExpressionNode visitVariable(ArithmeticParser.VariableContext context) {

		VariableNode node = new VariableNode(context.getText());
		return node;
	}

	@Override
	public ExpressionNode visitRuleVariable(ArithmeticParser.RuleVariableContext context) {
//		if (this.depth == 0) {
//			System.out.println("NO RULEVARIABLES IN TERM");
//		}
		
//		if (this.variables.get(context.getText()) != null){
//			return this.variables.get(context.getText());
//		}

		return new RuleVariableNode(context.getText());
	}

	@Override
	public ExpressionNode visitParenthetical(ArithmeticParser.ParentheticalContext context) {
		return visit(context.expression());
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
			break;
		}
		return node;
	}

	@Override
	public ExpressionNode visitOperation(ArithmeticParser.OperationContext context) {

		OperationNode node = null;
		switch (context.op.getType()) {
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
		// maybe store rewrite node as a variable, and return it if the simplification evaluations below don't add up
//		if (node.Left instanceof NumberNode && node.Right instanceof NumberNode && node instanceof AdditionNode) {
//			return new NumberNode(((NumberNode) node.Left).getValue() + ((NumberNode) node.Right).getValue());
//		} else if (node.Left instanceof NumberNode && node.Right instanceof NumberNode
//				&& node instanceof SubtractionNode) {
//			return new NumberNode(((NumberNode) node.Left).getValue() - ((NumberNode) node.Right).getValue());
//		}

		return node;
	}

	@Override
	public ExpressionNode visitFunctionExpression(ArithmeticParser.FunctionExpressionContext context) {
//		if (this.depth > 400) {
//			return null;
//		}
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}

		FunctionNode node = new FunctionNode(context.func.getText(), arguments);
		return node;
	}





}
