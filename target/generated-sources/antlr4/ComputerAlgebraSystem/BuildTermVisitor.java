package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import Algebra.AlgebraBaseVisitor;
import Algebra.AlgebraLexer;
import Algebra.AlgebraParser;
import RuleAlgebra.RuleAlgebraLexer;

public class BuildTermVisitor extends AlgebraBaseVisitor<ExpressionNode> {

	@Override
	public ExpressionNode visitTerm(AlgebraParser.TermContext context) {
		return visit(context.expression());
	}

	@Override
	public ExpressionNode visitDecimal(AlgebraParser.DecimalContext context) {
		BigDecimal b = new BigDecimal(context.getText());
		
		String formattedDecimal = b.stripTrailingZeros().toPlainString();
		if (!(formattedDecimal.contains("."))){
			return new NumberNode(Long.valueOf(formattedDecimal));
		}

		String[] splitByDecimalPoint = formattedDecimal.split("\\.");		
		long numerator = Long.valueOf(formattedDecimal.replaceAll("\\.", ""));
		
		int numberOfDecimalPlaces = splitByDecimalPoint[1].length();
		long denominator = 1;
		for (int i = 0; i < numberOfDecimalPlaces ; i ++) {
			denominator *= 10;
		}
		return new NumberNode(numerator, denominator);
	}
	
	@Override
	public ExpressionNode visitInteger(AlgebraParser.IntegerContext context) {
		return new NumberNode(Long.valueOf(context.getText()));
	}
	
	@Override
	public ExpressionNode visitRational(AlgebraParser.RationalContext context) {
		String[] split = context.getText().split("/");
		long numerator = Long.valueOf(split[0]);
		long denominator = Long.valueOf(split[1]);
		return new NumberNode(numerator, denominator);
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
		System.out.println("\nVisiting Unary for some reason");
		ExpressionNode node = visit(context.expression());
		
		switch (context.op.getType()) {
		case AlgebraLexer.OP_ADD:
			return node;
			

		case AlgebraLexer.OP_SUB:
			if (node instanceof NumberNode) {
				return new NumberNode(((NumberNode)node).getNumerator()* -1 , ((NumberNode)node).getDenominator());
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
		OperationNode node = null;
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
			node = new DivisionNode(left, right);
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
