package ConditionFunctions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import Nodes.ExpressionNode;

/**
 * Handles the identification and verification of the condition functions.
 * 
 * @author lewis
 *
 */
public class ConditionFunctionEvaluator {

	LinkedHashMap<String, ExpressionNode> variables;

	public ConditionFunctionEvaluator() {
	}

	/**
	 * Switch statement determines the validity of the entered function name. If it
	 * matches an existing condition function then the system attempts to carry out
	 * that function with the arguments passed.
	 * 
	 * @param functionName String representing the name of the condition function
	 * @param arguments    A list of nodes passed as arguments to the function
	 * @return A boolean representing the truth of the function performed on the
	 *         argument
	 * @throws Exception Users cannot invoke a function that is not provided by the
	 *                   system. Users cannot apply a condition function to an
	 *                   incorrect number of arguments.
	 */
	public boolean determineFunction(String functionName, ArrayList<ExpressionNode> arguments) throws Exception {
		ConditionFunction conditionFunction = null;
		switch (functionName) {
		case "_is_number":
			conditionFunction = new is_number();
			break;
		case "_is_literal":
			conditionFunction = new is_literal();
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

