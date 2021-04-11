package ComputerAlgebraSystem;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class TestNumericalOperations {

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
		NumberNode d2 = new DecimalNode(0.000000000000001);

		assertTrue(d1.add(d2) instanceof DecimalNode);
		System.out.println(d1.add(d2));
		assertTrue(((DecimalNode) d1.add(d2)).getValue().compareTo(BigDecimal.valueOf(2.000000000000001)) == 0);
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

//////////////////////////SUBTRACTION

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
		System.out.println(d1.subtract(d2));
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

///////////////////////////////////////// MULTIPLICATION

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
		System.out.println("\n -2.5*2.5 = " + d1.multiply(d2));
		assertTrue(d1.multiply(d2) instanceof DecimalNode);
		assertTrue(((DecimalNode) d1.multiply(d2)).getValue().compareTo(BigDecimal.valueOf(-6.25)) == 0);
	}

	@Test
	public void test_Multiplication_Decimal_Decimal_minuteValue() {
		NumberNode d1 = new DecimalNode(2.0);
		NumberNode d2 = new DecimalNode(1.0000000000001);

		assertTrue(d1.multiply(d2) instanceof DecimalNode);
		System.out.println(d1.multiply(d2));
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

///////////////////////////////////////// DIVISION

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
			assertTrue(((RationalNode)d1.divide(d2)).numerator == 8);
			assertTrue(((RationalNode)d1.divide(d2)).denominator == 5);
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
			System.out.println(d1.divide(d2) + "   "+ d1.divide(d2).getClass());
			assertTrue(d1.divide(d2) instanceof RationalNode);
			assertTrue(((RationalNode)d1.divide(d2)).numerator == 1);
			assertTrue(((RationalNode)d1.divide(d2)).denominator == 50);
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
		System.out.println("5^-2 " + d1.exponentiate(d2));
		assertTrue(((DecimalNode) d1.exponentiate(d2)).getValue().compareTo(BigDecimal.valueOf(0.04)) == 0);
	}
	
	
	@Test
	public void test_Exponentiation_Integer_Decimal() {
		NumberNode d1 = new IntegerNode(2);
		NumberNode d2 = new DecimalNode(1.2);

		assertTrue(d1.exponentiate(d2) instanceof DecimalNode);
		System.out.println("Exp " + d1.exponentiate(d2));
		assertTrue(((DecimalNode) d1.exponentiate(d2)).getValue().compareTo(BigDecimal.valueOf(6.8986483073060735904391549411229789257049560546875)) == 0);

	}


}
