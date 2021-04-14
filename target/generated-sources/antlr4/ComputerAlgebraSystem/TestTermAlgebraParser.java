package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;

public class TestTermAlgebraParser {


	@Test
	public void testParseSimpleNumber_Integer() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("3");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == 3);
			assertTrue(((NumberNode) n).denominator == 1);
			
			n = p.parseTerm("-3");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == -3);
			assertTrue(((NumberNode) n).denominator == 1);
			
			
			n = p.parseTerm("0");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == 0);
			assertTrue(((NumberNode) n).denominator == 1);
			
			
			n = p.parseTerm("-0");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == 0);
			assertTrue(((NumberNode) n).denominator == 1);
			
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}
		
	}

	@Test
	public void testParseSimpleNumber_Rational() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("1/3");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == 1);
			assertTrue(((NumberNode) n).denominator == 3);
			
			n = p.parseTerm("0/3");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == 0);
			assertTrue(((NumberNode) n).denominator == 1);
			
			n = p.parseTerm("1/-3");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == -1);
			assertTrue(((NumberNode) n).denominator == 3);
			
			
			n = p.parseTerm("-1/-3");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == 1);
			assertTrue(((NumberNode) n).denominator == 3);
		
			n = p.parseTerm("-001/-0003");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == 1);
			assertTrue(((NumberNode) n).denominator == 3);
			n = p.parseTerm("-1/-3");
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}
		
	}
	
	@Test
	public void testParseSimpleNumber_DecimalInteger() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("3.00000000000");
			System.out.println(n.toString());
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == 3);
			assertTrue(((NumberNode) n).denominator == 1);
			
			n = p.parseTerm("-00003.00000");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == -3);
			assertTrue(((NumberNode) n).denominator == 1);
			
			n = p.parseTerm("-00003.00000");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == -3);
			assertTrue(((NumberNode) n).denominator == 1);
			
			n = p.parseTerm("-0000.00000");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == 0);
			assertTrue(((NumberNode) n).denominator == 1);
			
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}
		
	}

	@Test
	public void testParseSimpleNumber_Decimal() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("3.7");
			System.out.println(n.toString());
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == 37);
			assertTrue(((NumberNode) n).denominator == 10);
			
			n = p.parseTerm("-3.2001");
			System.out.println(n.toString());
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == -32001);
			assertTrue(((NumberNode) n).denominator == 10000);
			
			n = p.parseTerm("-0.0001");
			System.out.println(n.toString());
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).numerator == -1);
			assertTrue(((NumberNode) n).denominator == 10000);
			
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}
		
	}
	
	@Test
	public void testParseSimpleNumber_Rational_DenominatorZero() {
		Program p = new Program();		
		try {
			assertThrows(ArithmeticException.class, () -> p.parseTerm("1/0"));
			assertThrows(ArithmeticException.class, () -> p.parseTerm("3/0"));

		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}
		
	}


	
	
	
	@Test
	public void testParseSimpleVariable() {
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
	public void testParseSimpleAddition() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("a+1");
			assertTrue(n instanceof AdditionNode);
			ExpressionNode left = (((AdditionNode)n).getLeft());
			ExpressionNode right = (((AdditionNode)n).getRight());
			assertTrue(left instanceof VariableNode);
			assertTrue(((AdditionNode)n).getRight() instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(((NumberNode) right).getNumerator() == 1);
			assertTrue(((NumberNode) right).getDenominator() == 1);
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	
	@Test
	public void testParseSimpleSubtraction() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("a-4/3");
			assertTrue(n instanceof SubtractionNode);
			ExpressionNode left = (((SubtractionNode)n).getLeft());
			ExpressionNode right = (((SubtractionNode)n).getRight());
			assertTrue(left instanceof VariableNode);
			assertTrue(((SubtractionNode)n).getRight() instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(((NumberNode) right).getNumerator() == 4);
			assertTrue(((NumberNode) right).getDenominator() == 3);
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	
	@Test
	public void testParseSimpleUnary_Negative() {
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
	public void testParseSimpleUnary_Negative_Number() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("-1");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getNumerator() == -1);
			assertTrue(((NumberNode) n).getDenominator() == 1);
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	@Test
	public void testParseSimpleUnary_Positive() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("+1");
			assertTrue(n instanceof NumberNode);

		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	
	@Test
	public void testParseSimpleFunction() {
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
	public void testParseSimpleMultiplication() {
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
			System.out.println(n.toString());
			assertTrue(((NumberNode) right).getNumerator() == 1);
			assertTrue(((NumberNode) right).getDenominator() == 1);
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	
	@Test
	public void testParseSimpleDivision() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("a/1");
			assertTrue(n instanceof DivisionNode);
			ExpressionNode left = (((DivisionNode)n).getLeft());
			ExpressionNode right = (((DivisionNode)n).getRight());
			assertTrue(left instanceof VariableNode);
			assertTrue(((DivisionNode)n).getRight() instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(((NumberNode) right).getNumerator() == 1);
			assertTrue(((NumberNode) right).getDenominator() == 1);
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}
	@Test
	public void testParseSimpleExponentiation() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("a^1");
			assertTrue(n instanceof PowerNode);
			ExpressionNode left = (((PowerNode)n).getLeft());
			ExpressionNode right = (((PowerNode)n).getRight());
			assertTrue(left instanceof VariableNode);
			assertTrue(((PowerNode)n).getRight() instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(((NumberNode) right).getNumerator() == 1);
			assertTrue(((NumberNode) right).getDenominator() == 1);
		} catch (ParseCancellationException e) {fail(); 
		} catch (Exception e) { fail();}	
	}

	
	@Test
	public void testParseSimpleRuleVariable_Exception() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("$a"));

	}

	@Test
	public void testParseInvalidVariable_Exception() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("a."));
		
	}
	
	@Test
	public void testParseInvalidNumber_Exception() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("2f"));
	}
	
	@Test
	public void testParseInvalidParenthetical_Exception() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("(a"));
	}
	@Test
	public void testParseInvalidUnary_Exception() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("-"));
	}
	@Test
	public void testParseInvalidSubtractionException() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("2-"));
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("2-."));
	}
	@Test
	public void testParseInvalidMultiplicationException() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("2*"));
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("*2"));
	}
	@Test
	public void testParseInvalidDivisionException() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("2.4/"));
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("2/."));
	}

	@Test
	public void testParseInvalidFunction_Exception() {
		Program p = new Program();
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("func("));
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("func(x,"));
		assertThrows(ParseCancellationException.class, () ->p.parseTerm("(x,2)"));
	}
	
	
	

}
