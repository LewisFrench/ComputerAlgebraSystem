package Nodes;

import java.math.BigInteger;

/**
 * Stores numerical values as rational numbers. Allows for generation as either
 * integer(denominator of 1) or a rational number.
 * 
 * @author lewis
 *
 */
public class NumberNode extends ExpressionNode {
	BigInteger numerator;
	BigInteger denominator;

	/**
	 * Constructor for a non-integer rational number. Normalises negative
	 * denominators and reduces values to a simplified form.
	 * 
	 * @param numerator
	 * @param denominator
	 * 
	 * @Throws ArithmeticException if attempting to create a rational number with a
	 *         denominators of 0.
	 */
	public NumberNode(BigInteger numerator, BigInteger denominator) {

		if (denominator.compareTo(BigInteger.ZERO) == 0) {
			throw new ArithmeticException("Attempted to divide by zero.");
		}

		if (denominator.compareTo(BigInteger.ZERO) == -1) {
			numerator = numerator.multiply(BigInteger.valueOf(-1));
			denominator = denominator.multiply(BigInteger.valueOf(-1));
		}

		BigInteger gcdValue = gcf(numerator, denominator);
		this.numerator = numerator.divide(gcdValue);
		this.denominator = denominator.divide(gcdValue);
	}

	/**
	 * Constructor for the generation of an integer stored as arational.
	 * 
	 * @param numerator
	 */
	public NumberNode(BigInteger numerator) {
		this.numerator = numerator;
		this.denominator = BigInteger.ONE;
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
	 * @return 0 if numbers are equivalent 1 if LHS is greater than RHS -1 if LHS is
	 *         less than the RHS
	 */
	public int compareTo(NumberNode n) {

		BigInteger lhs = this.numerator.multiply(n.getDenominator());
		BigInteger rhs = this.denominator.multiply(n.getNumerator());
		if (lhs.compareTo(rhs) == -1) {
			return -1;
		} else if (lhs.compareTo(rhs) == 1) {
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
	 * 
	 * @param node the RHS of the operation.
	 * @return NumberNode representing the result of the operation. PowerNode in
	 *         case of exponentiation that cannot be evaluated
	 */
	public NumberNode add(NumberNode node) {
		return new NumberNode(
				(this.numerator.multiply(node.getDenominator()).add(this.denominator.multiply(node.numerator))),
				this.denominator.multiply(node.getDenominator()));

	}

	public NumberNode subtract(NumberNode node) {

		return new NumberNode(
				(this.numerator.multiply(node.getDenominator()).subtract(this.denominator.multiply(node.numerator))),
				this.denominator.multiply(node.getDenominator()));

	}

	public NumberNode multiply(NumberNode node) {

		return new NumberNode(this.numerator.multiply(node.getNumerator()),
				this.denominator.multiply(node.getDenominator()));
	}

	public NumberNode divide(NumberNode node) {
		return this.multiply(node.getReciprocal());
	}

	public ExpressionNode exponentiate(NumberNode node) {
		if (node.isInteger()) {
			try {
				BigInteger exponent = node.getNumerator();
				// Negative exponent
				if (node.getNumerator().compareTo(BigInteger.ZERO) == -1) {
					return new NumberNode(
							this.getDenominator().pow(exponent.abs().intValueExact()), 
							this.getNumerator().pow(exponent.abs().intValueExact())
							);
	
				} else {
					return new NumberNode(this.getNumerator().pow( exponent.abs().intValue()),
							(this.getDenominator().pow(exponent.intValue())));
				}
			} catch (ArithmeticException ae) {
				throw new ArithmeticException("Exponent is invalid. It may be too large.");
			}
			}
		return new PowerNode(this, node);
	}

	public BigInteger getNumerator() {
		return this.numerator;
	}

	public BigInteger getDenominator() {
		return this.denominator;
	}

	/**
	 * Calculates the greatest common factor of two numbers
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static BigInteger gcf(BigInteger a, BigInteger b) {
		return a.gcd(b);
	}

	private boolean isInteger() {
		return this.denominator.compareTo(BigInteger.ONE) == 0;
	}

}