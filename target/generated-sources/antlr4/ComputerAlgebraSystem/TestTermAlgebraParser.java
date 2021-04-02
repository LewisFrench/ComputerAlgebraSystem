package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Test;

public class TestTermAlgebraParser {


	@Test
	public void testParseSimpleNumber() {
		Program p = new Program();
		
		
		try {
			ExpressionNode n = p.parseTerm("3");
			assertTrue(n instanceof NumberNode);
			assertEquals(((NumberNode)n).getValue(), 3);
			
			n = p.parseTerm("3.91");
			assertTrue(n instanceof NumberNode);
			assertEquals(((NumberNode)n).getValue(), 3.91);
			
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
			assertEquals(((NumberNode)right).getValue(), 1);
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
			assertEquals(((NumberNode)right).getValue(), 1);
		} catch (ParseCancellationException e) {e.printStackTrace(); 
		} catch (Exception e) { e.printStackTrace();}	
	}
	
	
	@Test
	public void testParseSimpleUnary() {
		Program p = new Program();
		
		try {
			ExpressionNode n = p.parseTerm("-1");
			assertTrue(n instanceof UnaryNode);
			ExpressionNode innerNode = (((UnaryNode)n).innerNode);
			assertTrue(((UnaryNode)n).innerNode instanceof NumberNode);
			assertEquals(((NumberNode)innerNode).getValue(), 1);
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
			ExpressionNode n = p.parseTerm("TestFunction(x,1,-2)");
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
			assertEquals(((NumberNode)right).getValue(), 1);
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
			assertEquals(((NumberNode)right).getValue(), 1);
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
