package Testing;

import static org.junit.Assert.*;

import org.junit.Test;

import ComputerAlgebraSystem.Rule;
import Nodes.*;
import Conditions.ConditionsLexer;

public class TestRule {

	@Test
	public void testRuleCreation_No_Conditions() {
		ExpressionNode lhsNode = new RuleVariableNode("x");
		ExpressionNode rhsNode = new NumberNode(2);
		
		try {
			Rule r = new Rule(lhsNode, rhsNode);
			assertTrue(r.getLhsNode() instanceof RuleVariableNode);
			assertTrue(r.getRhsNode() instanceof NumberNode);
		} catch (Exception e) {	fail(); }
		
	}
	

	@Test
	public void testRuleCreation_Conditions() {
		ExpressionNode lhsNode = new RuleVariableNode("x");
		ExpressionNode rhsNode = new NumberNode(2);
		ExpressionNode conditionsNode = new RelopNode(new NumberNode(2), new NumberNode(3), ConditionsLexer.RELOP_EQ, "==");
		
		try {
			Rule r = new Rule(lhsNode, rhsNode, conditionsNode);
			assertTrue(r.getLhsNode() instanceof RuleVariableNode);
			assertTrue(r.getRhsNode() instanceof NumberNode);
		} catch (Exception e) {	fail(); }
		
	}
	

}
