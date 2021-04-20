package Nodes;

/**
 * Superclass from which all mathematical operations are derived (+, -, *, / ^)
 * 
 * @author lewis
 *
 */
public abstract class OperationNode extends ExpressionNode {

	public ExpressionNode left;
	public ExpressionNode right;
	public String operator;

	public ExpressionNode getLeft() {
		return left;
	}

	public ExpressionNode getRight() {
		return right;
	}
}
