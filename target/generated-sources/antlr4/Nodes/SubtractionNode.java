package Nodes;


public class SubtractionNode extends OperationNode {
	public SubtractionNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;

	}

	public String toString() {
		return (getLeft().toString() + " - " + getRight().toString());
	}
}