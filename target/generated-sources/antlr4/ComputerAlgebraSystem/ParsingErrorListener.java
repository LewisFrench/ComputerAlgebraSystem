package ComputerAlgebraSystem;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * Extends the BaseErrorListener to catch ParseCancellationExceptions occurring during
 * the parsing of input by the ANTLR4 parsers. 
 * 
 * @author lewis
 *
 */
public class ParsingErrorListener extends BaseErrorListener {
	public static final ParsingErrorListener INSTANCE = new ParsingErrorListener();

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) throws ParseCancellationException {
		throw new ParseCancellationException("");
	}
}
