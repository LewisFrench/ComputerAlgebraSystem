package Nodes;

public class ConditionAndNode extends ConditionOperationNode {
	public ConditionAndNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return this.left.toString() + " & " + this.right.toString();
	}
}
