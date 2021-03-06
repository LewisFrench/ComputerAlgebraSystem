package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.ArrayList;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;

import ComputerAlgebraSystem.Program;
import ComputerAlgebraSystem.RewriteRuleFormatException;
import ComputerAlgebraSystem.Rule;
import Nodes.*;
public class TestProgram {

	@Test
	public void testParseRule_Normal_withConditions() {
		Program p = new Program();
		try {
			Rule r = p.parseRule("x = 1 : 3>4");
			assertTrue(r instanceof Rule);
			assertTrue(r.getConditionsNode() != null);
			assertTrue(r.getConditionsNode() instanceof RelopNode);
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testParseRule_Normal_noConditions() {
		Program p = new Program();
		try {
			Rule r = p.parseRule("x = 1");
			assertTrue(r instanceof Rule);
			assertTrue(r.getConditionsNode()  == null);
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}
	
	@Test
	public void testParseRule_EmptyLine_Exception() {
		Program p = new Program();
		try {
			assertThrows(NullPointerException.class, ()-> p.parseRule(""));
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}
	
	@Test
	public void testParseRule_ConditionRuleVairables_Exception() {
		Program p = new Program();
		try {
			assertThrows(RewriteRuleFormatException.class, ()-> p.parseRule("$x = $x : $y > 0"));
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}
	
	
	@Test
	public void testParseRule_DivisionByZero_Exception() {
		Program p = new Program();
		try {
			assertThrows(ArithmeticException.class, ()-> p.parseRule("$x = $x/0"));
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testParseRule_ParseCancellationException_LHS() {
		Program p = new Program();
		try {
			assertThrows(ParseCancellationException.class, () -> p.parseRule("x1 =1 : 3>4"));
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testParseRule_ParseCancellationException_Conditions() {
		Program p = new Program();
		try {
			assertThrows(ParseCancellationException.class, () -> p.parseRule("x =1 : 3==>4x"));
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testParseRule_ParseCancellationException_RHS() {
		Program p = new Program();
		try {
			assertThrows(ParseCancellationException.class, () -> p.parseRule("x ==1 : 3>4"));
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}
	
	@Test
	public void testParseRule_SplitError_NoEquals() {
		Program p = new Program();
		try {
			assertThrows(RewriteRuleFormatException.class, () -> p.parseRule("x"));
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}
	
	
	@Test
	public void testParseRule_SplitError_NoRHS() {
		Program p = new Program();
		try {
			assertThrows(RewriteRuleFormatException.class, () -> p.parseRule("x="));
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}
	
	@Test
	public void testParseRule_SplitError_NoLHS() {
		Program p = new Program();
		try {
			assertThrows(RewriteRuleFormatException.class, () -> p.parseRule("=x"));
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}
	
	@Test
	public void testParseRule_SplirError_ConditionsSymbolNoConditions() {
		Program p = new Program();
		try {
			assertThrows(RewriteRuleFormatException.class, () -> p.parseRule("x=y:"));
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}
	
	

	@Test
	public void testParseRule_RHSRuleVariables_Correspond_False() {
		Program p = new Program();
		try {
			assertThrows(Exception.class, () -> p.parseRule("$x = $y+$x"));

		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testParseRule_ConditionRuleVariables_Correspond_False() {
		Program p = new Program();
		try {
			assertThrows(Exception.class, () -> p.parseRule("$x = $x : is_number($y)"));

		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testParseTerm_Normal() {
		Program p = new Program();
		try {
			ExpressionNode node = p.parseTerm("x+1");
			assertTrue(node instanceof AdditionNode);
		} catch (ParseCancellationException e) {
			fail();
		} catch (Exception e) {
			fail();
		}

	}
	
	@Test
	public void testParseTerm_Invalid_ParseCancellationException() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () -> p.parseTerm("x+"));

	}

	@Test
	public void testParseTerm_Null_Exception() {
		Program p = new Program();

		assertThrows(Exception.class, () -> p.parseTerm(null));

	}
	
	@Test
	public void testParseTerm_DivideByZero_Exception() {
		Program p = new Program();

		assertThrows(Exception.class, () -> p.parseTerm("x/0"));
	}

	@Test
	public void testParseTerm_Empty_Exception() {
		Program p = new Program();

		assertThrows(Exception.class, () -> p.parseTerm(""));

	}
	@Test
	public void testRewrite_Normal() {
		Program p = new Program();
		ArrayList<Rule> rules = new ArrayList<>();
		try { 
			Rule r= new Rule(new VariableNode("x"), new NumberNode(BigInteger.ONE));
			rules.add(r);
			String result = p.Rewrite(rules,new VariableNode("x"), 100);
			assertTrue(result.equals("1"));
		} catch (Exception e ) {fail();}

	}
	@Test
	public void testRewrite_InfiniteRecursion_StackOverFlow() {
		Program p = new Program();
		ArrayList<Rule> rules = new ArrayList<>();
		try { 
			Rule r= new Rule(new RuleVariableNode("x"), new AdditionNode (new AdditionNode(new RuleVariableNode("x"),new RuleVariableNode("x")), new AdditionNode(new RuleVariableNode("x"),new RuleVariableNode("x"))));
			rules.add(r);
			assertThrows(StackOverflowError.class, ()-> p.Rewrite(rules,new VariableNode("x"), 1000000));
		} catch (Exception e ) {fail();}

	}
	
	@Test
	public void testRewrite_RewriteError() {
		Program p = new Program();
		ArrayList<Rule> rules = new ArrayList<>();
		try { 
			Rule r= new Rule(new RuleVariableNode("x"), new RuleVariableNode("x"));
			rules.add(r);
			assertThrows(Exception.class, () -> p.Rewrite(rules, new RuleVariableNode("a"), 100));
			
		} catch (Exception e ) {fail();}

	}
	@Test
	public void testRewriteDeterministic_Normal() {
		Program p = new Program();
		ArrayList<Rule> rules = new ArrayList<>();
		try { 
			Rule r= new Rule(new VariableNode("x"), new NumberNode(BigInteger.ONE));
			rules.add(r);
			String result = p.RewriteDeterministic(rules,new VariableNode("x"), 100);
			assertTrue(result.equals("1"));
		} catch (Exception e ) {fail();}

	}
	@Test
	public void testRewriteDeterministic_InfiniteRecursion_StackOverFlow() {
		Program p = new Program();
		ArrayList<Rule> rules = new ArrayList<>();
		try { 
			Rule r= new Rule(new RuleVariableNode("x"), new AdditionNode (new AdditionNode(new RuleVariableNode("x"),new RuleVariableNode("x")), new AdditionNode(new RuleVariableNode("x"),new RuleVariableNode("x"))));
			rules.add(r);
			assertThrows(StackOverflowError.class, ()-> p.RewriteDeterministic(rules,new VariableNode("x"), 1000000));
		} catch (Exception e ) {fail();}

	}
	
	@Test
	public void testRewriteDeterministic_RewriteError() {
		Program p = new Program();
		ArrayList<Rule> rules = new ArrayList<>();
		try { 
			Rule r= new Rule(new RuleVariableNode("x"), new RuleVariableNode("x"));
			rules.add(r);
			assertThrows(Exception.class, () -> p.RewriteDeterministic(rules, new RuleVariableNode("a"), 100));
			
		} catch (Exception e ) {fail();}

	}
	
	
}
