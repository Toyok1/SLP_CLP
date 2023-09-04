// Generated from C:/Users/Simone/Desktop/UNIVERSIT/COMPILATORI/PROGETTO/CLP/CLP_progetto-main_MIO/src\SimpLanPlus.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpLanPlusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, INTEGER=27, ID=28, WS=29, LINECOMENTS=30, BLOCKCOMENTS=31;
	public static final int
		RULE_prog = 0, RULE_dec = 1, RULE_param = 2, RULE_body = 3, RULE_type = 4, 
		RULE_stm = 5, RULE_thenStmBranch = 6, RULE_elseStmBranch = 7, RULE_exp = 8, 
		RULE_thenExpBranch = 9, RULE_elseExpBranch = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dec", "param", "body", "type", "stm", "thenStmBranch", "elseStmBranch", 
			"exp", "thenExpBranch", "elseExpBranch"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "','", "')'", "'{'", "'}'", "'int'", "'bool'", "'void'", 
			"'='", "'if'", "'else'", "'true'", "'false'", "'!'", "'*'", "'/'", "'+'", 
			"'-'", "'>'", "'<'", "'>='", "'<='", "'=='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INTEGER", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS"
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
	public String getGrammarFileName() { return "SimpLanPlus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpLanPlusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultExpContext extends ProgContext {
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public MultExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterMultExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitMultExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitMultExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleExpContext extends ProgContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public SingleExpContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterSingleExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitSingleExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitSingleExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			int _alt;
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__10:
			case T__12:
			case T__13:
			case T__14:
			case INTEGER:
			case ID:
				_localctx = new SingleExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				exp(0);
				}
				break;
			case T__6:
			case T__7:
			case T__8:
				_localctx = new MultExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(24); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(23);
					dec();
					}
					}
					setState(26); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0) );
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(28);
						stm();
						}
						} 
					}
					setState(33);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 402712580L) != 0)) {
					{
					setState(34);
					exp(0);
					}
				}

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

	@SuppressWarnings("CheckReturnValue")
	public static class DecContext extends ParserRuleContext {
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
	 
		public DecContext() { }
		public void copyFrom(DecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunDecContext extends DecContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public FunDecContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterFunDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitFunDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitFunDec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDecContext extends DecContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public VarDecContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterVarDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitVarDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitVarDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dec);
		int _la;
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new VarDecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				type();
				setState(40);
				match(ID);
				setState(41);
				match(T__0);
				}
				break;
			case 2:
				_localctx = new FunDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				type();
				setState(44);
				match(ID);
				setState(45);
				match(T__1);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) {
					{
					setState(46);
					param();
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(47);
						match(T__2);
						setState(48);
						param();
						}
						}
						setState(53);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(56);
				match(T__3);
				setState(57);
				match(T__4);
				setState(58);
				body();
				setState(59);
				match(T__5);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			type();
			setState(64);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_body);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) {
				{
				{
				setState(66);
				dec();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(72);
					stm();
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 402712580L) != 0)) {
				{
				setState(78);
				exp(0);
				}
			}

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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class StmContext extends ParserRuleContext {
		public StmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm; }
	 
		public StmContext() { }
		public void copyFrom(StmContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStmContext extends StmContext {
		public ExpContext condition;
		public ThenStmBranchContext thenB;
		public ElseStmBranchContext elseB;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ThenStmBranchContext thenStmBranch() {
			return getRuleContext(ThenStmBranchContext.class,0);
		}
		public ElseStmBranchContext elseStmBranch() {
			return getRuleContext(ElseStmBranchContext.class,0);
		}
		public IfStmContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterIfStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitIfStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitIfStm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunCallStmContext extends StmContext {
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FunCallStmContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterFunCallStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitFunCallStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitFunCallStm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsgStmContext extends StmContext {
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AsgStmContext(StmContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterAsgStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitAsgStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitAsgStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmContext stm() throws RecognitionException {
		StmContext _localctx = new StmContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stm);
		int _la;
		try {
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new AsgStmContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(ID);
				setState(84);
				match(T__9);
				setState(85);
				exp(0);
				setState(86);
				match(T__0);
				}
				break;
			case 2:
				_localctx = new FunCallStmContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(ID);
				setState(89);
				match(T__1);
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 402712580L) != 0)) {
					{
					setState(90);
					exp(0);
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(91);
						match(T__2);
						setState(92);
						exp(0);
						}
						}
						setState(97);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(100);
				match(T__3);
				setState(101);
				match(T__0);
				}
				break;
			case 3:
				_localctx = new IfStmContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				match(T__10);
				setState(103);
				match(T__1);
				setState(104);
				((IfStmContext)_localctx).condition = exp(0);
				setState(105);
				match(T__3);
				setState(106);
				match(T__4);
				setState(107);
				((IfStmContext)_localctx).thenB = thenStmBranch();
				setState(108);
				match(T__5);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(109);
					match(T__11);
					setState(110);
					match(T__4);
					setState(111);
					((IfStmContext)_localctx).elseB = elseStmBranch();
					setState(112);
					match(T__5);
					}
				}

				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ThenStmBranchContext extends ParserRuleContext {
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public ThenStmBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thenStmBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterThenStmBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitThenStmBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitThenStmBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThenStmBranchContext thenStmBranch() throws RecognitionException {
		ThenStmBranchContext _localctx = new ThenStmBranchContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_thenStmBranch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) {
				{
				{
				setState(118);
				dec();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				stm();
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__10 || _la==ID );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElseStmBranchContext extends ParserRuleContext {
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public ElseStmBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterElseStmBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitElseStmBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitElseStmBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStmBranchContext elseStmBranch() throws RecognitionException {
		ElseStmBranchContext _localctx = new ElseStmBranchContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elseStmBranch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) {
				{
				{
				setState(129);
				dec();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				stm();
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__10 || _la==ID );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusMinusExpContext extends ExpContext {
		public ExpContext e1;
		public Token op;
		public ExpContext e2;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public PlusMinusExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterPlusMinusExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitPlusMinusExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitPlusMinusExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueExpContext extends ExpContext {
		public TrueExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterTrueExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitTrueExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitTrueExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExpContext extends ExpContext {
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public IdExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterIdExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitIdExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitIdExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotIdExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NotIdExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterNotIdExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitNotIdExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitNotIdExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivExpContext extends ExpContext {
		public ExpContext e1;
		public Token op;
		public ExpContext e2;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public MulDivExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterMulDivExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitMulDivExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitMulDivExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunCallExpContext extends ExpContext {
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FunCallExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterFunCallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitFunCallExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitFunCallExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfExpContext extends ExpContext {
		public ExpContext condition;
		public ThenExpBranchContext thenB;
		public ElseExpBranchContext elseB;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ThenExpBranchContext thenExpBranch() {
			return getRuleContext(ThenExpBranchContext.class,0);
		}
		public ElseExpBranchContext elseExpBranch() {
			return getRuleContext(ElseExpBranchContext.class,0);
		}
		public IfExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterIfExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitIfExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitIfExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public BracketExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterBracketExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitBracketExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitBracketExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseExpContext extends ExpContext {
		public FalseExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterFalseExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitFalseExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitFalseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CfrExpContext extends ExpContext {
		public ExpContext e1;
		public Token op;
		public ExpContext e2;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public CfrExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterCfrExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitCfrExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitCfrExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExpContext extends ExpContext {
		public ExpContext e1;
		public Token op;
		public ExpContext e2;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public LogicalExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterLogicalExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitLogicalExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitLogicalExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntExpContext extends ExpContext {
		public TerminalNode INTEGER() { return getToken(SimpLanPlusParser.INTEGER, 0); }
		public IntExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterIntExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitIntExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitIntExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				_localctx = new IntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(141);
				match(INTEGER);
				}
				break;
			case 2:
				{
				_localctx = new TrueExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(T__12);
				}
				break;
			case 3:
				{
				_localctx = new FalseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(T__13);
				}
				break;
			case 4:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new NotIdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(T__14);
				setState(146);
				exp(8);
				}
				break;
			case 6:
				{
				_localctx = new IfExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(T__10);
				setState(148);
				match(T__1);
				setState(149);
				((IfExpContext)_localctx).condition = exp(0);
				setState(150);
				match(T__3);
				setState(151);
				match(T__4);
				setState(152);
				((IfExpContext)_localctx).thenB = thenExpBranch();
				setState(153);
				match(T__5);
				setState(154);
				match(T__11);
				setState(155);
				match(T__4);
				setState(156);
				((IfExpContext)_localctx).elseB = elseExpBranch();
				setState(157);
				match(T__5);
				}
				break;
			case 7:
				{
				_localctx = new BracketExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(T__1);
				setState(160);
				exp(0);
				setState(161);
				match(T__3);
				}
				break;
			case 8:
				{
				_localctx = new FunCallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(ID);
				setState(164);
				match(T__1);
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 402712580L) != 0)) {
					{
					setState(165);
					exp(0);
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(166);
						match(T__2);
						setState(167);
						exp(0);
						}
						}
						setState(172);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(175);
				match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(205);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExpContext(new ExpContext(_parentctx, _parentState));
						((MulDivExpContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(178);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(181);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__15:
							{
							setState(179);
							((MulDivExpContext)_localctx).op = match(T__15);
							}
							break;
						case T__16:
							{
							setState(180);
							((MulDivExpContext)_localctx).op = match(T__16);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(183);
						((MulDivExpContext)_localctx).e2 = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new PlusMinusExpContext(new ExpContext(_parentctx, _parentState));
						((PlusMinusExpContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(184);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(187);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__17:
							{
							setState(185);
							((PlusMinusExpContext)_localctx).op = match(T__17);
							}
							break;
						case T__18:
							{
							setState(186);
							((PlusMinusExpContext)_localctx).op = match(T__18);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(189);
						((PlusMinusExpContext)_localctx).e2 = exp(7);
						}
						break;
					case 3:
						{
						_localctx = new CfrExpContext(new ExpContext(_parentctx, _parentState));
						((CfrExpContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(190);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(196);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__19:
							{
							setState(191);
							((CfrExpContext)_localctx).op = match(T__19);
							}
							break;
						case T__20:
							{
							setState(192);
							((CfrExpContext)_localctx).op = match(T__20);
							}
							break;
						case T__21:
							{
							setState(193);
							((CfrExpContext)_localctx).op = match(T__21);
							}
							break;
						case T__22:
							{
							setState(194);
							((CfrExpContext)_localctx).op = match(T__22);
							}
							break;
						case T__23:
							{
							setState(195);
							((CfrExpContext)_localctx).op = match(T__23);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(198);
						((CfrExpContext)_localctx).e2 = exp(6);
						}
						break;
					case 4:
						{
						_localctx = new LogicalExpContext(new ExpContext(_parentctx, _parentState));
						((LogicalExpContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(199);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(202);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__24:
							{
							setState(200);
							((LogicalExpContext)_localctx).op = match(T__24);
							}
							break;
						case T__25:
							{
							setState(201);
							((LogicalExpContext)_localctx).op = match(T__25);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(204);
						((LogicalExpContext)_localctx).e2 = exp(5);
						}
						break;
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ThenExpBranchContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public ThenExpBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thenExpBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterThenExpBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitThenExpBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitThenExpBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThenExpBranchContext thenExpBranch() throws RecognitionException {
		ThenExpBranchContext _localctx = new ThenExpBranchContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_thenExpBranch);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) {
				{
				{
				setState(210);
				dec();
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(216);
					stm();
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(222);
			exp(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElseExpBranchContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public ElseExpBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseExpBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterElseExpBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitElseExpBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitElseExpBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseExpBranchContext elseExpBranch() throws RecognitionException {
		ElseExpBranchContext _localctx = new ElseExpBranchContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elseExpBranch);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) {
				{
				{
				setState(224);
				dec();
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(230);
					stm();
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(236);
			exp(0);
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
		case 8:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00ef\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000"+
		"\u0004\u0000\u0019\b\u0000\u000b\u0000\f\u0000\u001a\u0001\u0000\u0005"+
		"\u0000\u001e\b\u0000\n\u0000\f\u0000!\t\u0000\u0001\u0000\u0003\u0000"+
		"$\b\u0000\u0003\u0000&\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u00012\b\u0001\n\u0001\f\u00015\t\u0001\u0003\u00017\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		">\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0005\u0003"+
		"D\b\u0003\n\u0003\f\u0003G\t\u0003\u0001\u0003\u0005\u0003J\b\u0003\n"+
		"\u0003\f\u0003M\t\u0003\u0001\u0003\u0003\u0003P\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005^\b"+
		"\u0005\n\u0005\f\u0005a\t\u0005\u0003\u0005c\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005s\b\u0005\u0003\u0005u\b\u0005\u0001\u0006\u0005\u0006"+
		"x\b\u0006\n\u0006\f\u0006{\t\u0006\u0001\u0006\u0004\u0006~\b\u0006\u000b"+
		"\u0006\f\u0006\u007f\u0001\u0007\u0005\u0007\u0083\b\u0007\n\u0007\f\u0007"+
		"\u0086\t\u0007\u0001\u0007\u0004\u0007\u0089\b\u0007\u000b\u0007\f\u0007"+
		"\u008a\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0005\b\u00a9\b\b\n\b\f\b\u00ac\t\b\u0003\b\u00ae\b"+
		"\b\u0001\b\u0003\b\u00b1\b\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b6\b\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00bc\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00c5\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00cb\b\b\u0001\b\u0005\b\u00ce\b\b\n\b\f\b\u00d1\t"+
		"\b\u0001\t\u0005\t\u00d4\b\t\n\t\f\t\u00d7\t\t\u0001\t\u0005\t\u00da\b"+
		"\t\n\t\f\t\u00dd\t\t\u0001\t\u0001\t\u0001\n\u0005\n\u00e2\b\n\n\n\f\n"+
		"\u00e5\t\n\u0001\n\u0005\n\u00e8\b\n\n\n\f\n\u00eb\t\n\u0001\n\u0001\n"+
		"\u0001\n\u0000\u0001\u0010\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0000\u0001\u0001\u0000\u0007\t\u010e\u0000%\u0001\u0000"+
		"\u0000\u0000\u0002=\u0001\u0000\u0000\u0000\u0004?\u0001\u0000\u0000\u0000"+
		"\u0006E\u0001\u0000\u0000\u0000\bQ\u0001\u0000\u0000\u0000\nt\u0001\u0000"+
		"\u0000\u0000\fy\u0001\u0000\u0000\u0000\u000e\u0084\u0001\u0000\u0000"+
		"\u0000\u0010\u00b0\u0001\u0000\u0000\u0000\u0012\u00d5\u0001\u0000\u0000"+
		"\u0000\u0014\u00e3\u0001\u0000\u0000\u0000\u0016&\u0003\u0010\b\u0000"+
		"\u0017\u0019\u0003\u0002\u0001\u0000\u0018\u0017\u0001\u0000\u0000\u0000"+
		"\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000"+
		"\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u001f\u0001\u0000\u0000\u0000"+
		"\u001c\u001e\u0003\n\u0005\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e"+
		"!\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000"+
		"\u0000\"$\u0003\u0010\b\u0000#\"\u0001\u0000\u0000\u0000#$\u0001\u0000"+
		"\u0000\u0000$&\u0001\u0000\u0000\u0000%\u0016\u0001\u0000\u0000\u0000"+
		"%\u0018\u0001\u0000\u0000\u0000&\u0001\u0001\u0000\u0000\u0000\'(\u0003"+
		"\b\u0004\u0000()\u0005\u001c\u0000\u0000)*\u0005\u0001\u0000\u0000*>\u0001"+
		"\u0000\u0000\u0000+,\u0003\b\u0004\u0000,-\u0005\u001c\u0000\u0000-6\u0005"+
		"\u0002\u0000\u0000.3\u0003\u0004\u0002\u0000/0\u0005\u0003\u0000\u0000"+
		"02\u0003\u0004\u0002\u00001/\u0001\u0000\u0000\u000025\u0001\u0000\u0000"+
		"\u000031\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000047\u0001\u0000"+
		"\u0000\u000053\u0001\u0000\u0000\u00006.\u0001\u0000\u0000\u000067\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u000089\u0005\u0004\u0000\u0000"+
		"9:\u0005\u0005\u0000\u0000:;\u0003\u0006\u0003\u0000;<\u0005\u0006\u0000"+
		"\u0000<>\u0001\u0000\u0000\u0000=\'\u0001\u0000\u0000\u0000=+\u0001\u0000"+
		"\u0000\u0000>\u0003\u0001\u0000\u0000\u0000?@\u0003\b\u0004\u0000@A\u0005"+
		"\u001c\u0000\u0000A\u0005\u0001\u0000\u0000\u0000BD\u0003\u0002\u0001"+
		"\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000"+
		"\u0000\u0000EF\u0001\u0000\u0000\u0000FK\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000HJ\u0003\n\u0005\u0000IH\u0001\u0000\u0000\u0000JM\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000"+
		"LO\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NP\u0003\u0010\b\u0000"+
		"ON\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\u0007\u0001\u0000"+
		"\u0000\u0000QR\u0007\u0000\u0000\u0000R\t\u0001\u0000\u0000\u0000ST\u0005"+
		"\u001c\u0000\u0000TU\u0005\n\u0000\u0000UV\u0003\u0010\b\u0000VW\u0005"+
		"\u0001\u0000\u0000Wu\u0001\u0000\u0000\u0000XY\u0005\u001c\u0000\u0000"+
		"Yb\u0005\u0002\u0000\u0000Z_\u0003\u0010\b\u0000[\\\u0005\u0003\u0000"+
		"\u0000\\^\u0003\u0010\b\u0000][\u0001\u0000\u0000\u0000^a\u0001\u0000"+
		"\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`c\u0001"+
		"\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bZ\u0001\u0000\u0000\u0000"+
		"bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0005\u0004\u0000"+
		"\u0000eu\u0005\u0001\u0000\u0000fg\u0005\u000b\u0000\u0000gh\u0005\u0002"+
		"\u0000\u0000hi\u0003\u0010\b\u0000ij\u0005\u0004\u0000\u0000jk\u0005\u0005"+
		"\u0000\u0000kl\u0003\f\u0006\u0000lr\u0005\u0006\u0000\u0000mn\u0005\f"+
		"\u0000\u0000no\u0005\u0005\u0000\u0000op\u0003\u000e\u0007\u0000pq\u0005"+
		"\u0006\u0000\u0000qs\u0001\u0000\u0000\u0000rm\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000su\u0001\u0000\u0000\u0000tS\u0001\u0000\u0000"+
		"\u0000tX\u0001\u0000\u0000\u0000tf\u0001\u0000\u0000\u0000u\u000b\u0001"+
		"\u0000\u0000\u0000vx\u0003\u0002\u0001\u0000wv\u0001\u0000\u0000\u0000"+
		"x{\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000"+
		"\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000|~\u0003\n\u0005"+
		"\u0000}|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f"+
		"}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\r"+
		"\u0001\u0000\u0000\u0000\u0081\u0083\u0003\u0002\u0001\u0000\u0082\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0088"+
		"\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0089"+
		"\u0003\n\u0005\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001"+
		"\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u000f\u0001\u0000\u0000\u0000\u008c\u008d\u0006"+
		"\b\uffff\uffff\u0000\u008d\u00b1\u0005\u001b\u0000\u0000\u008e\u00b1\u0005"+
		"\r\u0000\u0000\u008f\u00b1\u0005\u000e\u0000\u0000\u0090\u00b1\u0005\u001c"+
		"\u0000\u0000\u0091\u0092\u0005\u000f\u0000\u0000\u0092\u00b1\u0003\u0010"+
		"\b\b\u0093\u0094\u0005\u000b\u0000\u0000\u0094\u0095\u0005\u0002\u0000"+
		"\u0000\u0095\u0096\u0003\u0010\b\u0000\u0096\u0097\u0005\u0004\u0000\u0000"+
		"\u0097\u0098\u0005\u0005\u0000\u0000\u0098\u0099\u0003\u0012\t\u0000\u0099"+
		"\u009a\u0005\u0006\u0000\u0000\u009a\u009b\u0005\f\u0000\u0000\u009b\u009c"+
		"\u0005\u0005\u0000\u0000\u009c\u009d\u0003\u0014\n\u0000\u009d\u009e\u0005"+
		"\u0006\u0000\u0000\u009e\u00b1\u0001\u0000\u0000\u0000\u009f\u00a0\u0005"+
		"\u0002\u0000\u0000\u00a0\u00a1\u0003\u0010\b\u0000\u00a1\u00a2\u0005\u0004"+
		"\u0000\u0000\u00a2\u00b1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u001c"+
		"\u0000\u0000\u00a4\u00ad\u0005\u0002\u0000\u0000\u00a5\u00aa\u0003\u0010"+
		"\b\u0000\u00a6\u00a7\u0005\u0003\u0000\u0000\u00a7\u00a9\u0003\u0010\b"+
		"\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000"+
		"\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ad\u00a5\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b1\u0005\u0004\u0000"+
		"\u0000\u00b0\u008c\u0001\u0000\u0000\u0000\u00b0\u008e\u0001\u0000\u0000"+
		"\u0000\u00b0\u008f\u0001\u0000\u0000\u0000\u00b0\u0090\u0001\u0000\u0000"+
		"\u0000\u00b0\u0091\u0001\u0000\u0000\u0000\u00b0\u0093\u0001\u0000\u0000"+
		"\u0000\u00b0\u009f\u0001\u0000\u0000\u0000\u00b0\u00a3\u0001\u0000\u0000"+
		"\u0000\u00b1\u00cf\u0001\u0000\u0000\u0000\u00b2\u00b5\n\u0007\u0000\u0000"+
		"\u00b3\u00b6\u0005\u0010\u0000\u0000\u00b4\u00b6\u0005\u0011\u0000\u0000"+
		"\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00ce\u0003\u0010\b\b\u00b8"+
		"\u00bb\n\u0006\u0000\u0000\u00b9\u00bc\u0005\u0012\u0000\u0000\u00ba\u00bc"+
		"\u0005\u0013\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00ba"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00ce"+
		"\u0003\u0010\b\u0007\u00be\u00c4\n\u0005\u0000\u0000\u00bf\u00c5\u0005"+
		"\u0014\u0000\u0000\u00c0\u00c5\u0005\u0015\u0000\u0000\u00c1\u00c5\u0005"+
		"\u0016\u0000\u0000\u00c2\u00c5\u0005\u0017\u0000\u0000\u00c3\u00c5\u0005"+
		"\u0018\u0000\u0000\u00c4\u00bf\u0001\u0000\u0000\u0000\u00c4\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c6\u00ce\u0003\u0010\b\u0006\u00c7\u00ca\n\u0004"+
		"\u0000\u0000\u00c8\u00cb\u0005\u0019\u0000\u0000\u00c9\u00cb\u0005\u001a"+
		"\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00c9\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0003\u0010"+
		"\b\u0005\u00cd\u00b2\u0001\u0000\u0000\u0000\u00cd\u00b8\u0001\u0000\u0000"+
		"\u0000\u00cd\u00be\u0001\u0000\u0000\u0000\u00cd\u00c7\u0001\u0000\u0000"+
		"\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u0011\u0001\u0000\u0000"+
		"\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d4\u0003\u0002\u0001"+
		"\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d6\u00db\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d8\u00da\u0003\n\u0005\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000"+
		"\u00da\u00dd\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00de\u0001\u0000\u0000\u0000"+
		"\u00dd\u00db\u0001\u0000\u0000\u0000\u00de\u00df\u0003\u0010\b\u0000\u00df"+
		"\u0013\u0001\u0000\u0000\u0000\u00e0\u00e2\u0003\u0002\u0001\u0000\u00e1"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e9\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e8\u0003\n\u0005\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e8\u00eb"+
		"\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ea\u00ec\u0001\u0000\u0000\u0000\u00eb\u00e9"+
		"\u0001\u0000\u0000\u0000\u00ec\u00ed\u0003\u0010\b\u0000\u00ed\u0015\u0001"+
		"\u0000\u0000\u0000\u001f\u001a\u001f#%36=EKO_brty\u007f\u0084\u008a\u00aa"+
		"\u00ad\u00b0\u00b5\u00bb\u00c4\u00ca\u00cd\u00cf\u00d5\u00db\u00e3\u00e9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}