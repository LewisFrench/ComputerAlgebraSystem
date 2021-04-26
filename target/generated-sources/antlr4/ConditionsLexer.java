// Generated from Conditions.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConditionsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CONDITION_VARIABLE=1, VARIABLE=2, INTEGER=3, DECIMALNUMBER=4, RELOP_EQ=5, 
		RELOP_NEQ=6, RELOP_GT=7, RELOP_GTE=8, RELOP_LT=9, RELOP_LTE=10, OP_AND=11, 
		OP_OR=12, OP_NOT=13, OP_POW=14, OP_MUL=15, OP_DIV=16, OP_ADD=17, OP_SUB=18, 
		COMMA=19, LPAREN=20, RPAREN=21, POINT=22, RULEVARIDENTIFIER=23, UNDERSCORE=24, 
		WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CONDITION_VARIABLE", "VARIABLE", "INTEGER", "DECIMALNUMBER", "VALID_CONDITION_CHAR", 
			"UNSIGNED_INTEGER", "VALID_CHAR", "RELOP_EQ", "RELOP_NEQ", "RELOP_GT", 
			"RELOP_GTE", "RELOP_LT", "RELOP_LTE", "OP_AND", "OP_OR", "OP_NOT", "OP_POW", 
			"OP_MUL", "OP_DIV", "OP_ADD", "OP_SUB", "COMMA", "LPAREN", "RPAREN", 
			"POINT", "RULEVARIDENTIFIER", "UNDERSCORE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'=='", "'!='", "'>'", "'>='", "'<'", "'<='", 
			"'&'", "'|'", "'!'", "'^'", "'*'", "'/'", "'+'", "'-'", "','", "'('", 
			"')'", "'.'", "'$'", "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CONDITION_VARIABLE", "VARIABLE", "INTEGER", "DECIMALNUMBER", "RELOP_EQ", 
			"RELOP_NEQ", "RELOP_GT", "RELOP_GTE", "RELOP_LT", "RELOP_LTE", "OP_AND", 
			"OP_OR", "OP_NOT", "OP_POW", "OP_MUL", "OP_DIV", "OP_ADD", "OP_SUB", 
			"COMMA", "LPAREN", "RPAREN", "POINT", "RULEVARIDENTIFIER", "UNDERSCORE", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ConditionsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Conditions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u008a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\6\2>\n\2\r\2\16"+
		"\2?\3\3\6\3C\n\3\r\3\16\3D\3\4\3\4\3\5\3\5\3\5\3\5\3\6\5\6N\n\6\3\7\6"+
		"\7Q\n\7\r\7\16\7R\3\b\5\bV\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\6\35\u0085\n\35\r\35\16\35\u0086\3"+
		"\35\3\35\2\2\36\3\3\5\4\7\5\t\6\13\2\r\2\17\2\21\7\23\b\25\t\27\n\31\13"+
		"\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27\63\30\65\31\67"+
		"\329\33\3\2\5\5\2C\\aac|\4\2C\\c|\5\2\13\f\17\17\"\"\2\u008a\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\3;\3\2\2\2\5B\3\2\2\2\7F\3\2\2\2\tH\3\2\2\2\13M\3\2"+
		"\2\2\rP\3\2\2\2\17U\3\2\2\2\21W\3\2\2\2\23Z\3\2\2\2\25]\3\2\2\2\27_\3"+
		"\2\2\2\31b\3\2\2\2\33d\3\2\2\2\35g\3\2\2\2\37i\3\2\2\2!k\3\2\2\2#m\3\2"+
		"\2\2%o\3\2\2\2\'q\3\2\2\2)s\3\2\2\2+u\3\2\2\2-w\3\2\2\2/y\3\2\2\2\61{"+
		"\3\2\2\2\63}\3\2\2\2\65\177\3\2\2\2\67\u0081\3\2\2\29\u0084\3\2\2\2;="+
		"\5\67\34\2<>\5\13\6\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\4\3\2\2"+
		"\2AC\5\13\6\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\6\3\2\2\2FG\5\r"+
		"\7\2G\b\3\2\2\2HI\5\r\7\2IJ\5\63\32\2JK\5\r\7\2K\n\3\2\2\2LN\t\2\2\2M"+
		"L\3\2\2\2N\f\3\2\2\2OQ\4\62;\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2"+
		"S\16\3\2\2\2TV\t\3\2\2UT\3\2\2\2V\20\3\2\2\2WX\7?\2\2XY\7?\2\2Y\22\3\2"+
		"\2\2Z[\7#\2\2[\\\7?\2\2\\\24\3\2\2\2]^\7@\2\2^\26\3\2\2\2_`\7@\2\2`a\7"+
		"?\2\2a\30\3\2\2\2bc\7>\2\2c\32\3\2\2\2de\7>\2\2ef\7?\2\2f\34\3\2\2\2g"+
		"h\7(\2\2h\36\3\2\2\2ij\7~\2\2j \3\2\2\2kl\7#\2\2l\"\3\2\2\2mn\7`\2\2n"+
		"$\3\2\2\2op\7,\2\2p&\3\2\2\2qr\7\61\2\2r(\3\2\2\2st\7-\2\2t*\3\2\2\2u"+
		"v\7/\2\2v,\3\2\2\2wx\7.\2\2x.\3\2\2\2yz\7*\2\2z\60\3\2\2\2{|\7+\2\2|\62"+
		"\3\2\2\2}~\7\60\2\2~\64\3\2\2\2\177\u0080\7&\2\2\u0080\66\3\2\2\2\u0081"+
		"\u0082\7a\2\2\u00828\3\2\2\2\u0083\u0085\t\4\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u0089\b\35\2\2\u0089:\3\2\2\2\t\2?DMRU\u0086\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}