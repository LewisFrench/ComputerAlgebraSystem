package Arithmetic;
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
		OP_ADD=1, OP_SUB=2, OP_MUL=3, OP_DIV=4, OP_POW=5, VARIABLE=6, NUMBER=7, 
		COMMA=8, LPAREN=9, VARIDENTIFIER=10, RPAREN=11, POINT=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", "OP_POW", "VARIABLE", "VALID_ID_START", 
			"VALID_ID_CHAR", "NUMBER", "UNSIGNED_INTEGER", "SIGN", "COMMA", "LPAREN", 
			"VARIDENTIFIER", "RPAREN", "POINT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'^'", null, null, "','", "'('", "'$'", 
			"')'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OP_ADD", "OP_SUB", "OP_MUL", "OP_DIV", "OP_POW", "VARIABLE", "NUMBER", 
			"COMMA", "LPAREN", "VARIDENTIFIER", "RPAREN", "POINT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17Z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\7\7\62\n\7\f\7\16\7\65"+
		"\13\7\3\b\5\b8\n\b\3\t\3\t\5\t<\n\t\3\n\3\n\3\n\5\nA\n\n\3\13\6\13D\n"+
		"\13\r\13\16\13E\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\6\22U\n\22\r\22\16\22V\3\22\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\2\21\2\23\t\25\2\27\2\31\n\33\13\35\f\37\r!\16#\17\3\2\5\5\2C\\aa"+
		"c|\4\2--//\5\2\13\f\17\17\"\"\2Z\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\23\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5\'\3"+
		"\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13-\3\2\2\2\r/\3\2\2\2\17\67\3\2\2\2\21;"+
		"\3\2\2\2\23=\3\2\2\2\25C\3\2\2\2\27G\3\2\2\2\31I\3\2\2\2\33K\3\2\2\2\35"+
		"M\3\2\2\2\37O\3\2\2\2!Q\3\2\2\2#T\3\2\2\2%&\7-\2\2&\4\3\2\2\2\'(\7/\2"+
		"\2(\6\3\2\2\2)*\7,\2\2*\b\3\2\2\2+,\7\61\2\2,\n\3\2\2\2-.\7`\2\2.\f\3"+
		"\2\2\2/\63\5\17\b\2\60\62\5\21\t\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3"+
		"\2\2\2\63\64\3\2\2\2\64\16\3\2\2\2\65\63\3\2\2\2\668\t\2\2\2\67\66\3\2"+
		"\2\28\20\3\2\2\29<\5\17\b\2:<\4\62;\2;9\3\2\2\2;:\3\2\2\2<\22\3\2\2\2"+
		"=@\5\25\13\2>?\7\60\2\2?A\5\25\13\2@>\3\2\2\2@A\3\2\2\2A\24\3\2\2\2BD"+
		"\4\62;\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\26\3\2\2\2GH\t\3\2\2"+
		"H\30\3\2\2\2IJ\7.\2\2J\32\3\2\2\2KL\7*\2\2L\34\3\2\2\2MN\7&\2\2N\36\3"+
		"\2\2\2OP\7+\2\2P \3\2\2\2QR\7\60\2\2R\"\3\2\2\2SU\t\4\2\2TS\3\2\2\2UV"+
		"\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\b\22\2\2Y$\3\2\2\2\t\2\63\67"+
		";@EV\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}