package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

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
		ExpressionNode dependency = new NumberNode(new BigDecimal(5.12));
		DependsEvaluator d = new DependsEvaluator(dependency);
		assertTrue(d.Visit(new NumberNode(new BigDecimal(5.12))));
		assertFalse(d.Visit(new NumberNode(new BigDecimal(5.13))));

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
			e.printStackTrace();
		}

	}

	@Test
	public void testDependsEvaluatorParenthetical() {
		ExpressionNode innerNode = new VariableNode("x");
		ExpressionNode dependency = new ParentheticalNode(innerNode);

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new ParentheticalNode(new VariableNode("x"))));
			assertFalse(d.Visit(new ParentheticalNode(new VariableNode("xy"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testDependsEvaluatorAddition() {
		ExpressionNode dependency = new AdditionNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new AdditionNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("x"))));
			assertFalse(d.Visit(new AdditionNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("xz"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testDependsEvaluatorSubtraction() {
		ExpressionNode dependency = new SubtractionNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new SubtractionNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("x"))));
			assertFalse(d.Visit(new SubtractionNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("xz"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testDependsEvaluatorMultiplication() {
		ExpressionNode dependency = new MultiplicationNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new MultiplicationNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("x"))));
			assertFalse(d.Visit(new MultiplicationNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("xz"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testDependsEvaluatorDivisionNode() {
		ExpressionNode dependency = new DivisionNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new DivisionNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("x"))));
			assertFalse(d.Visit(new DivisionNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("xz"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testDependsEvaluatorExponentiation() {
		ExpressionNode dependency = new PowerNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new PowerNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("x"))));
			assertFalse(d.Visit(new PowerNode(new NumberNode(new BigDecimal(2.1)), new VariableNode("xz"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testDependsEvaluatorFunction() {
		ArrayList<ExpressionNode> functionArguments = new ArrayList<>();
		functionArguments.add(new NumberNode(new BigDecimal(2.1)));
		functionArguments.add(new VariableNode("y"));
		ExpressionNode dependency = new FunctionNode("TestFunction", functionArguments);

		DependsEvaluator d = new DependsEvaluator(dependency);

		ArrayList<ExpressionNode> testFunctionArgumentsTrue = new ArrayList<>();
		testFunctionArgumentsTrue.add(new NumberNode(new BigDecimal(2.1)));
		testFunctionArgumentsTrue.add(new VariableNode("y"));

		ArrayList<ExpressionNode> testFunctionArgumentsFalse = new ArrayList<>();
		testFunctionArgumentsFalse.add(new NumberNode(new BigDecimal(2.3)));
		testFunctionArgumentsFalse.add(new VariableNode("x2"));

		try {
			assertTrue(d.Visit(new FunctionNode("TestFunction", testFunctionArgumentsTrue)));
			assertFalse(d.Visit(new FunctionNode("TestFunction", testFunctionArgumentsFalse)));
			assertFalse(d.Visit(new FunctionNode("TestFunctionFalse", testFunctionArgumentsTrue)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void testDependsEvaluator_VisitRuleVariableNode_Exception() {
		ExpressionNode dependency = new RuleVariableNode("d");
		DependsEvaluator d = new DependsEvaluator(dependency);

		assertThrows(Exception.class, () -> d.Visit(dependency));

	}
}
