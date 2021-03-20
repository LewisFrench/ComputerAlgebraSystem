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
		T__0=1, T__1=2, RELOP_GT=3, RELOP_LT=4, RELOP_EQ=5, RELOP_NEQ=6, RELOP_GTE=7, 
		RELOP_LTE=8, OP_AND=9, OP_OR=10, OP_NOT=11, OP_ADD=12, OP_SUB=13, OP_MUL=14, 
		OP_DIV=15, VARIABLE=16, SCIENTIFIC_NUMBER=17, LPAREN=18, RPAREN=19, POINT=20, 
		POW=21, WS=22;
	public static final int
		RULE_ruleConditions = 0, RULE_condition = 1, RULE_condExpr = 2, RULE_compileUnit = 3, 
		RULE_expression = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"ruleConditions", "condition", "condExpr", "compileUnit", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'$'", "'>'", "'<'", "'=='", "'!='", "'>='", "'<='", "'&'", 
			"'|'", "'!'", "'+'", "'-'", "'*'", "'/'", null, null, "'('", "')'", "'.'", 
			"'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "RELOP_GT", "RELOP_LT", "RELOP_EQ", "RELOP_NEQ", "RELOP_GTE", 
			"RELOP_LTE", "OP_AND", "OP_OR", "OP_NOT", "OP_ADD", "OP_SUB", "OP_MUL", 
			"OP_DIV", "VARIABLE", "SCIENTIFIC_NUMBER", "LPAREN", "RPAREN", "POINT", 
			"POW", "WS"
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
			setState(10);
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
		public CondExprContext arguments;
		public TerminalNode LPAREN() { return getToken(ConditionsParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ConditionsParser.RPAREN, 0); }
		public TerminalNode VARIABLE() { return getToken(ConditionsParser.VARIABLE, 0); }
		public List<CondExprContext> condExpr() {
			return getRuleContexts(CondExprContext.class);
		}
		public CondExprContext condExpr(int i) {
			return getRuleContext(CondExprContext.class,i);
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
		public CondExprContext left;
		public Token relop;
		public CondExprContext right;
		public List<CondExprContext> condExpr() {
			return getRuleContexts(CondExprContext.class);
		}
		public CondExprContext condExpr(int i) {
			return getRuleContext(CondExprContext.class,i);
		}
		public TerminalNode RELOP_EQ() { return getToken(ConditionsParser.RELOP_EQ, 0); }
		public TerminalNode RELOP_NEQ() { return getToken(ConditionsParser.RELOP_NEQ, 0); }
		public TerminalNode RELOP_GT() { return getToken(ConditionsParser.RELOP_GT, 0); }
		public TerminalNode RELOP_GTE() { return getToken(ConditionsParser.RELOP_GTE, 0); }
		public TerminalNode RELOP_LT() { return getToken(ConditionsParser.RELOP_LT, 0); }
		public TerminalNode RELOP_LTE() { return getToken(ConditionsParser.RELOP_LTE, 0); }
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
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new ConditionParentheticalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(13);
				match(LPAREN);
				setState(14);
				condition(0);
				setState(15);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(17);
				match(OP_NOT);
				setState(18);
				match(LPAREN);
				setState(19);
				((NotContext)_localctx).value = condition(0);
				setState(20);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new RelopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				((RelopContext)_localctx).left = condExpr();
				setState(23);
				((RelopContext)_localctx).relop = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RELOP_GT) | (1L << RELOP_LT) | (1L << RELOP_EQ) | (1L << RELOP_NEQ) | (1L << RELOP_GTE) | (1L << RELOP_LTE))) != 0)) ) {
					((RelopContext)_localctx).relop = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(24);
				((RelopContext)_localctx).right = condExpr();
				}
				break;
			case 4:
				{
				_localctx = new FunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				((FunctionContext)_localctx).function = match(VARIABLE);
				setState(27);
				match(LPAREN);
				setState(28);
				((FunctionContext)_localctx).arguments = condExpr();
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(29);
					match(T__0);
					setState(30);
					condExpr();
					}
					}
					setState(35);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(36);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(45);
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
					setState(40);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(41);
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
					setState(42);
					((ConditionOperationContext)_localctx).right = condition(6);
					}
					} 
				}
				setState(47);
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

	public static class CondExprContext extends ParserRuleContext {
		public CondExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condExpr; }
	 
		public CondExprContext() { }
		public void copyFrom(CondExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprContext extends CondExprContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprContext(CondExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondExprContext condExpr() throws RecognitionException {
		CondExprContext _localctx = new CondExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_condExpr);
		try {
			_localctx = new ExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			expression(0);
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

	public static class CompileUnitContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompileUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterCompileUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitCompileUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitCompileUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompileUnitContext compileUnit() throws RecognitionException {
		CompileUnitContext _localctx = new CompileUnitContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_compileUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			expression(0);
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
	public static class FunctionExpressionContext extends ExpressionContext {
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
		public FunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitFunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarContext extends ExpressionContext {
		public Token value;
		public TerminalNode VARIABLE() { return getToken(ConditionsParser.VARIABLE, 0); }
		public VarContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumContext extends ExpressionContext {
		public Token value;
		public TerminalNode SCIENTIFIC_NUMBER() { return getToken(ConditionsParser.SCIENTIFIC_NUMBER, 0); }
		public NumContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitNum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OP_ADD() { return getToken(ConditionsParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(ConditionsParser.OP_SUB, 0); }
		public UnaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConditionsListener ) ((ConditionsListener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConditionsVisitor ) return ((ConditionsVisitor<? extends T>)visitor).visitUnaryExpression(this);
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
	public static class RuleVariableContext extends ExpressionContext {
		public Token value;
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(53);
				((FunctionExpressionContext)_localctx).func = match(VARIABLE);
				setState(54);
				match(LPAREN);
				setState(55);
				((FunctionExpressionContext)_localctx).arguments = expression(0);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(56);
					match(T__0);
					setState(57);
					expression(0);
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(63);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				((UnaryExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==OP_ADD || _la==OP_SUB) ) {
					((UnaryExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(66);
				expression(7);
				}
				break;
			case 3:
				{
				_localctx = new ParentheticalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				match(LPAREN);
				setState(68);
				expression(0);
				setState(69);
				match(RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				((VarContext)_localctx).value = match(VARIABLE);
				}
				break;
			case 5:
				{
				_localctx = new RuleVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				match(T__1);
				setState(73);
				((RuleVariableContext)_localctx).value = match(VARIABLE);
				}
				break;
			case 6:
				{
				_localctx = new NumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				((NumContext)_localctx).value = match(SCIENTIFIC_NUMBER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(83);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new OperationContext(new ExpressionContext(_parentctx, _parentState));
						((OperationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(77);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(78);
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
						setState(79);
						((OperationContext)_localctx).right = expression(6);
						}
						break;
					case 2:
						{
						_localctx = new OperationContext(new ExpressionContext(_parentctx, _parentState));
						((OperationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(80);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(81);
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
						setState(82);
						((OperationContext)_localctx).right = expression(5);
						}
						break;
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
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
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30[\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3%\13\3\3\3"+
		"\3\3\5\3)\n\3\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\7\6=\n\6\f\6\16\6@\13\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6N\n\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6V\n\6\f\6"+
		"\16\6Y\13\6\3\6\2\4\4\n\7\2\4\6\b\n\2\6\3\2\5\n\3\2\13\f\3\2\16\17\3\2"+
		"\20\21\2b\2\f\3\2\2\2\4(\3\2\2\2\6\62\3\2\2\2\b\64\3\2\2\2\nM\3\2\2\2"+
		"\f\r\5\4\3\2\r\3\3\2\2\2\16\17\b\3\1\2\17\20\7\24\2\2\20\21\5\4\3\2\21"+
		"\22\7\25\2\2\22)\3\2\2\2\23\24\7\r\2\2\24\25\7\24\2\2\25\26\5\4\3\2\26"+
		"\27\7\25\2\2\27)\3\2\2\2\30\31\5\6\4\2\31\32\t\2\2\2\32\33\5\6\4\2\33"+
		")\3\2\2\2\34\35\7\22\2\2\35\36\7\24\2\2\36#\5\6\4\2\37 \7\3\2\2 \"\5\6"+
		"\4\2!\37\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'"+
		"\7\25\2\2\')\3\2\2\2(\16\3\2\2\2(\23\3\2\2\2(\30\3\2\2\2(\34\3\2\2\2)"+
		"/\3\2\2\2*+\f\7\2\2+,\t\3\2\2,.\5\4\3\b-*\3\2\2\2.\61\3\2\2\2/-\3\2\2"+
		"\2/\60\3\2\2\2\60\5\3\2\2\2\61/\3\2\2\2\62\63\5\n\6\2\63\7\3\2\2\2\64"+
		"\65\5\n\6\2\65\t\3\2\2\2\66\67\b\6\1\2\678\7\22\2\289\7\24\2\29>\5\n\6"+
		"\2:;\7\3\2\2;=\5\n\6\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2"+
		"\2@>\3\2\2\2AB\7\25\2\2BN\3\2\2\2CD\t\4\2\2DN\5\n\6\tEF\7\24\2\2FG\5\n"+
		"\6\2GH\7\25\2\2HN\3\2\2\2IN\7\22\2\2JK\7\4\2\2KN\7\22\2\2LN\7\23\2\2M"+
		"\66\3\2\2\2MC\3\2\2\2ME\3\2\2\2MI\3\2\2\2MJ\3\2\2\2ML\3\2\2\2NW\3\2\2"+
		"\2OP\f\7\2\2PQ\t\5\2\2QV\5\n\6\bRS\f\6\2\2ST\t\4\2\2TV\5\n\6\7UO\3\2\2"+
		"\2UR\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\13\3\2\2\2YW\3\2\2\2\t#(/"+
		">MUW";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}