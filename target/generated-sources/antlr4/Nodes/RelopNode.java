package Nodes;


public class RelopNode extends ExpressionNode {
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

	public ExpressionNode getLeft() {
		return this.left;
	}

	public ExpressionNode getRight() {
		return this.right;
	}
	
	public int getRelop() {
		return this.relop;
	}

	public String getRelopText() {
		return this.relopText;
	}
	public String toString() {
		return left.toString() + relopText + right.toString();
	}
}
