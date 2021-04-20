package Nodes;


public class DivisionNode extends OperationNode {
	public DivisionNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;

	}

	public String toString() {
		return (getLeft().toString() + " / " + getRight().toString());
	}
}

