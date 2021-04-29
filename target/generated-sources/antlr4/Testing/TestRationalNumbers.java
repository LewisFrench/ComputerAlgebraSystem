package Testing;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;

import org.junit.Test;
import Nodes.*;
public class TestRationalNumbers {

	@Test
	public void testConstructor_Numerator_Denominator() {
		NumberNode n = new NumberNode(BigInteger.valueOf(1), BigInteger.valueOf(2));
		assertEquals(BigInteger.valueOf(1), n.getNumerator());
		assertEquals(BigInteger.valueOf(2), n.getDenominator());
	}
	
	
	@Test
	public void testConstructor_Numerator_Denominator_Simplifies() {
		NumberNode n = new NumberNode(BigInteger.valueOf(3), BigInteger.valueOf(6));
		assertEquals(BigInteger.valueOf(1), n.getNumerator());
		assertEquals(BigInteger.valueOf(2), n.getDenominator());
	}

	@Test
	public void testConstructor_Numerator_Denominator_Normalises() {
		NumberNode n = new NumberNode(BigInteger.valueOf(-3), BigInteger.valueOf(6));
		assertEquals(BigInteger.valueOf(-1), n.getNumerator());
		assertEquals(BigInteger.valueOf(2), n.getDenominator());
		
		n = new NumberNode(BigInteger.valueOf(3), BigInteger.valueOf(-6));
		assertEquals(BigInteger.valueOf(-1), n.getNumerator());
		assertEquals(BigInteger.valueOf(2), n.getDenominator());
		
		n = new NumberNode(BigInteger.valueOf(-3), BigInteger.valueOf(-6));
		assertEquals(BigInteger.valueOf(1), n.getNumerator());
		assertEquals(BigInteger.valueOf(2), n.getDenominator());
		
	}
	@Test
	public void testConstructor_Numerator() {
		NumberNode n = new NumberNode(BigInteger.valueOf(6));
		assertEquals(BigInteger.valueOf(6), n.getNumerator());
		assertEquals(BigInteger.valueOf(1), n.getDenominator());
	}
	
	
	@Test
	public void testConstructor_Numerator_DenominatorZero() {
		assertThrows(ArithmeticException.class, () ->  new NumberNode(BigInteger.valueOf(3), BigInteger.valueOf(0)));
		assertThrows(ArithmeticException.class, () ->  new NumberNode(BigInteger.valueOf(0), BigInteger.valueOf(0)));
		
	}
	@Test
	public void test_getReciprocal() {
		NumberNode n = new NumberNode(BigInteger.valueOf(6),BigInteger.valueOf(11)).getReciprocal();
		assertEquals(BigInteger.valueOf(11), n.getNumerator());
		assertEquals(BigInteger.valueOf(6), n.getDenominator());
	}
	
	@Test
	public void test_getReciprocal_Normalises() {
		NumberNode n = new NumberNode(BigInteger.valueOf(-6),BigInteger.valueOf(11)).getReciprocal();
		assertEquals(BigInteger.valueOf(-11), n.getNumerator());
		assertEquals(BigInteger.valueOf(6), n.getDenominator());
	}	
	
	@Test
	public void test_compareTo_GT() {
		NumberNode n = new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(3332));
		NumberNode n2 = new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(3333));
		
		assertEquals(1, n.compareTo(n2));
	}
	
	@Test
	public void test_compareTo_EQ() {
		NumberNode n = new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(3333));
		NumberNode n2 = new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(3333));
		
		assertEquals(0, n.compareTo(n2));
	}
	
	@Test
	public void test_compareTo_LT() {
		NumberNode n = new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(3333));
		NumberNode n2 = new NumberNode(BigInteger.valueOf(5),BigInteger.valueOf(3332));
		
		assertEquals(-1, n.compareTo(n2));
	}
	
	
}
