package Nodes;

import ComputerAlgebraSystem.LongMath;

/**
 * Stores numerical values as rational numbers. Allows for generation as either
 * integer(denominator of 1) or a rational number.
 * 
 * @author lewis
 *
 */
public class NumberNode extends ExpressionNode {

	long numerator;
	long denominator;

	/**
	 * Constructor for a non-integer rational number.
	 * Normalises negative denominators and reduces values to a simplified form. 
	 * 
	 * @param numerator
	 * @param denominator
	 * 
	 * @Throws ArithmeticException if attempting to create a rational number with a denominators of 0.
	 */
	public NumberNode(long numerator, long denominator) {
		if (Math.abs(denominator) == 0) {
			throw new ArithmeticException("Attempted to divide by zero.");
		}

		if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		long gcdValue = gcf(numerator, denominator);
		this.numerator = numerator / gcdValue;
		this.denominator = denominator / gcdValue;
	}
	/** 
	 * Constructor for the generation of an integer stored as arational.
	 * @param numerator
	 */
	public NumberNode(long numerator) {
		this.numerator = numerator;
		this.denominator = 1;
	}

	/**
	 * Output rational as a fraction, or as an integer if denominator is 1. 
	 */
	public String toString() {
		if (!isInteger()) {
			return String.valueOf(this.numerator + "/" + this.denominator);
		} else {
			return String.valueOf(this.numerator);
		}
	}
	/**
	 * 
	 * @param n
	 * @return
	 * 0 if numbers are equivalent
	 * 1 if LHS is greater than RHS
	 * -1 if LHS is less than the RHS
	 */
	public int compareTo(NumberNode n) {
		long lhs = this.numerator * n.getDenominator();
		long rhs = this.denominator * n.getNumerator();
		if (lhs < rhs) {
			return -1;
		} else if (lhs > rhs) {
			return 1;
		} else {
			return 0;
		}
	}

	public NumberNode getReciprocal() {
		return new NumberNode(this.denominator, this.numerator);
	}

	/**
	 * Series of numerical operations performed between two NumberNode instances.  
	 * @param node the RHS of the operation.
	 * @return NumberNode representing the result of the operation. 
	 * 		   PowerNode in case of exponentiation that cannot be evaluated  
	 */
	public NumberNode add(NumberNode node) {
		return new NumberNode((this.numerator * node.getDenominator()) + (this.denominator * node.getNumerator()),
				this.denominator * node.getDenominator());
	}

	public NumberNode subtract(NumberNode node) {
		return new NumberNode(this.numerator * node.getDenominator() - this.denominator * node.getNumerator(),
				this.denominator * node.getDenominator());
	}

	public NumberNode multiply(NumberNode node) {
		return new NumberNode(this.numerator * node.getNumerator(), this.denominator * node.getDenominator());
	}

	public NumberNode divide(NumberNode node) {
		return this.multiply(node.getReciprocal());
	}

	public ExpressionNode exponentiate(NumberNode node) {
		if (node.isInteger()) {

			long exponent = node.getNumerator();
			if (node.getNumerator() < 0) {
				// Here

				return new NumberNode(LongMath.raiseToPowerLong(this.getDenominator(), Math.abs(exponent)),
						LongMath.raiseToPowerLong(this.getNumerator(), Math.abs(exponent)));
			} else {
				return new NumberNode(LongMath.raiseToPowerLong(this.getNumerator(), exponent),
						LongMath.raiseToPowerLong(this.getDenominator(), exponent));
			}
		}
		return new PowerNode(this, node);
	}

	public long getNumerator() {
		return this.numerator;
	}

	public long getDenominator() {
		return this.denominator;
	}
	/**
	 * Calculates the greatest common factor of two numbers 
	 * @param a 
	 * @param b
	 * @return
	 */
	private static long gcf(long a, long b) {
		if (b == 0) {
			return a;
		}
		return Math.abs(gcf(b, a % b));
	}

	private boolean isInteger() {
		return this.denominator == 1;
	}

}