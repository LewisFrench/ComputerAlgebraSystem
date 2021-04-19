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
		CONDITION_VARIABLE=1, VARIABLE=2, INTEGER=3, DECIMALNUMBER=4, RELOP_EQ=5, 
		RELOP_NEQ=6, RELOP_GT=7, RELOP_GTE=8, RELOP_LT=9, RELOP_LTE=10, OP_AND=11, 
		OP_OR=12, OP_NOT=13, OP_POW=14, OP_MUL=15, OP_DIV=16, OP_ADD=17, OP_SUB=18, 
		COMMA=19, LPAREN=20, RPAREN=21, POINT=22, RULEVARIDENTIFIER=23, UNDERSCORE=24, 
		WS=25;
	public static final int
		RULE_ruleConditions = 0, RULE_condition = 1, RULE_expression = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"ruleConditions", "condition", "expression"
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
		public TerminalNode EOF() { return getToken(ConditionsParser.EOF, 0); }
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
			setState(7);
			match(EOF);
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
	public static class ConditionNotOperationContext extends ConditionContext {
		public ConditionContext value;
		public TerminalNode OP_NOT() { return getToken(ConditionsParser.OP_NOT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionNotOperationContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterConditionNotOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitConditionNotOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitConditionNotOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionRelopContext extends ConditionContext {
		public ExpressionContext left;
		public Token relop;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RELOP_EQ() { return getToken(ConditionsParser.RELOP_EQ, 0); }
		public TerminalNode RELOP_NEQ() { return getToken(ConditionsParser.RELOP_NEQ, 0); }
		public TerminalNode RELOP_GT() { return getToken(ConditionsParser.RELOP_GT, 0); }
		public TerminalNode RELOP_GTE() { return getToken(ConditionsParser.RELOP_GTE, 0); }
		public TerminalNode RELOP_LT() { return getToken(ConditionsParser.RELOP_LT, 0); }
		public TerminalNode RELOP_LTE() { return getToken(ConditionsParser.RELOP_LTE, 0); }
		public ConditionRelopContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterConditionRelop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitConditionRelop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitConditionRelop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionFunctionContext extends ConditionContext {
		public Token function;
		public ExpressionContext arguments;
		public TerminalNode LPAREN() { return getToken(ConditionsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ConditionsParser.RPAREN, 0); }
		public TerminalNode CONDITION_VARIABLE() { return getToken(ConditionsParser.CONDITION_VARIABLE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ConditionsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ConditionsParser.COMMA, i);
		}
		public ConditionFunctionContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterConditionFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitConditionFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitConditionFunction(this);
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
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new ConditionParentheticalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(10);
				match(LPAREN);
				setState(11);
				condition(0);
				setState(12);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new ConditionNotOperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(14);
				match(OP_NOT);
				setState(15);
				((ConditionNotOperationContext)_localctx).value = condition(3);
				}
				break;
			case 3:
				{
				_localctx = new ConditionRelopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(16);
				((ConditionRelopContext)_localctx).left = expression(0);
				setState(17);
				((ConditionRelopContext)_localctx).relop = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RELOP_EQ) | (1L << RELOP_NEQ) | (1L << RELOP_GT) | (1L << RELOP_GTE) | (1L << RELOP_LT) | (1L << RELOP_LTE))) != 0)) ) {
					((ConditionRelopContext)_localctx).relop = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(18);
				((ConditionRelopContext)_localctx).right = expression(0);
				}
				break;
			case 4:
				{
				_localctx = new ConditionFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20);
				((ConditionFunctionContext)_localctx).function = match(CONDITION_VARIABLE);
				setState(21);
				match(LPAREN);
				setState(22);
				((ConditionFunctionContext)_localctx).arguments = expression(0);
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(23);
					match(COMMA);
					setState(24);
					expression(0);
					}
					}
					setState(29);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(30);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(39);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionOperationContext(new ConditionContext(_parentctx, _parentState));
					((ConditionOperationContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(34);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(35);
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
					setState(36);
					((ConditionOperationContext)_localctx).right = condition(5);
					}
					} 
				}
				setState(41);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntegerContext extends ExpressionContext {
		public Token value;
		public TerminalNode INTEGER() { return getToken(ConditionsParser.INTEGER, 0); }
		public IntegerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionContext extends ExpressionContext {
		public Token func;
		public ExpressionContext arguments;
		public TerminalNode LPAREN() { return getToken(ConditionsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ConditionsParser.RPAREN, 0); }
		public TerminalNode VARIABLE() { return getToken(ConditionsParser.VARIABLE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ConditionsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ConditionsParser.COMMA, i);
		}
		public FunctionContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class VariableContext extends ExpressionContext {
		public Token value;
		public TerminalNode VARIABLE() { return getToken(ConditionsParser.VARIABLE, 0); }
		public VariableContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class RationalContext extends ExpressionContext {
		public Token numerator;
		public Token denominator;
		public TerminalNode OP_DIV() { return getToken(ConditionsParser.OP_DIV, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(ConditionsParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(ConditionsParser.INTEGER, i);
		}
		public List<TerminalNode> OP_SUB() { return getTokens(ConditionsParser.OP_SUB); }
		public TerminalNode OP_SUB(int i) {
			return getToken(ConditionsParser.OP_SUB, i);
		}
		public RationalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterRational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitRational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitRational(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecimalContext extends ExpressionContext {
		public Token value;
		public TerminalNode DECIMALNUMBER() { return getToken(ConditionsParser.DECIMALNUMBER, 0); }
		public DecimalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentheticalContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(ConditionsParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ConditionsParser.RPAREN, 0); }
		public ParentheticalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterParenthetical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitParenthetical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitParenthetical(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OperationContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OP_POW() { return getToken(ConditionsParser.OP_POW, 0); }
		public TerminalNode OP_MUL() { return getToken(ConditionsParser.OP_MUL, 0); }
		public TerminalNode OP_DIV() { return getToken(ConditionsParser.OP_DIV, 0); }
		public TerminalNode OP_ADD() { return getToken(ConditionsParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(ConditionsParser.OP_SUB, 0); }
		public OperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OP_ADD() { return getToken(ConditionsParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(ConditionsParser.OP_SUB, 0); }
		public UnaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RuleVariableContext extends ExpressionContext {
		public Token value;
		public TerminalNode RULEVARIDENTIFIER() { return getToken(ConditionsParser.RULEVARIDENTIFIER, 0); }
		public TerminalNode VARIABLE() { return getToken(ConditionsParser.VARIABLE, 0); }
		public RuleVariableContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterRuleVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitRuleVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitRuleVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(43);
				((VariableContext)_localctx).value = match(VARIABLE);
				}
				break;
			case 2:
				{
				_localctx = new RuleVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				match(RULEVARIDENTIFIER);
				setState(45);
				((RuleVariableContext)_localctx).value = match(VARIABLE);
				}
				break;
			case 3:
				{
				_localctx = new RationalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_SUB) {
					{
					setState(46);
					match(OP_SUB);
					}
				}

				setState(49);
				((RationalContext)_localctx).numerator = match(INTEGER);
				setState(50);
				match(OP_DIV);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_SUB) {
					{
					setState(51);
					match(OP_SUB);
					}
				}

				setState(54);
				((RationalContext)_localctx).denominator = match(INTEGER);
				}
				break;
			case 4:
				{
				_localctx = new IntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(55);
				((IntegerContext)_localctx).value = match(INTEGER);
				}
				break;
			case 5:
				{
				_localctx = new DecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				((DecimalContext)_localctx).value = match(DECIMALNUMBER);
				}
				break;
			case 6:
				{
				_localctx = new ParentheticalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57);
				match(LPAREN);
				setState(58);
				expression(0);
				setState(59);
				match(RPAREN);
				}
				break;
			case 7:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OP_ADD || _la==OP_SUB) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(62);
				expression(5);
				}
				break;
			case 8:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				((FunctionContext)_localctx).func = match(VARIABLE);
				setState(64);
				match(LPAREN);
				setState(65);
				((FunctionContext)_localctx).arguments = expression(0);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(66);
					match(COMMA);
					setState(67);
					expression(0);
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(73);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(86);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new OperationContext(new ExpressionContext(_parentctx, _parentState));
						((OperationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(77);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(78);
						((OperationContext)_localctx).op = match(OP_POW);
						setState(79);
						((OperationContext)_localctx).right = expression(5);
						}
						break;
					case 2:
						{
						_localctx = new OperationContext(new ExpressionContext(_parentctx, _parentState));
						((OperationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(80);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(81);
						((OperationContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_MUL || _la==OP_DIV) ) {
							((OperationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(82);
						((OperationContext)_localctx).right = expression(4);
						}
						break;
					case 3:
						{
						_localctx = new OperationContext(new ExpressionContext(_parentctx, _parentState));
						((OperationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(83);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(84);
						((OperationContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OP_ADD || _la==OP_SUB) ) {
							((OperationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(85);
						((OperationContext)_localctx).right = expression(3);
						}
						break;
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33^\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\3\3\3\5\3#\n\3\3\3\3\3"+
		"\3\3\7\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\4\3\4\3\4\5\4\62\n\4\3\4\3\4\3"+
		"\4\5\4\67\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\7\4G\n\4\f\4\16\4J\13\4\3\4\3\4\5\4N\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\7\4Y\n\4\f\4\16\4\\\13\4\3\4\2\4\4\6\5\2\4\6\2\6\3\2\7\f\3\2"+
		"\r\16\3\2\23\24\3\2\21\22\2l\2\b\3\2\2\2\4\"\3\2\2\2\6M\3\2\2\2\b\t\5"+
		"\4\3\2\t\n\7\2\2\3\n\3\3\2\2\2\13\f\b\3\1\2\f\r\7\26\2\2\r\16\5\4\3\2"+
		"\16\17\7\27\2\2\17#\3\2\2\2\20\21\7\17\2\2\21#\5\4\3\5\22\23\5\6\4\2\23"+
		"\24\t\2\2\2\24\25\5\6\4\2\25#\3\2\2\2\26\27\7\3\2\2\27\30\7\26\2\2\30"+
		"\35\5\6\4\2\31\32\7\25\2\2\32\34\5\6\4\2\33\31\3\2\2\2\34\37\3\2\2\2\35"+
		"\33\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\7\27\2\2!#\3\2\2"+
		"\2\"\13\3\2\2\2\"\20\3\2\2\2\"\22\3\2\2\2\"\26\3\2\2\2#)\3\2\2\2$%\f\6"+
		"\2\2%&\t\3\2\2&(\5\4\3\7\'$\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5"+
		"\3\2\2\2+)\3\2\2\2,-\b\4\1\2-N\7\4\2\2./\7\31\2\2/N\7\4\2\2\60\62\7\24"+
		"\2\2\61\60\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\7\5\2\2\64\66\7\22"+
		"\2\2\65\67\7\24\2\2\66\65\3\2\2\2\66\67\3\2\2\2\678\3\2\2\28N\7\5\2\2"+
		"9N\7\5\2\2:N\7\6\2\2;<\7\26\2\2<=\5\6\4\2=>\7\27\2\2>N\3\2\2\2?@\t\4\2"+
		"\2@N\5\6\4\7AB\7\4\2\2BC\7\26\2\2CH\5\6\4\2DE\7\25\2\2EG\5\6\4\2FD\3\2"+
		"\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\7\27\2\2LN\3"+
		"\2\2\2M,\3\2\2\2M.\3\2\2\2M\61\3\2\2\2M9\3\2\2\2M:\3\2\2\2M;\3\2\2\2M"+
		"?\3\2\2\2MA\3\2\2\2NZ\3\2\2\2OP\f\6\2\2PQ\7\20\2\2QY\5\6\4\7RS\f\5\2\2"+
		"ST\t\5\2\2TY\5\6\4\6UV\f\4\2\2VW\t\4\2\2WY\5\6\4\5XO\3\2\2\2XR\3\2\2\2"+
		"XU\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\7\3\2\2\2\\Z\3\2\2\2\13\35"+
		"\")\61\66HMXZ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}