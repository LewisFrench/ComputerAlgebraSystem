package AstConversion;

import java.math.BigDecimal;
import java.util.ArrayList;

import Algebra.AlgebraBaseVisitor;
import Algebra.AlgebraLexer;
import Algebra.AlgebraParser;
import Nodes.*;

/**
 * Visitor class that traverses the ANTLR4 parse tree that represents the
 * algebraic term input by the user. Converts the parse tree nodes under the
 * 'expression' production rules into an AST structure comprised of
 * ExpressionNode objects. Returns the root node of the converted AST structure.
 * 
 * @author Lewis
 *
 * @param <T> Generic type
 */
public class BuildTermVisitor extends AlgebraBaseVisitor<ExpressionNode> {

	@Override
	public ExpressionNode visitTerm(AlgebraParser.TermContext context) {
		return visit(context.expression());
	}

	@Override
	public ExpressionNode visitVariable(AlgebraParser.VariableContext context) {
		VariableNode node = new VariableNode(context.value.getText());
		return node;
	}

	@Override
	public ExpressionNode visitRational(AlgebraParser.RationalContext context) {
		String[] split = context.getText().split("/");
		long numerator = Long.valueOf(split[0]);
		long denominator = Long.valueOf(split[1]);
		return new NumberNode(numerator, denominator);
	}

	@Override
	public ExpressionNode visitInteger(AlgebraParser.IntegerContext context) {
		return new NumberNode(Long.valueOf(context.getText()));
	}

	@Override
	public ExpressionNode visitDecimal(AlgebraParser.DecimalContext context) {
		BigDecimal b = new BigDecimal(context.getText());
		// Format decimal input, remove unnecessary zeroes

		String formattedDecimal = b.stripTrailingZeros().toPlainString();
		// process as integer if fractional part is zero
		if (!(formattedDecimal.contains("."))) {
			return new NumberNode(Long.valueOf(formattedDecimal));
		}
		// Split into integer and fraction part
		String[] splitByDecimalPoint = formattedDecimal.split("\\.");
		// set numerator to integer part
		long numerator = Long.valueOf(formattedDecimal.replaceAll("\\.", ""));
		// Scale denominator to number of decimal places
		int numberOfDecimalPlaces = splitByDecimalPoint[1].length();
		long denominator = 1;
		for (int i = 0; i < numberOfDecimalPlaces; i++) {
			denominator *= 10;
		}
		return new NumberNode(numerator, denominator);
	}

	@Override
	public ExpressionNode visitParenthetical(AlgebraParser.ParentheticalContext context) {
		return visit(context.expression());
	}

	@Override
	public ExpressionNode visitUnary(AlgebraParser.UnaryContext context) {
		ExpressionNode node = visit(context.expression());

		switch (context.op.getType()) {
		// ignore hanging + symbols before expressions
		case AlgebraLexer.OP_ADD:
			return node;
		
		case AlgebraLexer.OP_SUB:
			if (node instanceof UnaryNode) {
				return ((UnaryNode)node).getInnerNode();
			}
			if (node instanceof NumberNode) {
				return new NumberNode(((NumberNode) node).getNumerator() * -1, ((NumberNode) node).getDenominator());
			}
			return new UnaryNode(node);
		}
		return node;
	}

	@Override
	public ExpressionNode visitOperation(AlgebraParser.OperationContext context) {
		ExpressionNode left = visit(context.left);
		ExpressionNode right = visit(context.right);
		OperationNode node = null;
		switch (context.op.getType()) {
		case AlgebraLexer.OP_POW:
			node = new PowerNode(left, right);
			break;
		case AlgebraLexer.OP_ADD:
			node = new AdditionNode(left, right);

			break;

		case AlgebraLexer.OP_SUB:
			node = new SubtractionNode(left, right);

			break;

		case AlgebraLexer.OP_MUL:
			node = new MultiplicationNode(left, right);
			break;

		case AlgebraLexer.OP_DIV:
			// Case of multiple unary denominators causing recognition as division rather than rational
			if (left instanceof NumberNode && right instanceof NumberNode) {
				if (((NumberNode)left).getDenominator() == 1 && ((NumberNode)right).getDenominator() == 1){
					return new NumberNode(((NumberNode)left).getNumerator(), ((NumberNode)right).getNumerator());
				}
			}
			node = new DivisionNode(left, right);
			break;

		}

		return node;
	}

	@Override
	public ExpressionNode visitFunction(AlgebraParser.FunctionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}

		return new FunctionNode(context.func.getText(), arguments);
	}

}
