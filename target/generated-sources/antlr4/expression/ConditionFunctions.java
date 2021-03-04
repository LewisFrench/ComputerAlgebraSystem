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
		if (node instanceof RuleVariableNode) {
			return this.function(variables.get(((RuleVariableNode) node).getValue()));
		} else {
			return this.function(node);
		}
		//Error handling here or remove entirely and just use function (maybe rename function too)
		

	}

	abstract boolean function(ExpressionNode node);
}


class is_Integer extends ConditionFunction {

	String functionDescription = ("is_Integer($n)  :  Determines if the argument entered is an integer");

	@Override
	boolean function(ExpressionNode node) {
		System.out.println("Verifying is_Integer");
		System.out.println(node.getClass() + "   " + node.toString());
		if (node instanceof NumberNode) {
			return (((NumberNode) node).getValue() == Math.floor(((NumberNode) node).getValue()));
		} else {
			// Exception here - wrong type of node
			return false;
		}
	}

}
