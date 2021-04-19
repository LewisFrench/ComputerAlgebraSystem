package ComputerAlgebraSystem;

import Conditions.ConditionsBaseVisitor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import Conditions.ConditionsLexer;
import Conditions.ConditionsParser;

/**
 * Visitor class that traverses the ANTLR4 parse tree that represents the
 * conditions of the rule. Converts the parse tree nodes under the 'expression'
 * production rules into an AST structure comprised of ExpressionNode objects.
 * Returns the root node of the converted AST structure.
 * 
 * @author Lewis
 *
 * @param <T> Generic type
 */
public class BuildConditionsVisitor extends ConditionsBaseVisitor<ExpressionNode> {
	LinkedHashMap<String, ExpressionNode> variables;

	public BuildConditionsVisitor() {
	}

	@Override
	public ExpressionNode visitRuleConditions(ConditionsParser.RuleConditionsContext context) {
		return visit(context.condition());
	}

	@Override
	public ExpressionNode visitConditionParenthetical(ConditionsParser.ConditionParentheticalContext context) {
		return visit(context.condition());
	}

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

	@Override
	public ExpressionNode visitConditionNotOperation(ConditionsParser.ConditionNotOperationContext context) {

		return new ConditionNotNode(visit(context.condition()));
	}

	@Override
	public ExpressionNode visitConditionRelop(ConditionsParser.ConditionRelopContext context) {
		ExpressionNode left = visit(context.left);
		ExpressionNode right = visit(context.right);
		return new RelopNode(left, right, context.relop.getType(), context.relop.getText());
	}

	@Override
	public ExpressionNode visitConditionFunction(ConditionsParser.ConditionFunctionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}
		return new ConditionFunctionNode(context.function.getText(), arguments);
	}

	@Override
	public ExpressionNode visitVariable(ConditionsParser.VariableContext context) {
		return new VariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitRuleVariable(ConditionsParser.RuleVariableContext context) {
		return new RuleVariableNode(context.value.getText());
	}

	@Override
	public ExpressionNode visitRational(ConditionsParser.RationalContext context) {
		String[] split = context.getText().split("/");
		long numerator = Long.valueOf(split[0]);
		long denominator = Long.valueOf(split[1]);
		return new NumberNode(numerator, denominator);
	}

	@Override
	public ExpressionNode visitInteger(ConditionsParser.IntegerContext context) {
		return new NumberNode(Long.valueOf(context.getText()));
	}

	@Override
	public ExpressionNode visitDecimal(ConditionsParser.DecimalContext context) {
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
	public ExpressionNode visitParenthetical(ConditionsParser.ParentheticalContext context) {
		return visit(context.expression());
	}

	@Override
	public ExpressionNode visitUnary(ConditionsParser.UnaryContext context) {
		ExpressionNode node = visit(context.expression());

		switch (context.op.getType()) {
		case ConditionsLexer.OP_ADD:
			node = visit(context.expression());
			break;

		case ConditionsLexer.OP_SUB:
			if (node instanceof UnaryNode) {
				return ((UnaryNode)node).getInnerNode();
			}
			if (node instanceof NumberNode) {
				return new NumberNode(((NumberNode) node).getNumerator() * -1, ((NumberNode) node).getDenominator());
			}
			node = new UnaryNode(visit(context.expression()));
			break;
		}
		return node;
	}

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
			// Case of multiple unary denominators causing recognition as division rather than rational
			if (left instanceof NumberNode && right instanceof NumberNode) {
				if (((NumberNode)left).getDenominator() == 1 && ((NumberNode)right).getDenominator() == 1){
					return new NumberNode(((NumberNode)left).getNumerator(), ((NumberNode)right).getNumerator());
				}
			}
			node = new DivisionNode(left, right);
			break;

		default:
			return node;
		}

		return node;
	}

	public ExpressionNode visitFunction(ConditionsParser.FunctionContext context) {
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		for (int i = 0; i < context.expression().size(); i++) {
			arguments.add(visit(context.expression(i)));
		}

		return new FunctionNode(context.func.getText(), arguments);

	}

}
