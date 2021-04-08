package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;

public class TestTermAlgebraParser {


	@Test
	public void testParseSimpleNumber() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("3");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode) n).getValue().compareTo(new BigDecimal(3)) ==0);
			
			n = p.parseTerm("3.91");
			assertTrue(n instanceof NumberNode);
			System.out.println(n.toString());
			assertTrue(((NumberNode) n).getValue().compareTo(BigDecimal.valueOf(3.91)) == 0);
			
		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}
		
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
			
		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}	
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
			assertTrue(((AdditionNode)n).Right instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(((NumberNode) right).getValue().compareTo(new BigDecimal(1)) ==0);
		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}	
	}
	
	@Test
	public void testParseSimpleSubtraction() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("a-1");
			assertTrue(n instanceof SubtractionNode);
			ExpressionNode left = (((SubtractionNode)n).getLeft());
			ExpressionNode right = (((SubtractionNode)n).getRight());
			assertTrue(left instanceof VariableNode);
			assertTrue(((SubtractionNode)n).Right instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(((NumberNode) right).getValue().compareTo(new BigDecimal(1)) ==0);
		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}	
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
		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}	
	}
	
	@Test
	public void testParseSimpleUnary_Negative_Number() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("-1");
			assertTrue(n instanceof NumberNode);
			assertTrue(((NumberNode)n).getValue().compareTo(new BigDecimal(-1))==0 );
		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}	
	}
	@Test
	public void testParseSimpleUnary_Positive() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("+1");
			assertTrue(n instanceof NumberNode);

		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}	
	}
	
	@Test
	public void testParseSimpleParenthetical() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("(a)");
			assertTrue(n instanceof ParentheticalNode);
			ExpressionNode innerNode = (((ParentheticalNode)n).innerNode);
			assertTrue(((ParentheticalNode)n).innerNode instanceof VariableNode);
			assertEquals(((VariableNode)innerNode).getValue(), "a");
		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}	
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
			
			
		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}	
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
			assertTrue(((MultiplicationNode)n).Right instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(right instanceof NumberNode);
			System.out.println(n.toString());
			assertTrue(((NumberNode) right).getValue().compareTo(BigDecimal.valueOf(1)) ==0);
		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}	
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
			assertTrue(((DivisionNode)n).Right instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(((NumberNode) right).getValue().compareTo(new BigDecimal(1)) ==0);
		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}	
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
			assertTrue(((PowerNode)n).Right instanceof NumberNode);
			assertEquals(((VariableNode)left).getValue(), "a");
			assertTrue(((NumberNode) right).getValue().compareTo(new BigDecimal(1)) ==0);
		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}	
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
