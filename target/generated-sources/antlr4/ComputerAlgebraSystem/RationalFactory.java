package ComputerAlgebraSystem;

public class RationalFactory {
	public long numerator;
	public long denominator;
	
	public ExpressionNode createRational(long numerator, long denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("Attempting to create fraction with denominator of 0");
		}
		long gcd = gcd(numerator, denominator);
		if (gcd == denominator) {
			return new IntegerNode(numerator/denominator);
		} else {
			return new RationalNode(numerator/gcd, denominator/gcd );
		}
	}

	private static long gcd(long numerator, long denominator) {
		if (denominator == 0) {
			return numerator;
		}
		return gcd(denominator, numerator%denominator);
	}
	
	
}
