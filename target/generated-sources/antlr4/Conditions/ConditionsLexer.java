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
		RELOP_EQ=1, RELOP_NEQ=2, RELOP_GT=3, RELOP_GTE=4, RELOP_LT=5, RELOP_LTE=6, 
		OP_AND=7, OP_OR=8, OP_NOT=9, VARIABLE=10, COMMA=11, LPAREN=12, VARIDENTIFIER=13, 
		RPAREN=14, POINT=15, WS=16, OP_ADD=17, OP_SUB=18, OP_MUL=19, OP_DIV=20, 
		OP_POW=21, NUMBER=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"RELOP_EQ", "RELOP_NEQ", "RELOP_GT", "RELOP_GTE", "RELOP_LT", "RELOP_LTE", 
			"OP_AND", "OP_OR", "OP_NOT", "VARIABLE", "VALID_ID_CHAR", "COMMA", "LPAREN", 
			"VARIDENTIFIER", "RPAREN", "POINT", "WS", "OP_ADD", "OP_SUB", "OP_MUL", 
			"OP_DIV", "OP_POW", "NUMBER", "UNSIGNED_INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'=='", "'!='", "'>'", "'>='", "'<'", "'<='", "'&'", "'|'", "'!'", 
			null, "','", "'('", "'$'", "')'", "'.'", null, "'+'", "'-'", "'*'", "'/'", 
			"'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RELOP_EQ", "RELOP_NEQ", "RELOP_GT", "RELOP_GTE", "RELOP_LT", "RELOP_LTE", 
			"OP_AND", "OP_OR", "OP_NOT", "VARIABLE", "COMMA", "LPAREN", "VARIDENTIFIER", 
			"RPAREN", "POINT", "WS", "OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", "OP_POW", 
			"NUMBER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30v\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\6\13K\n\13\r\13\16\13L\3\f\5\fP\n\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\6\22]\n\22\r\22\16\22^\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\5\30p\n\30\3\31\6\31s\n\31\r\31\16\31t\2\2\32\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\2\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)"+
		"\25+\26-\27/\30\61\2\3\2\4\5\2C\\aac|\5\2\13\f\17\17\"\"\2w\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\63\3\2\2\2\5\66\3\2"+
		"\2\2\79\3\2\2\2\t;\3\2\2\2\13>\3\2\2\2\r@\3\2\2\2\17C\3\2\2\2\21E\3\2"+
		"\2\2\23G\3\2\2\2\25J\3\2\2\2\27O\3\2\2\2\31Q\3\2\2\2\33S\3\2\2\2\35U\3"+
		"\2\2\2\37W\3\2\2\2!Y\3\2\2\2#\\\3\2\2\2%b\3\2\2\2\'d\3\2\2\2)f\3\2\2\2"+
		"+h\3\2\2\2-j\3\2\2\2/l\3\2\2\2\61r\3\2\2\2\63\64\7?\2\2\64\65\7?\2\2\65"+
		"\4\3\2\2\2\66\67\7#\2\2\678\7?\2\28\6\3\2\2\29:\7@\2\2:\b\3\2\2\2;<\7"+
		"@\2\2<=\7?\2\2=\n\3\2\2\2>?\7>\2\2?\f\3\2\2\2@A\7>\2\2AB\7?\2\2B\16\3"+
		"\2\2\2CD\7(\2\2D\20\3\2\2\2EF\7~\2\2F\22\3\2\2\2GH\7#\2\2H\24\3\2\2\2"+
		"IK\5\27\f\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\26\3\2\2\2NP\t\2"+
		"\2\2ON\3\2\2\2P\30\3\2\2\2QR\7.\2\2R\32\3\2\2\2ST\7*\2\2T\34\3\2\2\2U"+
		"V\7&\2\2V\36\3\2\2\2WX\7+\2\2X \3\2\2\2YZ\7\60\2\2Z\"\3\2\2\2[]\t\3\2"+
		"\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\b\22\2\2a$\3"+
		"\2\2\2bc\7-\2\2c&\3\2\2\2de\7/\2\2e(\3\2\2\2fg\7,\2\2g*\3\2\2\2hi\7\61"+
		"\2\2i,\3\2\2\2jk\7`\2\2k.\3\2\2\2lo\5\61\31\2mn\7\60\2\2np\5\61\31\2o"+
		"m\3\2\2\2op\3\2\2\2p\60\3\2\2\2qs\4\62;\2rq\3\2\2\2st\3\2\2\2tr\3\2\2"+
		"\2tu\3\2\2\2u\62\3\2\2\2\b\2LO^ot\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}