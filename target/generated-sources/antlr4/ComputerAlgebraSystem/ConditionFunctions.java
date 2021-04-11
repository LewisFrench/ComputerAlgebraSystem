package ComputerAlgebraSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;

class ConditionFunctionEvaluator {

	LinkedHashMap<String, ExpressionNode> variables;

//	public ConditionFunctionEvaluator(LinkedHashMap<String, ExpressionNode> variables) {
//		this.variables = variables;
//	}
	public ConditionFunctionEvaluator() {

	}

	public boolean determineFunction(String functionName, ArrayList<ExpressionNode> arguments) throws Exception {
		ConditionFunction conditionFunction = null;
		switch (functionName) {
		case "_is_number":
			conditionFunction = new is_number();
			break;

		case "_is_literal":
			conditionFunction = new is_literal();
			break;

		case "_is_addition":
			conditionFunction = new is_addition();
			break;

		case "_is_subtraction":
			conditionFunction = new is_subtraction();
			break;
		case "_is_multiplication":
			conditionFunction = new is_multiplication();
			break;
		case "_is_division":
			conditionFunction = new is_division();
			break;
		case "_is_exponentiation":
			conditionFunction = new is_exponentiation();
			break;
		case "_is_unary":
			conditionFunction = new is_unary();
			break;
//		case "_is_parenthetical":
//			conditionFunction = new is_parenthetical();
//			break;
		case "_is_function":
			conditionFunction = new is_function();
			break;
		case "_is_integer":
			conditionFunction = new is_integer();
			break;
		case "_depends":
			conditionFunction = new depends();
			break;
		default:
			throw new Exception(
					"Attempting to apply a condition function that is not provided by the system.\nPlease check the user guide for a list of the provided functions.");
		}

		return conditionFunction.function(arguments);
	}

}

abstract class ConditionFunction {
	String functionDescription;

	abstract boolean function(ArrayList<ExpressionNode> arguments) throws Exception;
}

class is_literal extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		System.out.println("\n\nHERE\n\n");
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof VariableNode);
		}
		throw new Exception(
				"Attempting to call a condition function with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_number extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof NumberNode);
		}
		throw new Exception(
				"Attempting to call a condition function with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_addition extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof AdditionNode);
		}
		throw new Exception(
				"Attempting to call _is_addition with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_subtraction extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof SubtractionNode);
		}
		throw new Exception(
				"Attempting to call _is_subtraction with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_multiplication extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof MultiplicationNode);
		}
		throw new Exception(
				"Attempting to call _is_multiplication with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_division extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof DivisionNode);
		}
		throw new Exception(
				"Attempting to call _is_division with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_exponentiation extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof PowerNode);
		}
		throw new Exception(
				"Attempting to call _is_exponentiation with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_unary extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof UnaryNode);
		}
		throw new Exception(
				"Attempting to call _is_unary with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}
//
//class is_parenthetical extends ConditionFunction {
//	@Override
//	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
//		if (arguments.size() == 1) {
//			return (arguments.get(0) instanceof ParentheticalNode);
//		}
//		throw new Exception(
//				"Attempting to call _is_parenthetical with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
//	}
//}

class is_function extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof FunctionNode);
		}
		throw new Exception(
				"Attempting to call _is_function with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

// Creation of _is_decimal???????????????


class is_integer extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof IntegerNode);
//			if (arguments.get(0) instanceof NumberNode) {
////				return (((NumberNode) arguments.get(0)).getValue() == Math
////						.floor(((NumberNode) arguments.get(0)).getValue()));
//				return (((NumberNode)arguments.get(0)).getValue().remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0);
//			} else {
//				return false;
//			}
		}
		throw new Exception(
				"Attempting to call is_integer with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}

}

class depends extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 2) {
			return new DependsEvaluator(arguments.get(1)).Visit(arguments.get(0));
		}
		throw new Exception(
				"Attempting to call _depends with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}