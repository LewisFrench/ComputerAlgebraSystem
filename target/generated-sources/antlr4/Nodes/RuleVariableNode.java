package Nodes;

/**
 * Class storing instances of rule variables in an AST. 
 * Stores a string denoting the value of the rule variable. 
 * 
 * @author lewis
 */
public class RuleVariableNode extends ExpressionNode {
	public String value;

	public RuleVariableNode(String value) {
		this.value = value;
	}

	public String toString() {
		return "$" + this.value;
	}

}