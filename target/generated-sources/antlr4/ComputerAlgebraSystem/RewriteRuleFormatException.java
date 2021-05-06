package ComputerAlgebraSystem;

public class RewriteRuleFormatException extends Exception{
	/**
	 * Exception to catch invalid syntactic input in rewrite rules
	 */
	private static final long serialVersionUID = 9097470285554678108L;

	public RewriteRuleFormatException(String errorMessage) {
		super(errorMessage);
	}
	
}
