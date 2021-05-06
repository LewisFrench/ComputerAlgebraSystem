package Nodes;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Node representing instances of condition functions in the AST for the
 * conditions of a rule. Stores a string representation of the name of the
 * function Stores an Arraylist of ExpressionNodes for the root node of each
 * argument of the function.
 * 
 * @author lewis
 *
 */
public class ConditionFunctionNode extends ExpressionNode {
	String functionName;
	ArrayList<ExpressionNode> arguments;

	public ConditionFunctionNode(String functionName, ArrayList<ExpressionNode> arguments) {
		this.functionName = functionName;
		this.arguments = arguments;
	}

	public String getFunctionName() {
		return this.functionName;
	}

	public ArrayList<ExpressionNode> getArguments() {
		return this.arguments;
	}

	public String toString() {
		return this.functionName + Arrays.toString(this.arguments.toArray()).replace("[", "(").replace("]", ")");
	}

}