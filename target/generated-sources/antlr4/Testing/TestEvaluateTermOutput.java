package Testing;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Test;

import Nodes.*;
import VisitorClasses.EvaluateTermOutput;
public class TestEvaluateTermOutput {

	@Test
	public void testEvaluateTermOutput_simple_Number() {
		ExpressionNode node = new NumberNode(BigInteger.valueOf(1));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "1");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testEvaluateTermOutput_simple_Variable() {
		ExpressionNode node = new VariableNode("xa");
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "xa");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	
	@Test
	public void testEvaluateTermOutput_simple_Addition() {
		ExpressionNode node = new AdditionNode(new VariableNode("ac"), new NumberNode(BigInteger.valueOf(3)));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "ac+3");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testEvaluateTermOutput_simple_Subtraction() {
		ExpressionNode node = new SubtractionNode(new VariableNode("ac"), new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(3)));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "ac-2/3");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	
	@Test
	public void testEvaluateTermOutput_simple_Division() {
		ExpressionNode node = new DivisionNode(new VariableNode("ac"), new NumberNode(BigInteger.valueOf(4),BigInteger.valueOf(1)));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "ac/4");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	@Test
	public void testEvaluateTermOutput_simple_Multiplication() {
		ExpressionNode node = new MultiplicationNode(new VariableNode("ac"), new NumberNode(BigInteger.valueOf(-4),BigInteger.valueOf(-2)));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "ac*2");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testEvaluateTermOutput_simple_Exponentiation() {
		ExpressionNode node = new PowerNode(new VariableNode("ac"), new NumberNode(BigInteger.valueOf(-0),BigInteger.valueOf(-1)));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "ac^0");
		} catch (Exception e1) { e1.printStackTrace();}
	}

	
	@Test
	public void testEvaluateTermOutput_simple_Unary() {
		ExpressionNode node = new UnaryNode(new VariableNode("ac"));
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals(e.Visit(node), "-ac");
		} catch (Exception e1) { e1.printStackTrace();}
	}
	

	@Test
	public void testEvaluateTermOutput_simple_Function_noArguments() {
		
		ExpressionNode node = new FunctionNode("testFunction", new ArrayList<ExpressionNode>());
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("testFunction()", e.Visit(node));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	
	@Test
	public void testEvaluateTermOutput_simple_Function_() {
		ArrayList<ExpressionNode> arguments = new ArrayList<ExpressionNode>();
		arguments.add(new VariableNode("x"));
		ExpressionNode node = new FunctionNode("testFunction", arguments);
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("testFunction(x)", e.Visit(node));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	@Test
	public void testEvaluateTermOutput_complex_Function_() {
		ArrayList<ExpressionNode> arguments = new ArrayList<ExpressionNode>();
		arguments.add(new VariableNode("x"));
		arguments.add(new VariableNode("y"));
		ExpressionNode node = new FunctionNode("testFunction", arguments);
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("testFunction(x,y)", e.Visit(node));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testEvaluateTermOutput_parentheses_exponentiation_precedence_left_operation() {
		ExpressionNode add = new AdditionNode(new VariableNode("x"), new VariableNode("y"));
		ExpressionNode power = new PowerNode(add, new VariableNode("u"));
	
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("(x+y)^u", e.Visit(power));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	@Test
	public void testEvaluateTermOutput_parentheses_exponentiation_precedence_left_exponentiation() {
		ExpressionNode add = new PowerNode(new VariableNode("x"), new VariableNode("y"));
		ExpressionNode power = new PowerNode(add, new VariableNode("u"));
	
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("(x^y)^u", e.Visit(power));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testEvaluateTermOutput_parentheses_exponentiation_precedence_right_operation() {
		ExpressionNode add = new AdditionNode(new VariableNode("x"), new VariableNode("y"));
		ExpressionNode power = new PowerNode(new VariableNode("u"), add);
	
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("u^(x+y)", e.Visit(power));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testEvaluateTermOutput_parentheses_multiplication_precedence_right_operation() {
		ExpressionNode add = new AdditionNode(new VariableNode("x"), new VariableNode("y"));
		ExpressionNode power = new MultiplicationNode(new VariableNode("u"), add);
	
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("u*(x+y)", e.Visit(power));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testEvaluateTermOutput_parentheses_multiplication_precedence_left_operation() {
		ExpressionNode add = new AdditionNode(new VariableNode("x"), new VariableNode("y"));
		ExpressionNode mult = new MultiplicationNode(add, new VariableNode("u"));
	
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("(x+y)*u", e.Visit(mult));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testEvaluateTermOutput_parentheses_Division_precedence_left_multiplication() {
		ExpressionNode mult = new MultiplicationNode(new VariableNode("x"), new VariableNode("y"));
		ExpressionNode div = new DivisionNode(new VariableNode("u"), mult);
	
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("u/(x*y)", e.Visit(div));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testEvaluateTermOutput_parentheses_Division_precedence_right_addition() {
		ExpressionNode mult = new AdditionNode(new VariableNode("x"), new VariableNode("y"));
		ExpressionNode div = new DivisionNode(new VariableNode("u"), mult);
	
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("u/(x+y)", e.Visit(div));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	@Test
	public void testEvaluateTermOutput_parentheses_Division_precedence_right_subtraction() {
		ExpressionNode add = new SubtractionNode(new VariableNode("x"), new VariableNode("y"));
		ExpressionNode div = new DivisionNode(new VariableNode("u"), add);
	
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("u/(x-y)", e.Visit(div));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	@Test
	public void testEvaluateTermOutput_parentheses_Division_precedence_left_subtraction() {
		ExpressionNode sub = new SubtractionNode(new VariableNode("x"), new VariableNode("y"));
		ExpressionNode div = new DivisionNode(sub, new VariableNode("u"));
	
		EvaluateTermOutput e= new EvaluateTermOutput();
		try {
			assertEquals("(x-y)/u", e.Visit(div));
		} catch (Exception e1) { e1.printStackTrace();}
	}
	
	
	
}
