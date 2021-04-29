package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Test;

import Conditions.ConditionsLexer;
import Nodes.*;
import VisitorClasses.SubstituteConditionRuleVariables;
public class TestSubstituteConditionRuleVariables {

	@Test
	public void TestSubstituteConditionRuleVariables_Relop_Operation() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		RelopNode relop = new RelopNode(new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(2)), new RuleVariableNode("n"), ConditionsLexer.RELOP_EQ, "==");
		
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		
		try { 
			ExpressionNode result = s.Visit(relop);
			RelopNode relopResult = (RelopNode) result;
			assertTrue(relopResult.getLeft() instanceof NumberNode);
			assertTrue(relopResult.getRight() instanceof VariableNode);
			assertEquals(((VariableNode)relopResult.getRight()).getValue(), "x");
		} catch (Exception e ) {fail();}
	}

	@Test
	public void TestSubstituteConditionRuleVariables_Not() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		ExpressionNode subtraction = new SubtractionNode(new VariableNode("Var"), new RuleVariableNode("n"));
		ExpressionNode relop = new RelopNode(subtraction, new NumberNode(BigInteger.valueOf(2)), ConditionsLexer.RELOP_GTE, ">=");
		ExpressionNode not = new ConditionNotNode(relop);
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		
		try { 
			ExpressionNode result = s.Visit(not);
			ConditionNotNode notResult = (ConditionNotNode) result;
			assertTrue(notResult.innerNode instanceof RelopNode);
			
			assertTrue(((RelopNode)notResult.innerNode).getLeft() instanceof SubtractionNode);
		} catch (Exception e ) {fail();}
	}
	

	
	@Test
	public void TestSubstituteConditionRuleVariables_ConditionFunction() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new AdditionNode(new VariableNode("a"), new NumberNode(BigInteger.valueOf(2))));
		
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
		
		RelopNode relop = new RelopNode(new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(2)),new UnaryNode( new RuleVariableNode("n")), ConditionsLexer.RELOP_EQ, "==");
		
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		
		try { 
			ExpressionNode result = s.Visit(relop);
			RelopNode relopResult = (RelopNode) result;
			assertTrue(relopResult.getLeft() instanceof NumberNode);
			assertTrue(relopResult.getRight() instanceof UnaryNode);
			assertTrue(((UnaryNode)relopResult.getRight()).innerNode instanceof VariableNode);
		} catch (Exception e ) {fail();}
	}
	
	
	@Test
	public void TestSubstituteConditionRuleVariables_logicalAND() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		
		RelopNode relop = new RelopNode(new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(2)),new DivisionNode(new NumberNode(BigInteger.valueOf(2)), new NumberNode(BigInteger.valueOf(4))), ConditionsLexer.RELOP_EQ, "==");
		RelopNode relop2 = new RelopNode(new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(2)),new MultiplicationNode( new VariableNode("x"), new RuleVariableNode("n")), ConditionsLexer.RELOP_EQ, "==");
		ExpressionNode and = new ConditionAndNode(relop,relop2 );
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		
		try { 
			ExpressionNode result = s.Visit(and);
			ConditionAndNode andResult = (ConditionAndNode) result;
			assertTrue(andResult.getLeft() instanceof RelopNode);
			assertTrue(andResult.getRight() instanceof RelopNode);
			RelopNode rightRelop = (RelopNode)andResult.getRight();
			MultiplicationNode relopMult = (MultiplicationNode)rightRelop.getRight();
			assertTrue(relopMult.getRight() instanceof VariableNode);
			
		} catch (Exception e ) {fail();}
	}
	
	
	@Test
	public void TestSubstituteConditionRuleVariables_logicalOR() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		
		RelopNode relop = new RelopNode(new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(2)),new AdditionNode(new NumberNode(BigInteger.valueOf(2)), new NumberNode(BigInteger.valueOf(4))), ConditionsLexer.RELOP_EQ, "==");
		RelopNode relop2 = new RelopNode(new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(2)),new PowerNode( new VariableNode("x"), new RuleVariableNode("n")), ConditionsLexer.RELOP_EQ, "==");
		ExpressionNode and = new ConditionOrNode(relop,relop2 );
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		
		try { 
			ExpressionNode result = s.Visit(and);
			ConditionOrNode andResult = (ConditionOrNode) result;
			assertTrue(andResult.getLeft() instanceof RelopNode);
			assertTrue(andResult.getRight() instanceof RelopNode);
			RelopNode rightRelop = (RelopNode)andResult.getRight();
			PowerNode relopPow = (PowerNode)rightRelop.getRight();
			assertTrue(relopPow.getRight() instanceof VariableNode);
			
		} catch (Exception e ) {fail();}
	}
	
	@Test 
	public void TestSubstitutionConditionRuleVariables_Visit_Invalid_RuleVariableNode_Exception() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		
		ArrayList<ExpressionNode> arguments = new ArrayList<ExpressionNode>();
		arguments.add(new NumberNode(BigInteger.valueOf(2)));
		arguments.add(new RuleVariableNode("a"));
		
		RelopNode relop = new RelopNode(new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(2)),new AdditionNode(new FunctionNode("testFunc", new ArrayList<ExpressionNode>()), new FunctionNode("Test", arguments)), ConditionsLexer.RELOP_EQ, "==");
		
		SubstituteConditionRuleVariables s = new SubstituteConditionRuleVariables(variables);
		assertThrows(Exception.class, ()-> s.Visit(relop));
	}
}
