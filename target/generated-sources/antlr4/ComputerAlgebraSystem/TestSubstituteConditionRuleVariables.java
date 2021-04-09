package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Test;

import Conditions.ConditionsLexer;

public class TestSubstituteConditionRuleVariables {

	@Test
	public void TestSubstituteConditionRuleVariables_Relop_Operation() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		RelopNode relop = new RelopNode(new NumberNode(3.2), new RuleVariableNode("n"), ConditionsLexer.RELOP_EQ, "==");
		
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		
		try { 
			ExpressionNode result = s.Visit(relop);
			RelopNode relopResult = (RelopNode) result;
			assertTrue(relopResult.left instanceof NumberNode);
			assertTrue(relopResult.right instanceof VariableNode);
			assertEquals(((VariableNode)relopResult.right).getValue(), "x");
		} catch (Exception e ) {fail();}
	}

	@Test
	public void TestSubstituteConditionRuleVariables_Not() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		ExpressionNode subtraction = new SubtractionNode(new VariableNode("Var"), new RuleVariableNode("n"));
		ExpressionNode relop = new RelopNode(subtraction, new NumberNode(2), ConditionsLexer.RELOP_GTE, ">=");
		ExpressionNode not = new NotNode(relop);
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		
		try { 
			ExpressionNode result = s.Visit(not);
			NotNode notResult = (NotNode) result;
			assertTrue(notResult.innerNode instanceof RelopNode);
			
			assertTrue(((RelopNode)notResult.innerNode).left instanceof SubtractionNode);
		} catch (Exception e ) {fail();}
	}
	

	
	@Test
	public void TestSubstituteConditionRuleVariables_ConditionFunction() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new AdditionNode(new VariableNode("a"), new NumberNode(2.1)));
		
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new RuleVariableNode("n"));
		ExpressionNode node = new ConditionFunctionNode("_is_number", arguments);
		
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		
		try { 
			ExpressionNode result = s.Visit(node);
			assertTrue(result instanceof ConditionFunctionNode);
			
			assertTrue(((ConditionFunctionNode)result).getArguments().get(0) instanceof AdditionNode);
		} catch (Exception e ) {fail();}
	}	
	
	@Test
	public void TestSubstituteConditionRuleVariables_Relop_Unary() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		RelopNode relop = new RelopNode(new NumberNode(3.2),new UnaryNode( new RuleVariableNode("n")), ConditionsLexer.RELOP_EQ, "==");
		
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		
		try { 
			ExpressionNode result = s.Visit(relop);
			RelopNode relopResult = (RelopNode) result;
			assertTrue(relopResult.left instanceof NumberNode);
			assertTrue(relopResult.right instanceof UnaryNode);
			assertTrue(((UnaryNode)relopResult.right).innerNode instanceof VariableNode);
		} catch (Exception e ) {fail();}
	}
	
	
	@Test
	public void TestSubstituteConditionRuleVariables_logicalAND() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		
		RelopNode relop = new RelopNode(new NumberNode(3.2),new DivisionNode(new NumberNode(2), new NumberNode(4)), ConditionsLexer.RELOP_EQ, "==");
		RelopNode relop2 = new RelopNode(new NumberNode(3.2),new MultiplicationNode( new VariableNode("x"), new RuleVariableNode("n")), ConditionsLexer.RELOP_EQ, "==");
		ExpressionNode and = new ConditionAndNode(relop,relop2 );
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		
		try { 
			ExpressionNode result = s.Visit(and);
			ConditionAndNode andResult = (ConditionAndNode) result;
			assertTrue(andResult.left instanceof RelopNode);
			assertTrue(andResult.right instanceof RelopNode);
			RelopNode rightRelop = (RelopNode)andResult.right;
			MultiplicationNode relopMult = (MultiplicationNode)rightRelop.right;
			assertTrue(relopMult.Right instanceof VariableNode);
			
		} catch (Exception e ) {fail();}
	}
	
	
	@Test
	public void TestSubstituteConditionRuleVariables_logicalOR() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		
		RelopNode relop = new RelopNode(new NumberNode(3.2),new AdditionNode(new NumberNode(2), new NumberNode(4)), ConditionsLexer.RELOP_EQ, "==");
		RelopNode relop2 = new RelopNode(new NumberNode(3.2),new PowerNode( new VariableNode("x"), new RuleVariableNode("n")), ConditionsLexer.RELOP_EQ, "==");
		ExpressionNode and = new ConditionOrNode(relop,relop2 );
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		
		try { 
			ExpressionNode result = s.Visit(and);
			ConditionOrNode andResult = (ConditionOrNode) result;
			assertTrue(andResult.left instanceof RelopNode);
			assertTrue(andResult.right instanceof RelopNode);
			RelopNode rightRelop = (RelopNode)andResult.right;
			PowerNode relopPow = (PowerNode)rightRelop.right;
			assertTrue(relopPow.Right instanceof VariableNode);
			
		} catch (Exception e ) {fail();}
	}
	
	@Test 
	public void TestSubstitutionConditionRuleVariables_Visit_Invalid_RuleVariableNode_Exception() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		ArrayList<ExpressionNode> arguments = new ArrayList<ExpressionNode>();
		arguments.add(new NumberNode(2));
		arguments.add(new RuleVariableNode("a"));
		
		RelopNode relop = new RelopNode(new NumberNode(3.2),new AdditionNode(new FunctionNode("testFunc", new ArrayList<ExpressionNode>()), new FunctionNode("Test", arguments)), ConditionsLexer.RELOP_EQ, "==");
		
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		assertThrows(Exception.class, ()-> s.Visit(relop));
	}
	
	
	
	
	
	
	
	
}
