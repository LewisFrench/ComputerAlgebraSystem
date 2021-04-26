package Nodes;

/**
 * Node representing logical disjunction operations in the conditions of a rule. 
 * Stores ExpressionNodes for the left and right-hand sides of the operation. 
 * 
 * @author lewis
 */
public class ConditionOrNode extends ConditionOperationNode {
	public ConditionOrNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return this.left.toString() + " | " + this.right.toString();
	}
}
