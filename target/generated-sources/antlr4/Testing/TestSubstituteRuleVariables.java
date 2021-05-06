package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.Test;

import Nodes.*;
import VisitorClasses.SubstituteRuleVariables;
public class TestSubstituteRuleVariables {

	@Test
	public void testSubstituteRuleVariables_SubstituteVariable() {
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
	public void testSubstituteRuleVariables_SubstituteNumber() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$testSubstituteRuleVariables_", new NumberNode(BigInteger.valueOf(1), BigInteger.valueOf(4)));
		ExpressionNode rv = new RuleVariableNode("testSubstituteRuleVariables_");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof NumberNode);
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testSubstituteRuleVariables_SubstituteAddition() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();

		variables.put("$testSubstituteRuleVariables_", new AdditionNode(new NumberNode(BigInteger.valueOf(4)), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("testSubstituteRuleVariables_");
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
	public void testSubstituteRuleVariables_SubstituteSubstitution() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$testSubstituteRuleVariables_", new SubtractionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("testSubstituteRuleVariables_");
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
	public void testSubstituteRuleVariables_SubstituteMultiplication() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$testSubstituteRuleVariables_", new MultiplicationNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("testSubstituteRuleVariables_");
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
	public void testSubstituteRuleVariables_SubstituteDivision() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$testSubstituteRuleVariables_", new DivisionNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("testSubstituteRuleVariables_");
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
	public void testSubstituteRuleVariables_SubstituteExponentiation() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$testSubstituteRuleVariables_", new PowerNode(new NumberNode(BigInteger.valueOf(2)), new VariableNode("u")));
		ExpressionNode rv = new RuleVariableNode("testSubstituteRuleVariables_");
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
	public void testSubstituteRuleVariables_SubstituteUnary() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$testSubstituteRuleVariables_", new UnaryNode(new VariableNode("x")));
		ExpressionNode rv = new RuleVariableNode("testSubstituteRuleVariables_");
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
	public void testSubstituteRuleVariables_SubstituteUnary_Number() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$testSubstituteRuleVariables_", new UnaryNode(new NumberNode(BigInteger.valueOf(2))));
		ExpressionNode rv = new RuleVariableNode("testSubstituteRuleVariables_");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {

			ExpressionNode result = s.Visit(rv);
			assertTrue(result instanceof UnaryNode);
			assertTrue(((UnaryNode) result).innerNode instanceof NumberNode);
			ExpressionNode resultNode = (((UnaryNode) result).innerNode);
			assertTrue(((NumberNode) resultNode).getNumerator().compareTo(BigInteger.valueOf(2))==0);

		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void testSubstituteRuleVariables_SubstituteFunction() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();

		ArrayList<ExpressionNode> functionArguments = new ArrayList<ExpressionNode>();
		functionArguments.add(new NumberNode(BigInteger.valueOf(2), BigInteger.valueOf(11)));
		functionArguments.add(new VariableNode("xa"));
		ExpressionNode functionNode = new FunctionNode("TestFunction", functionArguments);

		variables.put("$testSubstituteRuleVariables_", functionNode);
		ExpressionNode rv = new RuleVariableNode("testSubstituteRuleVariables_");
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
	public void testSubstituteRuleVariables_SubstituteNullVariables_Exception() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		// variables.put("$n", new VariableNode("x"));
		ExpressionNode rv = new RuleVariableNode("n");
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		assertThrows(Exception.class, () -> s.Visit(rv));

	}

	@Test
	public void testSubstituteRuleVariables_SubstituteNullVariable_Node_Exception() {
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

		ExpressionNode additionNode = new AdditionNode(new NumberNode(BigInteger.valueOf(2)), new RuleVariableNode("n"));
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
	public void TestSubstituteIllegalNode() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));

		ExpressionNode unaryNode = new UnaryNode(new ConditionNotNode(new VariableNode("j")));
		SubstituteRuleVariables s = new SubstituteRuleVariables(variables);

		try {
			assertThrows(IllegalArgumentException.class, ()-> s.Visit(unaryNode));
			
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void TestSubstituteComplex_FunctionNode() {
		LinkedHashMap<String, ExpressionNode> variables = new LinkedHashMap<>();
		variables.put("$n", new VariableNode("x"));
		ArrayList<ExpressionNode> arguments = new ArrayList<>();
		arguments.add(new AdditionNode(new NumberNode(BigInteger.valueOf(3)), new NumberNode(BigInteger.valueOf(4))));
		arguments.add(new SubtractionNode(new NumberNode(BigInteger.valueOf(3)), new NumberNode(BigInteger.valueOf(4))));
		arguments.add(new MultiplicationNode(new NumberNode(BigInteger.valueOf(3)), new NumberNode(BigInteger.valueOf(4))));
		arguments.add(new DivisionNode(new NumberNode(BigInteger.valueOf(3)), new NumberNode(BigInteger.valueOf(4))));
		arguments.add(new PowerNode(new NumberNode(BigInteger.valueOf(3)), new RuleVariableNode("n")));

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
