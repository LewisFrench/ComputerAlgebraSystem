// Generated from Arithmetic.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArithmeticLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, OP_EXP=3, OP_ADD=4, OP_SUB=5, OP_MUL=6, OP_DIV=7, RELOP_EQ=8, 
		RELOP_LT=9, RELOP_GT=10, VARIABLE=11, SCIENTIFIC_NUMBER=12, LPAREN=13, 
		RPAREN=14, POINT=15, POW=16, WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "OP_EXP", "OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", "RELOP_EQ", 
			"RELOP_LT", "RELOP_GT", "VARIABLE", "VALID_ID_START", "VALID_ID_CHAR", 
			"SCIENTIFIC_NUMBER", "NUMBER", "UNSIGNED_INTEGER", "E", "SIGN", "LPAREN", 
			"RPAREN", "POINT", "POW", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'$'", null, "'+'", "'-'", "'*'", "'/'", "'='", "'<'", "'>'", 
			null, null, "'('", "')'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "OP_EXP", "OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", "RELOP_EQ", 
			"RELOP_LT", "RELOP_GT", "VARIABLE", "SCIENTIFIC_NUMBER", "LPAREN", "RPAREN", 
			"POINT", "POW", "WS"
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


	public ArithmeticLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Arithmetic.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u0081\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\7\fH\n\f\f\f\16\fK\13\f\3\r\5\rN\n\r\3\16\3\16\5\16R"+
		"\n\16\3\17\3\17\3\17\5\17W\n\17\3\17\3\17\5\17[\n\17\3\20\6\20^\n\20\r"+
		"\20\16\20_\3\20\3\20\6\20d\n\20\r\20\16\20e\5\20h\n\20\3\21\6\21k\n\21"+
		"\r\21\16\21l\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\6\30|\n\30\r\30\16\30}\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\2\33\2\35\16\37\2!\2#\2%\2\'\17)\20"+
		"+\21-\22/\23\3\2\6\5\2C\\aac|\4\2GGgg\4\2--//\5\2\13\f\17\17\"\"\2\u0083"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\35\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\3\61\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2\139\3\2\2\2\r;\3"+
		"\2\2\2\17=\3\2\2\2\21?\3\2\2\2\23A\3\2\2\2\25C\3\2\2\2\27E\3\2\2\2\31"+
		"M\3\2\2\2\33Q\3\2\2\2\35S\3\2\2\2\37]\3\2\2\2!j\3\2\2\2#n\3\2\2\2%p\3"+
		"\2\2\2\'r\3\2\2\2)t\3\2\2\2+v\3\2\2\2-x\3\2\2\2/{\3\2\2\2\61\62\7.\2\2"+
		"\62\4\3\2\2\2\63\64\7&\2\2\64\6\3\2\2\2\65\66\7`\2\2\66\b\3\2\2\2\678"+
		"\7-\2\28\n\3\2\2\29:\7/\2\2:\f\3\2\2\2;<\7,\2\2<\16\3\2\2\2=>\7\61\2\2"+
		">\20\3\2\2\2?@\7?\2\2@\22\3\2\2\2AB\7>\2\2B\24\3\2\2\2CD\7@\2\2D\26\3"+
		"\2\2\2EI\5\31\r\2FH\5\33\16\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2"+
		"J\30\3\2\2\2KI\3\2\2\2LN\t\2\2\2ML\3\2\2\2N\32\3\2\2\2OR\5\31\r\2PR\4"+
		"\62;\2QO\3\2\2\2QP\3\2\2\2R\34\3\2\2\2SZ\5\37\20\2TV\5#\22\2UW\5%\23\2"+
		"VU\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\5!\21\2Y[\3\2\2\2ZT\3\2\2\2Z[\3\2\2\2"+
		"[\36\3\2\2\2\\^\4\62;\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`g\3\2"+
		"\2\2ac\7\60\2\2bd\4\62;\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3"+
		"\2\2\2ga\3\2\2\2gh\3\2\2\2h \3\2\2\2ik\4\62;\2ji\3\2\2\2kl\3\2\2\2lj\3"+
		"\2\2\2lm\3\2\2\2m\"\3\2\2\2no\t\3\2\2o$\3\2\2\2pq\t\4\2\2q&\3\2\2\2rs"+
		"\7*\2\2s(\3\2\2\2tu\7+\2\2u*\3\2\2\2vw\7\60\2\2w,\3\2\2\2xy\7`\2\2y.\3"+
		"\2\2\2z|\t\5\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\177\3\2\2\2"+
		"\177\u0080\b\30\2\2\u0080\60\3\2\2\2\r\2IMQVZ_egl}\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}