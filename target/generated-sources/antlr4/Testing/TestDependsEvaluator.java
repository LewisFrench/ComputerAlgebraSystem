package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Test;

import Nodes.*;
import VisitorClasses.DependsEvaluator;
public class TestDependsEvaluator {


	@Test
	public void testDependsEvaluator_Variable() {
		ExpressionNode dependency = new VariableNode("x");
		DependsEvaluator d = new DependsEvaluator(dependency);
		assertTrue(d.Visit(new VariableNode("x")));
		assertFalse(d.Visit(new VariableNode("xy")));

	}

	@Test
	public void testDependsEvaluator_Number() {
		ExpressionNode dependency = new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(4));
		DependsEvaluator d = new DependsEvaluator(dependency);
		assertTrue(d.Visit(new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(4))));
		assertFalse(d.Visit(new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(3))));

	}

	@Test
	public void testDependsEvaluator_Unary() {
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
	public void testDependsEvaluator_FunctionArgument() {
		ExpressionNode dependency = new VariableNode("x");
		ArrayList<ExpressionNode> args = new ArrayList<>();
		args.add(dependency);
		FunctionNode f = new FunctionNode("func", args);
		//ExpressionNode dependency = new UnaryNode(innerNode);

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(f));
			
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testDependsEvaluator_Addition() {
		ExpressionNode dependency = new AdditionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new AdditionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"))));
			assertFalse(d.Visit(new AdditionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("xz"))));
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testDependsEvaluator_Subtraction() {
		ExpressionNode dependency = new SubtractionNode(new NumberNode(BigInteger.valueOf(1),BigInteger.valueOf(2)), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new SubtractionNode(new NumberNode(BigInteger.valueOf(1),BigInteger.valueOf(2)), new VariableNode("x"))));
			assertFalse(d.Visit(new SubtractionNode(new NumberNode(BigInteger.valueOf(1),BigInteger.valueOf(2)), new VariableNode("xz"))));
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testDependsEvaluator_Multiplication() {
		ExpressionNode dependency = new MultiplicationNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new MultiplicationNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"))));
			assertFalse(d.Visit(new MultiplicationNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("xz"))));
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testDependsEvaluator_DivisionNode() {
		ExpressionNode dependency = new DivisionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new DivisionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"))));
			assertFalse(d.Visit(new DivisionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("xz"))));
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testDependsEvaluator_Exponentiation() {
		ExpressionNode dependency = new PowerNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new PowerNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"))));
			assertFalse(d.Visit(new PowerNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("xz"))));
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testDependsEvaluator_Function() {
		ArrayList<ExpressionNode> functionArguments = new ArrayList<>();
		functionArguments.add(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)));
		functionArguments.add(new VariableNode("y"));
		ExpressionNode dependency = new FunctionNode("TestFunction", functionArguments);

		DependsEvaluator d = new DependsEvaluator(dependency);

		ArrayList<ExpressionNode> testFunctionArgumentsTrue = new ArrayList<>();
		testFunctionArgumentsTrue.add(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)));
		testFunctionArgumentsTrue.add(new VariableNode("y"));

		ArrayList<ExpressionNode> testFunctionArgumentsFalse = new ArrayList<>();
		testFunctionArgumentsFalse.add(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(3)));
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
