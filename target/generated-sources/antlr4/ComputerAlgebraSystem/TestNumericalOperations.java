package ComputerAlgebraSystem;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class TestNumericalOperations {

//////////////////////////ADDITION///////////////////////////////////

////////////////////////Decimal

	@Test
	public void test_Addition_Decimal_Decimal() {
		NumberNode d1 = new DecimalNode(2.0);
		NumberNode d2 = new DecimalNode(2.6);

		assertTrue(d1.add(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.add(d2)).getValue().compareTo(BigDecimal.valueOf(4.6)) == 0);

	}

	@Test
	public void test_Addition_Decimal_Decimal_negative() {
		NumberNode d1 = new DecimalNode(-2.0);
		NumberNode d2 = new DecimalNode(-2.6);

		assertTrue(d1.add(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.add(d2)).getValue().compareTo(BigDecimal.valueOf(-4.6)) == 0);
	}

	@Test
	public void test_Addition_Decimal_Decimal_minuteValue() {
		NumberNode d1 = new DecimalNode(2.0);
		NumberNode d2 = new DecimalNode(new BigDecimal("0.00000000000000000000001"));

		assertTrue(d1.add(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.add(d2)).getValue().compareTo(new BigDecimal("2.00000000000000000000001")) == 0);
	}

	@Test
	public void test_Addition_Decimal_Integer() {
		NumberNode d1 = new DecimalNode(2.0);
		NumberNode d2 = new IntegerNode(3);

		assertTrue(d1.add(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.add(d2)).getValue().compareTo(BigDecimal.valueOf(5)) == 0);

	}

	@Test
	public void test_Addition_Decimal_Integer_negative() {
		NumberNode d1 = new DecimalNode(-2.1);
		NumberNode d2 = new IntegerNode(-100);

		assertTrue(d1.add(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.add(d2)).getValue().compareTo(BigDecimal.valueOf(-102.1)) == 0);

	}

	@Test
	public void test_Addition_Decimal_Rational() {
		NumberNode d1 = new DecimalNode(2.2);
		NumberNode d2 = new RationalNode(1, 4);

		assertTrue(d1.add(d2) instanceof AdditionNode);
		assertTrue(((AdditionNode) d1.add(d2)).Left instanceof DecimalNode);
		assertTrue(((AdditionNode) d1.add(d2)).Right instanceof RationalNode);

	}

	@Test
	public void test_Addition_Decimal_Rational_Negative() {
		NumberNode d1 = new DecimalNode(2.2);
		NumberNode d2 = new RationalNode(10, 4);

		assertTrue(d1.add(d2) instanceof AdditionNode);
		assertTrue(((AdditionNode) d1.add(d2)).Left instanceof DecimalNode);
		assertTrue(((AdditionNode) d1.add(d2)).Right instanceof RationalNode);

	}

	////////////////////////////// Integer

	@Test
	public void test_Addition_Integer_Integer() {
		NumberNode d1 = new IntegerNode(8);
		NumberNode d2 = new IntegerNode(4);

		assertTrue(d1.add(d2) instanceof IntegerNode);
		assertTrue(((IntegerNode) d1.add(d2)).getValue() == 12);

	}

	@Test
	public void test_Addition_Integer_Integer_negative() {
		NumberNode d1 = new IntegerNode(-2l);
		NumberNode d2 = new IntegerNode(-100);

		assertTrue(d1.add(d2) instanceof IntegerNode);
		assertTrue(((IntegerNode) d1.add(d2)).getValue() == -102);

	}

	@Test
	public void test_Addition_Integer_Decimal() {
		NumberNode d1 = new IntegerNode(2);
		NumberNode d2 = new DecimalNode(3.1);

		assertTrue(d1.add(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.add(d2)).getValue().compareTo(BigDecimal.valueOf(5.1)) == 0);

	}

	@Test
	public void test_Addition_Integer_Decimal_negative() {

		NumberNode d1 = new IntegerNode(-2);
		NumberNode d2 = new DecimalNode(-2.6);

		assertTrue(d1.add(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.add(d2)).getValue().compareTo(BigDecimal.valueOf(-4.6)) == 0);
	}

	@Test
	public void test_Addition_Integer_Rational() {
		NumberNode d1 = new IntegerNode(8);
		NumberNode d2 = new RationalNode(1, 3);

		assertTrue(d1.add(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.add(d2)).numerator == 25);
		assertTrue(((RationalNode) d1.add(d2)).denominator == 3);
	}

	@Test
	public void test_Addition_Integer_Rational_negative() {
		NumberNode d1 = new IntegerNode(4);
		NumberNode d2 = new RationalNode(-2, 3);

		assertTrue(d1.add(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.add(d2)).numerator == 10);
		assertTrue(((RationalNode) d1.add(d2)).denominator == 3);
	}

	@Test
	public void test_Addition_Integer_Rational_Simplifies() {
		NumberNode d1 = new IntegerNode(4);
		NumberNode d2 = new RationalNode(3, 2);

		assertTrue(d1.add(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.add(d2)).numerator == 11);
		assertTrue(((RationalNode) d1.add(d2)).denominator == 2);
	}

	@Test
	public void test_Addition_Integer_Rational_SimplifiesToInteger() {
		NumberNode d1 = new IntegerNode(4);
		NumberNode d2 = new RationalNode(4, -2);

		assertTrue(d1.add(d2) instanceof IntegerNode);
		assertEquals(((IntegerNode) d1.add(d2)).getValue(), 2);
	}

/////////////////////////////// Rational

	@Test
	public void test_Addition_Rational_Integer() {
		NumberNode d2 = new IntegerNode(8);
		NumberNode d1 = new RationalNode(1, 3);

		assertTrue(d1.add(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.add(d2)).numerator == 25);
		assertTrue(((RationalNode) d1.add(d2)).denominator == 3);
	}

	@Test
	public void test_Addition_Rational_Integer_negative() {
		NumberNode d2 = new IntegerNode(4);
		NumberNode d1 = new RationalNode(-2, 3);

		assertTrue(d1.add(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.add(d2)).numerator == 10);
		assertTrue(((RationalNode) d1.add(d2)).denominator == 3);
	}

	@Test
	public void test_Addition_Rational_Integer_Simplifies() {
		NumberNode d2 = new IntegerNode(4);
		NumberNode d1 = new RationalNode(3, 2);

		assertTrue(d1.add(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.add(d2)).numerator == 11);
		assertTrue(((RationalNode) d1.add(d2)).denominator == 2);
	}

	@Test
	public void test_Addition_Rational_Integer_SimplifiesToInteger() {
		NumberNode d2 = new IntegerNode(4);
		NumberNode d1 = new RationalNode(4, -2);

		assertTrue(d1.add(d2) instanceof IntegerNode);
		assertEquals(((IntegerNode) d1.add(d2)).getValue(), 2);
	}

	@Test
	public void test_Addition_Rational_Rational() {
		NumberNode d1 = new RationalNode(2, 3);
		NumberNode d2 = new RationalNode(3, 4);

		assertTrue(d1.add(d2) instanceof RationalNode);
		assertEquals(17, ((RationalNode) d1.add(d2)).numerator);
		assertEquals(12, ((RationalNode) d1.add(d2)).denominator);
	}

	@Test
	public void test_Addition_Rational_Rational_Negative() {
		NumberNode d1 = new RationalNode(2, 3);
		NumberNode d2 = new RationalNode(-3, 4);

		assertTrue(d1.add(d2) instanceof RationalNode);
		assertEquals(-1, ((RationalNode) d1.add(d2)).numerator);
		assertEquals(12, ((RationalNode) d1.add(d2)).denominator);
	}

	@Test
	public void test_Addition_Rational_Rational_Simplifies() {
		NumberNode d1 = new RationalNode(2, 3);
		NumberNode d2 = new RationalNode(6, 9);

		assertTrue(d1.add(d2) instanceof RationalNode);
		assertEquals(4, ((RationalNode) d1.add(d2)).numerator);
		assertEquals(3, ((RationalNode) d1.add(d2)).denominator);
	}

	@Test
	public void test_Addition_Rational_Rational_SimplifiesToInteger() {
		NumberNode d1 = new RationalNode(2, 3);
		NumberNode d2 = new RationalNode(3, 9);

		assertTrue(d1.add(d2) instanceof IntegerNode);
		assertEquals(((IntegerNode) d1.add(d2)).getValue(), 1);
	}

	@Test
	public void test_Addition_Rational_Decimal() {
		NumberNode d1 = new RationalNode(1, 3);
		NumberNode d2 = new DecimalNode(1.33);

		assertTrue(d1.add(d2) instanceof AdditionNode);
		assertTrue(((AdditionNode) d1.add(d2)).Left instanceof RationalNode);
		assertTrue(((AdditionNode) d1.add(d2)).Right instanceof DecimalNode);
	}

////////////////////////SUBTRACTION///////////////////////////////////

	@Test
	public void test_Subtraction_Decimal_Decimal() {
		NumberNode d1 = new DecimalNode(2.0);
		NumberNode d2 = new DecimalNode(2.6);

		assertTrue(d1.subtract(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.subtract(d2)).getValue().compareTo(BigDecimal.valueOf(-0.6)) == 0);

	}

	@Test
	public void test_Subtraction_Decimal_Decimal_negative() {
		NumberNode d1 = new DecimalNode(-2.0);
		NumberNode d2 = new DecimalNode(-2.6);

		assertTrue(d1.subtract(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.subtract(d2)).getValue().compareTo(BigDecimal.valueOf(0.6)) == 0);
	}

	@Test
	public void test_Subtraction_Decimal_Decimal_minuteValue() {
		NumberNode d1 = new DecimalNode(2.0);
		NumberNode d2 = new DecimalNode(0.000000000000001);

		assertTrue(d1.subtract(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.subtract(d2)).getValue().compareTo(BigDecimal.valueOf(1.999999999999999)) == 0);
	}

	@Test
	public void test_Subtraction_Decimal_Integer() {
		NumberNode d1 = new DecimalNode(2.0);
		NumberNode d2 = new IntegerNode(3);

		assertTrue(d1.subtract(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.subtract(d2)).getValue().compareTo(BigDecimal.valueOf(-1)) == 0);

	}

	@Test
	public void test_Subtraction_Decimal_Integer_negative() {
		NumberNode d1 = new DecimalNode(-2.1);
		NumberNode d2 = new IntegerNode(-100);

		assertTrue(d1.subtract(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.subtract(d2)).getValue().compareTo(BigDecimal.valueOf(97.9)) == 0);

	}

	@Test
	public void test_Subtraction_Decimal_Rational() {
		NumberNode d1 = new DecimalNode(2.2);
		NumberNode d2 = new RationalNode(1, 4);

		assertTrue(d1.subtract(d2) instanceof SubtractionNode);
		assertTrue(((AdditionNode) d1.add(d2)).Left instanceof DecimalNode);
		assertTrue(((AdditionNode) d1.add(d2)).Right instanceof RationalNode);

	}

	@Test
	public void test_Subtraction_Decimal_Rational_Negative() {
		NumberNode d1 = new DecimalNode(2.2);
		NumberNode d2 = new RationalNode(10, 4);

		assertTrue(d1.subtract(d2) instanceof SubtractionNode);
		assertTrue(((AdditionNode) d1.add(d2)).Left instanceof DecimalNode);
		assertTrue(((AdditionNode) d1.add(d2)).Right instanceof RationalNode);

	}

	////////////////////////////// Integer

	@Test
	public void test_Subtraction_Integer_Integer() {
		NumberNode d1 = new IntegerNode(8);
		NumberNode d2 = new IntegerNode(4);

		assertTrue(d1.subtract(d2) instanceof IntegerNode);
		assertTrue(((IntegerNode) d1.subtract(d2)).getValue() == 4);

	}

	@Test
	public void test_Subtraction_Integer_Integer_negative() {
		NumberNode d1 = new IntegerNode(-2l);
		NumberNode d2 = new IntegerNode(-100);

		assertTrue(d1.subtract(d2) instanceof IntegerNode);
		assertTrue(((IntegerNode) d1.subtract(d2)).getValue() == 98);

	}

	@Test
	public void test_Subtraction_Integer_Decimal() {
		NumberNode d1 = new IntegerNode(2);
		NumberNode d2 = new DecimalNode(3.1);

		assertTrue(d1.subtract(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.subtract(d2)).getValue().compareTo(BigDecimal.valueOf(-1.1)) == 0);

	}

	@Test
	public void test_Subtraction_Integer_Decimal_negative() {
		NumberNode d1 = new IntegerNode(-2);
		NumberNode d2 = new DecimalNode(-2.6);

		assertTrue(d1.subtract(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.subtract(d2)).getValue().compareTo(BigDecimal.valueOf(0.6)) == 0);
	}

	@Test
	public void test_Subtraction_Integer_Rational() {
		NumberNode d1 = new IntegerNode(8);
		NumberNode d2 = new RationalNode(1, 3);
		assertTrue(d1.subtract(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.subtract(d2)).numerator == 23);
		assertTrue(((RationalNode) d1.subtract(d2)).denominator == 3);
	}

	@Test
	public void test_Subtraction_Integer_Rational_negative() {
		NumberNode d1 = new IntegerNode(4);
		NumberNode d2 = new RationalNode(-2, 3);

		assertTrue(d1.subtract(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.subtract(d2)).numerator == 14);
		assertTrue(((RationalNode) d1.subtract(d2)).denominator == 3);
	}

	@Test
	public void test_Subtraction_Integer_Rational_Simplifies() {
		NumberNode d1 = new IntegerNode(4);
		NumberNode d2 = new RationalNode(3, 2);
		assertTrue(d1.subtract(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.subtract(d2)).numerator == 5);
		assertTrue(((RationalNode) d1.subtract(d2)).denominator == 2);
	}

	@Test
	public void test_Subtraction_Integer_Rational_SimplifiesToInteger() {
		NumberNode d1 = new IntegerNode(4);
		NumberNode d2 = new RationalNode(4, -2);

		assertTrue(d1.subtract(d2) instanceof IntegerNode);
		assertEquals(((IntegerNode) d1.subtract(d2)).getValue(), 6);
	}

/////////////////////////////// Rational

	@Test
	public void test_Subtraction_Rational_Integer() {
		NumberNode d1 = new RationalNode(1, 3);
		NumberNode d2 = new IntegerNode(8);

		assertTrue(d1.subtract(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.subtract(d2)).numerator == -23);
		assertTrue(((RationalNode) d1.subtract(d2)).denominator == 3);
	}

	@Test
	public void test_Subtraction_Rational_Integer_negative() {
		NumberNode d1 = new RationalNode(-2, 3);
		NumberNode d2 = new IntegerNode(4);

		assertTrue(d1.subtract(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.subtract(d2)).numerator == -14);
		assertTrue(((RationalNode) d1.subtract(d2)).denominator == 3);
	}

	@Test
	public void test_Subtraction_Rational_Integer_Simplifies() {
		NumberNode d1 = new RationalNode(3, 2);
		NumberNode d2 = new IntegerNode(4);

		assertTrue(d1.subtract(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.subtract(d2)).numerator == -5);
		assertTrue(((RationalNode) d1.subtract(d2)).denominator == 2);
	}

	@Test
	public void test_Subtraction_Rational_Integer_SimplifiesToInteger() {
		NumberNode d1 = new RationalNode(4, -2);
		NumberNode d2 = new IntegerNode(4);

		assertTrue(d1.subtract(d2) instanceof IntegerNode);
		assertEquals(((IntegerNode) d1.subtract(d2)).getValue(), -6);
	}

	@Test
	public void test_Subtraction_Rational_Rational() {
		NumberNode d1 = new RationalNode(2, 3);
		NumberNode d2 = new RationalNode(3, 4);

		assertTrue(d1.subtract(d2) instanceof RationalNode);
		assertEquals(-1, ((RationalNode) d1.subtract(d2)).numerator);
		assertEquals(12, ((RationalNode) d1.subtract(d2)).denominator);
	}

	@Test
	public void test_Subtraction_Rational_Rational_Negative() {
		NumberNode d1 = new RationalNode(2, 3);
		NumberNode d2 = new RationalNode(-3, 4);

		assertTrue(d1.subtract(d2) instanceof RationalNode);
		assertEquals(17, ((RationalNode) d1.subtract(d2)).numerator);
		assertEquals(12, ((RationalNode) d1.subtract(d2)).denominator);
	}

	@Test
	public void test_Subtraction_Rational_Rational_Simplifies() {
		NumberNode d1 = new RationalNode(2, 3);
		NumberNode d2 = new RationalNode(3, 9);
		System.out.println(d1.subtract(d2));
		assertTrue(d1.subtract(d2) instanceof RationalNode);
		assertEquals(1, ((RationalNode) d1.subtract(d2)).numerator);
		assertEquals(3, ((RationalNode) d1.subtract(d2)).denominator);
	}

	@Test
	public void test_Subtraction_Rational_Rational_SimplifiesToInteger() {
		NumberNode d1 = new RationalNode(2, 3);
		NumberNode d2 = new RationalNode(6, 9);

		assertTrue(d1.subtract(d2) instanceof IntegerNode);
		assertEquals(((IntegerNode) d1.subtract(d2)).getValue(), 0);
	}

	@Test
	public void test_Subtraction_Rational_Decimal() {
		NumberNode d1 = new RationalNode(1, 3);
		NumberNode d2 = new DecimalNode(1.33);

		assertTrue(d1.subtract(d2) instanceof SubtractionNode);
		assertTrue(((SubtractionNode) d1.subtract(d2)).Left instanceof RationalNode);
		assertTrue(((SubtractionNode) d1.subtract(d2)).Right instanceof DecimalNode);
	}

	//////////////////////// MULTIPLICATION///////////////////////////////////

	@Test
	public void test_Multiplication_Decimal_Decimal() {
		NumberNode d1 = new DecimalNode(1.5);
		NumberNode d2 = new DecimalNode(1.5);

		assertTrue(d1.multiply(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.multiply(d2)).getValue().compareTo(BigDecimal.valueOf(2.25)) == 0);

	}

	@Test
	public void test_Multiplication_Decimal_Decimal_negative() {
		NumberNode d1 = new DecimalNode(-2.5);
		NumberNode d2 = new DecimalNode(2.5);

		assertTrue(d1.multiply(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.multiply(d2)).getValue().compareTo(BigDecimal.valueOf(-6.25)) == 0);
	}

	@Test
	public void test_Multiplication_Decimal_Decimal_minuteValue() {
		NumberNode d1 = new DecimalNode(2.0);
		NumberNode d2 = new DecimalNode(1.0000000000001);

		assertTrue(d1.multiply(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.multiply(d2)).getValue().compareTo(BigDecimal.valueOf(2.0000000000002)) == 0);
	}

	@Test
	public void test_Multiplication_Decimal_Integer() {
		NumberNode d1 = new DecimalNode(2.2);
		NumberNode d2 = new IntegerNode(3);

		assertTrue(d1.multiply(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.multiply(d2)).getValue().compareTo(BigDecimal.valueOf(6.6)) == 0);

	}

	@Test
	public void test_Multiplication_Decimal_Integer_negative() {
		NumberNode d1 = new DecimalNode(-2.1);
		NumberNode d2 = new IntegerNode(-100);

		assertTrue(d1.multiply(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.multiply(d2)).getValue().compareTo(BigDecimal.valueOf(210)) == 0);

	}

	@Test
	public void test_Multiplication_Decimal_Rational() {
		NumberNode d1 = new DecimalNode(2.2);
		NumberNode d2 = new RationalNode(1, 4);

		assertTrue(d1.multiply(d2) instanceof MultiplicationNode);
		assertTrue(((MultiplicationNode) d1.multiply(d2)).Left instanceof DecimalNode);
		assertTrue(((MultiplicationNode) d1.multiply(d2)).Right instanceof RationalNode);

	}

	@Test
	public void test_Multiplication_Decimal_Rational_Negative() {
		NumberNode d1 = new DecimalNode(2.2);
		NumberNode d2 = new RationalNode(10, 4);

		assertTrue(d1.multiply(d2) instanceof MultiplicationNode);
		assertTrue(((MultiplicationNode) d1.multiply(d2)).Left instanceof DecimalNode);
		assertTrue(((MultiplicationNode) d1.multiply(d2)).Right instanceof RationalNode);

	}

	////////////////////////////// Integer

	@Test
	public void test_Multiplication_Integer_Integer() {
		NumberNode d1 = new IntegerNode(8);
		NumberNode d2 = new IntegerNode(4);

		assertTrue(d1.multiply(d2) instanceof IntegerNode);
		assertTrue(((IntegerNode) d1.multiply(d2)).getValue() == 32);

	}

	@Test
	public void test_Multiplication_Integer_Integer_negative() {
		NumberNode d1 = new IntegerNode(-2l);
		NumberNode d2 = new IntegerNode(-100);

		assertTrue(d1.multiply(d2) instanceof IntegerNode);
		assertTrue(((IntegerNode) d1.multiply(d2)).getValue() == 200);

	}

	@Test
	public void test_Multiplication_Integer_Decimal() {
		NumberNode d1 = new IntegerNode(2);
		NumberNode d2 = new DecimalNode(3.1);

		assertTrue(d1.multiply(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.multiply(d2)).getValue().compareTo(BigDecimal.valueOf(6.2)) == 0);

	}

	@Test
	public void test_Multiplication_Integer_Decimal_negative() {
		NumberNode d1 = new IntegerNode(-2);
		NumberNode d2 = new DecimalNode(-2.6);

		assertTrue(d1.multiply(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.multiply(d2)).getValue().compareTo(BigDecimal.valueOf(5.2)) == 0);
	}

	@Test
	public void test_Multiplication_Integer_Rational() {
		NumberNode d1 = new IntegerNode(8);
		NumberNode d2 = new RationalNode(1, 3);

		assertTrue(d1.multiply(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.multiply(d2)).numerator == 8);
		assertTrue(((RationalNode) d1.multiply(d2)).denominator == 3);
	}

	@Test
	public void test_Multiplication_Integer_Rational_negative() {
		NumberNode d1 = new IntegerNode(4);
		NumberNode d2 = new RationalNode(-2, 3);

		assertTrue(d1.multiply(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.multiply(d2)).numerator == -8);
		assertTrue(((RationalNode) d1.multiply(d2)).denominator == 3);
	}

	@Test
	public void test_Multiplication_Integer_Rational_Simplifies() {
		NumberNode d1 = new IntegerNode(11);
		NumberNode d2 = new RationalNode(3, 9);

		assertTrue(d1.multiply(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.multiply(d2)).numerator == 11);
		assertTrue(((RationalNode) d1.multiply(d2)).denominator == 3);
	}

	@Test
	public void test_Multiplication_Integer_Rational_SimplifiesToInteger() {
		NumberNode d1 = new IntegerNode(4);
		NumberNode d2 = new RationalNode(-4, 2);
		System.out.println(d1.multiply(d2));
		assertTrue(d1.multiply(d2) instanceof IntegerNode);
		assertEquals(((IntegerNode) d1.multiply(d2)).getValue(), -8);
	}

//////////////////////////////Rational
	@Test
	public void test_Multiplication_Rational_Integer() {
		NumberNode d2 = new IntegerNode(8);
		NumberNode d1 = new RationalNode(1, 3);

		assertTrue(d1.multiply(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.multiply(d2)).numerator == 8);
		assertTrue(((RationalNode) d1.multiply(d2)).denominator == 3);
	}

	@Test
	public void test_Multiplication_Rational_Integer_negative() {
		NumberNode d2 = new IntegerNode(4);
		NumberNode d1 = new RationalNode(-2, 3);

		assertTrue(d1.multiply(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.multiply(d2)).numerator == -8);
		assertTrue(((RationalNode) d1.multiply(d2)).denominator == 3);
	}

	@Test
	public void test_Multiplication_Rational_Integer_Simplifies() {
		NumberNode d2 = new IntegerNode(15);
		NumberNode d1 = new RationalNode(2, 8);

		assertTrue(d1.multiply(d2) instanceof RationalNode);
		assertTrue(((RationalNode) d1.multiply(d2)).numerator == 15);
		assertTrue(((RationalNode) d1.multiply(d2)).denominator == 4);
	}

	@Test
	public void test_Multiplication_Rational_Integer_SimplifiesToInteger() {
		NumberNode d2 = new IntegerNode(4);
		NumberNode d1 = new RationalNode(-4, 2);

		assertTrue(d1.multiply(d2) instanceof IntegerNode);
		assertEquals(((IntegerNode) d1.multiply(d2)).getValue(), -8);
	}

	@Test
	public void test_Multiplication_Rational_Rational() {
		NumberNode d1 = new RationalNode(2, 3);
		NumberNode d2 = new RationalNode(7, 9);

		assertTrue(d1.multiply(d2) instanceof RationalNode);
		assertEquals(14, ((RationalNode) d1.multiply(d2)).numerator);
		assertEquals(27, ((RationalNode) d1.multiply(d2)).denominator);
	}

	@Test
	public void test_Multiplication_Rational_Rational_Negative() {
		NumberNode d1 = new RationalNode(2, 3);
		NumberNode d2 = new RationalNode(-7,9);

		assertTrue(d1.multiply(d2) instanceof RationalNode);
		assertEquals(-14, ((RationalNode) d1.multiply(d2)).numerator);
		assertEquals(27, ((RationalNode) d1.multiply(d2)).denominator);
	}

	@Test
	public void test_Multiplication_Rational_Rational_Simplifies() {
		NumberNode d1 = new RationalNode(2, 3);
		NumberNode d2 = new RationalNode(3, 4);

		assertTrue(d1.multiply(d2) instanceof RationalNode);
		assertEquals(1, ((RationalNode) d1.multiply(d2)).numerator);
		assertEquals(2, ((RationalNode) d1.multiply(d2)).denominator);
	}

	@Test
	public void test_Multiplication_Rational_Rational_SimplifiesToInteger() {
		NumberNode d1 = new RationalNode(8, 4);
		NumberNode d2 = new RationalNode(4, 2);

		assertTrue(d1.multiply(d2) instanceof IntegerNode);
		assertEquals(((IntegerNode) d1.multiply(d2)).getValue(), 4);
	}

	@Test
	public void test_Multiplication_Rational_Decimal() {
		NumberNode d1 = new RationalNode(1, 3);
		NumberNode d2 = new DecimalNode(1.33);

		assertTrue(d1.multiply(d2) instanceof MultiplicationNode);
		assertTrue(((MultiplicationNode) d1.multiply(d2)).Left instanceof RationalNode);
		assertTrue(((MultiplicationNode) d1.multiply(d2)).Right instanceof DecimalNode);
	}

	//////////////////////// DVISION///////////////////////////////////

	@Test
	public void test_Division_Decimal_Decimal() {
		NumberNode d1 = new DecimalNode(7.7);
		NumberNode d2 = new DecimalNode(2.5);

		try {
			assertTrue(d1.divide(d2) instanceof DecimalNode);
			assertTrue(((DecimalNode) d1.divide(d2)).getValue().compareTo(BigDecimal.valueOf(3.08)) == 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void test_Division_Decimal_Decimal_negative() {
		NumberNode d1 = new DecimalNode(-7.7);
		NumberNode d2 = new DecimalNode(2.5);

		try {
			assertTrue(d1.divide(d2) instanceof DecimalNode);
			assertTrue(((DecimalNode) d1.divide(d2)).getValue().compareTo(BigDecimal.valueOf(-3.08)) == 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void test_Division_Decimal_Integer() {
		NumberNode d1 = new DecimalNode(6.6);
		NumberNode d2 = new IntegerNode(3);

		try {
			assertTrue(d1.divide(d2) instanceof DecimalNode);
			assertTrue(((DecimalNode) d1.divide(d2)).getValue().compareTo(BigDecimal.valueOf(2.2)) == 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void test_Division_Decimal_Integer_negative() {
		NumberNode d1 = new DecimalNode(-2.1);
		NumberNode d2 = new IntegerNode(-100);

		try {
			assertTrue(d1.divide(d2) instanceof DecimalNode);
			assertTrue(((DecimalNode) d1.divide(d2)).getValue().compareTo(BigDecimal.valueOf(0.021)) == 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

////////////////////////////// Integer

	@Test
	public void test_Division_Integer_Integer_wholeNumber() {
		NumberNode d1 = new IntegerNode(8);
		NumberNode d2 = new IntegerNode(4);

		try {
			assertTrue(d1.divide(d2) instanceof IntegerNode);
			assertTrue(((IntegerNode) d1.divide(d2)).getValue() == 2);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void test_Division_Integer_Integer_Rational() {
		NumberNode d1 = new IntegerNode(8);
		NumberNode d2 = new IntegerNode(5);

		try {
			assertTrue(d1.divide(d2) instanceof RationalNode);
			assertTrue(((RationalNode) d1.divide(d2)).numerator == 8);
			assertTrue(((RationalNode) d1.divide(d2)).denominator == 5);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void test_Division_Integer_Integer_negative_Rational() {
		NumberNode d1 = new IntegerNode(-2l);
		NumberNode d2 = new IntegerNode(-100);
		try {
			assertTrue(d1.divide(d2) instanceof RationalNode);
			assertTrue(((RationalNode) d1.divide(d2)).numerator == 1);
			assertTrue(((RationalNode) d1.divide(d2)).denominator == 50);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void test_Division_Integer_Integer_negative_wholeNumber() {
		NumberNode d1 = new IntegerNode(-6l);
		NumberNode d2 = new IntegerNode(-2);

		try {
			System.out.println(d1.divide(d2));
			assertTrue(d1.divide(d2) instanceof IntegerNode);

			assertTrue(((IntegerNode) d1.divide(d2)).getValue() == 3);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void test_Division_Integer_Decimal() {
		NumberNode d1 = new IntegerNode(7);
		NumberNode d2 = new DecimalNode(1.6);

		try {
			assertTrue(d1.divide(d2) instanceof DecimalNode);
			assertTrue(((DecimalNode) d1.divide(d2)).getValue().compareTo(BigDecimal.valueOf(4.375)) == 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void test_Division_Integer_Decimal_negative() {
		NumberNode d1 = new IntegerNode(5);
		NumberNode d2 = new DecimalNode(0.4);

		try {
			assertTrue(d1.divide(d2) instanceof DecimalNode);
			assertTrue(((DecimalNode) d1.divide(d2)).getValue().compareTo(BigDecimal.valueOf(12.5)) == 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

//////////////////////////////EXPONENTIATION

	@Test
	public void test_Exponentiation_Integer_Integer() {
		NumberNode d1 = new IntegerNode(-6l);
		NumberNode d2 = new IntegerNode(2);

		assertTrue(d1.exponentiate(d2) instanceof IntegerNode);
		assertTrue(((IntegerNode) d1.exponentiate(d2)).getValue() == 36);
	}

	@Test
	public void test_Exponentiation_Integer_Integer_negativePower() {
		NumberNode d1 = new IntegerNode(5);
		NumberNode d2 = new IntegerNode(-2);

		assertTrue(d1.exponentiate(d2) instanceof DecimalNode);

		assertTrue(((DecimalNode) d1.exponentiate(d2)).getValue().compareTo(BigDecimal.valueOf(0.04)) == 0);
	}

	@Test
	public void test_Exponentiation_Integer_Decimal() {
		NumberNode d1 = new IntegerNode(2);
		NumberNode d2 = new DecimalNode(1.2);

		assertTrue(d1.exponentiate(d2) instanceof DecimalNode);

		assertTrue(((DecimalNode) d1.exponentiate(d2)).getValue()
				.compareTo(BigDecimal.valueOf(6.8986483073060735904391549411229789257049560546875)) == 0);

	}

}
