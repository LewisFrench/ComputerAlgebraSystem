package expression;

import java.util.LinkedHashMap;

import Conditions.ConditionsParser.RuleConditionsContext;
import RuleAlgebra.RuleAlgebraParser.RuleTermContext;

class Rule {
//	RuleTermContext lhs;
//	RuleTermContext rhs;
//	RuleConditionsContext conditions;
	ExpressionNode lhsNode;
	ExpressionNode rhsNode;
	ExpressionNode conditionsNode;
	LinkedHashMap<String, ExpressionNode> variables;

//	public Rule(ExpressionNode lhsNode, ExpressionNode rhsNode) {
////		this.lhs = lhs;
////		this.rhs = rhs;
//		this.lhsNode = lhsNode;
//		this.rhsNode = rhsNode;
//		FetchRuleVariables f = new FetchRuleVariables();
//		ExpressionNode test = f.Visit(lhsNode);
//		this.variables = f.variables;
//		this.conditions = null;
//		this.conditionsNode = null;
//		// this.lhsNode = new BuildLhsVisitor(variables).visit(lhs);
//	}
//
//	public Rule(ExpressionNode lhsNode, ExpressionNode rhsNode, RuleConditionsContext conditions) {
////		this.lhs = lhs;
////		this.rhs = rhs;
//		this.lhsNode = lhsNode;
//		this.rhsNode = rhsNode;
//		this.conditions = conditions;
//		FetchRuleVariables f = new FetchRuleVariables();
//		ExpressionNode test = f.Visit(lhsNode);
//		this.variables = f.variables;
//
//		// this.lhsNode = new BuildLhsVisitor(variables).visit(lhs);
//	}
	public Rule(ExpressionNode lhsNode, ExpressionNode rhsNode) {

		this.lhsNode = lhsNode;
		this.rhsNode = rhsNode;
		FetchRuleVariables f = new FetchRuleVariables();
		ExpressionNode test = f.Visit(lhsNode);
		this.variables = f.variables;
		//this.conditions = null;
		this.conditionsNode = null;
	}

	public Rule(ExpressionNode lhsNode, ExpressionNode rhsNode, ExpressionNode conditions) {
		this.lhsNode = lhsNode;
		this.rhsNode = rhsNode;
		this.conditionsNode = conditions;
		FetchRuleVariables f = new FetchRuleVariables();
		ExpressionNode test = f.Visit(lhsNode);
		this.variables = f.variables;

		// this.lhsNode = new BuildLhsVisitor(variables).visit(lhs);
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