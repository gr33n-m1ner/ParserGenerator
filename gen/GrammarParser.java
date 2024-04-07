// Generated from C:/Users/Master/Desktop/working-folder/ParserGenerator/src/Grammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SKIPPED=2, TERMINAL=3, CODE=4, SIGNATURE=5, ANNOTATION=6, MEMBER=7, 
		CALL=8, WHITESPACE=9, NEWLINE=10, TOKEN=11, NONTERMINAL=12;
	public static final int
		RULE_file = 0, RULE_tokenRule = 1, RULE_rule = 2, RULE_rulePart = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "tokenRule", "rule", "rulePart"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'->'", "'skipped'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "SKIPPED", "TERMINAL", "CODE", "SIGNATURE", "ANNOTATION", 
			"MEMBER", "CALL", "WHITESPACE", "NEWLINE", "TOKEN", "NONTERMINAL"
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public TerminalNode NONTERMINAL() { return getToken(GrammarParser.NONTERMINAL, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(GrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GrammarParser.NEWLINE, i);
		}
		public TerminalNode ANNOTATION() { return getToken(GrammarParser.ANNOTATION, 0); }
		public TerminalNode MEMBER() { return getToken(GrammarParser.MEMBER, 0); }
		public List<TokenRuleContext> tokenRule() {
			return getRuleContexts(TokenRuleContext.class);
		}
		public TokenRuleContext tokenRule(int i) {
			return getRuleContext(TokenRuleContext.class,i);
		}
		public List<RuleContext> rule_() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule_(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ANNOTATION) {
				{
				setState(8);
				match(ANNOTATION);
				setState(9);
				match(NEWLINE);
				}
			}

			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MEMBER) {
				{
				setState(12);
				match(MEMBER);
				setState(13);
				match(NEWLINE);
				}
			}

			{
			setState(16);
			match(NONTERMINAL);
			setState(17);
			match(NEWLINE);
			}
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TOKEN) {
				{
				{
				setState(19);
				tokenRule();
				setState(20);
				match(NEWLINE);
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NONTERMINAL) {
				{
				{
				setState(27);
				rule_();
				setState(28);
				match(NEWLINE);
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class TokenRuleContext extends ParserRuleContext {
		public TerminalNode TOKEN() { return getToken(GrammarParser.TOKEN, 0); }
		public TerminalNode TERMINAL() { return getToken(GrammarParser.TERMINAL, 0); }
		public TerminalNode SKIPPED() { return getToken(GrammarParser.SKIPPED, 0); }
		public TokenRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTokenRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTokenRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTokenRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenRuleContext tokenRule() throws RecognitionException {
		TokenRuleContext _localctx = new TokenRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tokenRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(TOKEN);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SKIPPED) {
				{
				setState(36);
				match(SKIPPED);
				}
			}

			setState(39);
			match(T__0);
			setState(40);
			match(TERMINAL);
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
	public static class RuleContext extends ParserRuleContext {
		public TerminalNode NONTERMINAL() { return getToken(GrammarParser.NONTERMINAL, 0); }
		public TerminalNode SIGNATURE() { return getToken(GrammarParser.SIGNATURE, 0); }
		public List<RulePartContext> rulePart() {
			return getRuleContexts(RulePartContext.class);
		}
		public RulePartContext rulePart(int i) {
			return getRuleContext(RulePartContext.class,i);
		}
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public List<TerminalNode> CALL() { return getTokens(GrammarParser.CALL); }
		public TerminalNode CALL(int i) {
			return getToken(GrammarParser.CALL, i);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleContext rule_() throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(NONTERMINAL);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIGNATURE) {
				{
				setState(43);
				match(SIGNATURE);
				}
			}

			setState(46);
			match(T__0);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TOKEN || _la==NONTERMINAL) {
				{
				{
				setState(47);
				rulePart();
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CALL) {
					{
					setState(48);
					match(CALL);
					}
				}

				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CODE) {
				{
				setState(56);
				match(CODE);
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
	public static class RulePartContext extends ParserRuleContext {
		public TerminalNode NONTERMINAL() { return getToken(GrammarParser.NONTERMINAL, 0); }
		public TerminalNode TOKEN() { return getToken(GrammarParser.TOKEN, 0); }
		public RulePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulePart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRulePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRulePart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitRulePart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulePartContext rulePart() throws RecognitionException {
		RulePartContext _localctx = new RulePartContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rulePart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if ( !(_la==TOKEN || _la==NONTERMINAL) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001\f>\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u000b\b\u0000\u0001\u0000\u0001\u0000\u0003\u0000\u000f\b\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000\u0017\b\u0000\n\u0000\f\u0000\u001a\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0005\u0000\u001f\b\u0000\n\u0000\f\u0000\"\t\u0000"+
		"\u0001\u0001\u0001\u0001\u0003\u0001&\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0003\u0002-\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00022\b\u0002\u0005\u00024\b\u0002\n\u0002"+
		"\f\u00027\t\u0002\u0001\u0002\u0003\u0002:\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0000\u0000\u0004\u0000\u0002\u0004\u0006\u0000\u0001\u0001"+
		"\u0000\u000b\fB\u0000\n\u0001\u0000\u0000\u0000\u0002#\u0001\u0000\u0000"+
		"\u0000\u0004*\u0001\u0000\u0000\u0000\u0006;\u0001\u0000\u0000\u0000\b"+
		"\t\u0005\u0006\u0000\u0000\t\u000b\u0005\n\u0000\u0000\n\b\u0001\u0000"+
		"\u0000\u0000\n\u000b\u0001\u0000\u0000\u0000\u000b\u000e\u0001\u0000\u0000"+
		"\u0000\f\r\u0005\u0007\u0000\u0000\r\u000f\u0005\n\u0000\u0000\u000e\f"+
		"\u0001\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f\u0010"+
		"\u0001\u0000\u0000\u0000\u0010\u0011\u0005\f\u0000\u0000\u0011\u0012\u0005"+
		"\n\u0000\u0000\u0012\u0018\u0001\u0000\u0000\u0000\u0013\u0014\u0003\u0002"+
		"\u0001\u0000\u0014\u0015\u0005\n\u0000\u0000\u0015\u0017\u0001\u0000\u0000"+
		"\u0000\u0016\u0013\u0001\u0000\u0000\u0000\u0017\u001a\u0001\u0000\u0000"+
		"\u0000\u0018\u0016\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000"+
		"\u0000\u0019 \u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000"+
		"\u001b\u001c\u0003\u0004\u0002\u0000\u001c\u001d\u0005\n\u0000\u0000\u001d"+
		"\u001f\u0001\u0000\u0000\u0000\u001e\u001b\u0001\u0000\u0000\u0000\u001f"+
		"\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000"+
		"\u0000\u0000!\u0001\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000"+
		"#%\u0005\u000b\u0000\u0000$&\u0005\u0002\u0000\u0000%$\u0001\u0000\u0000"+
		"\u0000%&\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0005\u0001"+
		"\u0000\u0000()\u0005\u0003\u0000\u0000)\u0003\u0001\u0000\u0000\u0000"+
		"*,\u0005\f\u0000\u0000+-\u0005\u0005\u0000\u0000,+\u0001\u0000\u0000\u0000"+
		",-\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.5\u0005\u0001\u0000"+
		"\u0000/1\u0003\u0006\u0003\u000002\u0005\b\u0000\u000010\u0001\u0000\u0000"+
		"\u000012\u0001\u0000\u0000\u000024\u0001\u0000\u0000\u00003/\u0001\u0000"+
		"\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u0000"+
		"8:\u0005\u0004\u0000\u000098\u0001\u0000\u0000\u00009:\u0001\u0000\u0000"+
		"\u0000:\u0005\u0001\u0000\u0000\u0000;<\u0007\u0000\u0000\u0000<\u0007"+
		"\u0001\u0000\u0000\u0000\t\n\u000e\u0018 %,159";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}