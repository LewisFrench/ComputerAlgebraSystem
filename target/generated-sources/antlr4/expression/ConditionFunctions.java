package expression;

import java.util.ArrayList;
import java.util.LinkedHashMap;

class ConditionFunctionEvaluator {

	LinkedHashMap<String, ExpressionNode> variables;

	public ConditionFunctionEvaluator(LinkedHashMap<String, ExpressionNode> variables) {
		this.variables = variables;
	}

	public boolean determineFunction(String functionName, ArrayList<ExpressionNode> arguments) {
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
		case "depends":
			conditionFunction = new depends();
			break;
		default:
			System.out.println("Entered condition function has no match - please check the entered name");
		}

		if (conditionFunction != null) {
			return conditionFunction.function(this.transformRuleVariableArguments(arguments));
		}
		return false;
	}

	public ArrayList<ExpressionNode> transformRuleVariableArguments(ArrayList<ExpressionNode> arguments) {
		ArrayList<ExpressionNode> transformedArguments = new ArrayList<>();
		for (ExpressionNode argument : arguments) {
			if (argument instanceof RuleVariableNode) {
				if (this.variables.get(((RuleVariableNode) argument).toString()) != null) {
					transformedArguments.add(this.variables.get(((RuleVariableNode) argument).toString()));
				} else {
					transformedArguments.add(argument);
				}

			} else {
				transformedArguments.add(argument);
			}
		}
		return transformedArguments;
	}

}

abstract class ConditionFunction {
	String functionDescription;

	abstract boolean function(ArrayList<ExpressionNode> arguments);
}

class is_literal extends ConditionFunction {
	String functionDescription = ("is_literal($n)  :  Determines if the argument entered is an variable");

	@Override
	boolean function(ArrayList<ExpressionNode> arguments) {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof VariableNode);
		}
		return false;
	}
}

class is_number extends ConditionFunction {
	String functionDescription = ("is_number($n)  :  Determines if the argument entered is an number");

	@Override
	boolean function(ArrayList<ExpressionNode> arguments) {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof NumberNode);
		}
		return false;
	}
}

class is_integer extends ConditionFunction {

	String functionDescription = ("is_integer($n)  :  Determines if the argument entered is an integer");

	@Override
	boolean function(ArrayList<ExpressionNode> arguments) {
		if (arguments.size() == 1) {
			if (arguments.get(0) instanceof NumberNode) {
				return (((NumberNode) arguments.get(0)).getValue() == Math
						.floor(((NumberNode) arguments.get(0)).getValue()));
			} else {
				return false;
			}
		}
		return false;
	}

}

class depends extends ConditionFunction {
	String functionDescription = "depends($A, $b)  :  Determines if term $A contains any instance of term $b";

	@Override
	boolean function(ArrayList<ExpressionNode> arguments) {
		if (arguments.size() == 2) {
			return new DependsEvaluator(arguments.get(1)).Visit(arguments.get(0));
		}
		return false; // Throw Exception
	}
}