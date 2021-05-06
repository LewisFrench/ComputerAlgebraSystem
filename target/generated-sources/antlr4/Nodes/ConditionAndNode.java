package Nodes;

/**
 * Node representing logical conjunction operations in the conditions of a rule.
 * Stores ExpressionNodes representing the LHS and RHS of the operation.
 * 
 * @author lewis
 *
 */
public class ConditionAndNode extends ConditionOperationNode {
	public ConditionAndNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return this.left.toString() + " & " + this.right.toString();
	}
}
