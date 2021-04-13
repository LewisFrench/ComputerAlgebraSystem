package ComputerAlgebraSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNumericalOperations {

	@Test
	public void testIntegerAddition() {
		NumberNode num1 = new NumberNode(2);
		NumberNode num2 = new NumberNode(4, 1);
		NumberNode result = num1.add(num2);
		assertEquals(6, result.getNumerator());
		assertEquals(1, result.getDenominator());
	}

	@Test
	public void testIntegerAddition_negative() {

		NumberNode num1 = new NumberNode(2);
		NumberNode num2 = new NumberNode(-4, 1);
		NumberNode result = num1.add(num2);
		assertEquals(-2, result.getNumerator());
		assertEquals(1, result.getDenominator());
	}

	@Test
	public void testRationalAddition() {

		NumberNode num1 = new NumberNode(6, 9);
		NumberNode num2 = new NumberNode(4, 3);
		NumberNode result = num1.add(num2);
		assertEquals(2, result.getNumerator());
		assertEquals(1, result.getDenominator());
	}

	@Test
	public void testRationalAddition_Negative() {

		NumberNode num1 = new NumberNode(6, 9);
		NumberNode num2 = new NumberNode(-4, 3);
		NumberNode result = num1.add(num2);
		assertEquals(-2, result.getNumerator());
		assertEquals(3, result.getDenominator());
	}

	@Test
	public void testIntegerSubtraction() {
		NumberNode num1 = new NumberNode(2, 9);
		NumberNode num2 = new NumberNode(4, 3);
		NumberNode result = num1.subtract(num2);
		assertEquals(-10, result.getNumerator());
		assertEquals(9, result.getDenominator());
	}

	@Test
	public void testIntegerSubtraction_negative() {

		NumberNode num1 = new NumberNode(-2, -4);
		NumberNode num2 = new NumberNode(-4, 1);
		NumberNode result = num1.subtract(num2);
		assertEquals(9, result.getNumerator());
		assertEquals(2, result.getDenominator());
	}

	@Test
	public void testRationalSubtraction() {

		NumberNode num1 = new NumberNode(6, 9);
		NumberNode num2 = new NumberNode(4, 3);
		NumberNode result = num1.subtract(num2);
		assertEquals(-2, result.getNumerator());
		assertEquals(3, result.getDenominator());
	}

	@Test
	public void testRationalSubtraction_Negative() {

		NumberNode num1 = new NumberNode(6, -9);
		NumberNode num2 = new NumberNode(-4, -3);
		NumberNode result = num1.subtract(num2);
		assertEquals(-2, result.getNumerator());
		assertEquals(1, result.getDenominator());
	}

	@Test
	public void testIntegerMultiplication() {
		NumberNode num1 = new NumberNode(2, 9);
		NumberNode num2 = new NumberNode(4, 3);
		NumberNode result = num1.multiply(num2);
		assertEquals(8, result.getNumerator());
		assertEquals(27, result.getDenominator());
	}

	@Test
	public void testIntegerMultiplication_negative() {

		NumberNode num1 = new NumberNode(72, -5);
		NumberNode num2 = new NumberNode(-4, 11);
		NumberNode result = num1.multiply(num2);
		assertEquals(288, result.getNumerator());
		assertEquals(55, result.getDenominator());
	}

	@Test
	public void testRationalMultiplication() {

		NumberNode num1 = new NumberNode(6, -9);
		NumberNode num2 = new NumberNode(4, 3);
		NumberNode result = num1.multiply(num2);
		assertEquals(-8, result.getNumerator());
		assertEquals(9, result.getDenominator());
	}

	@Test
	public void testRationalMultiplication_Negative() {

		NumberNode num1 = new NumberNode(6, -9);
		NumberNode num2 = new NumberNode(4, -3);
		NumberNode result = num1.multiply(num2);
		assertEquals(8, result.getNumerator());
		assertEquals(9, result.getDenominator());
	}

	@Test
	public void testIntegerDivision() {
		NumberNode num1 = new NumberNode(2, 9);
		NumberNode num2 = new NumberNode(4, 3);
		NumberNode result = num1.divide(num2);
		assertEquals(1, result.getNumerator());
		assertEquals(6, result.getDenominator());
	}

	@Test
	public void testIntegerDivision_negative() {

		NumberNode num1 = new NumberNode(72, -5);
		NumberNode num2 = new NumberNode(-4, 11);
		NumberNode result = num1.divide(num2);
		assertEquals(198, result.getNumerator());
		assertEquals(5, result.getDenominator());
	}

	@Test
	public void testRatinalDivision() {

		NumberNode num1 = new NumberNode(6, -9);
		NumberNode num2 = new NumberNode(4, 3);
		NumberNode result = num1.divide(num2);
		assertEquals(-1, result.getNumerator());
		assertEquals(2, result.getDenominator());
	}

	@Test
	public void testRationalDivision_Negative() {

		NumberNode num1 = new NumberNode(6, -9);
		NumberNode num2 = new NumberNode(4, -3);
		NumberNode result = num1.divide(num2);
		assertEquals(1, result.getNumerator());
		assertEquals(2, result.getDenominator());
	}

	@Test
	public void testIntegerExponentiation() {
		NumberNode num1 = new NumberNode(2);
		NumberNode num2 = new NumberNode(4, 1);
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(16, ((NumberNode) result).getNumerator());
		assertEquals(1, ((NumberNode) result).getDenominator());
	}

	@Test
	public void testIntegerExponentiationNegative() {
		NumberNode num1 = new NumberNode(2);
		NumberNode num2 = new NumberNode(-4, 1);
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(1, ((NumberNode) result).getNumerator());
		assertEquals(16, ((NumberNode) result).getDenominator());
	}

	@Test
	public void testRationalExponentiation() {
		NumberNode num1 = new NumberNode(-2, 4);
		NumberNode num2 = new NumberNode(4, 1);
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(1, ((NumberNode) result).getNumerator());
		assertEquals(16, ((NumberNode) result).getDenominator());
	}

	@Test
	public void testRationalExponentiationNegative() {
		NumberNode num1 = new NumberNode(3,4);
		NumberNode num2 = new NumberNode(-4, 1);
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(256, ((NumberNode) result).getNumerator());
		assertEquals(81, ((NumberNode) result).getDenominator());
	}
	
	@Test
	public void testRationalExponentiation_FractionalExponent() {
		NumberNode num1 = new NumberNode(-2, 4);
		NumberNode num2 = new NumberNode(1,2);
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(PowerNode.class, result.getClass());
	}

}
