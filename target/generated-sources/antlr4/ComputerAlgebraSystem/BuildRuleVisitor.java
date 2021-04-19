package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.util.ArrayList;

import RuleAlgebra.RuleAlgebraBaseVisitor;
import RuleAlgebra.RuleAlgebraLexer;
import RuleAlgebra.RuleAlgebraParser;

/**
 * Visitor class that traverses the ANTLR4 parse tree that represents the
 * left-hand side of the rule. Converts the parse tree nodes under the
 * 'expression' production rules into an AST structure comprised of
 * ExpressionNode objects. Returns the root node of the converted AST structure.
 * 
 * @author Lewis
 *
 * @param <T> Generic type
 */

public class BuildRuleVisitor extends RuleAlgebraBaseVisitor<ExpressionNode> {

	public BuildRuleVisitor() {
	}

	@Override
	public ExpressionNode visitRuleTerm(RuleAlgebraParser.RuleTermContext context) {
		return visit(context.expression());
	}

	@Override
	public ExpressionNode visitVariable(RuleAlgebraParser.VariableContext context) {
		return new VariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitRuleVariable(RuleAlgebraParser.RuleVariableContext context) {
		return new RuleVariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitRational(RuleAlgebraParser.RationalContext context) {
		String[] split = context.getText().split("/");
		long numerator = Long.valueOf(split[0]);
		long denominator = Long.valueOf(split[1]);
		return new NumberNode(numerator, denominator);
	}

	@Override
	public ExpressionNode visitInteger(RuleAlgebraParser.IntegerContext context) {
		return new NumberNode(Long.valueOf(context.getText()));
	}

	@Override
	public ExpressionNode visitDecimal(RuleAlgebraParser.DecimalContext context) {
		BigDecimal b = new BigDecimal(context.getText());
		String formattedDecimal = b.stripTrailingZeros().toPlainString();
		if (!(formattedDecimal.contains("."))) {
			return new NumberNode(Long.valueOf(formattedDecimal));
		}

		String[] splitByDecimalPoint = formattedDecimal.split("\\.");
		long numerator = Long.valueOf(formattedDecimal.replaceAll("\\.", ""));

		int numberOfDecimalPlaces = splitByDecimalPoint[1].length();
		long denominator = 1;
		for (int i = 0; i < numberOfDecimalPlaces; i++) {
			denominator *= 10;
		}
		return new NumberNode(numerator, denominator);
	}

	@Override
	public ExpressionNode visitParenthetical(RuleAlgebraParser.ParentheticalContext context) {
		return (visit(context.expression()));
	}

	@Override
	public ExpressionNode visitUnary(RuleAlgebraParser.UnaryContext context) {

		ExpressionNode node = visit(context.expression());
		switch (context.op.getType()) {
		case RuleAlgebraLexer.OP_ADD:
			node = visit(context.expression());
			break;

		case RuleAlgebraLexer.OP_SUB:
			if (node instanceof NumberNode) {
				return new NumberNode(((NumberNode) node).getNumerator() * -1, ((NumberNode) node).getDenominator());
			}
			node = new UnaryNode(visit(context.expression()));
			break;
		}
		return node;
	}

	@Override
	public ExpressionNode visitOperation(RuleAlgebraParser.OperationContext context) {
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
	public ExpressionNode visitFunction(RuleAlgebraParser.FunctionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}

		return new FunctionNode(context.func.getText(), arguments);

	}

}
