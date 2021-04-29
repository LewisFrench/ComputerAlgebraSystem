package Testing;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Test;

import Nodes.*;
import VisitorClasses.EvaluateTermOutput;
public class TestEvaluateExpressionVisitor {

	@Test
	public void testSimple_Number() {
		ExpressionNode node = new NumberNode(BigInteger.valueOf(1));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "1");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testSimple_Variable() {
		ExpressionNode node = new VariableNode("xa");
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "xa");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	
	@Test
	public void testSimple_Addition() {
		ExpressionNode node = new AdditionNode(new VariableNode("ac"), new NumberNode(BigInteger.valueOf(3)));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "ac+3");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testSimple_Subtraction() {
		ExpressionNode node = new SubtractionNode(new VariableNode("ac"), new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(3)));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			System.out.println(e.Visit(node));
			assertEquals(e.Visit(node), "ac-2/3");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	
	@Test
	public void testSimple_Division() {
		ExpressionNode node = new DivisionNode(new VariableNode("ac"), new NumberNode(BigInteger.valueOf(4),BigInteger.valueOf(1)));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "ac/4");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	@Test
	public void testSimple_Multiplication() {
		ExpressionNode node = new MultiplicationNode(new VariableNode("ac"), new NumberNode(BigInteger.valueOf(-4),BigInteger.valueOf(-2)));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "ac*2");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testSimple_Exponentiation() {
		ExpressionNode node = new PowerNode(new VariableNode("ac"), new NumberNode(BigInteger.valueOf(-0),BigInteger.valueOf(-1)));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "ac^0");
		} catch (Exception e1) { e1.printStackTrace();}
	}

	
	@Test
	public void testSimple_Unary() {
		ExpressionNode node = new UnaryNode(new VariableNode("ac"));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "-ac");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	

	@Test
	public void testSimple_Function_noArguments() {
		
		ExpressionNode node = new FunctionNode("testFunction", new ArrayList<ExpressionNode>());
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("testFunction()", e.Visit(node));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	
	@Test
	public void testSimple_Function_() {
		ArrayList<ExpressionNode> arguments = new ArrayList<ExpressionNode>();
		arguments.add(new VariableNode("x"));
		ExpressionNode node = new FunctionNode("testFunction", arguments);
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("testFunction(x)", e.Visit(node));
		} catch (Exception e1) { e1.printStackTrace();}
	}
}
