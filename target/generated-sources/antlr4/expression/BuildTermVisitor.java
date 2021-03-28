package expression;

import java.util.ArrayList;

import Algebra.AlgebraBaseVisitor;
import Algebra.AlgebraLexer;
import Algebra.AlgebraParser;

public class BuildTermVisitor extends AlgebraBaseVisitor<ExpressionNode> {

	@Override
	public ExpressionNode visitTerm(AlgebraParser.TermContext context) {
		return visit(context.expression());
	}

	@Override
	public ExpressionNode visitNumber(AlgebraParser.NumberContext context) {
		NumberNode node = new NumberNode(Double.valueOf(context.value.getText()));
		return node;
	}

	@Override
	public ExpressionNode visitVariable(AlgebraParser.VariableContext context) {

		VariableNode node = new VariableNode(context.getText());
		return node;
	}


	@Override
	public ExpressionNode visitParenthetical(AlgebraParser.ParentheticalContext context) {

		return new ParentheticalNode(visit(context.expression()));
	}

	@Override
	public ExpressionNode visitUnaryExpression(AlgebraParser.UnaryExpressionContext context) {
		ExpressionNode node = null;
		switch (context.op.getType()) {
		case AlgebraLexer.OP_ADD:
			node = visit(context.expression());
			break;

		case AlgebraLexer.OP_SUB:
			node = new UnaryNode(visit(context.expression()));
			break;

		default:
			break;
		}
		return node;
	}

	@Override
	public ExpressionNode visitOperation(AlgebraParser.OperationContext context) {

		OperationNode node = null;
		switch (context.op.getType()) {
		case AlgebraLexer.OP_POW:
			node = new PowerNode();
			break;
		case AlgebraLexer.OP_ADD:
			node = new AdditionNode();

			break;

		case AlgebraLexer.OP_SUB:
			node = new SubtractionNode();

			break;

		case AlgebraLexer.OP_MUL:
			node = new MultiplicationNode();
			break;

		case AlgebraLexer.OP_DIV:
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
	public ExpressionNode visitFunctionExpression(AlgebraParser.FunctionExpressionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}

		FunctionNode node = new FunctionNode(context.func.getText(), arguments);
		return node;
	}

}
