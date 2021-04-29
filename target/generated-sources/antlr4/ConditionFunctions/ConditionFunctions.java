package ConditionFunctions;

import java.math.BigInteger;
import java.util.ArrayList;
import Nodes.*;
import VisitorClasses.DependsEvaluator;

abstract class ConditionFunction {
	String functionDescription;

	abstract boolean function(ArrayList<ExpressionNode> arguments) throws Exception;
}

class is_literal extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof VariableNode);
		}
		throw new IllegalArgumentException(
				"Attempting to call a condition function with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_number extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof NumberNode);
		}
		throw new IllegalArgumentException(
				"Attempting to call a condition function with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_integer extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			if (arguments.get(0) instanceof NumberNode) {

				return (((NumberNode) arguments.get(0)).getDenominator().compareTo(BigInteger.ONE) ==0);
			} else {
				return false;
			}
		}
		throw new IllegalArgumentException(
				"Attempting to call _is_integer with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}

}
//
//class is_even extends ConditionFunction {
//	@Override
//	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
//		if (arguments.size() == 1) {
//			if (arguments.get(0) instanceof NumberNode) {
//				return (new is_integer().function(arguments) && ((NumberNode) arguments.get(0)).getNumerator() % 2 == 0);
//				
//				
//			} else {
//				return false;
//			}
//		}
//		throw new IllegalArgumentException(
//				"Attempting to call _is_even with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
//	}
//}

class is_addition extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof AdditionNode);
		}
		throw new IllegalArgumentException(
				"Attempting to call _is_addition with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_subtraction extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof SubtractionNode);
		}
		throw new IllegalArgumentException(
				"Attempting to call _is_subtraction with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_multiplication extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof MultiplicationNode);
		}
		throw new IllegalArgumentException(
				"Attempting to call _is_multiplication with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_division extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof DivisionNode);
		}
		throw new IllegalArgumentException(
				"Attempting to call _is_division with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_exponentiation extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof PowerNode);
		}
		throw new IllegalArgumentException(
				"Attempting to call _is_exponentiation with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_unary extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof UnaryNode);
		}
		throw new IllegalArgumentException(
				"Attempting to call _is_unary with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_function extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			return (arguments.get(0) instanceof FunctionNode);
		}
		throw new IllegalArgumentException(
				"Attempting to call _is_function with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}



class depends extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 2) {
			return new DependsEvaluator(arguments.get(1)).Visit(arguments.get(0));
		}
		throw new IllegalArgumentException(
				"Attempting to call _depends with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}