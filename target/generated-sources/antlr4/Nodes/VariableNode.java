package Nodes;


public class VariableNode extends ExpressionNode {
	public String value;

	public VariableNode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return this.getValue();
	}

}