package expression;

import java.util.LinkedHashMap;

import Conditions.ConditionsParser.RuleConditionsContext;
import RuleAlgebra.RuleAlgebraParser.RuleTermContext;

class Rule {
	RuleTermContext lhs;
	RuleTermContext rhs;
	RuleConditionsContext conditions;
	ExpressionNode lhsNode;
	ExpressionNode rhsNode;
	ExpressionNode conditionsNode;
	LinkedHashMap<String, ExpressionNode> variables;

	public Rule(RuleTermContext lhs, RuleTermContext rhs, RuleConditionsContext conditions) {
		this.lhs = lhs;
		this.rhs = rhs;
		this.conditions = conditions;
		this.variables = new LinkedHashMap<String, ExpressionNode>();
		this.lhsNode = new BuildLhsVisitor(variables).visit(lhs);
	}

	public Rule(RuleTermContext lhs, RuleTermContext rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
		this.conditions = null;
		this.variables = new LinkedHashMap<String, ExpressionNode>();
		this.lhsNode = new BuildLhsVisitor(variables).visit(lhs);
	}

	public String toString() {
		return (this.lhs.getText() + " = " + this.rhs.getText());
	}

	public ExpressionNode getLhsNode() {
		return this.lhsNode;

	}

}