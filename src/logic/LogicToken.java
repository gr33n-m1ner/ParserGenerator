package logic;

public enum LogicToken { 
	not(false),
	or(false),
	xor(false),
	and(false),
	left(false),
	right(false),
	var(false),
	whitespace(true),
	end(false);
	final boolean skip;
	LogicToken(boolean skip) {this.skip = skip;}
}
