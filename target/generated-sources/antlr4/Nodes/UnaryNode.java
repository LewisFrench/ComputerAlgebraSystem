package Nodes;

public class UnaryNode extends ExpressionNode {
	public ExpressionNode innerNode;

	public UnaryNode(ExpressionNode innerNode) {
		this.innerNode = innerNode;
	}

	public String toString() {
		return "-" + this.innerNode.toString();
	}
	public ExpressionNode getInnerNode() {
		return this.innerNode;
	}
}