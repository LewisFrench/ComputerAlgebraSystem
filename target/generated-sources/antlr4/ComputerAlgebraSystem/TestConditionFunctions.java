package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

public class TestConditionFunctions {

	@Test
	public void testConditionFunctions_is_number_valid_true() {
		String functionName = "_is_number";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.3)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	@Test
	public void testConditionFunctions__is_number_valid_False() {
		String functionName = "_is_number";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testConditionFunctions_is_number_invalid_arguments() {
		String functionName = "_is_number";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.1)));
		arguments.add(new NumberNode(new BigDecimal(2.2)));
		
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
			
		} catch (Exception e) {e.printStackTrace();}
	}
	@Test
	public void testConditionFunctions__is_literal_valid_False() {
		String functionName = "_is_literal";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.3)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
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
	public void testConditionFunctions_is_addition_valid_true() {
		String functionName = "_is_addition";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new AdditionNode(new NumberNode(new BigDecimal(1.2)), new VariableNode("l")));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	@Test
	public void testConditionFunctions__is_addition_valid_False() {
		String functionName = "_is_addition";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.3)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testConditionFunctions_is_addition_invalid_arguments() {
		String functionName = "_is_addition";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new VariableNode("x"));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}
	
	@Test
	public void testConditionFunctions_is_subtraction_valid_true() {
		String functionName = "_is_subtraction";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new SubtractionNode(new NumberNode(new BigDecimal(1.2)), new VariableNode("l")));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	@Test
	public void testConditionFunctions__is_subtraction_valid_False() {
		String functionName = "_is_subtraction";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.3)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testConditionFunctions_is_subtraction_invalid_arguments() {
		String functionName = "_is_subtraction";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new VariableNode("x"));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}
	
	@Test
	public void testConditionFunctions_is_multiplication_valid_true() {
		String functionName = "_is_multiplication";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new MultiplicationNode(new NumberNode(new BigDecimal(1.2)), new VariableNode("l")));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	@Test
	public void testConditionFunctions__is_multiplication_valid_False() {
		String functionName = "_is_multiplication";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.3)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testConditionFunctions_is_multiplication_invalid_arguments() {
		String functionName = "_is_multiplication";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new VariableNode("x"));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}
	
	@Test
	public void testConditionFunctions_is_division_valid_true() {
		String functionName = "_is_division";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new DivisionNode(new NumberNode(new BigDecimal(1.2)), new VariableNode("l")));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	@Test
	public void testConditionFunctions__is_division_valid_False() {
		String functionName = "_is_division";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.3)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testConditionFunctions_is_division_invalid_arguments() {
		String functionName = "_is_division";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new VariableNode("x"));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}
	
	@Test
	public void testConditionFunctions_is_exponentiation_valid_true() {
		String functionName = "_is_exponentiation";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new PowerNode(new NumberNode(new BigDecimal(1.2)), new VariableNode("l")));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	@Test
	public void testConditionFunctions__is_exponentiation_valid_False() {
		String functionName = "_is_exponentiation";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.3)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testConditionFunctions_is_exponentiation_invalid_arguments() {
		String functionName = "_is_exponentiation";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new VariableNode("x"));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}
	
	
	@Test
	public void testConditionFunctions_is_unary_valid_true() {
		String functionName = "_is_unary";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new UnaryNode(new VariableNode("l")));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	@Test
	public void testConditionFunctions__is_unary_valid_False() {
		String functionName = "_is_unary";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.3)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testConditionFunctions_is_unary_invalid_arguments() {
		String functionName = "_is_unary";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new VariableNode("x"));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}
	
	
	@Test
	public void testConditionFunctions_is_parenthetical_valid_true() {
		String functionName = "_is_parenthetical";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new ParentheticalNode(new VariableNode("l")));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	@Test
	public void testConditionFunctions__is_parenthetical_valid_False() {
		String functionName = "_is_parenthetical";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.3)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testConditionFunctions_is_parenthetical_invalid_arguments() {
		String functionName = "_is_parenthetical";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		arguments.add(new VariableNode("x"));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}
	
	
	
	@Test
	public void testConditionFunctions_is_function_valid_true() {
		String functionName = "_is_function";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		
		ArrayList<ExpressionNode> functionArguments = new ArrayList<>();
		ExpressionNode f = new FunctionNode("TestFunction", functionArguments);
		
		arguments.add(f);
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	@Test
	public void testConditionFunctions__is_function_valid_False() {
		String functionName = "_is_function";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.3)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
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
		arguments.add(new NumberNode(new BigDecimal(2)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	@Test
	public void testConditionFunctions__is_integer_valid_False() {
		String functionName = "_is_integer";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.1)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	@Test
	public void testConditionFunctions__is_integer_valid_notNumber_False() {
		String functionName = "_is_integer";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new VariableNode("x"));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testConditionFunctions_is_integer_invalid_arguments() {
		String functionName = "_is_integer";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.1)));
		arguments.add(new NumberNode(new BigDecimal(2.2)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}
	
	@Test
	public void testConditionFunctions_depends_valid_true() {
		String functionName = "_depends";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		
		arguments.add(new AdditionNode(new NumberNode(new BigDecimal(2.1)), new NumberNode(new BigDecimal(2))));
		
		arguments.add(new NumberNode(new BigDecimal(2)));
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertTrue(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testConditionFunctions_depends_valid_False() {
		String functionName = "_depends";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2)));
		arguments.add(new AdditionNode(new NumberNode(new BigDecimal(2.1)), new NumberNode(new BigDecimal(2.3))));
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		try {
			assertFalse(c.determineFunction(functionName, arguments));
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	@Test
	public void testConditionFunctions_depends_invalid_arguments() {
		String functionName = "_depends";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.1)));
		
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}
	
	@Test
	public void testConditionFunctions_invalid_functionname_Exception() {
		String functionName = "invalidName";
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new NumberNode(new BigDecimal(2.1)));
		ConditionFunctionEvaluator c = new ConditionFunctionEvaluator();
		assertThrows(Exception.class, () -> c.determineFunction(functionName, arguments));
	}
	
	
	
}
