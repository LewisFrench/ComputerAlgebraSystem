package Nodes;


public class ConditionOperationNode extends ExpressionNode {

	ExpressionNode left;
	ExpressionNode right;

	public ExpressionNode getLeft() {
		return this.left;
	}

	public ExpressionNode getRight() {
		return this.right;
	}
}
