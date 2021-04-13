package ComputerAlgebraSystem;

public final class LongMath {
	
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
}
