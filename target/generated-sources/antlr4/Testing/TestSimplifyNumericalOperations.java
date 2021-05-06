
package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;

import org.junit.Test;

import Nodes.*;
import VisitorClasses.EvaluateNumericalOperations;
public class TestSimplifyNumericalOperations {


	@Test
	public void testSimplifyNumericalOperations_SimpleAddition_can_simplify() {
		ExpressionNode addition = new AdditionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(2)));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertTrue(result.getClass() ==  NumberNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSimplifyNumericalOperations_SimpleAddition_cannot_simplify() {
		ExpressionNode addition = new AdditionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertFalse(result.getClass() ==  NumberNode.class);
			assertTrue(result.getClass() ==  AdditionNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	@Test
	public void testSimplifyNumericalOperations_SimpleSubtraction() {
		ExpressionNode subtraction = new SubtractionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(2)));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(subtraction);
			assertTrue(result.getClass() ==  NumberNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSimplifyNumericalOperations_SimpleSubtraction_cannot_simplify() {
		ExpressionNode subtraction = new SubtractionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(subtraction);
			assertFalse(result.getClass() ==  NumberNode.class);
			assertTrue(result.getClass() ==  SubtractionNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimplifyNumericalOperations_SimpleMultiplication() {
		ExpressionNode multiplication = new MultiplicationNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(2)));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(multiplication);
			assertTrue(result.getClass() ==  NumberNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	@Test
	public void testSimplifyNumericalOperations_SimpleMultiplication_cannot_simplify() {
		ExpressionNode multiplication = new MultiplicationNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(multiplication);
			assertFalse(result.getClass() ==  NumberNode.class);
			assertTrue(result.getClass() ==  MultiplicationNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	

	@Test
	public void testSimplifyNumericalOperations_SimpleDivision() {
		ExpressionNode division = new DivisionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(2)));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			assertTrue(result.getClass() ==  NumberNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSimplifyNumericalOperations_SimpleDivision_cannot_simplify() {
		ExpressionNode division = new DivisionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			assertFalse(result.getClass() ==  NumberNode.class);
			assertTrue(result.getClass() ==  DivisionNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimplifyNumericalOperations_SimpleDivision_DivideByZero() {
		ExpressionNode division = new DivisionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new NumberNode(BigInteger.valueOf(0),BigInteger.valueOf(2)));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		assertThrows(ArithmeticException.class ,() -> s.Visit(division));
	}
	
	@Test
	public void testSimplifyNumericalOperations_ComplexDivision_DivideByZero() {
		AdditionNode add = new AdditionNode(new NumberNode(BigInteger.valueOf(2)) , new NumberNode(BigInteger.valueOf(3)));
		SubtractionNode subtract = new SubtractionNode(add, new NumberNode(BigInteger.valueOf(10),BigInteger.valueOf(2)));
		ExpressionNode division = new DivisionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), subtract);
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		assertThrows(ArithmeticException.class ,() -> s.Visit(division));
	}
	
	@Test
	public void testSimplifyNumericalOperations_SimpleExponentiation_IntegerPower() {
		ExpressionNode exponentiation = new PowerNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(3)), new NumberNode(BigInteger.valueOf(2)));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(exponentiation);
			assertTrue(result.getClass() ==  NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() .compareTo(BigInteger.valueOf( 4))==0);
			assertTrue(((NumberNode) result).getDenominator() .compareTo(BigInteger.valueOf( 9))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimplifyNumericalOperations_SimpleExponentiation_NegativeIntegerPower() {
		ExpressionNode exponentiation = new PowerNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(3)), new NumberNode(BigInteger.valueOf(-2),BigInteger.valueOf(1)));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(exponentiation);
			assertTrue(result.getClass() ==  NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() .compareTo(BigInteger.valueOf( 9))==0);
			assertTrue(((NumberNode) result).getDenominator() .compareTo(BigInteger.valueOf( 4))==0);
		} catch (Exception e) {

			fail();
		}
	}

	@Test
	public void testSimplifyNumericalOperations_SimpleExponentiation_cannot_Evaluate_FractionalPower() {
		ExpressionNode exponentiation = new PowerNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new NumberNode(BigInteger.valueOf(1),BigInteger.valueOf(2)));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(exponentiation);
			assertFalse(result.getClass() ==  NumberNode.class);
			assertTrue(result.getClass() ==  PowerNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimplifyNumericalOperations_SimpleExponentiation_cannot_Evaluate() {
		ExpressionNode exponentiation = new PowerNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new VariableNode("x"));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(exponentiation);
			assertFalse(result.getClass() ==  NumberNode.class);
			assertTrue(result.getClass() ==  PowerNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimplifyNumericalOperations_ComplexAddition() {

		ExpressionNode subAddition = new AdditionNode(new NumberNode(BigInteger.valueOf(2),BigInteger.valueOf(1)), new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(2)));
		ExpressionNode addition = new AdditionNode(new NumberNode(BigInteger.valueOf(1)), subAddition);
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertTrue(result.getClass() ==  NumberNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSimplifyNumericalOperations_Unary() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(BigInteger.valueOf(1),BigInteger.valueOf(5)));

		EvaluateNumericalOperations s = new EvaluateNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryNode);
			assertTrue(result.getClass() ==  NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() .compareTo(BigInteger.valueOf( -1))==0);
			assertTrue(((NumberNode) result).getDenominator() .compareTo(BigInteger.valueOf( 5))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testSimplifyNumericalOperations_UnaryNumberAddition() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(BigInteger.valueOf(1),BigInteger.valueOf(6)));
		AdditionNode unaryAddition = new AdditionNode(unaryNode, new NumberNode(BigInteger.valueOf(4),BigInteger.valueOf(6)));
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryAddition);
			assertTrue(result.getClass() ==  NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() .compareTo(BigInteger.valueOf( 1))==0);
			assertTrue(((NumberNode) result).getDenominator() .compareTo(BigInteger.valueOf( 2))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testSimplifyNumericalOperations_UnaryUnaryAddition() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(BigInteger.valueOf(1)));
		UnaryNode unaryNode2 = new UnaryNode(new NumberNode(BigInteger.valueOf(2)));

		ExpressionNode unaryAddition = new AdditionNode(unaryNode, unaryNode2);
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryAddition);
			assertTrue(result.getClass() ==  NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() .compareTo(BigInteger.valueOf( -3))==0);
			assertTrue(((NumberNode) result).getDenominator() .compareTo(BigInteger.valueOf( 1))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}
	
	@Test
	public void testSimplifyNumericalOperations_UnaryUnaryAddition_cannot_simplify() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(BigInteger.valueOf(1)));
		UnaryNode unaryNode2 = new UnaryNode(new VariableNode("x"));

		ExpressionNode unaryAddition = new AdditionNode(unaryNode, unaryNode2);
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryAddition);
	
			assertTrue(result.getClass() == AdditionNode.class);
		
			// Further testSimplifyNumericalOperations_: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
	

	@Test
	public void testSimplifyNumericalOperations_UnaryUnarySubtraction() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(BigInteger.valueOf(1)));
		UnaryNode unaryNode2 = new UnaryNode(new NumberNode(BigInteger.valueOf(2)));

		ExpressionNode unarySubtraction = new SubtractionNode(unaryNode, unaryNode2);
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unarySubtraction);
			assertTrue(result.getClass() == NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() .compareTo(BigInteger.valueOf( 1))==0);
			assertTrue(((NumberNode) result).getDenominator() .compareTo(BigInteger.valueOf( 1))==0);
			// Further testSimplifyNumericalOperations_: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testSimplifyNumericalOperations_UnaryUnaryMultiplication() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(BigInteger.valueOf(1)));
		UnaryNode unaryNode2 = new UnaryNode(new NumberNode(BigInteger.valueOf(2)));

		ExpressionNode unaryMultiplication = new MultiplicationNode(unaryNode, unaryNode2);
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryMultiplication);
			assertTrue(result.getClass() ==  NumberNode.class);
			assertTrue(((NumberNode) result).getNumerator() .compareTo(BigInteger.valueOf( 2))==0);
			assertTrue(((NumberNode) result).getDenominator() .compareTo(BigInteger.valueOf( 1))==0);
			// Further testSimplifyNumericalOperations_: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testSimplifyNumericalOperations_UnaryUnaryDivision() {
		UnaryNode unaryNode = new UnaryNode(new NumberNode(BigInteger.valueOf(1)));
		UnaryNode unaryNode2 = new UnaryNode(new NumberNode(BigInteger.valueOf(2)));

		ExpressionNode unaryDivisionNode = new DivisionNode(unaryNode, unaryNode2);
		EvaluateNumericalOperations s = new EvaluateNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryDivisionNode);
			assertTrue(result.getClass().equals( NumberNode.class));
			assertTrue(((NumberNode) result).getNumerator() .compareTo(BigInteger.valueOf( 1))==0);
			assertTrue(((NumberNode) result).getDenominator() .compareTo(BigInteger.valueOf( 2))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}
	
	

	
	
	@Test
	public void testSimplifyNumericalOperations_VisitRuleVariableNode_Exception() {
		
		ExpressionNode rv = new RuleVariableNode("x");

		EvaluateNumericalOperations s = new EvaluateNumericalOperations();
		assertThrows(Exception.class, () -> s.Visit(rv));
	}
	

}
