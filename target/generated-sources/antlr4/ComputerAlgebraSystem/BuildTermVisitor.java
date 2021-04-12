package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.util.ArrayList;

import Algebra.AlgebraBaseVisitor;
import Algebra.AlgebraLexer;
import Algebra.AlgebraParser;
import RuleAlgebra.RuleAlgebraLexer;
import RuleAlgebra.RuleAlgebraParser;

public class BuildTermVisitor extends AlgebraBaseVisitor<ExpressionNode> {

	@Override
	public ExpressionNode visitTerm(AlgebraParser.TermContext context) {
		return visit(context.expression());
	}

	@Override
	public ExpressionNode visitDecimal(AlgebraParser.DecimalContext context) {
		BigDecimal b = new BigDecimal(context.value.getText());
		if (context.getText().contains("-")) {
			return new DecimalNode(b.multiply(new BigDecimal("-1")));
		}
		return new DecimalNode(b);

	}

	@Override
	public ExpressionNode visitInteger(AlgebraParser.IntegerContext context) {
		if (context.getText().contains("-")) {
			return new IntegerNode(-1 * Long.parseLong(context.value.getText()));
		}
		return new IntegerNode(Long.parseLong(context.value.getText()));
	}

	@Override
	public ExpressionNode visitRational(AlgebraParser.RationalContext context) {
		long numerator;
		long denominator;
		String[] splitRational = context.getText().split("/");
		numerator = Long.parseLong(splitRational[0]);
		denominator = Long.parseLong(splitRational[1]);
		return (RationalFactory.createRational(numerator, denominator));
	}

	@Override
	public ExpressionNode visitVariable(AlgebraParser.VariableContext context) {

		VariableNode node = new VariableNode(context.getText());
		return node;
	}

	@Override
	public ExpressionNode visitParenthetical(AlgebraParser.ParentheticalContext context) {

		return (visit(context.expression()));
	}

	@Override
	public ExpressionNode visitUnaryExpression(AlgebraParser.UnaryExpressionContext context) {
		ExpressionNode node = visit(context.expression());

		switch (context.op.getType()) {
		case AlgebraLexer.OP_ADD:
			return node;

		case AlgebraLexer.OP_SUB:
			if (node instanceof NumberNode) {
				if (node instanceof DecimalNode) {
					return new DecimalNode(((DecimalNode) node).getValue().multiply(BigDecimal.valueOf(-1)));
				}
				if (node instanceof IntegerNode) {
					return new IntegerNode(((IntegerNode) node).getValue() * -1);
				}
				if (node instanceof RationalNode) {
					return RationalFactory.createRational(-1 * ((RationalNode) node).numerator,
							((RationalNode) node).denominator);
				}
			}
			return new UnaryNode(node);

		default:
			break;
		}
		return node;
	}

	@Override
	public ExpressionNode visitOperation(AlgebraParser.OperationContext context) {
		ExpressionNode left = visit(context.left);
		ExpressionNode right = visit(context.right);
		ExpressionNode node = null;
		switch (context.op.getType()) {
		case RuleAlgebraLexer.OP_POW:
			node = new PowerNode(left, right);
			break;
		case RuleAlgebraLexer.OP_ADD:
			node = new AdditionNode(left, right);
			break;

		case RuleAlgebraLexer.OP_SUB:
			node = new SubtractionNode(left, right);
			break;

		case RuleAlgebraLexer.OP_MUL:
			node = new MultiplicationNode(left, right);
			break;

		case RuleAlgebraLexer.OP_DIV:
			System.out.println("Visiting Division");
			// Division by 0 here
			if (left instanceof IntegerNode && right instanceof IntegerNode) {
				System.out.println("Creating RatinalNode");
				node = RationalFactory.createRational(((IntegerNode) left).getValue(),
						((IntegerNode) right).getValue());
			} else {
				node = new DivisionNode(left, right);
			}
			break;

		}

//		node.Left = visit(context.left);
//		node.Right = visit(context.right);

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
