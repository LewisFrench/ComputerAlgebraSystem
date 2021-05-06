package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import Nodes.*;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Test;

import ConditionFunctions.ConditionFunctionEvaluator;

public class TestConditionFunctions {

	@Test
	public void testConditionFunctions_is_number_valid_true() {
		String functionName = "_is_number";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(BigInteger.valueOf(2), BigInteger.valueOf(3)));

		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testConditionFunctions__is_number_valid_False() {
		String functionName = "_is_number";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));

		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testConditionFunctions_is_number_invalid_arguments() {
		String functionName = "_is_number";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(BigInteger.valueOf(1), BigInteger.valueOf(-2)));
		arguments.add(new NumberNode(BigInteger.valueOf(-1), BigInteger.valueOf(2)));

		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}

	@Test
	public void testConditionFunctions_is_literal_valid_true() {
		String functionName = "_is_literal";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));

		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testConditionFunctions__is_literal_valid_False() {
		String functionName = "_is_literal";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(BigInteger.valueOf(2), BigInteger.valueOf(3)));

		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testConditionFunctions_is_literal_invalid_arguments() {
		String functionName = "_is_literal";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new VariableNode("x"));

		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}


	@Test
	public void testConditionFunctions_is_function_invalid_arguments() {
		String functionName = "_is_function";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new VariableNode("x"));

		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}

	@Test
	public void testConditionFunctions_is_integer_valid_true() {
		String functionName = "_is_integer";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode((BigInteger.valueOf(2))));

		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testConditionFunctions__is_integer_valid_False() {
		String functionName = "_is_integer";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(BigInteger.valueOf(11), BigInteger.valueOf(2)));

		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testConditionFunctions__is_integer_valid_notNumber_False() {
		String functionName = "_is_integer";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));

		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testConditionFunctions_is_integer_invalid_arguments() {
		String functionName = "_is_integer";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(BigInteger.valueOf(2)));
		arguments.add(new NumberNode(BigInteger.valueOf(2)));

		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}

	@Test
	public void testConditionFunctions_depends_valid_true() {
		String functionName = "_depends";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();

		arguments.add(
				new AdditionNode(new NumberNode((BigInteger.valueOf(21))), new NumberNode((BigInteger.valueOf(2)))));

		arguments.add(new NumberNode((BigInteger.valueOf(2))));
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testConditionFunctions_depends_valid_False() {
		String functionName = "_depends";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode((BigInteger.valueOf(2))));
		arguments.add(new AdditionNode(new NumberNode((BigInteger.valueOf(2))),
				new NumberNode(BigInteger.valueOf(2), BigInteger.valueOf(2))));
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testConditionFunctions_depends_invalid_arguments() {
		String functionName = "_depends";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(BigInteger.valueOf(2), BigInteger.valueOf(1)));

		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}

	@Test
	public void testConditionFunctions_invalid_functionName_Exception() {
		String functionName = "invalidName";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(BigInteger.valueOf(2), BigInteger.valueOf(1)));
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}

}
