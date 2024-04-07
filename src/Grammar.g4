grammar Grammar;

file : (ANNOTATION NEWLINE)? (MEMBER NEWLINE)? (NONTERMINAL NEWLINE) (tokenRule NEWLINE)* (rule NEWLINE)*;

tokenRule : TOKEN SKIPPED? '->' TERMINAL;

rule : NONTERMINAL SIGNATURE? '->' rulePart* CODE?;

rulePart : (NONTERMINAL | TOKEN) CALL?;

SKIPPED : 'skipped';
TERMINAL : '@t{'.*?'}@';
CODE : '@c{'.*?'}@';
SIGNATURE : '@s{'.*?'}@';
ANNOTATION : '@a{'.*?'}@';
MEMBER : '@m{'.*?'}@';
CALL : '@v{'.*?'}@';
WHITESPACE : [ ]+ -> skip;
NEWLINE : [\r\n];
TOKEN : [a-z]+;
NONTERMINAL : [A-Z][A-Za-z]*;
