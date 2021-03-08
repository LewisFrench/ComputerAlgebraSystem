package Conditions;
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
		T__0=1, T__1=2, RELOP_GT=3, RELOP_LT=4, RELOP_EQ=5, RELOP_GTE=6, RELOP_LTE=7, 
		OP_AND=8, OP_OR=9, OP_NOT=10, OP_ADD=11, OP_SUB=12, OP_MUL=13, OP_DIV=14, 
		VARIABLE=15, SCIENTIFIC_NUMBER=16, LPAREN=17, RPAREN=18, POINT=19, POW=20, 
		WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "RELOP_GT", "RELOP_LT", "RELOP_EQ", "RELOP_GTE", "RELOP_LTE", 
			"OP_AND", "OP_OR", "OP_NOT", "OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", 
			"VARIABLE", "VALID_ID_START", "VALID_ID_CHAR", "SCIENTIFIC_NUMBER", "NUMBER", 
			"UNSIGNED_INTEGER", "E", "SIGN", "LPAREN", "RPAREN", "POINT", "POW", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'$'", "'>'", "'<'", "'=='", "'>='", "'<='", "'&'", "'|'", 
			"'!'", "'+'", "'-'", "'*'", "'/'", null, null, "'('", "')'", "'.'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "RELOP_GT", "RELOP_LT", "RELOP_EQ", "RELOP_GTE", "RELOP_LTE", 
			"OP_AND", "OP_OR", "OP_NOT", "OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", 
			"VARIABLE", "SCIENTIFIC_NUMBER", "LPAREN", "RPAREN", "POINT", "POW", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u0094\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\7\20[\n\20\f\20\16\20^\13\20\3\21"+
		"\5\21a\n\21\3\22\3\22\5\22e\n\22\3\23\3\23\3\23\5\23j\n\23\3\23\3\23\5"+
		"\23n\n\23\3\24\6\24q\n\24\r\24\16\24r\3\24\3\24\6\24w\n\24\r\24\16\24"+
		"x\5\24{\n\24\3\25\6\25~\n\25\r\25\16\25\177\3\26\3\26\3\27\3\27\3\30\3"+
		"\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\6\34\u008f\n\34\r\34\16\34\u0090"+
		"\3\34\3\34\2\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\2#\2%\22\'\2)\2+\2-\2/\23\61\24\63\25\65\26\67"+
		"\27\3\2\6\5\2C\\aac|\4\2GGgg\4\2--//\5\2\13\f\17\17\"\"\2\u0096\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2%\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5;\3\2\2"+
		"\2\7=\3\2\2\2\t?\3\2\2\2\13A\3\2\2\2\rD\3\2\2\2\17G\3\2\2\2\21J\3\2\2"+
		"\2\23L\3\2\2\2\25N\3\2\2\2\27P\3\2\2\2\31R\3\2\2\2\33T\3\2\2\2\35V\3\2"+
		"\2\2\37X\3\2\2\2!`\3\2\2\2#d\3\2\2\2%f\3\2\2\2\'p\3\2\2\2)}\3\2\2\2+\u0081"+
		"\3\2\2\2-\u0083\3\2\2\2/\u0085\3\2\2\2\61\u0087\3\2\2\2\63\u0089\3\2\2"+
		"\2\65\u008b\3\2\2\2\67\u008e\3\2\2\29:\7.\2\2:\4\3\2\2\2;<\7&\2\2<\6\3"+
		"\2\2\2=>\7@\2\2>\b\3\2\2\2?@\7>\2\2@\n\3\2\2\2AB\7?\2\2BC\7?\2\2C\f\3"+
		"\2\2\2DE\7@\2\2EF\7?\2\2F\16\3\2\2\2GH\7>\2\2HI\7?\2\2I\20\3\2\2\2JK\7"+
		"(\2\2K\22\3\2\2\2LM\7~\2\2M\24\3\2\2\2NO\7#\2\2O\26\3\2\2\2PQ\7-\2\2Q"+
		"\30\3\2\2\2RS\7/\2\2S\32\3\2\2\2TU\7,\2\2U\34\3\2\2\2VW\7\61\2\2W\36\3"+
		"\2\2\2X\\\5!\21\2Y[\5#\22\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2"+
		"] \3\2\2\2^\\\3\2\2\2_a\t\2\2\2`_\3\2\2\2a\"\3\2\2\2be\5!\21\2ce\4\62"+
		";\2db\3\2\2\2dc\3\2\2\2e$\3\2\2\2fm\5\'\24\2gi\5+\26\2hj\5-\27\2ih\3\2"+
		"\2\2ij\3\2\2\2jk\3\2\2\2kl\5)\25\2ln\3\2\2\2mg\3\2\2\2mn\3\2\2\2n&\3\2"+
		"\2\2oq\4\62;\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2sz\3\2\2\2tv\7\60"+
		"\2\2uw\4\62;\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zt\3\2"+
		"\2\2z{\3\2\2\2{(\3\2\2\2|~\4\62;\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2"+
		"\177\u0080\3\2\2\2\u0080*\3\2\2\2\u0081\u0082\t\3\2\2\u0082,\3\2\2\2\u0083"+
		"\u0084\t\4\2\2\u0084.\3\2\2\2\u0085\u0086\7*\2\2\u0086\60\3\2\2\2\u0087"+
		"\u0088\7+\2\2\u0088\62\3\2\2\2\u0089\u008a\7\60\2\2\u008a\64\3\2\2\2\u008b"+
		"\u008c\7`\2\2\u008c\66\3\2\2\2\u008d\u008f\t\5\2\2\u008e\u008d\3\2\2\2"+
		"\u008f\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0093\b\34\2\2\u00938\3\2\2\2\r\2\\`dimrxz\177\u0090\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}