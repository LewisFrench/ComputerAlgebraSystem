package AstConversion;

import java.math.BigInteger;
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

	/**
	 * Conversion of variable to AST node. Stores a string representation of the
	 * variable
	 * 
	 * @return VariableNode instance
	 */
	@Override
	public ExpressionNode visitVariable(AlgebraParser.VariableContext context) {
		VariableNode node = new VariableNode(context.value.getText());
		return node;
	}

	/**
	 * Conversion of integer input to rational number
	 * Calls NumberNode constructor accepting numerator
	 * 
	 * @return NumberNode representing integer value.
	 */
	@Override
	public ExpressionNode visitInteger(AlgebraParser.IntegerContext context) {
		return new NumberNode(new BigInteger(context.getText()));
	}

	/**
	 * Handles conversion of decimal input to rational number.
	 * 
	 * @return instance of NumberNode storing rational representation of decimal
	 * 
	 */
	@Override
	public ExpressionNode visitDecimal(AlgebraParser.DecimalContext context) {

		// Format decimal input, remove unnecessary zeroes
		String decimalString = context.getText();
		boolean removedTrailingZeros = false;
		
		// String trailing zeroes from decimal string
		while (!(removedTrailingZeros)&& decimalString.length()>1 ) {
			if (decimalString.endsWith("0") || decimalString.endsWith("."))
			{
				decimalString = decimalString.substring(0, decimalString.length()-1);
			} else {
				removedTrailingZeros = true;
			}
		}
		String formattedDecimal = decimalString;
		// process as integer if fractional part is zero
		if (!(formattedDecimal.contains("."))) {
			return new NumberNode(new BigInteger(formattedDecimal));
		}
		// Split into integer and fraction part
		String[] splitByDecimalPoint = formattedDecimal.split("\\.");
		// set numerator to integer part
		BigInteger numerator = new BigInteger(formattedDecimal.replaceAll("\\.", ""));
		// Scale denominator to number of decimal places
		int numberOfDecimalPlaces = splitByDecimalPoint[1].length();
		BigInteger denominator = BigInteger.ONE;
		for (int i = 0; i < numberOfDecimalPlaces; i++) {
			denominator =denominator.multiply(BigInteger.valueOf(10));
		}
		return new NumberNode(numerator, denominator);
	}
	
	/**
	 * Parentheses in parse tree are not represented in AST. Returns the expression
	 * within the parentheses.
	 * 
	 * @return ExpressionNode representing expression contained in parentheses
	 */
	@Override
	public ExpressionNode visitParenthetical(AlgebraParser.ParentheticalContext context) {
		return visit(context.expression());
	}

	/**
	 * Unary negation node conversion.
	 * 
	 * @return Unary node storing the expression being negated.
	 */
	@Override
	public ExpressionNode visitUnary(AlgebraParser.UnaryContext context) {
		ExpressionNode node = visit(context.expression());

		switch (context.op.getType()) {
		// ignore hanging '+' symbols before expressions
		case AlgebraLexer.OP_ADD:
			break;
		
		case AlgebraLexer.OP_SUB:
			if (node instanceof UnaryNode) {
				return ((UnaryNode)node).getInnerNode();
			}
			if (node instanceof NumberNode) {
				return new NumberNode(((NumberNode) node).getNumerator().multiply(BigInteger.valueOf(-1)) , ((NumberNode) node).getDenominator());
			}
			return new UnaryNode(node);
		}
		return node;
	}

	/**
	 * Conversion of operations into AST nodes. Switch statement determines which
	 * operator is present in operation, and creates an instance of the
	 * corresponding AST node.
	 * 
	 * @return Converted ExpressionNode instance representing operation.
	 */
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
			// Throw division by zero error
			if (right instanceof NumberNode && ((NumberNode)right).getNumerator().compareTo(BigInteger.ZERO) == 0){
				throw new ArithmeticException();
			}
			// Store number / number division as rational number
			if (left instanceof NumberNode && right instanceof NumberNode) {
				return ((NumberNode)left).divide((NumberNode)right);
			}
			node = new DivisionNode(left, right);
			break;

		}

		return node;
	}

	/**
	 * Visits each argument of the function in the parse tree, storing them in a
	 * FunctionNode instance's array of arguments
	 * 
	 * @return FunctionNode of converted parse tree function
	 */
	@Override
	public ExpressionNode visitFunction(AlgebraParser.FunctionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}

		return new FunctionNode(context.func.getText(), arguments);
	}

}
