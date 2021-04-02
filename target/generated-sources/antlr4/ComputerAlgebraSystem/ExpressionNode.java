package ComputerAlgebraSystem;

import java.util.ArrayList;
import java.util.Arrays;

abstract class CompileUnitNode {
	ExpressionNode expression;

}

public abstract class ExpressionNode {
}

abstract class OperationNode extends ExpressionNode {

	public ExpressionNode Left;
	public ExpressionNode Right;
	public String operator;


	
	public ExpressionNode getLeft() {
		return Left;
	}

	public void setLeft(ExpressionNode left) {
		Left = left;
	}

	public ExpressionNode getRight() {
		return Right;
	}

	public void setRight(ExpressionNode right) {
		Right = right;
	}

}

class PowerNode extends OperationNode {

	public PowerNode(ExpressionNode Left, ExpressionNode Right) {
		this.Left = Left;
		this.Right = Right;
		
	}

	public String toString() {
		return (getLeft().toString() + " ^ " + getRight().toString());
	}
}

class AdditionNode extends OperationNode {

	public AdditionNode(ExpressionNode Left, ExpressionNode Right) {
		this.Left = Left;
		this.Right = Right;
		
	}

	public String toString() {
		return (getLeft().toString() + " + " + getRight().toString());
	}
}

class SubtractionNode extends OperationNode {
	public SubtractionNode(ExpressionNode Left, ExpressionNode Right) {
		this.Left = Left;
		this.Right = Right;
		
	}
	public String toString() {
		return (getLeft().toString() + " - " + getRight().toString());
	}
}

class MultiplicationNode extends OperationNode {
	public MultiplicationNode(ExpressionNode Left, ExpressionNode Right) {
		this.Left = Left;
		this.Right = Right;
		
	}

	public String toString() {
		return (getLeft().toString() + " * " + getRight().toString());
	}
}

class DivisionNode extends OperationNode {
	public DivisionNode(ExpressionNode Left, ExpressionNode Right) {
		this.Left = Left;
		this.Right = Right;
		
	}

	public String toString() {
		return (getLeft().toString() + " / " + getRight().toString());
	}
}

class ParentheticalNode extends ExpressionNode {
	public ExpressionNode innerNode;

	public ParentheticalNode(ExpressionNode innerNode) {
		this.innerNode = innerNode;
	}

	public String toString() {
		return "(" + this.innerNode.toString() + ")";
	}
}

class UnaryNode extends ExpressionNode {
	public ExpressionNode innerNode;

	public UnaryNode(ExpressionNode innerNode) {
		this.innerNode = innerNode;
	}

	public String toString() {
		return "-" + this.innerNode.toString();
	}
}

class FunctionNode extends ExpressionNode {
	public String function;
	public ArrayList<ExpressionNode> arguments;

	public FunctionNode(String function, ArrayList<ExpressionNode> arguments) {
		this.function = function;
		this.arguments = arguments;
	}

	public ArrayList<ExpressionNode> getArguments() {
		return this.arguments;
	}

	public String toString() {
		return this.function + Arrays.toString(this.arguments.toArray()).replace("[", "(").replace("]", ")");
	}
}

class NumberNode extends ExpressionNode {
	public double value;

	public NumberNode(double d) {
		this.value = d;
	}

	public String toString() {
		return String.valueOf(value);
	}

	public double getValue() {
		return value;
	}

}

class VariableNode extends ExpressionNode {
	public String value;

	public VariableNode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return this.getValue();
	}

}

class RuleVariableNode extends ExpressionNode {
	public String value;

	public RuleVariableNode(String value) {
		this.value = value;
	}

	public String toString() {
		return  "$"+this.value;
	}

}

class ConditionOperationNode extends ExpressionNode {

	ExpressionNode left;
	ExpressionNode right;

}

class ConditionAndNode extends ConditionOperationNode {
	public ConditionAndNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;
	}
	public String toString() {
		return this.left.toString() + " & " + this.right.toString();
	}
}

class ConditionOrNode extends ConditionOperationNode {
	public ConditionOrNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;
	}
	public String toString() {
		return this.left.toString() + " | " + this.right.toString();
	}
}

class RelopNode extends ExpressionNode {
	ExpressionNode left;
	ExpressionNode right;
	int relop;
	String relopText;

	public RelopNode(ExpressionNode left, ExpressionNode right, int relop, String relopText) {
		this.left = left;
		this.right = right;
		this.relop = relop;
		this.relopText = relopText;
	}

	public String toString() {
		return left.toString() + relopText + right.toString();
	}
}

class ConditionFunctionNode extends ExpressionNode {
	String functionName;
	ArrayList<ExpressionNode> arguments;

	public ConditionFunctionNode(String functionName, ArrayList<ExpressionNode> arguments) {
		this.functionName = functionName;
		this.arguments = arguments;
	}
	public ArrayList<ExpressionNode> getArguments(){
		return this.arguments;
	}

	public String toString() {
		return this.functionName + Arrays.toString(this.arguments.toArray()).replace("[", "(").replace("]", ")");
	}

}

class NotNode extends ExpressionNode {

	public ExpressionNode innerNode;

	public NotNode(ExpressionNode innerNode) {
		this.innerNode = innerNode;
	}

	public String toString() {
		return "!" + this.innerNode.toString();
	}

}

//class ConditionParentheticalNode extends ExpressionNode {
//
//}
