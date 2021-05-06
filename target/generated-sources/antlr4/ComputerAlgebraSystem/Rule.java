package ComputerAlgebraSystem;

import Nodes.*;
/**
 * Class storing the components of a rewrite rule in AST format
 * @author lewis
 *
 */
public class Rule {
	ExpressionNode lhsNode;
	ExpressionNode rhsNode;
	ExpressionNode conditionsNode;

	// Constructor if no rule conditions
	public Rule(ExpressionNode lhsNode, ExpressionNode rhsNode) throws Exception {
		this.lhsNode = lhsNode;
		this.rhsNode = rhsNode;
		this.conditionsNode = null;
	}
	// constructor if rule has conditions
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
	
	public ExpressionNode getConditionsNode() {
		return this.conditionsNode;
	}
	
	

}