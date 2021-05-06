package Nodes;

/**
 * Node type representing relational operations in the conditions of the rule
 * Stores the LHS and RHS of the operation as ExpressionNodes Stores the integer
 * value of the relational operator as per the ConditionsLexer Stores a string
 * representation of this operator for output purposes.
 * 
 * @author lewis
 *
 */
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
