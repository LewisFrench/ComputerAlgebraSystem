package Nodes;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Node representing function expressions in an AST
 * Stores the name of the function
 * Stores an ArrayList of ExpressionNodes for each argument of the function. 
 * @author lewis
 *
 */
public class FunctionNode extends ExpressionNode {
	public String function;
	public ArrayList<ExpressionNode> arguments;

	public FunctionNode(String function, ArrayList<ExpressionNode> arguments) {
		this.function = function;
		this.arguments = arguments;
	}
	public String getFunction() {
		return this.function;
	}
	public ArrayList<ExpressionNode> getArguments() {
		return this.arguments;
	}

	public String toString() {
		return this.function + Arrays.toString(this.arguments.toArray()).replace("[", "(").replace("]", ")");
	}
}