package Nodes;

import java.util.ArrayList;
import java.util.Arrays;


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