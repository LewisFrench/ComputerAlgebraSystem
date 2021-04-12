package ComputerAlgebraSystem;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class TestMathematicalOperations {

	@Test
	public void testRaiseToPowerLong_Zero() {
		assertEquals(0, MathematicalOperations.raiseToPowerLong(0, 3));
	}

	@Test
	public void testRaiseToPowerLong_ZeroExponent() {
		assertEquals(1, MathematicalOperations.raiseToPowerLong(1, 0));
	}
	@Test
	public void testRaiseToPowerLong_Simple_Positive() {
		assertEquals(256, MathematicalOperations.raiseToPowerLong(2, 8));
		assertEquals(128, MathematicalOperations.raiseToPowerLong(2, 7));
		assertEquals(125, MathematicalOperations.raiseToPowerLong(5, 3));
		assertEquals(1000000, MathematicalOperations.raiseToPowerLong(10, 6));
	}
	
	
	@Test
	public void testRaiseToPowerLong_NegativeBase() {
		assertEquals(-8, MathematicalOperations.raiseToPowerLong(-2, 3));
	}
	
	@Test
	public void testRaiseToPowerLong_NegativeExponent_Exception() {
		assertThrows(IllegalArgumentException.class, () -> MathematicalOperations.raiseToPowerLong(2, -2));
	}
	
	
	
	@Test
	public void testGCD_zero() {
		assertEquals(0, MathematicalOperations.gcd(0, 0));
	}
	
	@Test
	public void testGCD_Simple_Positive() {
		assertEquals(3, MathematicalOperations.gcd(12, 3));
		assertEquals(3, MathematicalOperations.gcd(3, 12));
		assertEquals(100, MathematicalOperations.gcd(100, 100));
		assertEquals(1, MathematicalOperations.gcd(3, 7));
		assertEquals(1, MathematicalOperations.gcd(7, 3));
		assertEquals(2, MathematicalOperations.gcd(10, 12));
		assertEquals(2, MathematicalOperations.gcd(12, 10));
		assertEquals(12, MathematicalOperations.gcd(0, 12));
		assertEquals(10, MathematicalOperations.gcd(10, 0));
	}
	
	@Test
	public void testGCD_Simple_Negative() {
		assertEquals(3, MathematicalOperations.gcd(-12, 3));
		assertEquals(3, MathematicalOperations.gcd(-3, 12));
		assertEquals(100, MathematicalOperations.gcd(-100, 100));
		assertEquals(1, MathematicalOperations.gcd(-3, 7));
		assertEquals(1, MathematicalOperations.gcd(-7, 3));
		assertEquals(2, MathematicalOperations.gcd(-10, 12));
		assertEquals(2, MathematicalOperations.gcd(-12, 10));
		assertEquals(12, MathematicalOperations.gcd(0,- 12));
		assertEquals(10, MathematicalOperations.gcd(0, -10));
	}
	
	
	
}
