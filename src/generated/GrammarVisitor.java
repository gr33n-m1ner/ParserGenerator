// Generated from C:/Users/Master/Desktop/working-folder/ParserGenerator/src/Grammar.g4 by ANTLR 4.13.1
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(GrammarParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#tokenRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenRule(GrammarParser.TokenRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(GrammarParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulePart(GrammarParser.RulePartContext ctx);
}