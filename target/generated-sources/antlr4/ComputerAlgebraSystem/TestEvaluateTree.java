package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

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
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void testEvaluateTree_Number () {
		ExpressionNode l = new NumberNode(2.56);
		ExpressionNode r = new NumberNode(2.56);
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(l,  r));
			assertFalse(treeMatcher.Visit(l, new NumberNode(2.57)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEvaluateTree_Addition() {
		
		ExpressionNode l = new NumberNode(2.56);
		ExpressionNode r = new NumberNode(2.57);
		ExpressionNode add = new AdditionNode(l, r);
		
		ExpressionNode l2 = new NumberNode(2.56);
		ExpressionNode r2 = new NumberNode(2.57);
		ExpressionNode add2 = new AdditionNode(l2, r2);
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(add, add2));
			assertFalse(treeMatcher.Visit(l, new AdditionNode(new NumberNode(2.57), r2)));
			assertFalse(treeMatcher.Visit(l, new AdditionNode(new VariableNode("n"), r2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testEvaluateTree_Subtraction() {
		
		ExpressionNode l = new NumberNode(2.56);
		ExpressionNode r = new VariableNode("x");
		ExpressionNode add = new SubtractionNode(l, r);
		
		ExpressionNode l2 = new NumberNode(2.56);
		ExpressionNode r2 = new VariableNode("x");
		ExpressionNode add2 = new SubtractionNode(l2, r2);
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(add, add2));
			assertFalse(treeMatcher.Visit(l, new SubtractionNode(new NumberNode(2.57), r2)));
			assertFalse(treeMatcher.Visit(l, new SubtractionNode(new VariableNode("n"), r2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testEvaluateTree_Multiplication() {
		
		ExpressionNode l = new NumberNode(2.56);
		ExpressionNode r = new VariableNode("x");
		ExpressionNode add = new MultiplicationNode(l, r);
		
		ExpressionNode l2 = new NumberNode(2.56);
		ExpressionNode r2 = new VariableNode("x");
		ExpressionNode add2 = new MultiplicationNode(l2, r2);
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(add, add2));
			assertFalse(treeMatcher.Visit(l, new MultiplicationNode(new NumberNode(2.57), r2)));
			assertFalse(treeMatcher.Visit(l, new MultiplicationNode(new VariableNode("n"), r2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEvaluateTree_Division() {
		
		ExpressionNode l = new NumberNode(2.56);
		ExpressionNode r = new VariableNode("x");
		ExpressionNode add = new DivisionNode(l, r);
		
		ExpressionNode l2 = new NumberNode(2.56);
		ExpressionNode r2 = new VariableNode("x");
		ExpressionNode add2 = new DivisionNode(l2, r2);
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(add, add2));
			assertFalse(treeMatcher.Visit(l, new DivisionNode(new NumberNode(2.57), r2)));
			assertFalse(treeMatcher.Visit(l, new DivisionNode(new VariableNode("n"), r2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEvaluateTree_Exponentiation() {
		
		ExpressionNode l = new NumberNode(2.56);
		ExpressionNode r = new VariableNode("x");
		ExpressionNode add = new PowerNode(l, r);
		
		ExpressionNode l2 = new NumberNode(2.56);
		ExpressionNode r2 = new VariableNode("x");
		ExpressionNode add2 = new PowerNode(l2, r2);
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(add, add2));
			assertFalse(treeMatcher.Visit(l, new PowerNode(new NumberNode(2.57), r2)));
			assertFalse(treeMatcher.Visit(l, new PowerNode(new VariableNode("n"), r2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			assertFalse(treeMatcher.Visit(unaryNode, new UnaryNode(new NumberNode(2.1))));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEvaluateTree_Function() {
		
		ArrayList<ExpressionNode> functionArguments = new ArrayList<>();
		functionArguments.add(new VariableNode("p"));
		functionArguments.add(new NumberNode(2.4));
		ExpressionNode functionNode = new FunctionNode("TestFunction", functionArguments);
		
		ArrayList<ExpressionNode> functionArguments2 = new ArrayList<>();
		functionArguments.add(new VariableNode("p"));
		functionArguments.add(new NumberNode(2.4));
		ExpressionNode functionNode2 = new FunctionNode("TestFunction", functionArguments);
		
		
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(functionNode, functionNode2));
			assertFalse(treeMatcher.Visit(functionNode, new FunctionNode("DifferentFunctionName" , functionArguments2)));
			functionArguments2.add(new VariableNode("f"));
			assertFalse(treeMatcher.Visit(functionNode, new FunctionNode("TestFunctino" , functionArguments2)));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testEvaluateTree_Parenthetical() {
		
		ExpressionNode innerNode = new VariableNode("x");
		ExpressionNode parentheticalNode = new ParentheticalNode(innerNode);
		
		ExpressionNode innerNode2 = new VariableNode("x");
		ExpressionNode parentheticalNode2 = new ParentheticalNode (innerNode2);
		
		
		EvaluateTree treeMatcher = new EvaluateTree();
		
		try {
			assertTrue(treeMatcher.Visit(parentheticalNode, parentheticalNode2));
			assertFalse(treeMatcher.Visit(parentheticalNode, new ParentheticalNode(new VariableNode("xa"))));
			assertFalse(treeMatcher.Visit(parentheticalNode, new ParentheticalNode(new NumberNode(2.1))));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testEvaluateTree_RuleVariable_AddsRuleVariable () {
		ExpressionNode l = new RuleVariableNode("x");
		ExpressionNode r = new VariableNode("x");
		EvaluateTree treeMatcher = new EvaluateTree();
		try { 
			treeMatcher.Visit(l, r);
			assertTrue(treeMatcher.variables.size() > 0);
			assertTrue ( treeMatcher.variables.get(0).equals(l.toString()));
			assertTrue(treeMatcher.arguments.get(0) instanceof VariableNode);
			assertTrue(((VariableNode)treeMatcher.arguments.get(0)).getValue().equals(((VariableNode)r).getValue()) );
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@Test
	public void testEvaluateTree_RuleVariable_Exception () {
		ExpressionNode l = new RuleVariableNode("x");
		ExpressionNode r = new RuleVariableNode("x");
		EvaluateTree treeMatcher = new EvaluateTree();
		assertThrows(Exception.class, () -> treeMatcher.Visit(l,r));
		
	}
	
	@Test
	public void testEvaluateTree_Complex_Addition_Unary () {
		ExpressionNode innerNode = new RuleVariableNode("x");
		ExpressionNode unaryNode = new UnaryNode(innerNode);
		ExpressionNode additionNode = new AdditionNode(new VariableNode("xy"), unaryNode);
		
		ExpressionNode innerNode2 = new VariableNode("x");
		ExpressionNode unaryNode2 = new UnaryNode(innerNode2);
		ExpressionNode additionNode2 = new AdditionNode(new VariableNode("xy"), unaryNode2);
		EvaluateTree treeMatcher = new EvaluateTree();
		try {
			assertTrue(treeMatcher.Visit(additionNode, additionNode2));
			assertEquals(treeMatcher.variables.get(0), "$x");
			assertTrue(treeMatcher.arguments.get(0) instanceof VariableNode);
			assertTrue(((VariableNode)treeMatcher.arguments.get(0)).getValue().equals("x"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
