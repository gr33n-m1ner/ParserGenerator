import generated.GrammarBaseVisitor;
import generated.GrammarParser;

import java.nio.file.Path;

public class Visitor extends GrammarBaseVisitor<String> {
    public final Grammar grammar = new Grammar();

    private String getFromBrackets(String s) {
        return s.substring(3, s.length() - 2);
    }

    @Override
    public String visitFile(GrammarParser.FileContext ctx) {
        if (ctx.ANNOTATION() != null) {
            grammar.annotation = getFromBrackets(ctx.ANNOTATION().getText());
        } else {
            grammar.annotation = "";
        }
        if (ctx.MEMBER() != null) {
            grammar.member = getFromBrackets(ctx.MEMBER().getText());
        } else {
            grammar.member = "";
        }
        grammar.s = ctx.NONTERMINAL().getText();
        return super.visitFile(ctx);
    }

    @Override
    public String visitTokenRule(GrammarParser.TokenRuleContext ctx) {
        grammar.tokens.add(new Grammar.Pair(ctx.TOKEN().getText(), "^" + getFromBrackets(ctx.TERMINAL().getText()) + "$"));
        if (ctx.SKIPPED() != null) {
            grammar.skipTokens.add(ctx.TOKEN().getText());
        }
        return super.visitTokenRule(ctx);
    }

    @Override
    public String visitRule(GrammarParser.RuleContext ctx) {
        Rule rule = new Rule();

        if (ctx.SIGNATURE() != null) {
            rule.signature = getFromBrackets(ctx.SIGNATURE().getText());
        } else {
            rule.signature = "";
        }

        if (ctx.CODE() != null) {
            rule.code = getFromBrackets(ctx.CODE().getText());
        } else {
            rule.code = "";
        }
        rule.left = ctx.NONTERMINAL().getText();

        for (GrammarParser.RulePartContext part : ctx.rulePart()) {
            if (part.TOKEN() != null) {
                rule.right.add(part.TOKEN().getText());
            } else {
                rule.right.add(part.NONTERMINAL().getText());
            }
            if (part.CALL() != null) {
                rule.calls.add(getFromBrackets(part.CALL().getText()));
            } else {
                rule.calls.add("");
            }
        }
        grammar.rules.add(rule);
        return super.visitRule(ctx);
    }
}
