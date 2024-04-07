package logic;

import java.io.InputStream;
import java.io.IOException;
import java.text.ParseException;
import static logic.LogicToken.*;

public class LogicParser { 

    private final LogicLexer lex;

    private void expect(LogicToken token) throws IOException, ParseException {
        if (token == lex.curToken()) {
            lex.nextToken();
        } else {
            throw new ParseException("Unexpected token", 0);
        }
    }

    public LogicParser(InputStream in) throws IOException, ParseException {
        lex = new LogicLexer(in);
    }
	private Tree OrCont() throws IOException, ParseException {
		switch (lex.curToken()) {
			case end, right -> {
				return new Tree("OrCont", new Tree("eps"));
			}
			case or -> {
				String _or1 = lex.curObject();
				expect(or);
				Tree _x = Xor();
				return new Tree("OrCont", new Tree("or"), _x, OrCont());
			}
		}
		throw new ParseException("Token not found", 0);
	}

	private Tree AndCont() throws IOException, ParseException {
		switch (lex.curToken()) {
			case and -> {
				String _and1 = lex.curObject();
				expect(and);
				Tree _u = Unary();
				return new Tree("AndCont", new Tree("and"), _u, AndCont());
			}
			case or, xor, end, right -> {
				return new Tree("AndCont", new Tree("eps"));
			}
		}
		throw new ParseException("Token not found", 0);
	}

	private Tree Or() throws IOException, ParseException {
		switch (lex.curToken()) {
			case not, left, var -> {
				Tree _x = Xor();
				return new Tree("Or", _x, OrCont());
			}
		}
		throw new ParseException("Token not found", 0);
	}

	public Tree Expr() throws IOException, ParseException {
		switch (lex.curToken()) {
			case not, left, var -> {
				return new Tree("Expr", Or());
			}
		}
		throw new ParseException("Token not found", 0);
	}

	private Tree And() throws IOException, ParseException {
		switch (lex.curToken()) {
			case not, left, var -> {
				Tree _u = Unary();
				return new Tree("And", _u, AndCont());
			}
		}
		throw new ParseException("Token not found", 0);
	}

	private Tree XorCont() throws IOException, ParseException {
		switch (lex.curToken()) {
			case or, end, right -> {
				return new Tree("XorCont", new Tree("eps"));
			}
			case xor -> {
				String _xor1 = lex.curObject();
				expect(xor);
				Tree _a = And();
				return new Tree("XorCont", new Tree("xor"), _a, XorCont());
			}
		}
		throw new ParseException("Token not found", 0);
	}

	private Tree Xor() throws IOException, ParseException {
		switch (lex.curToken()) {
			case not, left, var -> {
				Tree _a = And();
				return new Tree("Xor", _a, XorCont());
			}
		}
		throw new ParseException("Token not found", 0);
	}

	private Tree Unary() throws IOException, ParseException {
		switch (lex.curToken()) {
			case var -> {
				String _var1 = lex.curObject();
				expect(var);
				if (_var1.length() == 1) {return new Tree("Unary", new Tree("var"));};
			}
			case not -> {
				String _not1 = lex.curObject();
				expect(not);
				return new Tree("Tree", new Tree("not"), Unary());
			}
			case left -> {
				String _left1 = lex.curObject();
				expect(left);
				Tree _e = Expr();
				String _right3 = lex.curObject();
				expect(right);
				return new Tree("Unary", new Tree("("), _e, new Tree(")"));
			}
		}
		throw new ParseException("Token not found", 0);
	}

}
