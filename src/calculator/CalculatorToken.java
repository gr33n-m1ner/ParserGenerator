package calculator;

public enum CalculatorToken { 
	plus(false),
	minus(false),
	slash(false),
	sslash(false),
	number(false),
	star(false),
	left(false),
	right(false),
	whitespace(true),
	end(false);
	final boolean skip;
	CalculatorToken(boolean skip) {this.skip = skip;}
}
