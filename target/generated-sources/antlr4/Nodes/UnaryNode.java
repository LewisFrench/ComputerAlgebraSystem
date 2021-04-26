package Nodes;

/** 
 * Class storing instances of unary expressions in an AST. 
 * Stores an ExpressionNode of the root of the expression being negated. 
 *  
 * @author lewis
 */
public class UnaryNode extends ExpressionNode {
	public ExpressionNode innerNode;

	public UnaryNode(ExpressionNode innerNode) {
		this.innerNode = innerNode;
	}

	public String toString() {
		return "-" + this.innerNode.toString();
	}
	public ExpressionNode getInnerNode() {
		return this.innerNode;
	}
}