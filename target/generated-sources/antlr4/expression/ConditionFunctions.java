package expression;

import java.util.LinkedHashMap;

class ConditionFunctionEvaluator {

	LinkedHashMap<String, ExpressionNode> variables;

	public ConditionFunctionEvaluator(LinkedHashMap<String, ExpressionNode> variables) {
		this.variables = variables;
	}

	public boolean determineFunction(String functionName, ExpressionNode node) {
		ConditionFunction conditionFunction = null;
		switch (functionName) {
		case "is_number":
			conditionFunction = new is_number();
			break;

		case "is_literal":
			conditionFunction = new is_literal();
			break;

		case "is_integer":
			conditionFunction = new is_integer();
			break;
		default:
			System.out.println("Entered condition function has no match - please check the entered name");
		}

		if (node instanceof RuleVariableNode) {
			return conditionFunction.function(variables.get(((RuleVariableNode) node).getValue()));
		} else {
			return conditionFunction.function(node);
		}
	}
}

abstract class ConditionFunction {
	String functionDescription;

	abstract boolean function(ExpressionNode node);
}

class is_literal extends ConditionFunction {
	String functionDescription = ("is_literal($n)  :  Determines if the argument entered is an variable");

	@Override
	boolean function(ExpressionNode node) {
		return (node instanceof VariableNode);
	}
}

class is_number extends ConditionFunction {
	String functionDescription = ("is_number($n)  :  Determines if the argument entered is an number");

	@Override
	boolean function(ExpressionNode node) {
		return (node instanceof NumberNode);
	}
}

class is_integer extends ConditionFunction {

	String functionDescription = ("is_integer($n)  :  Determines if the argument entered is an integer");

	@Override
	boolean function(ExpressionNode node) {
		if (node instanceof NumberNode) {
			return (((NumberNode) node).getValue() == Math.floor(((NumberNode) node).getValue()));
		} else {
			return false;
		}
	}

}