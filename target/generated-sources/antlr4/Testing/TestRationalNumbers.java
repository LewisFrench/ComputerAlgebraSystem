package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import Nodes.*;
public class TestRationalNumbers {

	@Test
	public void testConstructor_Numerator_Denominator() {
		NumberNode n = new NumberNode(1, 2);
		assertEquals(1, n.getNumerator());
		assertEquals(2, n.getDenominator());
	}
	
	
	@Test
	public void testConstructor_Numerator_Denominator_Simplifies() {
		NumberNode n = new NumberNode(3, 6);
		assertEquals(1, n.getNumerator());
		assertEquals(2, n.getDenominator());
	}

	@Test
	public void testConstructor_Numerator_Denominator_Normalises() {
		NumberNode n = new NumberNode(-3, 6);
		assertEquals(-1, n.getNumerator());
		assertEquals(2, n.getDenominator());
		
		n = new NumberNode(3, -6);
		assertEquals(-1, n.getNumerator());
		assertEquals(2, n.getDenominator());
		
		n = new NumberNode(-3, -6);
		assertEquals(1, n.getNumerator());
		assertEquals(2, n.getDenominator());
		
	}
	@Test
	public void testConstructor_Numerator() {
		NumberNode n = new NumberNode(6);
		assertEquals(6, n.getNumerator());
		assertEquals(1, n.getDenominator());
	}
	
	
	@Test
	public void testConstructor_Numerator_DenominatorZero() {
		assertThrows(ArithmeticException.class, () ->  new NumberNode(3, 0));
		assertThrows(ArithmeticException.class, () ->  new NumberNode(0, 0));
		
	}
	@Test
	public void test_getReciprocal() {
		NumberNode n = new NumberNode(6,11).getReciprocal();
		assertEquals(11, n.getNumerator());
		assertEquals(6, n.getDenominator());
	}
	
	@Test
	public void test_getReciprocal_Normalises() {
		NumberNode n = new NumberNode(-6,11).getReciprocal();
		assertEquals(-11, n.getNumerator());
		assertEquals(6, n.getDenominator());
	}	
	
	@Test
	public void test_compareTo_GT() {
		NumberNode n = new NumberNode(5,3332);
		NumberNode n2 = new NumberNode(5,3333);
		
		assertEquals(1, n.compareTo(n2));
	}
	
	@Test
	public void test_compareTo_EQ() {
		NumberNode n = new NumberNode(5,3333);
		NumberNode n2 = new NumberNode(5,3333);
		
		assertEquals(0, n.compareTo(n2));
	}
	
	@Test
	public void test_compareTo_LT() {
		NumberNode n = new NumberNode(5,3333);
		NumberNode n2 = new NumberNode(5,3332);
		
		assertEquals(-1, n.compareTo(n2));
	}
	
	
}
