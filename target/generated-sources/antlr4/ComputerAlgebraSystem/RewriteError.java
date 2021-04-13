package ComputerAlgebraSystem;

public class RewriteError extends Exception {
	private static final long serialVersionUID = -690338710518143434L;
	String errorMessage;

	public RewriteError(String errorMessage, Rule rule, ExpressionNode redex) {
		this.errorMessage = errorMessage + "\nOccurred when applying Rule : " + rule.toString() + "\nto term : "
				+ redex.toString();
	}

	public String getMessage() {
		return this.errorMessage;
	}
}
