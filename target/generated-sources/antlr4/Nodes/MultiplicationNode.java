package Nodes;

public class MultiplicationNode extends OperationNode {
	public MultiplicationNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;

	}

	public String toString() {
		return (getLeft().toString() + " * " + getRight().toString());
	}
}