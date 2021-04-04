package ComputerAlgebraSystem;

import java.util.LinkedHashMap;

import Conditions.ConditionsParser.RuleConditionsContext;
import RuleAlgebra.RuleAlgebraParser.RuleTermContext;

class Rule {
	ExpressionNode lhsNode;
	ExpressionNode rhsNode;
	ExpressionNode conditionsNode;
	LinkedHashMap<String, ExpressionNode> variables;

	public Rule(ExpressionNode lhsNode, ExpressionNode rhsNode) throws Exception {

		this.lhsNode = lhsNode;
		this.rhsNode = rhsNode;
		FetchRuleVariables f = new FetchRuleVariables();
		f.Visit(lhsNode); 
		this.variables = f.variables;
		this.conditionsNode = null;
	}

	public Rule(ExpressionNode lhsNode, ExpressionNode rhsNode, ExpressionNode conditions) throws Exception {
		this.lhsNode = lhsNode;
		this.rhsNode = rhsNode;
		this.conditionsNode = conditions;
		FetchRuleVariables f = new FetchRuleVariables();
		f.Visit(lhsNode);
		this.variables = f.variables;

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

}