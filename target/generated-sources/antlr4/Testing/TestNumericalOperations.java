package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;

import Nodes.*;
import org.junit.Test;

import ComputerAlgebraSystem.LongMath;

public class TestNumericalOperations {

	@Test
	public void testIntegerAddition() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(2));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(1));
		NumberNode result = num1.add(num2);
		assertEquals(BigInteger.valueOf(6), result.getNumerator());
		
		assertEquals(BigInteger.valueOf(1), result.getDenominator());
	}

	@Test
	public void testIntegerAddition_negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(2));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(1));
		NumberNode result = num1.add(num2);
		assertEquals(BigInteger.valueOf(-2), result.getNumerator());
		assertEquals(BigInteger.valueOf(1), result.getDenominator());
	}

	@Test
	public void testRationalAddition() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.add(num2);
		assertEquals(BigInteger.valueOf(2), result.getNumerator());
		assertEquals(BigInteger.valueOf(1), result.getDenominator());
	}

	@Test
	public void testRationalAddition_Negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(3));
		NumberNode result = num1.add(num2);
		assertEquals(BigInteger.valueOf(-2), result.getNumerator());
		assertEquals(BigInteger.valueOf(3), result.getDenominator());
	}

	@Test
	public void testIntegerSubtraction() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(2), BigInteger.valueOf(9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.subtract(num2);
		assertEquals(BigInteger.valueOf(-10), result.getNumerator());
		assertEquals(BigInteger.valueOf(9), result.getDenominator());
	}

	@Test
	public void testIntegerSubtraction_negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(-2), BigInteger.valueOf(-4));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(1));
		NumberNode result = num1.subtract(num2);
		assertEquals(BigInteger.valueOf(9), result.getNumerator());
		assertEquals(BigInteger.valueOf(2), result.getDenominator());
	}

	@Test
	public void testRationalSubtraction() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.subtract(num2);
		assertEquals(BigInteger.valueOf(-2), result.getNumerator());
		assertEquals(BigInteger.valueOf(3), result.getDenominator());
	}

	@Test
	public void testRationalSubtraction_Negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(-9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(-3));
		NumberNode result = num1.subtract(num2);
		assertEquals(BigInteger.valueOf(-2), result.getNumerator());
		assertEquals(BigInteger.valueOf(1), result.getDenominator());
	}

	@Test
	public void testIntegerMultiplication() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(2), BigInteger.valueOf(9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.multiply(num2);
		assertEquals(BigInteger.valueOf(8), result.getNumerator());
		assertEquals(BigInteger.valueOf(27), result.getDenominator());
	}

	@Test
	public void testIntegerMultiplication_negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(72), BigInteger.valueOf(-5));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(11));
		NumberNode result = num1.multiply(num2);
		assertEquals(BigInteger.valueOf(288), result.getNumerator());
		assertEquals(BigInteger.valueOf(55), result.getDenominator());
	}

	@Test
	public void testRationalMultiplication() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(-9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.multiply(num2);
		System.out.println(result.toString());
		assertEquals(BigInteger.valueOf(-8), result.getNumerator());
		assertEquals(BigInteger.valueOf(9), result.getDenominator());
	}

	@Test
	public void testRationalMultiplication_Negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(-9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(-3));
		NumberNode result = num1.multiply(num2);
		assertEquals(BigInteger.valueOf(8), result.getNumerator());
		assertEquals(BigInteger.valueOf(9), result.getDenominator());
	}

	@Test
	public void testIntegerDivision() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(2), BigInteger.valueOf(9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.divide(num2);
		assertEquals(BigInteger.valueOf(1), result.getNumerator());
		assertEquals(BigInteger.valueOf(6), result.getDenominator());
	}

	@Test
	public void testIntegerDivision_negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(72), BigInteger.valueOf(-5));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(11));
		NumberNode result = num1.divide(num2);
		assertEquals(BigInteger.valueOf(198), result.getNumerator());
		assertEquals(BigInteger.valueOf(5), result.getDenominator());
	}

	@Test
	public void testRatinalDivision() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(-9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.divide(num2);
		assertEquals(BigInteger.valueOf(-1), result.getNumerator());
		assertEquals(BigInteger.valueOf(2), result.getDenominator());
	}

	@Test
	public void testRationalDivision_Negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(-9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(-3));
		NumberNode result = num1.divide(num2);
		assertEquals(BigInteger.valueOf(1), result.getNumerator());
		assertEquals(BigInteger.valueOf(2), result.getDenominator());
	}

	@Test
	public void testIntegerExponentiation() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(2));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(1));
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(BigInteger.valueOf(16), ((NumberNode) result).getNumerator());
		assertEquals(BigInteger.valueOf(1), ((NumberNode) result).getDenominator());
	}

	@Test
	public void testIntegerExponentiationNegative() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(2));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(1));
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(BigInteger.valueOf(1), ((NumberNode) result).getNumerator());
		assertEquals(BigInteger.valueOf(16), ((NumberNode) result).getDenominator());
	}

	@Test
	public void testRationalExponentiation() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(-2), BigInteger.valueOf(4));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(1));
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(BigInteger.valueOf(1), ((NumberNode) result).getNumerator());
		assertEquals(BigInteger.valueOf(16), ((NumberNode) result).getDenominator());
	}

	@Test
	public void testRationalExponentiationNegative() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(4));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(1));
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(BigInteger.valueOf(256), ((NumberNode) result).getNumerator());
		assertEquals(BigInteger.valueOf(81), ((NumberNode) result).getDenominator());
	}
	
	@Test
	public void testRationalExponentiation_FractionalExponent() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(-2), BigInteger.valueOf(4));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(1),BigInteger.valueOf(2));
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(PowerNode.class, result.getClass());
	}
	
	
	@Test
	public void testRationalExponentiation_ZeroExponent() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(-2), BigInteger.valueOf(4));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(0),BigInteger.valueOf(1));
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(NumberNode.class, result.getClass());
		assertEquals(BigInteger.valueOf(1), ((NumberNode)result).getNumerator());
		
		
	}
	
	@Test
	public void testRationalExponentiation_NegativeExponent_Exception() {
		assertThrows(IllegalArgumentException.class, () -> LongMath.raiseToPowerLong(2,-2));
		
		
	}

}
