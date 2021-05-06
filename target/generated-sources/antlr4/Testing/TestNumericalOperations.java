package Testing;

import static org.junit.Assert.*;

import java.math.BigInteger;

import Nodes.*;
import org.junit.Test;


public class TestNumericalOperations {

	@Test
	public void testNumericalOperations_IntegerAddition() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(2));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(1));
		NumberNode result = num1.add(num2);
		assertEquals(BigInteger.valueOf(6), result.getNumerator());
		
		assertEquals(BigInteger.valueOf(1), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_IntegerAddition_negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(2));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(1));
		NumberNode result = num1.add(num2);
		assertEquals(BigInteger.valueOf(-2), result.getNumerator());
		assertEquals(BigInteger.valueOf(1), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_RationalAddition() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.add(num2);
		assertEquals(BigInteger.valueOf(2), result.getNumerator());
		assertEquals(BigInteger.valueOf(1), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_RationalAddition_Negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(3));
		NumberNode result = num1.add(num2);
		assertEquals(BigInteger.valueOf(-2), result.getNumerator());
		assertEquals(BigInteger.valueOf(3), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_IntegerSubtraction() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(2), BigInteger.valueOf(9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.subtract(num2);
		assertEquals(BigInteger.valueOf(-10), result.getNumerator());
		assertEquals(BigInteger.valueOf(9), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_IntegerSubtraction_negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(-2), BigInteger.valueOf(-4));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(1));
		NumberNode result = num1.subtract(num2);
		assertEquals(BigInteger.valueOf(9), result.getNumerator());
		assertEquals(BigInteger.valueOf(2), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_RationalSubtraction() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.subtract(num2);
		assertEquals(BigInteger.valueOf(-2), result.getNumerator());
		assertEquals(BigInteger.valueOf(3), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_RationalSubtraction_Negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(-9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(-3));
		NumberNode result = num1.subtract(num2);
		assertEquals(BigInteger.valueOf(-2), result.getNumerator());
		assertEquals(BigInteger.valueOf(1), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_IntegerMultiplication() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(2), BigInteger.valueOf(9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.multiply(num2);
		assertEquals(BigInteger.valueOf(8), result.getNumerator());
		assertEquals(BigInteger.valueOf(27), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_IntegerMultiplication_negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(72), BigInteger.valueOf(-5));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(11));
		NumberNode result = num1.multiply(num2);
		assertEquals(BigInteger.valueOf(288), result.getNumerator());
		assertEquals(BigInteger.valueOf(55), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_RationalMultiplication() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(-9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.multiply(num2);
		assertEquals(BigInteger.valueOf(-8), result.getNumerator());
		assertEquals(BigInteger.valueOf(9), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_RationalMultiplication_Negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(-9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(-3));
		NumberNode result = num1.multiply(num2);
		assertEquals(BigInteger.valueOf(8), result.getNumerator());
		assertEquals(BigInteger.valueOf(9), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_IntegerDivision() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(2), BigInteger.valueOf(9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.divide(num2);
		assertEquals(BigInteger.valueOf(1), result.getNumerator());
		assertEquals(BigInteger.valueOf(6), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_IntegerDivision_negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(72), BigInteger.valueOf(-5));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(11));
		NumberNode result = num1.divide(num2);
		assertEquals(BigInteger.valueOf(198), result.getNumerator());
		assertEquals(BigInteger.valueOf(5), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_RatinalDivision() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(-9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(3));
		NumberNode result = num1.divide(num2);
		assertEquals(BigInteger.valueOf(-1), result.getNumerator());
		assertEquals(BigInteger.valueOf(2), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_RationalDivision_Negative() {

		NumberNode num1 = new NumberNode(BigInteger.valueOf(6), BigInteger.valueOf(-9));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(-3));
		NumberNode result = num1.divide(num2);
		assertEquals(BigInteger.valueOf(1), result.getNumerator());
		assertEquals(BigInteger.valueOf(2), result.getDenominator());
	}

	@Test
	public void testNumericalOperations_IntegerExponentiation() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(2));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(1));
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(BigInteger.valueOf(16), ((NumberNode) result).getNumerator());
		assertEquals(BigInteger.valueOf(1), ((NumberNode) result).getDenominator());
	}

	@Test
	public void testNumericalOperations_IntegerExponentiationNegative() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(2));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(1));
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(BigInteger.valueOf(1), ((NumberNode) result).getNumerator());
		assertEquals(BigInteger.valueOf(16), ((NumberNode) result).getDenominator());
	}

	@Test
	public void testNumericalOperations_RationalExponentiation() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(-2), BigInteger.valueOf(4));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(4), BigInteger.valueOf(1));
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(BigInteger.valueOf(1), ((NumberNode) result).getNumerator());
		assertEquals(BigInteger.valueOf(16), ((NumberNode) result).getDenominator());
	}

	@Test
	public void testNumericalOperations_RationalExponentiationNegative() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(3),BigInteger.valueOf(4));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(-4), BigInteger.valueOf(1));
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(BigInteger.valueOf(256), ((NumberNode) result).getNumerator());
		assertEquals(BigInteger.valueOf(81), ((NumberNode) result).getDenominator());
	}
	
	@Test
	public void testNumericalOperations_RationalExponentiation_FractionalExponent() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(-2), BigInteger.valueOf(4));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(1),BigInteger.valueOf(2));
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(PowerNode.class, result.getClass());
	}
	
	
	@Test
	public void testNumericalOperations_RationalExponentiation_ZeroExponent() {
		NumberNode num1 = new NumberNode(BigInteger.valueOf(-2), BigInteger.valueOf(4));
		NumberNode num2 = new NumberNode(BigInteger.valueOf(0),BigInteger.valueOf(1));
		ExpressionNode result = num1.exponentiate(num2);
		assertEquals(NumberNode.class, result.getClass());
		assertEquals(BigInteger.valueOf(1), ((NumberNode)result).getNumerator());
		
		
	}


}
