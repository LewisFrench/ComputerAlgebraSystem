package ComputerAlgebraSystem;

import Nodes.*;

/**
 * Custom Exception to output errors occurring during the rewrite process
 * Contains the redex and rule that caused the error to occur. 
 * @author lewis
 *
 */
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
