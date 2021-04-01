package ComputerAlgebraSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestDependsEvaluator {

	@Test
	void testDependsEvaluatorVariable() {
		ExpressionNode dependency = new VariableNode("x");
		DependsEvaluator d = new DependsEvaluator(dependency);
		assertTrue(d.Visit(new VariableNode("x")));
		assertFalse(d.Visit(new VariableNode("xy")));

	}

	@Test
	void testDependsEvaluatorNumber() {
		ExpressionNode dependency = new NumberNode(5.12);
		DependsEvaluator d = new DependsEvaluator(dependency);
		assertTrue(d.Visit(new NumberNode(5.12)));
		assertFalse(d.Visit(new NumberNode(5.13)));

	}

	@Test
	void testDependsEvaluatorUnary() {
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
	void testDependsEvaluatorParenthetical() {
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
	void testDependsEvaluatorAddition() {
		ExpressionNode dependency = new AdditionNode(new NumberNode(2.1), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new AdditionNode(new NumberNode(2.1), new VariableNode("x"))));
			assertFalse(d.Visit(new AdditionNode(new NumberNode(2.1), new VariableNode("xz"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testDependsEvaluatorSubtraction() {
		ExpressionNode dependency = new SubtractionNode(new NumberNode(2.1), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new SubtractionNode(new NumberNode(2.1), new VariableNode("x"))));
			assertFalse(d.Visit(new SubtractionNode(new NumberNode(2.1), new VariableNode("xz"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testDependsEvaluatorMultiplication() {
		ExpressionNode dependency = new MultiplicationNode(new NumberNode(2.1), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new MultiplicationNode(new NumberNode(2.1), new VariableNode("x"))));
			assertFalse(d.Visit(new MultiplicationNode(new NumberNode(2.1), new VariableNode("xz"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testDependsEvaluatorDivisionNode() {
		ExpressionNode dependency = new DivisionNode(new NumberNode(2.1), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new DivisionNode(new NumberNode(2.1), new VariableNode("x"))));
			assertFalse(d.Visit(new DivisionNode(new NumberNode(2.1), new VariableNode("xz"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testDependsEvaluatorExponentiation() {
		ExpressionNode dependency = new PowerNode(new NumberNode(2.1), new VariableNode("x"));

		DependsEvaluator d = new DependsEvaluator(dependency);

		try {
			assertTrue(d.Visit(new PowerNode(new NumberNode(2.1), new VariableNode("x"))));
			assertFalse(d.Visit(new PowerNode(new NumberNode(2.1), new VariableNode("xz"))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void testDependsEvaluatorFunction() {
		ArrayList<ExpressionNode> functionArguments = new ArrayList<>();
		functionArguments.add(new NumberNode(2.1));
		functionArguments.add(new VariableNode("y"));
		ExpressionNode dependency = new FunctionNode("TestFunction", functionArguments);

		DependsEvaluator d = new DependsEvaluator(dependency);

		ArrayList<ExpressionNode> testFunctionArgumentsTrue = new ArrayList<>();
		testFunctionArgumentsTrue.add(new NumberNode(2.1));
		testFunctionArgumentsTrue.add(new VariableNode("y"));

		ArrayList<ExpressionNode> testFunctionArgumentsFalse = new ArrayList<>();
		testFunctionArgumentsFalse.add(new NumberNode(2.3));
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
	void testDependsEvaluator_VisitRuleVariableNode_Exception() {
		ExpressionNode dependency = new RuleVariableNode("d");
		DependsEvaluator d = new DependsEvaluator(dependency);

		assertThrows(Exception.class, () -> d.Visit(dependency));

	}
	
	
}