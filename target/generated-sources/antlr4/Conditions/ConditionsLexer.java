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
		OP_AND=7, OP_OR=8, OP_NOT=9, OP_ADD=10, OP_SUB=11, OP_MUL=12, OP_DIV=13, 
		OP_POW=14, VARIABLE=15, NUMBER=16, COMMA=17, LPAREN=18, VARIDENTIFIER=19, 
		RPAREN=20, POINT=21, WS=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"RELOP_EQ", "RELOP_NEQ", "RELOP_GT", "RELOP_GTE", "RELOP_LT", "RELOP_LTE", 
			"OP_AND", "OP_OR", "OP_NOT", "OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", 
			"OP_POW", "VARIABLE", "VALID_ID_START", "VALID_ID_CHAR", "NUMBER", "UNSIGNED_INTEGER", 
			"SIGN", "COMMA", "LPAREN", "VARIDENTIFIER", "RPAREN", "POINT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'=='", "'!='", "'>'", "'>='", "'<'", "'<='", "'&'", "'|'", "'!'", 
			"'+'", "'-'", "'*'", "'/'", "'^'", null, null, "','", "'('", "'$'", "')'", 
			"'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RELOP_EQ", "RELOP_NEQ", "RELOP_GT", "RELOP_GTE", "RELOP_LT", "RELOP_LTE", 
			"OP_AND", "OP_OR", "OP_NOT", "OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", 
			"OP_POW", "VARIABLE", "NUMBER", "COMMA", "LPAREN", "VARIDENTIFIER", "RPAREN", 
			"POINT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0082\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\7\20Z\n\20\f\20\16\20]\13\20\3\21\5\21"+
		"`\n\21\3\22\3\22\5\22d\n\22\3\23\3\23\3\23\5\23i\n\23\3\24\6\24l\n\24"+
		"\r\24\16\24m\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\6\33}\n\33\r\33\16\33~\3\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\2#\2%\22\'\2)"+
		"\2+\23-\24/\25\61\26\63\27\65\30\3\2\5\5\2C\\aac|\4\2--//\5\2\13\f\17"+
		"\17\"\"\2\u0082\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2%\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\3\67\3\2\2\2\5:\3\2\2\2\7=\3\2\2\2\t?\3\2\2\2\13B\3\2\2\2\rD"+
		"\3\2\2\2\17G\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27O\3\2\2\2\31"+
		"Q\3\2\2\2\33S\3\2\2\2\35U\3\2\2\2\37W\3\2\2\2!_\3\2\2\2#c\3\2\2\2%e\3"+
		"\2\2\2\'k\3\2\2\2)o\3\2\2\2+q\3\2\2\2-s\3\2\2\2/u\3\2\2\2\61w\3\2\2\2"+
		"\63y\3\2\2\2\65|\3\2\2\2\678\7?\2\289\7?\2\29\4\3\2\2\2:;\7#\2\2;<\7?"+
		"\2\2<\6\3\2\2\2=>\7@\2\2>\b\3\2\2\2?@\7@\2\2@A\7?\2\2A\n\3\2\2\2BC\7>"+
		"\2\2C\f\3\2\2\2DE\7>\2\2EF\7?\2\2F\16\3\2\2\2GH\7(\2\2H\20\3\2\2\2IJ\7"+
		"~\2\2J\22\3\2\2\2KL\7#\2\2L\24\3\2\2\2MN\7-\2\2N\26\3\2\2\2OP\7/\2\2P"+
		"\30\3\2\2\2QR\7,\2\2R\32\3\2\2\2ST\7\61\2\2T\34\3\2\2\2UV\7`\2\2V\36\3"+
		"\2\2\2W[\5!\21\2XZ\5#\22\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\"+
		" \3\2\2\2][\3\2\2\2^`\t\2\2\2_^\3\2\2\2`\"\3\2\2\2ad\5!\21\2bd\4\62;\2"+
		"ca\3\2\2\2cb\3\2\2\2d$\3\2\2\2eh\5\'\24\2fg\7\60\2\2gi\5\'\24\2hf\3\2"+
		"\2\2hi\3\2\2\2i&\3\2\2\2jl\4\62;\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2"+
		"\2\2n(\3\2\2\2op\t\3\2\2p*\3\2\2\2qr\7.\2\2r,\3\2\2\2st\7*\2\2t.\3\2\2"+
		"\2uv\7&\2\2v\60\3\2\2\2wx\7+\2\2x\62\3\2\2\2yz\7\60\2\2z\64\3\2\2\2{}"+
		"\t\4\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2"+
		"\u0080\u0081\b\33\2\2\u0081\66\3\2\2\2\t\2[_chm~\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}