package Nodes;

/**
 * Superclass for binary logical operations in the conditions of a rule. 
 * Stores ExpressionNode instances for the left-hand side and right-hand side of an expression. 
 * @author lewis
 *
 */
public class ConditionOperationNode extends ExpressionNode {

	ExpressionNode left;
	ExpressionNode right;

	public ExpressionNode getLeft() {
		return this.left;
	}

	public ExpressionNode getRight() {
		return this.right;
	}
}
