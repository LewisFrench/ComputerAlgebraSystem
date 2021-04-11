// Generated from RuleAlgebra.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RuleAlgebraParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OP_ADD=1, OP_SUB=2, OP_MUL=3, OP_DIV=4, OP_POW=5, VARIABLE=6, INTEGER=7, 
		DECIMALNUMBER=8, COMMA=9, LPAREN=10, VARIDENTIFIER=11, RPAREN=12, POINT=13, 
		WS=14;
	public static final int
		RULE_ruleTerm = 0, RULE_expression = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"ruleTerm", "expression"
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

	@Override
	public String getGrammarFileName() { return "RuleAlgebra.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RuleAlgebraParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RuleTermContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RuleAlgebraParser.EOF, 0); }
		public RuleTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).enterRuleTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).exitRuleTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleAlgebraVisitor ) return ((RuleAlgebraVisitor<? extends T>)visitor).visitRuleTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleTermContext ruleTerm() throws RecognitionException {
		RuleTermContext _localctx = new RuleTermContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ruleTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			expression(0);
			setState(5);
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
		public TerminalNode INTEGER() { return getToken(RuleAlgebraParser.INTEGER, 0); }
		public IntegerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleAlgebraVisitor ) return ((RuleAlgebraVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends ExpressionContext {
		public Token value;
		public TerminalNode VARIABLE() { return getToken(RuleAlgebraParser.VARIABLE, 0); }
		public VariableContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleAlgebraVisitor ) return ((RuleAlgebraVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionExpressionContext extends ExpressionContext {
		public Token func;
		public ExpressionContext arguments;
		public TerminalNode LPAREN() { return getToken(RuleAlgebraParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(RuleAlgebraParser.RPAREN, 0); }
		public TerminalNode VARIABLE() { return getToken(RuleAlgebraParser.VARIABLE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(RuleAlgebraParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(RuleAlgebraParser.COMMA, i);
		}
		public FunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).enterFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).exitFunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleAlgebraVisitor ) return ((RuleAlgebraVisitor<? extends T>)visitor).visitFunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecimalContext extends ExpressionContext {
		public Token value;
		public TerminalNode DECIMALNUMBER() { return getToken(RuleAlgebraParser.DECIMALNUMBER, 0); }
		public DecimalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).enterDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).exitDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleAlgebraVisitor ) return ((RuleAlgebraVisitor<? extends T>)visitor).visitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParentheticalContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(RuleAlgebraParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(RuleAlgebraParser.RPAREN, 0); }
		public ParentheticalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).enterParenthetical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).exitParenthetical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleAlgebraVisitor ) return ((RuleAlgebraVisitor<? extends T>)visitor).visitParenthetical(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OP_ADD() { return getToken(RuleAlgebraParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(RuleAlgebraParser.OP_SUB, 0); }
		public UnaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleAlgebraVisitor ) return ((RuleAlgebraVisitor<? extends T>)visitor).visitUnaryExpression(this);
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
		public TerminalNode OP_POW() { return getToken(RuleAlgebraParser.OP_POW, 0); }
		public TerminalNode OP_MUL() { return getToken(RuleAlgebraParser.OP_MUL, 0); }
		public TerminalNode OP_DIV() { return getToken(RuleAlgebraParser.OP_DIV, 0); }
		public TerminalNode OP_ADD() { return getToken(RuleAlgebraParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(RuleAlgebraParser.OP_SUB, 0); }
		public OperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleAlgebraVisitor ) return ((RuleAlgebraVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RuleVariableContext extends ExpressionContext {
		public Token value;
		public TerminalNode VARIDENTIFIER() { return getToken(RuleAlgebraParser.VARIDENTIFIER, 0); }
		public TerminalNode VARIABLE() { return getToken(RuleAlgebraParser.VARIABLE, 0); }
		public RuleVariableContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).enterRuleVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleAlgebraListener ) ((RuleAlgebraListener)listener).exitRuleVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleAlgebraVisitor ) return ((RuleAlgebraVisitor<? extends T>)visitor).visitRuleVariable(this);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(8);
				((VariableContext)_localctx).value = match(VARIABLE);
				}
				break;
			case 2:
				{
				_localctx = new RuleVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(9);
				match(VARIDENTIFIER);
				setState(10);
				((RuleVariableContext)_localctx).value = match(VARIABLE);
				}
				break;
			case 3:
				{
				_localctx = new DecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(11);
				((DecimalContext)_localctx).value = match(DECIMALNUMBER);
				}
				break;
			case 4:
				{
				_localctx = new IntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(12);
				((IntegerContext)_localctx).value = match(INTEGER);
				}
				break;
			case 5:
				{
				_localctx = new ParentheticalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(13);
				match(LPAREN);
				setState(14);
				expression(0);
				setState(15);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new FunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(17);
				((FunctionExpressionContext)_localctx).func = match(VARIABLE);
				setState(18);
				match(LPAREN);
				setState(19);
				((FunctionExpressionContext)_localctx).arguments = expression(0);
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(20);
					match(COMMA);
					setState(21);
					expression(0);
					}
					}
					setState(26);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(27);
				match(RPAREN);
				}
				break;
			case 7:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
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
				setState(30);
				expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(42);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new OperationContext(new ExpressionContext(_parentctx, _parentState));
						((OperationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(33);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(34);
						((OperationContext)_localctx).op = match(OP_POW);
						setState(35);
						((OperationContext)_localctx).right = expression(6);
						}
						break;
					case 2:
						{
						_localctx = new OperationContext(new ExpressionContext(_parentctx, _parentState));
						((OperationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(36);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(37);
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
						setState(38);
						((OperationContext)_localctx).right = expression(5);
						}
						break;
					case 3:
						{
						_localctx = new OperationContext(new ExpressionContext(_parentctx, _parentState));
						((OperationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(39);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(40);
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
						setState(41);
						((OperationContext)_localctx).right = expression(4);
						}
						break;
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20\62\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\2\3\4\4\2\4\2"+
		"\4\3\2\3\4\3\2\5\6\29\2\6\3\2\2\2\4!\3\2\2\2\6\7\5\4\3\2\7\b\7\2\2\3\b"+
		"\3\3\2\2\2\t\n\b\3\1\2\n\"\7\b\2\2\13\f\7\r\2\2\f\"\7\b\2\2\r\"\7\n\2"+
		"\2\16\"\7\t\2\2\17\20\7\f\2\2\20\21\5\4\3\2\21\22\7\16\2\2\22\"\3\2\2"+
		"\2\23\24\7\b\2\2\24\25\7\f\2\2\25\32\5\4\3\2\26\27\7\13\2\2\27\31\5\4"+
		"\3\2\30\26\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\35\3\2"+
		"\2\2\34\32\3\2\2\2\35\36\7\16\2\2\36\"\3\2\2\2\37 \t\2\2\2 \"\5\4\3\3"+
		"!\t\3\2\2\2!\13\3\2\2\2!\r\3\2\2\2!\16\3\2\2\2!\17\3\2\2\2!\23\3\2\2\2"+
		"!\37\3\2\2\2\".\3\2\2\2#$\f\7\2\2$%\7\7\2\2%-\5\4\3\b&\'\f\6\2\2\'(\t"+
		"\3\2\2(-\5\4\3\7)*\f\5\2\2*+\t\2\2\2+-\5\4\3\6,#\3\2\2\2,&\3\2\2\2,)\3"+
		"\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\5\3\2\2\2\60.\3\2\2\2\6\32!,.";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}