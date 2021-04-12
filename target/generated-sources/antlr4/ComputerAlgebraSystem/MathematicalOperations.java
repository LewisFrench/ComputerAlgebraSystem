package ComputerAlgebraSystem;

public final class MathematicalOperations {

	// Raises a long base to a positive exponent without double conversion
	public static long raiseToPowerLong(long base, long exponent) {
		if (exponent < 0) {
			throw new IllegalArgumentException("Cannot raise a long to a negative power");
		}
		if (exponent == 0) {
			return 1;
		}
		long result = base;
		while (exponent > 1) {
			result *= base;
			exponent--;
		}
		return result;
	}

	
	// Calculates the greatest common denominator between two long values
	public static long gcd(long a, long b) {
	
		if (b == 0) {
			return a;
		}
		return Math.abs(gcd(b, a % b));
	}
}
