// Generated from Algebra.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AlgebraLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OP_ADD=1, OP_SUB=2, OP_MUL=3, OP_DIV=4, OP_POW=5, VARIABLE=6, INTEGER=7, 
		DECIMALNUMBER=8, COMMA=9, LPAREN=10, VARIDENTIFIER=11, RPAREN=12, POINT=13, 
		WS=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", "OP_POW", "VARIABLE", "VALID_ID_CHAR", 
			"INTEGER", "DECIMALNUMBER", "UNSIGNED_INTEGER", "COMMA", "LPAREN", "VARIDENTIFIER", 
			"RPAREN", "POINT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'^'", null, null, null, "','", "'('", 
			"'$'", "')'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", "OP_POW", "VARIABLE", "INTEGER", 
			"DECIMALNUMBER", "COMMA", "LPAREN", "VARIDENTIFIER", "RPAREN", "POINT", 
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


	public AlgebraLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Algebra.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20Q\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\6\7/\n\7\r\7\16\7\60\3\b\5\b\64\n\b"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\13\6\13=\n\13\r\13\16\13>\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\6\21L\n\21\r\21\16\21M\3\21\3\21\2\2"+
		"\22\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\t\23\n\25\2\27\13\31\f\33\r\35\16"+
		"\37\17!\20\3\2\4\4\2C\\c|\5\2\13\f\17\17\"\"\2Q\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\3#\3\2\2\2\5%\3\2\2\2\7\'\3\2\2\2\t)\3\2\2\2\13+\3\2\2"+
		"\2\r.\3\2\2\2\17\63\3\2\2\2\21\65\3\2\2\2\23\67\3\2\2\2\25<\3\2\2\2\27"+
		"@\3\2\2\2\31B\3\2\2\2\33D\3\2\2\2\35F\3\2\2\2\37H\3\2\2\2!K\3\2\2\2#$"+
		"\7-\2\2$\4\3\2\2\2%&\7/\2\2&\6\3\2\2\2\'(\7,\2\2(\b\3\2\2\2)*\7\61\2\2"+
		"*\n\3\2\2\2+,\7`\2\2,\f\3\2\2\2-/\5\17\b\2.-\3\2\2\2/\60\3\2\2\2\60.\3"+
		"\2\2\2\60\61\3\2\2\2\61\16\3\2\2\2\62\64\t\2\2\2\63\62\3\2\2\2\64\20\3"+
		"\2\2\2\65\66\5\25\13\2\66\22\3\2\2\2\678\5\25\13\289\7\60\2\29:\5\25\13"+
		"\2:\24\3\2\2\2;=\4\62;\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\26\3"+
		"\2\2\2@A\7.\2\2A\30\3\2\2\2BC\7*\2\2C\32\3\2\2\2DE\7&\2\2E\34\3\2\2\2"+
		"FG\7+\2\2G\36\3\2\2\2HI\7\60\2\2I \3\2\2\2JL\t\3\2\2KJ\3\2\2\2LM\3\2\2"+
		"\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\b\21\2\2P\"\3\2\2\2\7\2\60\63>M\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}