package ComputerAlgebraSystem;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

public class TestEvaluateExpressionVisitor {

	@Test
	public void testSimple_Number() {
		ExpressionNode node = new NumberNode(BigDecimal.valueOf(2.1));
		EvaluateExpressionVisitor e= new EvaluateExpressionVisitor();
		try {
			assertEquals(e.Visit(node), "2.1");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testSimple_Variable() {
		ExpressionNode node = new VariableNode("xa");
		EvaluateExpressionVisitor e= new EvaluateExpressionVisitor();
		try {
			assertEquals(e.Visit(node), "xa");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	
	@Test
	public void testSimple_Addition() {
		ExpressionNode node = new AdditionNode(new VariableNode("ac"), new NumberNode(BigDecimal.valueOf(2.3)));
		EvaluateExpressionVisitor e= new EvaluateExpressionVisitor();
		try {
			assertEquals(e.Visit(node), "ac+2.3");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testSimple_Subtraction() {
		ExpressionNode node = new SubtractionNode(new VariableNode("ac"), new NumberNode(BigDecimal.valueOf(2.3)));
		EvaluateExpressionVisitor e= new EvaluateExpressionVisitor();
		try {
			System.out.println(e.Visit(node));
			assertEquals(e.Visit(node), "ac-2.3");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	
	@Test
	public void testSimple_Division() {
		ExpressionNode node = new DivisionNode(new VariableNode("ac"), new NumberNode(BigDecimal.valueOf(2.3)));
		EvaluateExpressionVisitor e= new EvaluateExpressionVisitor();
		try {
			assertEquals(e.Visit(node), "ac/2.3");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	@Test
	public void testSimple_Multiplication() {
		ExpressionNode node = new MultiplicationNode(new VariableNode("ac"), new NumberNode(BigDecimal.valueOf(2.3)));
		EvaluateExpressionVisitor e= new EvaluateExpressionVisitor();
		try {
			assertEquals(e.Visit(node), "ac*2.3");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testSimple_Exponentiation() {
		ExpressionNode node = new PowerNode(new VariableNode("ac"), new NumberNode(BigDecimal.valueOf(2.3)));
		EvaluateExpressionVisitor e= new EvaluateExpressionVisitor();
		try {
			assertEquals(e.Visit(node), "ac^2.3");
		} catch (Exception e1) { e1.printStackTrace();}
	}

	
	@Test
	public void testSimple_Unary() {
		ExpressionNode node = new UnaryNode(new VariableNode("ac"));
		EvaluateExpressionVisitor e= new EvaluateExpressionVisitor();
		try {
			assertEquals(e.Visit(node), "-ac");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	

	@Test
	public void testSimple_Function_noArguments() {
		
		ExpressionNode node = new FunctionNode("testFunction", new ArrayList<ExpressionNode>());
		EvaluateExpressionVisitor e= new EvaluateExpressionVisitor();
		try {
			assertEquals("testFunction()", e.Visit(node));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	
	@Test
	public void testSimple_Function_() {
		ArrayList<ExpressionNode> arguments = new ArrayList<ExpressionNode>();
		arguments.add(new VariableNode("x"));
		ExpressionNode node = new FunctionNode("testFunction", arguments);
		EvaluateExpressionVisitor e= new EvaluateExpressionVisitor();
		try {
			assertEquals("testFunction(x)", e.Visit(node));
		} catch (Exception e1) { e1.printStackTrace();}
	}
}
