package Nodes;

public class PowerNode extends OperationNode {

	public PowerNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;

	}

	public String toString() {
		return (getLeft().toString() + " ^ " + getRight().toString());
	}
}
