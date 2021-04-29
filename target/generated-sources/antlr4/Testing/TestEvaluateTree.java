package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Test;

import Nodes.*;
import VisitorClasses.EvaluateTree;
public class TestEvaluateTree {


	@Test
	public void testEvaluateTree_Variable() {
		ExpressionNode l = new VariableNode("x");
		ExpressionNode r = new VariableNode("x");
		
		EvaluateTree treeMatcher = new EvaluateTree();
		try {
			assertTrue(treeMatcher.Visit(l,  r));
			assertFalse(treeMatcher.Visit(l,  new VariableNode("xy")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	
	}
	
	@Test
	public void testEvaluateTree_Number () {
		ExpressionNode l = new NumberNode(BigInteger.valueOf(2));
		ExpressionNode r = new NumberNode(BigInteger.valueOf(2));
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(l,  r));
			assertFalse(treeMatcher.Visit(l, new NumberNode(BigInteger.valueOf(3))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testEvaluateTree_Addition() {
		
		ExpressionNode l = new NumberNode(BigInteger.valueOf(23),BigInteger.valueOf(99));
		ExpressionNode r = new NumberNode(BigInteger.valueOf(23),BigInteger.valueOf(100));
		ExpressionNode add = new AdditionNode(l, r);
		
		ExpressionNode l2 = new NumberNode(BigInteger.valueOf(23),BigInteger.valueOf(99));
		ExpressionNode r2 = new NumberNode(BigInteger.valueOf(23),BigInteger.valueOf(100));
		ExpressionNode add2 = new AdditionNode(l2, r2);
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(add, add2));
			assertFalse(treeMatcher.Visit(l, new AdditionNode(new NumberNode(BigInteger.valueOf(22),BigInteger.valueOf(100)), r2)));
			assertFalse(treeMatcher.Visit(l, new AdditionNode(new VariableNode("n"), r2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	@Test
	public void testEvaluateTree_Subtraction() {
		
		ExpressionNode l = new NumberNode(BigInteger.valueOf(44),BigInteger.valueOf(103));
		ExpressionNode r = new VariableNode("x");
		ExpressionNode add = new SubtractionNode(l, r);
		
		ExpressionNode l2 = new NumberNode(BigInteger.valueOf(44),BigInteger.valueOf(103));
		ExpressionNode r2 = new VariableNode("x");
		ExpressionNode add2 = new SubtractionNode(l2, r2);
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(add, add2));
			assertFalse(treeMatcher.Visit(l, new SubtractionNode(new NumberNode(BigInteger.valueOf(44),BigInteger.valueOf(1031)), r2)));
			assertFalse(treeMatcher.Visit(l, new SubtractionNode(new VariableNode("n"), r2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	
	@Test
	public void testEvaluateTree_Multiplication() {
		
		ExpressionNode l = new NumberNode(BigInteger.valueOf(1),BigInteger.valueOf(1000));
		ExpressionNode r = new VariableNode("x");
		ExpressionNode add = new MultiplicationNode(l, r);
		
		ExpressionNode l2 = new NumberNode(BigInteger.valueOf(1),BigInteger.valueOf(1000));
		ExpressionNode r2 = new VariableNode("x");
		ExpressionNode add2 = new MultiplicationNode(l2, r2);
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(add, add2));
			assertFalse(treeMatcher.Visit(l, new MultiplicationNode(new NumberNode(BigInteger.valueOf(1),BigInteger.valueOf(1001)), r2)));
			assertFalse(treeMatcher.Visit(l, new MultiplicationNode(new VariableNode("n"), r2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testEvaluateTree_Division() {
		
		ExpressionNode l = new NumberNode(BigInteger.valueOf(0),BigInteger.valueOf(4));
		ExpressionNode r = new VariableNode("x");
		ExpressionNode add = new DivisionNode(l, r);
		
		ExpressionNode l2 = new NumberNode(BigInteger.valueOf(0));
		ExpressionNode r2 = new VariableNode("x");
		ExpressionNode add2 = new DivisionNode(l2, r2);
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(add, add2));
			assertFalse(treeMatcher.Visit(l, new DivisionNode(new NumberNode(BigInteger.valueOf(1),BigInteger.valueOf(1)), r2)));
			assertFalse(treeMatcher.Visit(l, new DivisionNode(new VariableNode("n"), r2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testEvaluateTree_Exponentiation() {
		
		ExpressionNode l = new NumberNode(BigInteger.valueOf(11),BigInteger.valueOf(1));
		ExpressionNode r = new VariableNode("x");
		ExpressionNode add = new PowerNode(l, r);
		
		ExpressionNode l2 = new NumberNode(BigInteger.valueOf(11),BigInteger.valueOf(1));
		ExpressionNode r2 = new VariableNode("x");
		ExpressionNode add2 = new PowerNode(l2, r2);
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(add, add2));
			assertFalse(treeMatcher.Visit(l, new PowerNode(new NumberNode(BigInteger.valueOf(11),BigInteger.valueOf(2)), r2)));
			assertFalse(treeMatcher.Visit(l, new PowerNode(new VariableNode("n"), r2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testEvaluateTree_Unary() {
		
		ExpressionNode innerNode = new VariableNode("x");
		ExpressionNode unaryNode = new UnaryNode(innerNode);
		
		ExpressionNode innerNode2 = new VariableNode("x");
		ExpressionNode unaryNode2 = new UnaryNode (innerNode2);
		
		
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(unaryNode, unaryNode2));
			assertFalse(treeMatcher.Visit(unaryNode, new UnaryNode(new VariableNode("xa"))));
			assertFalse(treeMatcher.Visit(unaryNode, new UnaryNode(new NumberNode(BigInteger.valueOf(2)))));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testEvaluateTree_Function() {
		
		ArrayList<ExpressionNode> functionArguments = new ArrayList<>();
		functionArguments.add(new VariableNode("p"));
		functionArguments.add(new NumberNode(BigInteger.valueOf(553),BigInteger.valueOf(299)));
		ExpressionNode functionNode = new FunctionNode("TestFunction", functionArguments);
		
		ArrayList<ExpressionNode> functionArguments2 = new ArrayList<>();
		functionArguments.add(new VariableNode("p"));
		functionArguments.add(new NumberNode(BigInteger.valueOf(553),BigInteger.valueOf(299)));
		ExpressionNode functionNode2 = new FunctionNode("TestFunction", functionArguments);
		
		
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(functionNode, functionNode2));
			assertFalse(treeMatcher.Visit(functionNode, new FunctionNode("DifferentFunctionName" , functionArguments2)));
			functionArguments2.add(new VariableNode("f"));
			assertFalse(treeMatcher.Visit(functionNode, new FunctionNode("TestFunctino" , functionArguments2)));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
		
	
	@Test
	public void testEvaluateTree_RuleVariable_Exception () {
		ExpressionNode l = new RuleVariableNode("x");
		ExpressionNode r = new RuleVariableNode("x");
		EvaluateTree treeMatcher = new EvaluateTree();
		assertThrows(Exception.class, () -> treeMatcher.Visit(l,r));
		
	}

}
