package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Test;

public class TestSubstituteRuleVariables {

	@Test
	public void testSubstituteVariable() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		ExpressionNode rv = new RuleVariableNode("n");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof VariableNode);
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testSubstituteNumber() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new NumberNode(1, 4));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof NumberNode);
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testSubstituteAddition() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();

		variables.put("$test", new AdditionNode(new NumberNode(2), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof AdditionNode);
			assertTrue(((AdditionNode) result).getLeft() instanceof NumberNode);
			assertTrue(((AdditionNode) result).getRight() instanceof VariableNode);
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testSubstituteSubstitution() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new SubtractionNode(new NumberNode(2), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof SubtractionNode);
			assertTrue(((SubtractionNode) result).getLeft() instanceof NumberNode);
			assertTrue(((SubtractionNode) result).getRight() instanceof VariableNode);
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testSubstituteMultiplication() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new MultiplicationNode(new NumberNode(2), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof MultiplicationNode);
			assertTrue(((MultiplicationNode) result).getLeft() instanceof NumberNode);
			assertTrue(((MultiplicationNode) result).getRight() instanceof VariableNode);
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testSubstituteDivision() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new DivisionNode(new NumberNode(2), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof DivisionNode);
			assertTrue(((DivisionNode) result).getLeft() instanceof NumberNode);
			assertTrue(((DivisionNode) result).getRight() instanceof VariableNode);
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testSubstituteExponentiation() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new PowerNode(new NumberNode(2), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof PowerNode);
			assertTrue(((PowerNode) result).getLeft() instanceof NumberNode);
			assertTrue(((PowerNode) result).getRight() instanceof VariableNode);
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testSubstituteUnary() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new UnaryNode(new VariableNode("x")));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof UnaryNode);

			assertTrue(((UnaryNode) result).innerNode instanceof VariableNode);
			ExpressionNode resultNode = (((UnaryNode) result).innerNode);
			assertTrue(((VariableNode) resultNode).getValue().equals("x"));

		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testSubstituteUnary_Number() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$test", new UnaryNode(new NumberNode(2)));
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {

			ExpressionNode result = s.Visit(rv);
			System.out.println(result.toString() + "   " + result.getClass());
			assertTrue(result instanceof UnaryNode);
			assertTrue(((UnaryNode) result).innerNode instanceof NumberNode);
			ExpressionNode resultNode = (((UnaryNode) result).innerNode);
			assertTrue(((NumberNode) resultNode).getNumerator() == 2);

		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testSubstituteFunction() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();

		ArrayList<ExpressionNode> functionArguments = new ArrayList<ExpressionNode>();
		functionArguments.add(new NumberNode(2, 11));
		functionArguments.add(new VariableNode("xa"));
		ExpressionNode functionNode = new FunctionNode("TestFunction", functionArguments);

		variables.put("$test", functionNode);
		ExpressionNode rv = new RuleVariableNode("test");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof FunctionNode);

			assertTrue(((FunctionNode) result).getArguments().get(0) instanceof NumberNode);
			assertTrue(((FunctionNode) result).getArguments().get(1) instanceof VariableNode);

		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testSubstituteNullVariables_Exception() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		// variables.put("$n", new VariableNode("x"));
		ExpressionNode rv = new RuleVariableNode("n");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		assertThrows(Exception.class, () -> s.Visit(rv));

	}

	@Test
	public void testSubstituteNullVariable_Node_Exception() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", null);
		ExpressionNode rv = new RuleVariableNode("n");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);
		assertThrows(Exception.class, () -> s.Visit(rv));

	}

	@Test
	public void TestSubstituteComplex_Addition() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));

		ExpressionNode additionNode = new AdditionNode(new NumberNode(2), new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(additionNode);
			assertTrue(result instanceof AdditionNode);
			AdditionNode addResult = (AdditionNode) result;
			assertTrue(addResult.getLeft() instanceof NumberNode);
			assertTrue(addResult.getRight() instanceof VariableNode);

		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void TestSubstituteComplex_Subtraction() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));

		ExpressionNode subtractionNode = new SubtractionNode(new VariableNode("y"), new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(subtractionNode);
			assertTrue(result instanceof SubtractionNode);
			SubtractionNode addResult = (SubtractionNode) result;
			assertTrue(addResult.getLeft() instanceof VariableNode);
			assertTrue(addResult.getRight() instanceof VariableNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void TestSubstituteComplex_Multiplication() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));

		ExpressionNode multiplicationNode = new MultiplicationNode(new VariableNode("y"), new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(multiplicationNode);
			assertTrue(result instanceof MultiplicationNode);
			MultiplicationNode addResult = (MultiplicationNode) result;
			assertTrue(addResult.getLeft() instanceof VariableNode);
			assertTrue(addResult.getRight() instanceof VariableNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void TestSubstituteComplex_DivisionNode() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));

		ExpressionNode divisionNode = new DivisionNode(new VariableNode("y"), new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(divisionNode);
			assertTrue(result instanceof DivisionNode);
			DivisionNode addResult = (DivisionNode) result;
			assertTrue(addResult.getLeft() instanceof VariableNode);
			assertTrue(addResult.getRight() instanceof VariableNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void TestSubstituteComplex_Exponentiation() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));

		ExpressionNode powerNode = new PowerNode(new VariableNode("y"), new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(powerNode);
			assertTrue(result instanceof PowerNode);
			PowerNode addResult = (PowerNode) result;
			assertTrue(addResult.getLeft() instanceof VariableNode);
			assertTrue(addResult.getRight() instanceof VariableNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void TestSubstituteComplex_Unary() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));

		ExpressionNode unaryNode = new UnaryNode(new RuleVariableNode("n"));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(unaryNode);
			assertTrue(result instanceof UnaryNode);
			UnaryNode addResult = (UnaryNode) result;
			assertTrue(addResult.innerNode instanceof VariableNode);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void TestSubstituteComplex_FunctionNode() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new AdditionNode(new NumberNode(3), new NumberNode(4)));
		arguments.add(new SubtractionNode(new NumberNode(3), new NumberNode(4)));
		arguments.add(new MultiplicationNode(new NumberNode(3), new NumberNode(4)));
		arguments.add(new DivisionNode(new NumberNode(3), new NumberNode(4)));
		arguments.add(new PowerNode(new NumberNode(3), new RuleVariableNode("n")));

		ExpressionNode functionNode = new FunctionNode("TestFunction", arguments);
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(functionNode);
			assertTrue(result instanceof FunctionNode);
			FunctionNode addResult = (FunctionNode) result;
			assertTrue(((PowerNode) addResult.arguments.get(4)).getRight() instanceof VariableNode);

		} catch (Exception e) {
			fail();
		}
	}

}
