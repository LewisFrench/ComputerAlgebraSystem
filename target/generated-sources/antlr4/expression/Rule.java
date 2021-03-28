package expression;

import java.util.LinkedHashMap;

import Arithmetic.ArithmeticParser.CompileUnitContext;
import Conditions.ConditionsParser.RuleConditionsContext;

class Rule {
	CompileUnitContext lhs;
	CompileUnitContext rhs;
	RuleConditionsContext conditions;
	ExpressionNode lhsNode;
	ExpressionNode rhsNode;
	ExpressionNode conditionsNode;
	LinkedHashMap<String, ExpressionNode> variables;

	public Rule(CompileUnitContext lhs, CompileUnitContext rhs, RuleConditionsContext conditions) {
		this.lhs = lhs;
		this.rhs = rhs;
		this.conditions = conditions;
		this.variables = new LinkedHashMap<String, ExpressionNode>();
		this.lhsNode = new BuildLhsVisitor(variables).visitCompileUnit(lhs);
	}

	public Rule(CompileUnitContext lhs, CompileUnitContext rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
		this.conditions = null;
		this.variables = new LinkedHashMap<String, ExpressionNode>();
		this.lhsNode = new BuildLhsVisitor(variables).visitCompileUnit(lhs);
	}

	public String toString() {
		return (this.lhs.getText() + " = " + this.rhs.getText());
	}

	public ExpressionNode getLhsNode() {
		return this.lhsNode;

	}

}