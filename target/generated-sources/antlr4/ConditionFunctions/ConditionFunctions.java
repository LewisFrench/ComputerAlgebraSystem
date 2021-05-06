package ConditionFunctions;

import java.math.BigInteger;
import java.util.ArrayList;
import Nodes.*;
import VisitorClasses.DependsEvaluator;
import VisitorClasses.EvaluateNumericalOperations;

abstract class ConditionFunction {
	String functionDescription;

	abstract boolean function(ArrayList<ExpressionNode> arguments) throws Exception;
}

class is_literal extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			ExpressionNode argument = new EvaluateNumericalOperations().Visit(arguments.get(0));
			return (argument instanceof VariableNode);
		}
		throw new IllegalArgumentException(
				"Attempting to call a condition function with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_number extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		ExpressionNode argument = new EvaluateNumericalOperations().Visit(arguments.get(0));
		if (arguments.size() == 1) {
			return (argument instanceof NumberNode);
		}
		throw new IllegalArgumentException(
				"Attempting to call a condition function with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
	}
}

class is_integer extends ConditionFunction {
	@Override
	boolean function(ArrayList<ExpressionNode> arguments) throws Exception {
		if (arguments.size() == 1) {
			ExpressionNode argument = new EvaluateNumericalOperations().Visit(arguments.get(0));
			if (argument instanceof NumberNode) {
				return (((NumberNode) argument).getDenominator().compareTo(BigInteger.ONE) ==0);
			} else {
				return false;
			}
		}
		throw new IllegalArgumentException(
				"Attempting to call _is_integer with the incorrect number of arguments. Please consult the user guide for the syntax of these functions");
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