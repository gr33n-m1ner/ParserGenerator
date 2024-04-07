// Generated from C:/Users/Master/Desktop/working-folder/ParserGenerator/src/Grammar.g4 by ANTLR 4.13.1
package generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SKIPPED=2, TERMINAL=3, CODE=4, SIGNATURE=5, ANNOTATION=6, MEMBER=7, 
		CALL=8, WHITESPACE=9, NEWLINE=10, TOKEN=11, NONTERMINAL=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "SKIPPED", "TERMINAL", "CODE", "SIGNATURE", "ANNOTATION", "MEMBER", 
			"CALL", "WHITESPACE", "NEWLINE", "TOKEN", "NONTERMINAL"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\u0004\u0000\f\u0087\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"*\b\u0002\n\u0002\f\u0002-\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"7\b\u0003\n\u0003\f\u0003:\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"D\b\u0004\n\u0004\f\u0004G\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"Q\b\u0005\n\u0005\f\u0005T\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"^\b\u0006\n\u0006\f\u0006a\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"k\b\u0007\n\u0007\f\u0007n\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0004\bt\b\b\u000b\b\f\bu\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0004\n}\b\n\u000b\n\f\n~\u0001\u000b\u0001\u000b\u0005\u000b\u0083"+
		"\b\u000b\n\u000b\f\u000b\u0086\t\u000b\u0006+8ER_l\u0000\f\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0001\u0000\u0005\u0001\u0000 "+
		" \u0002\u0000\n\n\r\r\u0001\u0000az\u0001\u0000AZ\u0002\u0000AZaz\u008f"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0001\u0019"+
		"\u0001\u0000\u0000\u0000\u0003\u001c\u0001\u0000\u0000\u0000\u0005$\u0001"+
		"\u0000\u0000\u0000\u00071\u0001\u0000\u0000\u0000\t>\u0001\u0000\u0000"+
		"\u0000\u000bK\u0001\u0000\u0000\u0000\rX\u0001\u0000\u0000\u0000\u000f"+
		"e\u0001\u0000\u0000\u0000\u0011s\u0001\u0000\u0000\u0000\u0013y\u0001"+
		"\u0000\u0000\u0000\u0015|\u0001\u0000\u0000\u0000\u0017\u0080\u0001\u0000"+
		"\u0000\u0000\u0019\u001a\u0005-\u0000\u0000\u001a\u001b\u0005>\u0000\u0000"+
		"\u001b\u0002\u0001\u0000\u0000\u0000\u001c\u001d\u0005s\u0000\u0000\u001d"+
		"\u001e\u0005k\u0000\u0000\u001e\u001f\u0005i\u0000\u0000\u001f \u0005"+
		"p\u0000\u0000 !\u0005p\u0000\u0000!\"\u0005e\u0000\u0000\"#\u0005d\u0000"+
		"\u0000#\u0004\u0001\u0000\u0000\u0000$%\u0005@\u0000\u0000%&\u0005t\u0000"+
		"\u0000&\'\u0005{\u0000\u0000\'+\u0001\u0000\u0000\u0000(*\t\u0000\u0000"+
		"\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+,\u0001\u0000"+
		"\u0000\u0000+)\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000-+\u0001"+
		"\u0000\u0000\u0000./\u0005}\u0000\u0000/0\u0005@\u0000\u00000\u0006\u0001"+
		"\u0000\u0000\u000012\u0005@\u0000\u000023\u0005c\u0000\u000034\u0005{"+
		"\u0000\u000048\u0001\u0000\u0000\u000057\t\u0000\u0000\u000065\u0001\u0000"+
		"\u0000\u00007:\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u000086\u0001"+
		"\u0000\u0000\u00009;\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		";<\u0005}\u0000\u0000<=\u0005@\u0000\u0000=\b\u0001\u0000\u0000\u0000"+
		">?\u0005@\u0000\u0000?@\u0005s\u0000\u0000@A\u0005{\u0000\u0000AE\u0001"+
		"\u0000\u0000\u0000BD\t\u0000\u0000\u0000CB\u0001\u0000\u0000\u0000DG\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000"+
		"FH\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HI\u0005}\u0000\u0000"+
		"IJ\u0005@\u0000\u0000J\n\u0001\u0000\u0000\u0000KL\u0005@\u0000\u0000"+
		"LM\u0005a\u0000\u0000MN\u0005{\u0000\u0000NR\u0001\u0000\u0000\u0000O"+
		"Q\t\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000"+
		"\u0000TR\u0001\u0000\u0000\u0000UV\u0005}\u0000\u0000VW\u0005@\u0000\u0000"+
		"W\f\u0001\u0000\u0000\u0000XY\u0005@\u0000\u0000YZ\u0005m\u0000\u0000"+
		"Z[\u0005{\u0000\u0000[_\u0001\u0000\u0000\u0000\\^\t\u0000\u0000\u0000"+
		"]\\\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000"+
		"\u0000\u0000bc\u0005}\u0000\u0000cd\u0005@\u0000\u0000d\u000e\u0001\u0000"+
		"\u0000\u0000ef\u0005@\u0000\u0000fg\u0005v\u0000\u0000gh\u0005{\u0000"+
		"\u0000hl\u0001\u0000\u0000\u0000ik\t\u0000\u0000\u0000ji\u0001\u0000\u0000"+
		"\u0000kn\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000lj\u0001\u0000"+
		"\u0000\u0000mo\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005"+
		"}\u0000\u0000pq\u0005@\u0000\u0000q\u0010\u0001\u0000\u0000\u0000rt\u0007"+
		"\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wx\u0006\b\u0000\u0000x\u0012\u0001\u0000\u0000\u0000yz\u0007\u0001"+
		"\u0000\u0000z\u0014\u0001\u0000\u0000\u0000{}\u0007\u0002\u0000\u0000"+
		"|{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0016\u0001\u0000\u0000\u0000"+
		"\u0080\u0084\u0007\u0003\u0000\u0000\u0081\u0083\u0007\u0004\u0000\u0000"+
		"\u0082\u0081\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000"+
		"\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000"+
		"\u0085\u0018\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000"+
		"\n\u0000+8ER_lu~\u0084\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}