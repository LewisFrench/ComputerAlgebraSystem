package Nodes;


public class AdditionNode extends OperationNode {

	public AdditionNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;

	}

	public String toString() {
		return (getLeft().toString() + " + " + getRight().toString());
	}
}
