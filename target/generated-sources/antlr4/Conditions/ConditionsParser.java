package Conditions;
// Generated from Conditions.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConditionsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RELOP_GT=1, RELOP_LT=2, RELOP_EQ=3, OP_AND=4, OP_OR=5, OP_NOT=6, VARIABLE=7, 
		FUNCTION=8, SCIENTIFIC_NUMBER=9, LPAREN=10, RPAREN=11, WS=12;
	public static final int
		RULE_ruleConditions = 0, RULE_condition = 1, RULE_var = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"ruleConditions", "condition", "var"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'>'", "'<'", "'=='", "'&'", "'|'", "'!'", null, null, null, "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RELOP_GT", "RELOP_LT", "RELOP_EQ", "OP_AND", "OP_OR", "OP_NOT", 
			"VARIABLE", "FUNCTION", "SCIENTIFIC_NUMBER", "LPAREN", "RPAREN", "WS"
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

	@Override
	public String getGrammarFileName() { return "Conditions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ConditionsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RuleConditionsContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public RuleConditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleConditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterRuleConditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitRuleConditions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitRuleConditions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleConditionsContext ruleConditions() throws RecognitionException {
		RuleConditionsContext _localctx = new RuleConditionsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ruleConditions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			condition(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionContext extends ConditionContext {
		public Token function;
		public VarContext value;
		public TerminalNode LPAREN() { return getToken(ConditionsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ConditionsParser.RPAREN, 0); }
		public TerminalNode FUNCTION() { return getToken(ConditionsParser.FUNCTION, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public FunctionContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionParentheticalContext extends ConditionContext {
		public TerminalNode LPAREN() { return getToken(ConditionsParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ConditionsParser.RPAREN, 0); }
		public ConditionParentheticalContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterConditionParenthetical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitConditionParenthetical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitConditionParenthetical(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ConditionContext {
		public ConditionContext value;
		public TerminalNode OP_NOT() { return getToken(ConditionsParser.OP_NOT, 0); }
		public TerminalNode LPAREN() { return getToken(ConditionsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ConditionsParser.RPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public NotContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelopContext extends ConditionContext {
		public VarContext left;
		public Token relop;
		public VarContext right;
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public TerminalNode RELOP_GT() { return getToken(ConditionsParser.RELOP_GT, 0); }
		public TerminalNode RELOP_LT() { return getToken(ConditionsParser.RELOP_LT, 0); }
		public TerminalNode RELOP_EQ() { return getToken(ConditionsParser.RELOP_EQ, 0); }
		public RelopContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterRelop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitRelop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitRelop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionOperationContext extends ConditionContext {
		public ConditionContext left;
		public Token op;
		public ConditionContext right;
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode OP_AND() { return getToken(ConditionsParser.OP_AND, 0); }
		public TerminalNode OP_OR() { return getToken(ConditionsParser.OP_OR, 0); }
		public ConditionOperationContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterConditionOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitConditionOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitConditionOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new ConditionParentheticalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(9);
				match(LPAREN);
				setState(10);
				condition(0);
				setState(11);
				match(RPAREN);
				}
				break;
			case OP_NOT:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(13);
				match(OP_NOT);
				setState(14);
				match(LPAREN);
				setState(15);
				((NotContext)_localctx).value = condition(0);
				setState(16);
				match(RPAREN);
				}
				break;
			case VARIABLE:
			case SCIENTIFIC_NUMBER:
				{
				_localctx = new RelopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18);
				((RelopContext)_localctx).left = var();
				setState(19);
				((RelopContext)_localctx).relop = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RELOP_GT) | (1L << RELOP_LT) | (1L << RELOP_EQ))) != 0)) ) {
					((RelopContext)_localctx).relop = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(20);
				((RelopContext)_localctx).right = var();
				}
				break;
			case FUNCTION:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				((FunctionContext)_localctx).function = match(FUNCTION);
				setState(23);
				match(LPAREN);
				setState(24);
				((FunctionContext)_localctx).value = var();
				setState(25);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionOperationContext(new ConditionContext(_parentctx, _parentState));
					((ConditionOperationContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(29);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(30);
					((ConditionOperationContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==OP_AND || _la==OP_OR) ) {
						((ConditionOperationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(31);
					((ConditionOperationContext)_localctx).right = condition(6);
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	 
		public VarContext() { }
		public void copyFrom(VarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableContext extends VarContext {
		public Token value;
		public TerminalNode VARIABLE() { return getToken(ConditionsParser.VARIABLE, 0); }
		public VariableContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends VarContext {
		public Token value;
		public TerminalNode SCIENTIFIC_NUMBER() { return getToken(ConditionsParser.SCIENTIFIC_NUMBER, 0); }
		public NumberContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var);
		try {
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				((VariableContext)_localctx).value = match(VARIABLE);
				}
				break;
			case SCIENTIFIC_NUMBER:
				_localctx = new NumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				((NumberContext)_localctx).value = match(SCIENTIFIC_NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16,\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\3\3\3\3\3\7\3#\n\3\f\3\16\3&\13"+
		"\3\3\4\3\4\5\4*\n\4\3\4\2\3\4\5\2\4\6\2\4\3\2\3\5\3\2\6\7\2-\2\b\3\2\2"+
		"\2\4\35\3\2\2\2\6)\3\2\2\2\b\t\5\4\3\2\t\3\3\2\2\2\n\13\b\3\1\2\13\f\7"+
		"\f\2\2\f\r\5\4\3\2\r\16\7\r\2\2\16\36\3\2\2\2\17\20\7\b\2\2\20\21\7\f"+
		"\2\2\21\22\5\4\3\2\22\23\7\r\2\2\23\36\3\2\2\2\24\25\5\6\4\2\25\26\t\2"+
		"\2\2\26\27\5\6\4\2\27\36\3\2\2\2\30\31\7\n\2\2\31\32\7\f\2\2\32\33\5\6"+
		"\4\2\33\34\7\r\2\2\34\36\3\2\2\2\35\n\3\2\2\2\35\17\3\2\2\2\35\24\3\2"+
		"\2\2\35\30\3\2\2\2\36$\3\2\2\2\37 \f\7\2\2 !\t\3\2\2!#\5\4\3\b\"\37\3"+
		"\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\5\3\2\2\2&$\3\2\2\2\'*\7\t\2\2"+
		"(*\7\13\2\2)\'\3\2\2\2)(\3\2\2\2*\7\3\2\2\2\5\35$)";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}