package ComputerAlgebraSystem;

public final class LongMath {
	
	/**
	 * Raises long integer to a positive integer exponent. 
	 * @param base Long value representing the base of an exponentiation 
	 * @param exponent Long value representing power to which the base is raised 

	 * @return long value representing the resulting calculation
	 * 
	 * @Throws IllegalArgumentException in case of negative exponent. 
	 */
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
