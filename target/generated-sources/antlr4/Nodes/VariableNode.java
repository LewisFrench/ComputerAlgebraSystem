package Nodes;

/** 
 * Class storing instances of variables in an AST. 
 * Stores a string representing the value of the variable.
 * 
 * @author lewis
 */
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