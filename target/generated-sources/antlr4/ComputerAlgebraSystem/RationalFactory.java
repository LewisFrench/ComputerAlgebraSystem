package ComputerAlgebraSystem;

public final class RationalFactory {
	public long numerator;
	public long denominator;
	
	public static ExpressionNode createRational(long numerator, long denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("Attempting to create fraction with denominator of 0");
		}
		// Normalise negative denominators
		if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		long rationalGcd = MathematicalOperations.gcd(numerator, denominator);
		// Simplify rational to integer if possible
		if (rationalGcd == Math.abs(denominator)) {
			return new IntegerNode(numerator/denominator);
		} else {
			return new RationalNode(numerator/rationalGcd, denominator/rationalGcd );
		}
	}
}
