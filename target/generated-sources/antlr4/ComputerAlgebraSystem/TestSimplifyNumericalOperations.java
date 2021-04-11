
package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

public class TestSimplifyNumericalOperations {


	@Test
	public void testSimpleAddition_Decimal_Decimal_can_simplify() {
		ExpressionNode addition = new AdditionNode(new DecimalNode(2.1), new DecimalNode(3.2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertTrue(result.getClass() == DecimalNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	@Test
	public void testSimpleAddition_Decimal_Integer_can_simplify() {
		ExpressionNode addition = new AdditionNode(new DecimalNode(2.1), new IntegerNode(3l));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode)result).getValue().compareTo(BigDecimal.valueOf(5.1))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimpleAddition_Integer_Decimal_can_simplify() {
		ExpressionNode addition = new AdditionNode(new IntegerNode(3l), new DecimalNode(2.1));
		
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode)result).getValue().compareTo(BigDecimal.valueOf(5.1))==0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSimpleAddition_Integer_Integer_can_simplify() {
		ExpressionNode addition = new AdditionNode(new IntegerNode(3l), new IntegerNode(5));
		
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertTrue(result.getClass() == IntegerNode.class);
			assertTrue(((IntegerNode)result).getValue() ==8);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSimpleAddition_Decimal_Variable_cannot_simplify() {
		ExpressionNode addition = new AdditionNode(new DecimalNode(2.1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertFalse(result.getClass() == DecimalNode.class);
			assertTrue(result.getClass() == AdditionNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	
	@Test
	public void testSimpleSubtraction_Decimal_Decimal_can_simplify() {
		ExpressionNode subtraction = new SubtractionNode(new DecimalNode(2.1), new DecimalNode(3.2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(subtraction);
			assertTrue(result.getClass() == DecimalNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	@Test
	public void testSimpleSubtraction_Decimal_Integer_can_simplify() {
		ExpressionNode subtraction = new SubtractionNode(new DecimalNode(2.1), new IntegerNode(3l));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(subtraction);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode)result).getValue().compareTo(BigDecimal.valueOf(-0.9))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimpleSubtraction_Integer_Decimal_can_simplify() {
		ExpressionNode subtraction = new SubtractionNode(new IntegerNode(3l), new DecimalNode(2.1));
		
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(subtraction);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode)result).getValue().compareTo(BigDecimal.valueOf(
					0.9))==0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSimpleSubtraction_Integer_Integer_can_simplify() {
		ExpressionNode subtraction = new SubtractionNode(new IntegerNode(3l), new IntegerNode(5));
		
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(subtraction);
			assertTrue(result.getClass() == IntegerNode.class);
			assertTrue(((IntegerNode)result).getValue() ==-2);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	

	@Test
	public void testSimpleSubtraction_Decimal_Variable_cannot_simplify() {
		ExpressionNode subtraction = new SubtractionNode(new DecimalNode(2.1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(subtraction);
			assertFalse(result.getClass() == DecimalNode.class);
			assertTrue(result.getClass() == SubtractionNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimpleMultiplication_Decimal_Decimal_can_simplify() {
		ExpressionNode multiplication = new MultiplicationNode(new DecimalNode(2.1), new DecimalNode(3.2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(multiplication);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode)result).getValue().compareTo(BigDecimal.valueOf(6.72))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	@Test
	public void testSimpleMultiplication_Decimal_Integer_can_simplify() {
		ExpressionNode multiplication = new MultiplicationNode(new DecimalNode(2.1), new IntegerNode(3l));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(multiplication);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode)result).getValue().compareTo(BigDecimal.valueOf(6.3))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimpleMultiplication_Integer_Decimal_can_simplify() {
		ExpressionNode multiplication = new MultiplicationNode(new IntegerNode(3l), new DecimalNode(2.1));
		
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(multiplication);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode)result).getValue().compareTo(BigDecimal.valueOf(6.3))==0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSimpleMultiplication_Integer_Integer_can_simplify() {
		ExpressionNode multiplication = new MultiplicationNode(new IntegerNode(3l), new IntegerNode(5));
		
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(multiplication);
			assertTrue(result.getClass() == IntegerNode.class);
			assertTrue(((IntegerNode)result).getValue() ==15);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	
	
	@Test
	public void testSimpleDivision_Decimal_Decimal_can_simplify() {
		ExpressionNode division = new DivisionNode(new DecimalNode(2), new DecimalNode(4));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode)result).getValue().compareTo(BigDecimal.valueOf(0.5))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	@Test
	public void testSimpleDivision_Decimal_Integer_can_simplify() {
		ExpressionNode division = new DivisionNode(new DecimalNode(4), new IntegerNode(2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode)result).getValue().compareTo(BigDecimal.valueOf(2))==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testSimpleDivision_Integer_Decimal_can_simplify_whole() {
		ExpressionNode division = new DivisionNode(new IntegerNode(5), new DecimalNode(2));
		
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			System.out.println("R : " + result.toString());
			
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode)result).getValue().compareTo(BigDecimal.valueOf(2.5))==0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	


	@Test
	public void testSimpleDivision_Integer_Integer_can_simplify_whole() {
		ExpressionNode division = new DivisionNode(new IntegerNode(4), new IntegerNode(2));
		
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			assertTrue(result.getClass() == IntegerNode.class);
			assertTrue(((IntegerNode)result).getValue() ==2);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSimpleDivision_Integer_Integer_can_simplify_not_whole() {
		ExpressionNode division = new DivisionNode(new IntegerNode(5), new IntegerNode(2));
		
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			System.out.println(result);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode)result).getValue().compareTo(BigDecimal.valueOf(2.5))==0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	
	
	@Test
	public void testSimpleMultiplication_Decimal_Variable_cannot_simplify() {
		ExpressionNode multiplication = new MultiplicationNode(new DecimalNode(2.1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(multiplication);
			assertFalse(result.getClass() == DecimalNode.class);
			assertTrue(result.getClass() == MultiplicationNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	

	@Test
	public void testSimpleDivision_Decimal_Decimal() {
		ExpressionNode division = new DivisionNode(new DecimalNode(2.1), new DecimalNode(3.2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			assertTrue(result.getClass() == DecimalNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSimpleDivision_Decimal_Variable_cannot_simplify() {
		ExpressionNode division = new DivisionNode(new DecimalNode(2.1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(division);
			assertFalse(result.getClass() == DecimalNode.class);
			assertTrue(result.getClass() == DivisionNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	
	@Test
	public void testSimpleExponentiation_Decimal_Decimal() {
		ExpressionNode exponentiation = new PowerNode(new DecimalNode(2.1), new DecimalNode(3.2));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(exponentiation);
			assertTrue(result.getClass() == DecimalNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testSimpleExponentiation_Decimal_Variable_cannot_simplify() {
		ExpressionNode exponentiation = new PowerNode(new DecimalNode(2.1), new VariableNode("x"));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(exponentiation);
			assertFalse(result.getClass() == DecimalNode.class);
			assertTrue(result.getClass() == PowerNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	
	@Test
	public void testComplexAddition_Decimal_Decimal() {

		ExpressionNode subAddition = new AdditionNode(new DecimalNode(2.1), new DecimalNode(3.2));
		ExpressionNode addition = new AdditionNode(new DecimalNode(1.0), subAddition);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();

		try {
			ExpressionNode result = s.Visit(addition);
			assertTrue(result.getClass() == DecimalNode.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void testUnary_Decimal() {
		UnaryNode unaryNode = new UnaryNode(new DecimalNode(1.0));

		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryNode);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode) result).getValue().compareTo(new BigDecimal(-1.0)) == 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testUnaryNumberAddition_Decimal() {
		UnaryNode unaryNode = new UnaryNode(new DecimalNode(1.0));
		AdditionNode unaryAddition = new AdditionNode(unaryNode, new DecimalNode(4.3));
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryAddition);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode) result).getValue().compareTo(BigDecimal.valueOf(3.3)) == 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testUnaryUnaryAddition_Decimal() {
		UnaryNode unaryNode = new UnaryNode(new DecimalNode(1.0));
		UnaryNode unaryNode2 = new UnaryNode(new DecimalNode(2.0));

		ExpressionNode unaryAddition = new AdditionNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryAddition);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode) result).getValue().compareTo(new BigDecimal(-3.0)) ==0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}
	
	@Test
	public void testUnaryUnaryAddition_Decimal_Variable_cannot_simplify() {
		UnaryNode unaryNode = new UnaryNode(new DecimalNode(1.0));
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
	public void testUnaryUnarySubtraction_Decimal() {
		UnaryNode unaryNode = new UnaryNode(new DecimalNode(1.0));
		UnaryNode unaryNode2 = new UnaryNode(new DecimalNode(2.0));

		ExpressionNode unarySubtraction = new SubtractionNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unarySubtraction);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode) result).getValue().compareTo(new BigDecimal(1.0)) == 0);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testUnaryUnaryMultiplication_Decimal() {
		UnaryNode unaryNode = new UnaryNode(new DecimalNode(1.0));
		UnaryNode unaryNode2 = new UnaryNode(new DecimalNode(2.0));

		ExpressionNode unaryMultiplication = new MultiplicationNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryMultiplication);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode) result).getValue().compareTo(new BigDecimal(2.0)) == 0);
			// Further test: when using bigdecimal check value = 5.3
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}

	}

	@Test
	public void testUnaryUnaryDivision_Decimal() {
		UnaryNode unaryNode = new UnaryNode(new DecimalNode(1.0));
		UnaryNode unaryNode2 = new UnaryNode(new DecimalNode(2.0));

		ExpressionNode unaryDivisionNode = new DivisionNode(unaryNode, unaryNode2);
		SimplifyNumericalOperations s = new SimplifyNumericalOperations();
		try {
			ExpressionNode result = s.Visit(unaryDivisionNode);
			assertTrue(result.getClass() == DecimalNode.class);
			assertTrue(((DecimalNode) result).getValue().compareTo(new BigDecimal(0.5)) == 0);
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
