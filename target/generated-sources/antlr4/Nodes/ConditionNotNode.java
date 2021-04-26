package Nodes;


/**
 * Node representing logical negation operations in the conditions of a rule. 
 * @author lewis
 *
 */
public class ConditionNotNode extends ExpressionNode {

	public ExpressionNode innerNode;

	public ConditionNotNode(ExpressionNode innerNode) {
		this.innerNode = innerNode;
	}
	public ExpressionNode getInnerNode() {
		return this.innerNode;
	}

	public String toString() {
		return "!" + this.innerNode.toString();
	}

}
