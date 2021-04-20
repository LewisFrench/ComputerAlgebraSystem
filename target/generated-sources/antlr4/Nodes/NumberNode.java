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

	public NumberNode(long numerator, long denominator) {
		if (Math.abs(denominator) == 0) {
			throw new ArithmeticException("Attempted to create a rational with a denominator of 0");
		}

		if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		long gcdValue = gcd(numerator, denominator);
		this.numerator = numerator / gcdValue;
		this.denominator = denominator / gcdValue;
	}

	public NumberNode(long numerator) {
		this.numerator = numerator;
		this.denominator = 1;
	}

	public String toString() {
		if (!isInteger()) {
			// Handle recurring and complicated decimal output. Only print as decimal if
			// under a certain amount of dp

			return String.valueOf(this.numerator + "/" + this.denominator);
		} else {
			return String.valueOf(this.numerator);
		}
	}

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

	private static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return Math.abs(gcd(b, a % b));
	}

	private boolean isInteger() {
		return this.denominator == 1;
	}

}