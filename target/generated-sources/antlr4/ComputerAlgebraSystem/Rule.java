package ComputerAlgebraSystem;

/**
 * Class storing the components of a rewrite rule in AST format
 * @author lewis
 *
 */
class Rule {
	ExpressionNode lhsNode;
	ExpressionNode rhsNode;
	ExpressionNode conditionsNode;

	public Rule(ExpressionNode lhsNode, ExpressionNode rhsNode) throws Exception {
		this.lhsNode = lhsNode;
		this.rhsNode = rhsNode;
		this.conditionsNode = null;
	}

	public Rule(ExpressionNode lhsNode, ExpressionNode rhsNode, ExpressionNode conditions) throws Exception {
		this.lhsNode = lhsNode;
		this.rhsNode = rhsNode;
		this.conditionsNode = conditions;

	}

	public String toString() {
		if (this.conditionsNode != null) {
			return (this.lhsNode.toString() + " = " + this.rhsNode.toString() + " : " + this.conditionsNode.toString());
		} else {
			return (this.lhsNode.toString() + " = " + this.rhsNode.toString());
		}
	}

	public ExpressionNode getLhsNode() {
		return this.lhsNode;

	}

	public ExpressionNode getRhsNode() {
		return this.rhsNode;
	}
	
	public ExpressionNode getConditions() {
		return this.conditionsNode;
	}
	
	

}