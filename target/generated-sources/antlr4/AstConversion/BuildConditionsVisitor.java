package AstConversion;

import Conditions.ConditionsBaseVisitor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import Nodes.*;
import Conditions.ConditionsLexer;
import Conditions.ConditionsParser;

/**
 * Traverses the ANTLR4 parse tree that represents the conditions of the rule.
 * Converts the parse tree nodes under the 'expression' production rules into an
 * AST structure comprised of ExpressionNode objects. Returns the root node of
 * the converted AST structure.
 * 
 * @author Lewis
 *
 * @param <T> Generic type
 */
public class BuildConditionsVisitor extends ConditionsBaseVisitor<ExpressionNode> {
	LinkedHashMap<String, ExpressionNode> variables;

	public BuildConditionsVisitor() {
	}

	/**
	 * Visit root of parse tree
	 * 
	 * @return Abstract syntax tree after conversion.
	 */
	@Override
	public ExpressionNode visitRuleConditions(ConditionsParser.RuleConditionsContext context) {
		return visit(context.condition());
	}

	/**
	 * Condition order of evaluation can be altered through use of parentheses. They
	 * do not get converted to a type of node.
	 * 
	 * @return ExpressionNode converted subtree contained within parentheses
	 */
	@Override
	public ExpressionNode visitConditionParenthetical(ConditionsParser.ConditionParentheticalContext context) {
		return visit(context.condition());
	}

	/**
	 * Determines the operator in a binary logical operation (AND , OR) and returns
	 * the AST node representing that type of operation.
	 * 
	 * @return ConditionAndNode in case of a logical conjunction operation
	 *         ConditionOrNode in case of a logical disjunction operation
	 */
	@Override
	public ExpressionNode visitConditionOperation(ConditionsParser.ConditionOperationContext context) {
		ConditionOperationNode node = null;
		ExpressionNode left = visit(context.left);
		ExpressionNode right = visit(context.right);
		if (context.op.getType() == ConditionsLexer.OP_AND) {
			node = new ConditionAndNode(left, right);
		} else if (context.op.getType() == ConditionsLexer.OP_OR) {
			node = new ConditionOrNode(left, right);
		}

		return node;
	}

	/**
	 * Conversion of logical negation operation to AST
	 * Stores the condition tree being negated as ExpressionNode
	 * 
	 * @return ConditionNotNode storing the negated expression
	 */
	@Override
	public ExpressionNode visitConditionNotOperation(ConditionsParser.ConditionNotOperationContext context) {

		return new ConditionNotNode(visit(context.condition()));
	}

	/**
	 * Conversion of relational operation to AST node.
	 * 
	 * @return ExpressionNode storing the LHS and RHS of operation, and the int and
	 *         string representation of the operator
	 */
	@Override
	public ExpressionNode visitConditionRelop(ConditionsParser.ConditionRelopContext context) {
		ExpressionNode left = visit(context.left);
		ExpressionNode right = visit(context.right);
		return new RelopNode(left, right, context.relop.getType(), context.relop.getText());
	}

	/**
	 * Conversion of condition function to AST node. Stores the name and the
	 * arguments of the condition function.
	 * 
	 * @return ConditionFunctionNode with attributes from parse tree.
	 */
	@Override
	public ExpressionNode visitConditionFunction(ConditionsParser.ConditionFunctionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}
		return new ConditionFunctionNode(context.function.getText(), arguments);
	}

	/**
	 * Conversion of variable to AST node. Stores a string representation of the
	 * variable
	 * 
	 * @return VariableNode instance
	 */
	@Override
	public ExpressionNode visitVariable(ConditionsParser.VariableContext context) {
		return new VariableNode(context.value.getText());
	}

	/**
	 * Conversion of rule variable to AST node. Stores a string representation of
	 * the rule variable
	 * 
	 * @return RuleVariableNode instance
	 */
	@Override
	public ExpressionNode visitRuleVariable(ConditionsParser.RuleVariableContext context) {
		return new RuleVariableNode(context.value.getText());
	}

	/**
	 * Conversion of integer input to rational number
	 * Calls NumberNode constructor accepting numerator
	 * 
	 * @return NumberNode representing integer value.
	 */
	@Override
	public ExpressionNode visitInteger(ConditionsParser.IntegerContext context) {
		return new NumberNode(new BigInteger(context.getText()));
	}

	/**
	 * Handles conversion of decimal input to rational number.
	 * 
	 * @return instance of NumberNode storing rational representation of decimal
	 * 
	 */
	@Override
	public ExpressionNode visitDecimal(ConditionsParser.DecimalContext context) {


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
	public ExpressionNode visitParenthetical(ConditionsParser.ParentheticalContext context) {
		return visit(context.expression());
	}

	/**
	 * Unary negation node conversion.
	 * 
	 * @return Unary node storing the expression being negated.
	 */
	@Override
	public ExpressionNode visitUnary(ConditionsParser.UnaryContext context) {
		ExpressionNode node = visit(context.expression());

		switch (context.op.getType()) {
		case ConditionsLexer.OP_ADD:
			node = visit(context.expression());
			break;

		case ConditionsLexer.OP_SUB:
			// Cancel redundant negation (---x --> -x)
			if (node instanceof UnaryNode) {
				return ((UnaryNode) node).getInnerNode();
			}
			// apply negation to numerator of a numbernode if applicable
			if (node instanceof NumberNode) {
				return new NumberNode(((NumberNode) node).getNumerator().multiply(BigInteger.valueOf(-1)) , ((NumberNode) node).getDenominator());
			}
			node = new UnaryNode(visit(context.expression()));
			break;
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
	public ExpressionNode visitOperation(ConditionsParser.OperationContext context) {
		OperationNode node = null;
		ExpressionNode left = visit(context.left);
		ExpressionNode right = visit(context.right);

		switch (context.op.getType()) {
		case ConditionsLexer.OP_POW:
			node = new PowerNode(left, right);
			break;
		case ConditionsLexer.OP_ADD:
			node = new AdditionNode(left, right);
			break;

		case ConditionsLexer.OP_SUB:
			node = new SubtractionNode(left, right);
			break;

		case ConditionsLexer.OP_MUL:
			node = new MultiplicationNode(left, right);
			break;

		case ConditionsLexer.OP_DIV:
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

//		default:
//			return node;
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
	public ExpressionNode visitFunction(ConditionsParser.FunctionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}

		return new FunctionNode(context.func.getText(), arguments);

	}

}
