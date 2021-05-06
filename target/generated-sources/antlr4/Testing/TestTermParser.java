package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;

import ComputerAlgebraSystem.Program;
import Nodes.*;
public class TestTermParser {


	@Test
	public void testTermParser_ParseSimpleNumber_Integer() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("3");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( 3))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
			
			n = p.parseTerm("-3");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( -3))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
			
			
			n = p.parseTerm("0");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( 0))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
			
			
			n = p.parseTerm("-0");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( 0))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
			
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}
		
	}

	@Test
	public void testTermParser_ParseSimpleNumber_Rational() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("1/3");
			
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( 1))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 3))==0);
			
			n = p.parseTerm("0/3");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( 0))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
			
			n = p.parseTerm("1/-3");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( -1))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 3))==0);
			
			
			n = p.parseTerm("-1/-3");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( 1))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 3))==0);
		
			n = p.parseTerm("-001/-0003");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( 1))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 3))==0);
			n = p.parseTerm("-1/-3");
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}
		
	}
	
	@Test
	public void testTermParser_ParseSimpleNumber_DecimalInteger() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("3.00000000000");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( 3))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
			
			n = p.parseTerm("-00003.00000");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( -3))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
			
			n = p.parseTerm("-00003.00000");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( -3))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
//			
			n = p.parseTerm("-0000.00000");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( 0))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
			
		} catch (ParseCancellationException e) {fail(); 
			
		} catch (Exception e) { 
			e.printStackTrace();
			System.out.println(e.getMessage());
			fail();}
		
	}

	@Test
	public void testTermParser_ParseSimpleNumber_Decimal() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("3.7");
			assertTrue(n instanceof NumberNode);

			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( 37))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 10))==0);
			
			n = p.parseTerm("-3.2001");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( -32001))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 10000))==0);
			
			n = p.parseTerm("-0.0001");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( -1))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 10000))==0);
			
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}
		
	}
	
	@Test
	public void testTermParser_ParseSimpleNumber_Rational_DenominatorZero() {
		Program p = new Program();		
		try {
			assertThrows(ArithmeticException.class, () -> p.parseTerm("1/0"));
			assertThrows(ArithmeticException.class, () -> p.parseTerm("3/0"));

		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}
		
	}


	
	
	
	@Test
	public void testTermParser_ParseSimpleVariable() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("a");
			assertTrue(n instanceof VariableNode);
			assertEquals(((VariableNode)n).getValue(), "a");
			
			n = p.parseTerm("test");
			assertTrue(n instanceof VariableNode);
			assertEquals(((VariableNode)n).getValue(), "test");
			
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	
	@Test
	public void testTermParser_ParseSimpleAddition() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("a+1");
			assertTrue(n instanceof AdditionNode);
			ExpressionNode left = (((AdditionNode)n).getLeft());
			ExpressionNode right = (((AdditionNode)n).getRight());
			assertTrue(left instanceof VariableNode);
			assertTrue(((AdditionNode)n).getRight() instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(((NumberNode) right).getNumerator().compareTo(BigInteger.valueOf( 1))==0);
			assertTrue(((NumberNode) right).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	
	@Test
	public void testTermParser_ParseSimpleSubtraction() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("a-4/3");
			assertTrue(n instanceof SubtractionNode);
			ExpressionNode left = (((SubtractionNode)n).getLeft());
			ExpressionNode right = (((SubtractionNode)n).getRight());
			assertTrue(left instanceof VariableNode);
			assertTrue(((SubtractionNode)n).getRight() instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(((NumberNode) right).getNumerator().compareTo(BigInteger.valueOf( 4))==0);
			assertTrue(((NumberNode) right).getDenominator().compareTo(BigInteger.valueOf( 3))==0);
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	
	@Test
	public void testTermParser_ParseSimpleUnary_Negative() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("-x");
			assertTrue(n instanceof UnaryNode);
			ExpressionNode innerNode = (((UnaryNode)n).innerNode);
			assertTrue(((UnaryNode)n).innerNode instanceof VariableNode);
			assertTrue(((VariableNode) innerNode).getValue().equals("x"));
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	
	@Test
	public void testTermParser_ParseSimpleUnary_Redundant() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("--x");
			assertTrue(n instanceof VariableNode);
		
			assertTrue(((VariableNode) n).getValue().equals("x"));
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	
	@Test
	public void testTermParser_ParseSimpleUnary_Negative_Number() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("-1");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator().compareTo(BigInteger.valueOf( -1))==0);
			assertTrue(((NumberNode) n).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	@Test
	public void testTermParser_ParseSimpleUnary_Positive() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("+1");
			assertTrue(n instanceof NumberNode);

		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	
	@Test
	public void testTermParser_ParseSimpleFunction() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("TestFunction(x,1,-x)");
			assertTrue(n instanceof FunctionNode);
			FunctionNode nFunc = (FunctionNode) n;
			assertTrue(nFunc.arguments.size() == 3);
			assertTrue(nFunc.arguments.get(0) instanceof VariableNode);
			assertTrue(nFunc.arguments.get(1) instanceof NumberNode);
			assertTrue(nFunc.arguments.get(2) instanceof UnaryNode);
			
			
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	@Test
	public void testTermParser_ParseSimple_Parentheses() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("((x))");
			assertTrue(n instanceof VariableNode);
		
			assertTrue(((VariableNode) n).getValue().equals("x"));
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	
	
	
	@Test
	public void testTermParser_ParseSimpleMultiplication() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("a*+1");
			assertTrue(n instanceof MultiplicationNode);
			ExpressionNode left = (((MultiplicationNode)n).getLeft());
			ExpressionNode right = (((MultiplicationNode)n).getRight());
			assertTrue(left instanceof VariableNode);
			assertTrue(((MultiplicationNode)n).getRight() instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(right instanceof NumberNode);
			assertTrue(((NumberNode) right).getNumerator().compareTo(BigInteger.valueOf( 1))==0);
			assertTrue(((NumberNode) right).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	
	@Test
	public void testTermParser_ParseSimpleDivision() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("a/1");
			assertTrue(n instanceof DivisionNode);
			ExpressionNode left = (((DivisionNode)n).getLeft());
			ExpressionNode right = (((DivisionNode)n).getRight());
			assertTrue(left instanceof VariableNode);
			assertTrue(((DivisionNode)n).getRight() instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(((NumberNode) right).getNumerator().compareTo(BigInteger.valueOf( 1))==0);
			assertTrue(((NumberNode) right).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	@Test
	public void testTermParser_ParseSimpleExponentiation() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("a^1");
			assertTrue(n instanceof PowerNode);
			ExpressionNode left = (((PowerNode)n).getLeft());
			ExpressionNode right = (((PowerNode)n).getRight());
			assertTrue(left instanceof VariableNode);
			assertTrue(((PowerNode)n).getRight() instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(((NumberNode) right).getNumerator().compareTo(BigInteger.valueOf( 1))==0);
			assertTrue(((NumberNode) right).getDenominator().compareTo(BigInteger.valueOf( 1))==0);
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}

	
	@Test
	public void testTermParser_ParseSimpleRuleVariable_Exception() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("$a"));

	}

	@Test
	public void testTermParser_ParseInvalidVariable_Exception() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("a."));
		
	}
	
	@Test
	public void testTermParser_ParseInvalidNumber_Exception() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("2f"));
	}
	
	@Test
	public void testTermParser_ParseInvalidParenthetical_Exception() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("(a"));
	}
	@Test
	public void testTermParser_ParseInvalidUnary_Exception() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("-"));
	}
	@Test
	public void testTermParser_ParseInvalidSubtractionException() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("2-"));
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("2-."));
	}
	@Test
	public void testTermParser_ParseInvalidMultiplicationException() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("2*"));
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("*2"));
	}
	@Test
	public void testTermParser_ParseInvalidDivisionException() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("2.4/"));
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("2/."));
	}

	@Test
	public void testTermParser_ParseInvalidFunction_Exception() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("func("));
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("func(x,"));
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("(x,2)"));
	}
	
	
	

}
