package expression;

import java.util.ArrayList;

abstract class CompileUnitNode {
	ExpressionNode expression;
}

abstract class ExpressionNode {
	abstract boolean match(ExpressionNode node);
}

abstract class OperationNode extends ExpressionNode {

	public ExpressionNode Left;
	public ExpressionNode Right;
	public String operator;

	public ExpressionNode calculate(ExpressionNode left, ExpressionNode right) {
		return new NumberNode(3);
	}

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

	@Override
	public boolean match(ExpressionNode node) {
		
		return node.getClass() == this.getClass();
	}

}

class AdditionNode extends OperationNode {

	public String toString() {
		return (getLeft().toString() + " + " + getRight().toString());
	}
}

class SubtractionNode extends OperationNode {
	public String toString() {
		return ( getLeft().toString() + " - " + getRight().toString());
	}
}

class MultiplicationNode extends OperationNode {
	public String toString() {
		return (getLeft().toString() + " * " + getRight().toString());
	}
}

class DivisionNode extends OperationNode {
	public String toString() {
		return (getLeft().toString() + " / " + getRight().toString());
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

	@Override
	public boolean match(ExpressionNode node) {
		return false;
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
		return (this.function +this.arguments.toString());
	}

	@Override
	public boolean match(ExpressionNode node) {
		boolean match = false;
		if (node.getClass() == this.getClass()) {
			ArrayList<ExpressionNode> nodeArguments = ((FunctionNode) node).getArguments();
			if (this.arguments.size() == nodeArguments.size() && this.function.equals(((FunctionNode) node).function)) {
				for (int i = 0; i < this.arguments.size(); i++) {
					if ((this.arguments.get(i).match(nodeArguments.get(i)))) {
						match = true;
					}
				}
			}
		}
		return match;
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

	@Override
	public boolean match(ExpressionNode node) {
		if (node.getClass() == this.getClass()) {
			return ((NumberNode) node).getValue() == this.getValue();
		}
		return false;
	}

	public double getValue() {
		return value;
	}

}

class VariableNode extends ExpressionNode {
	public String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean match(ExpressionNode node) {

		if (node.getClass() == this.getClass()) {
			return this.getValue() == ((VariableNode) node).getValue();

			// Return true for all numberNodes
		} else if (node.getClass() == new NumberNode(0).getClass()) {
			return true;
		} // Does this need to be true for other functionNodes, operation nodes, etc?

		return false;
	}
}

class RuleVariableNode extends ExpressionNode {
	public String value;

	public RuleVariableNode(String value) {
		this.value = value;
	}

	public String toString() {
		return "$"+value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean match(ExpressionNode node) {
		System.out.println("matching " + this.toString() + " to " + node.toString());
		if (node.getClass() == this.getClass()) {
			return this.getValue() == ((RuleVariableNode) node).getValue();
		
		} else {
			
			//System.out.println(this.getValue() + "  =  " + node.toString());
			return true;
		}
		

	}
	// Method to replace value with number ?
}

/*
 * 
 * 
 * Condition Stuff
 * 
 * 
 */

class ConditionSetNode extends ExpressionNode {
	public ArrayList<ExpressionNode> conditions;

	public boolean match(ExpressionNode node) {
		return true;
	}
}

class RelopNode extends ExpressionNode {
	ExpressionNode left;
	ExpressionNode right;
	String relop;

	public RelopNode(ExpressionNode left, ExpressionNode right, String relop) {
		this.left = left;
		this.right = right;
		this.relop = relop;
	}

	public String toString() {
		return left.toString() + relop + right.toString();
	}

	@Override
	public boolean match(ExpressionNode node) {
		return true;
	}

}

class ConditionFunctionNode extends ExpressionNode {
	String functionName;
	ExpressionNode argument;

	public ConditionFunctionNode(String functionName, ExpressionNode argument) {
		this.functionName = functionName;
		this.argument = argument;
	}

	@Override
	public boolean match(ExpressionNode node) {
		return true;
	}

}

class NotNode extends ExpressionNode {

	public ExpressionNode innerNode;

	public NotNode(ExpressionNode innerNode) {
		this.innerNode = innerNode;
	}

	@Override
	boolean match(ExpressionNode node) {
		return true;
	}

}
