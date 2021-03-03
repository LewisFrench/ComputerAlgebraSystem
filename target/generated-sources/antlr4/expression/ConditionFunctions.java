package expression;

import java.util.LinkedHashMap;

class ConditionFunctionEvaluator {

	LinkedHashMap<String, ExpressionNode> variables;

	public ConditionFunctionEvaluator(LinkedHashMap<String, ExpressionNode> variables) {
		this.variables = variables;
	}


	public boolean determineFunction(String functionName, ExpressionNode node) {
		boolean functionResult = false;

		ConditionFunction conditionFunction = null;
		switch (functionName) {
		case "is_Integer":
			conditionFunction = new is_Integer();
			break;
		default:
			System.out.println("Entered condition function has no matched - please check the entered name");
		}

		functionResult = conditionFunction.evaluateConditionFunction(node, this.variables);

		return functionResult;
	}
}

abstract class ConditionFunction {
	String functionDescription;

	public boolean evaluateConditionFunction(ExpressionNode node, LinkedHashMap<String, ExpressionNode> variables) {
		if (node instanceof NumberNode) {
			return this.function(((NumberNode) node).value);
		} else if (node instanceof RuleVariableNode) {
			ExpressionNode n = variables.get(((RuleVariableNode) node).value);
			if (n instanceof NumberNode) {
				return this.function(((NumberNode) n).value);
			} else {
				System.out.println("ERROR - Condition Function didn't process node of correct type");
				return false;
			}
		} else {
			System.out.println("ERROR - Condition Function didn't process node of correct type");
			return false;
		}

	}

	abstract boolean function(Double value);
}

// is_integer($n)

class is_Integer extends ConditionFunction {

	String functionDescription = ("is_Integer($n)  :  Determines if the argument entered is an integer");

	@Override
	boolean function(Double value) {
		return (value == Math.floor(value));
	}

}
