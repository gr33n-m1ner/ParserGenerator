// Generated from C:/Users/Master/Desktop/working-folder/ParserGenerator/src/Grammar.g4 by ANTLR 4.13.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(GrammarParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(GrammarParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#tokenRule}.
	 * @param ctx the parse tree
	 */
	void enterTokenRule(GrammarParser.TokenRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#tokenRule}.
	 * @param ctx the parse tree
	 */
	void exitTokenRule(GrammarParser.TokenRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(GrammarParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(GrammarParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void enterRulePart(GrammarParser.RulePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void exitRulePart(GrammarParser.RulePartContext ctx);
}