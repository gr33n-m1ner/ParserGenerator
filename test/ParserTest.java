import logic.LogicLexer;
import logic.LogicParser;
import logic.LogicToken;
import logic.Tree;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

public class ParserTest {
    public InputStream getStream(String str) {
        return new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
    }


    @Test
    public void simpleAnd() {
        try {
            LogicParser parser = new LogicParser(getStream("a and b "));
            Tree tree = parser.Expr();
            Assert.assertEquals(tree.toString(), "var and var");
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void simpleOr() {
        try {
            LogicParser parser = new LogicParser(getStream("a or b "));
            Tree tree = parser.Expr();
            Assert.assertEquals(tree.toString(), "var or var");
        } catch (Exception e) {
            Assert.fail();

        }
    }

    @Test
    public void simpleXor() {
        try {
            LogicParser parser = new LogicParser(getStream("a xor b "));
            Tree tree = parser.Expr();
            Assert.assertEquals(tree.toString(), "var xor var");
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void simpleNot() {
        try {
            LogicParser parser = new LogicParser(getStream("not a "));
            Tree tree = parser.Expr();
            Assert.assertEquals(tree.toString(), "not var");
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void variables() {
        for (char i = 'a'; i <= 'z'; ++i) {
            try {
                LogicParser parser = new LogicParser(getStream(i + " "));
                Tree tree = parser.Expr();
                Assert.assertEquals(tree.toString(), "var");
            } catch (Exception e) {
                Assert.fail();
            }
        }
    }

    @Test
    public void parenthesis() {
        try {
            LogicParser parser = new LogicParser(getStream("((a ) and (b ))"));
            Tree tree = parser.Expr();
            Assert.assertEquals(tree.toString(), "( ( var ) and ( var ) )");
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void wrong() {
        try {
            LogicParser parser = new LogicParser(getStream("abc"));
            Tree tree = parser.Expr();
            Assert.fail();
        } catch (Exception e) {
        }
    }

}
