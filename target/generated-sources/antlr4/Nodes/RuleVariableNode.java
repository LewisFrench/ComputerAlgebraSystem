package Nodes;


public class RuleVariableNode extends ExpressionNode {
	public String value;

	public RuleVariableNode(String value) {
		this.value = value;
	}

	public String toString() {
		return "$" + this.value;
	}

}