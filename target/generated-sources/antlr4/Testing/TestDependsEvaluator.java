package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import Nodes.*;
import VisitorClasses.DependsEvaluator;
public class TestDependsEvaluator {


	@Test
	public void testDependsEvaluatorVariable() {
		ExpressionNode dependency = new VariableNode("x");
		DependsEvaluator d = new DependsEvaluator(dependency);
		assertTrue(d.Visit(new VariableNode("x")));
		assertFalse(d.Visit(new VariableNode("xy")));

	}

	@Test
	public void testDependsEvaluatorNumber() {
		ExpressionNode dependency = new NumberNode(5,4);
		DependsEvaluator d = new DependsEvaluator(dependency);
		assertTrue(d.Visit(new NumberNode(5,4)));
		assertFalse(d.Visit(new NumberNode(5,3)));

	}

	@Test
	public void testDependsEvaluatorUnary() {
		ExpressionNode innerNode = new VariableNode("x");
		ExpressionNode dependency = new UnaryNode(innerNode);

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new UnaryNode(new VariableNode("x"))));
			assertFalse(d.Visit(new UnaryNode(new VariableNode("xy"))));
		} catch (Exception e) {
			fail();
		}

	}


	@Test
	public void testDependsEvaluatorAddition() {
		ExpressionNode dependency = new AdditionNode(new NumberNode(2,1), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new AdditionNode(new NumberNode(2,1), new VariableNode("x"))));
			assertFalse(d.Visit(new AdditionNode(new NumberNode(2,1), new VariableNode("xz"))));
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testDependsEvaluatorSubtraction() {
		ExpressionNode dependency = new SubtractionNode(new NumberNode(1,2), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new SubtractionNode(new NumberNode(1,2), new VariableNode("x"))));
			assertFalse(d.Visit(new SubtractionNode(new NumberNode(1,2), new VariableNode("xz"))));
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testDependsEvaluatorMultiplication() {
		ExpressionNode dependency = new MultiplicationNode(new NumberNode(2,1), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new MultiplicationNode(new NumberNode(2,1), new VariableNode("x"))));
			assertFalse(d.Visit(new MultiplicationNode(new NumberNode(2,1), new VariableNode("xz"))));
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testDependsEvaluatorDivisionNode() {
		ExpressionNode dependency = new DivisionNode(new NumberNode(2,1), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new DivisionNode(new NumberNode(2,1), new VariableNode("x"))));
			assertFalse(d.Visit(new DivisionNode(new NumberNode(2,1), new VariableNode("xz"))));
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testDependsEvaluatorExponentiation() {
		ExpressionNode dependency = new PowerNode(new NumberNode(2,1), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new PowerNode(new NumberNode(2,1), new VariableNode("x"))));
			assertFalse(d.Visit(new PowerNode(new NumberNode(2,1), new VariableNode("xz"))));
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testDependsEvaluatorFunction() {
		ArrayList<ExpressionNode> functionArguments = new ArrayList<>();
		functionArguments.add(new NumberNode(2,1));
		functionArguments.add(new VariableNode("y"));
		ExpressionNode dependency = new FunctionNode("TestFunction", functionArguments);

		DependsEvaluator d = new DependsEvaluator(dependency);

		ArrayList<ExpressionNode> testFunctionArgumentsTrue = new ArrayList<>();
		testFunctionArgumentsTrue.add(new NumberNode(2,1));
		testFunctionArgumentsTrue.add(new VariableNode("y"));

		ArrayList<ExpressionNode> testFunctionArgumentsFalse = new ArrayList<>();
		testFunctionArgumentsFalse.add(new NumberNode(2,3));
		testFunctionArgumentsFalse.add(new VariableNode("x2"));

		try {
			assertTrue(d.Visit(new FunctionNode("TestFunction", testFunctionArgumentsTrue)));
			assertFalse(d.Visit(new FunctionNode("TestFunction", testFunctionArgumentsFalse)));
			assertFalse(d.Visit(new FunctionNode("TestFunctionFalse", testFunctionArgumentsTrue)));
		} catch (Exception e) {
			fail();
		}

	}
	
	
	@Test
	public void testDependsEvaluator_VisitRuleVariableNode_Exception() {
		ExpressionNode dependency = new RuleVariableNode("d");
		DependsEvaluator d = new DependsEvaluator(dependency);

		assertThrows(Exception.class, () -> d.Visit(dependency));

	}
}
