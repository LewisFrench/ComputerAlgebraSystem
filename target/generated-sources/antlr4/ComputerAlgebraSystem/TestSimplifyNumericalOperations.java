
package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

public class TestSimplifyNumericalOperations {


	@Test
	public void testSimpleAddition_can_simplify() {
		ExpressionNode addition = new AdditionNode(new NumberNode(2,1), new NumberNode(3,2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertTrue(result.getClass() == NumberNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSimpleAddition_cannot_simplify() {
		ExpressionNode addition = new AdditionNode(new NumberNode(2,1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertFalse(result.getClass() == NumberNode.class);
			assertTrue(result.getClass() == AdditionNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	@Test
	public void testSimpleSubtraction() {
		ExpressionNode subtraction = new SubtractionNode(new NumberNode(2,1), new NumberNode(3,2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(subtraction);
			assertTrue(result.getClass() == NumberNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSimpleSubtraction_cannot_simplify() {
		ExpressionNode subtraction = new SubtractionNode(new NumberNode(2,1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(subtraction);
			assertFalse(result.getClass() == NumberNode.class);
			assertTrue(result.getClass() == SubtractionNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimpleMultiplication() {
		ExpressionNode multiplication = new MultiplicationNode(new NumberNode(2,1), new NumberNode(3,2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(multiplication);
			assertTrue(result.getClass() == NumberNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	@Test
	public void testSimpleMultiplication_cannot_simplify() {
		ExpressionNode multiplication = new MultiplicationNode(new NumberNode(2,1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(multiplication);
			assertFalse(result.getClass() == NumberNode.class);
			assertTrue(result.getClass() == MultiplicationNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	

	@Test
	public void testSimpleDivision() {
		ExpressionNode division = new DivisionNode(new NumberNode(2,1), new NumberNode(3,2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			assertTrue(result.getClass() == NumberNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSimpleDivision_cannot_simplify() {
		ExpressionNode division = new DivisionNode(new NumberNode(2,1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			assertFalse(result.getClass() == NumberNode.class);
			assertTrue(result.getClass() == DivisionNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	
	@Test
	public void testSimpleExponentiation_IntegerPower() {
		ExpressionNode exponentiation = new PowerNode(new NumberNode(2,3), new NumberNode(2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(exponentiation);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == 4);
			assertTrue(((NumberNode) result).getDenominator() == 9);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimpleExponentiation_NegativeIntegerPower() {
		ExpressionNode exponentiation = new PowerNode(new NumberNode(2,3), new NumberNode(-2,1));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(exponentiation);
			System.out.println(result);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == 9);
			assertTrue(((NumberNode) result).getDenominator() == 4);
		} catch (Exception e) {

			fail();
		}
	}

	@Test
	public void testSimpleExponentiation_cannot_Evaluate_FractionalPower() {
		ExpressionNode exponentiation = new PowerNode(new NumberNode(2,1), new NumberNode(1,2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(exponentiation);
			assertFalse(result.getClass() == NumberNode.class);
			assertTrue(result.getClass() == PowerNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimpleExponentiation_cannot_Evaluate() {
		ExpressionNode exponentiation = new PowerNode(new NumberNode(2,1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(exponentiation);
			assertFalse(result.getClass() == NumberNode.class);
			assertTrue(result.getClass() == PowerNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testComplexAddition() {

		ExpressionNode subAddition = new AdditionNode(new NumberNode(2,1), new NumberNode(3,2));
		ExpressionNode addition = new AdditionNode(new NumberNode(1), subAddition);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertTrue(result.getClass() == NumberNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testUnary() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1,5));

		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryNode);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == -1);
			assertTrue(((NumberNode) result).getDenominator() == 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testUnaryNumberAddition() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1,6));
		AdditionNode unaryAddition = new AdditionNode(unaryNode, new NumberNode(4,6));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryAddition);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == 1);
			assertTrue(((NumberNode) result).getDenominator() == 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testUnaryUnaryAddition() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1));
		UnaryNode unaryNode2 = new UnaryNode(new NumberNode(2));

		ExpressionNode unaryAddition = new AdditionNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryAddition);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == -3);
			assertTrue(((NumberNode) result).getDenominator() == 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}
	
	@Test
	public void testUnaryUnaryAddition_cannot_simplify() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1));
		UnaryNode unaryNode2 = new UnaryNode(new VariableNode("x"));

		ExpressionNode unaryAddition = new AdditionNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryAddition);
			assertTrue(result.getClass() == AdditionNode.class);
		
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}
	

	@Test
	public void testUnaryUnarySubtraction() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1));
		UnaryNode unaryNode2 = new UnaryNode(new NumberNode(2));

		ExpressionNode unarySubtraction = new SubtractionNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unarySubtraction);
			System.out.println(result);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == 1);
			assertTrue(((NumberNode) result).getDenominator() == 1);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testUnaryUnaryMultiplication() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1));
		UnaryNode unaryNode2 = new UnaryNode(new NumberNode(2));

		ExpressionNode unaryMultiplication = new MultiplicationNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryMultiplication);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == 2);
			assertTrue(((NumberNode) result).getDenominator() == 1);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testUnaryUnaryDivision() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(1));
		UnaryNode unaryNode2 = new UnaryNode(new NumberNode(2));

		ExpressionNode unaryDivisionNode = new DivisionNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryDivisionNode);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() == 1);
			assertTrue(((NumberNode) result).getDenominator() == 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}
	
	

	
	
	@Test
	public void testVisitRuleVariableNode_Exception() {
		
		ExpressionNode rv = new RuleVariableNode("x");

		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		assertThrows(Exception.class, () -> s.Visit(rv));
	}
	

}
