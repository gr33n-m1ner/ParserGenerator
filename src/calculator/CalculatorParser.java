package calculator;

import java.io.InputStream;
import java.io.IOException;
import java.text.ParseException;
import static calculator.CalculatorToken.*;

public class CalculatorParser { 

    private final CalculatorLexer lex;

    private void expect(CalculatorToken token) throws IOException, ParseException {
        if (token == lex.curToken()) {
            lex.nextToken();
        } else {
            throw new ParseException("Unexpected token", 0);
        }
    }

    public CalculatorParser(InputStream in) throws IOException, ParseException {
        lex = new CalculatorLexer(in);
    }
	private int SumCont(int _val) throws IOException, ParseException {
		switch (lex.curToken()) {
			case plus -> {
				String _plus1 = lex.curObject();
				expect(plus);
				int _p = Product();
				return SumCont(_val + _p);
			}
			case end, right -> {
				return _val;
			}
			case minus -> {
				String _minus1 = lex.curObject();
				expect(minus);
				int _p = Product();
				return SumCont(_val - _p);
			}
		}
		throw new ParseException("Token not found", 0);
	}

	private int Log() throws IOException, ParseException {
		switch (lex.curToken()) {
			case number, minus, left -> {
				int _u = Unary();
				return LogCont(_u);
			}
		}
		throw new ParseException("Token not found", 0);
	}

	private int ProductCont(int _val) throws IOException, ParseException {
		switch (lex.curToken()) {
			case slash -> {
				String _slash1 = lex.curObject();
				expect(slash);
				int _u = Log();
				return ProductCont(_val / _u);
			}
			case star -> {
				String _star1 = lex.curObject();
				expect(star);
				int _u = Log();
				return ProductCont(_val * _u);
			}
			case minus, end, right, plus -> {
				return _val;
			}
		}
		throw new ParseException("Token not found", 0);
	}

	private int Product() throws IOException, ParseException {
		switch (lex.curToken()) {
			case number, minus, left -> {
				int _u = Log();
				return ProductCont(_u);
			}
		}
		throw new ParseException("Token not found", 0);
	}

	private int LogCont(int _val) throws IOException, ParseException {
		switch (lex.curToken()) {
			case minus, star, slash, end, right, plus -> {
				return _val;
			}
			case sslash -> {
				String _sslash1 = lex.curObject();
				expect(sslash);
				int _u = Unary();
				return (int) (Math.log(_val) / Math.log(LogCont(_u)));
			}
		}
		throw new ParseException("Token not found", 0);
	}

	public int Sum() throws IOException, ParseException {
		switch (lex.curToken()) {
			case number, minus, left -> {
				int _p = Product();
				return SumCont(_p);
			}
		}
		throw new ParseException("Token not found", 0);
	}

	private int Unary() throws IOException, ParseException {
		switch (lex.curToken()) {
			case left -> {
				String _left1 = lex.curObject();
				expect(left);
				int _s = Sum();
				String _right3 = lex.curObject();
				expect(right);
				return _s;
			}
			case minus -> {
				String _minus1 = lex.curObject();
				expect(minus);
				return -Unary();
			}
			case number -> {
				String _number1 = lex.curObject();
				expect(number);
				return Integer.parseInt(_number1);
			}
		}
		throw new ParseException("Token not found", 0);
	}

}
