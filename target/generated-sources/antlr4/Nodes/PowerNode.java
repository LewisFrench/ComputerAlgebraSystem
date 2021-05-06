package Nodes;

/** 
 * Class storing exponentiation operations in an AST.
 * Extends OperationNode, stores an ExpressionNode for the LHS and RHS of the operation. 
 * 
 * @author lewis
 */
public class PowerNode extends OperationNode {

	public PowerNode(ExpressionNode left, ExpressionNode right) {
		this.left = left;
		this.right = right;

	}

	public String toString() {
		return (getLeft().toString() + "^" + getRight().toString());
	}
}
