import generated.GrammarLexer;
import generated.GrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Generator {
    private final String from;
    private final String to;
    private final String name;
    private Grammar grammar;

    public Generator(String from, String to, String name) {
        this.from = from;
        this.to = to;
        this.name = name;
        grammar = getGrammar();
        grammar.compute();
    }

    public void start() throws IOException {
        generateTokens();
        generateLexer();
        generateParser();
    }

    private void generateTokens() throws IOException {
        Path path = Path.of("src/" + to + "/" + name + "Token.java");
        createFile(path);
        try (BufferedWriter w = Files.newBufferedWriter(path)) {
            w.write("package " + to + ";\n");
            w.write(grammar.annotation + "\n");
            w.write("public enum " + name + "Token { \n");
            for (Grammar.Pair tokenPair : grammar.tokens) {
                String token = tokenPair.token;
                w.write("\t" + token + "(" + (grammar.skipTokens.contains(token) + "),\n"));
            }
            w.write("\t" + "end(false);\n");
            w.write("\tfinal boolean skip;\n");
            w.write("\t" + name + "Token(boolean skip) {this.skip = skip;}\n");
            w.write("}\n");
        }
    }

    private void generateLexer() throws IOException {
        Path path = Path.of("src/" + to + "/" + name + "Lexer.java");
        createFile(path);
        try (BufferedWriter w = Files.newBufferedWriter(path)) {
            w.write("package " + to + ";\n");
            w.write(grammar.annotation + "\n");
            w.write("""
                    import java.io.BufferedReader;
                    import java.io.IOException;
                    import java.io.InputStream;
                    import java.io.InputStreamReader;
                    import java.text.ParseException;
                    import static #.$Token.*;
                                        
                    """.replace("#", to).replace("$", name));
            w.write("public class " + name + "Lexer { \n");
            w.write("""
                        private final BufferedReader in;
                        private int currentChar;
                        private $Token currentToken;
                        private String currentObject;
                    """.replace("$", name));
            w.write(grammar.member);
            w.write("""
                        
                        public $Lexer(InputStream in) throws IOException, ParseException {
                            this.in = new BufferedReader(new InputStreamReader(in));
                            nextChar();
                            nextToken();
                        }
                                        
                        private void nextChar() throws IOException {
                            currentChar = in.read();
                        }
                                        
                        public $Token curToken() {
                            return currentToken;
                        }
                                        
                        public String curObject() {
                            return currentObject;
                        }
                        public void nextToken() throws IOException, ParseException {
                            if (currentChar == -1) {
                                currentToken = end;
                                return;
                            }
                            String str = "";
                            $Token prev = end;
                            $Token cur = end;
                            while (true) {
                                str += (char) currentChar;
                    """.replace("$", name));
            for (Grammar.Pair tokenPair : grammar.tokens) {
                w.write("""
                                    if (str.matches("$2")) {
                                        cur = $1;
                                    } else
                        """.replace("$1", tokenPair.token).replace("$2", tokenPair.regexp));
            }
            w.write("""
                                if (prev == end && currentChar == -1) {
                                    throw new IOException();
                                }
                                
                                if (prev != end && cur == end) {
                                    currentToken = prev;
                                    currentObject = str.substring(0, str.length() - 1);
                                    break;
                                }
                                prev = cur;
                                cur = end;
                                nextChar();
                            }
                            if (currentToken.skip) {
                                nextToken();
                            }
                        }
                    """);

            w.write("}\n");
        }

    }

    private void generateParser() throws IOException {
        Path path = Path.of("src/" + to + "/" + name + "Parser.java");
        createFile(path);
        try (BufferedWriter w = Files.newBufferedWriter(path)) {
            w.write("package " + to + ";\n");
            w.write(grammar.annotation + "\n");
            w.write("""
                    import java.io.InputStream;
                    import java.io.IOException;
                    import java.text.ParseException;
                    import static #.$Token.*;
                                        
                    public class $Parser { \n
                        private final $Lexer lex;
                        
                        private void expect($Token token) throws IOException, ParseException {
                            if (token == lex.curToken()) {
                                lex.nextToken();
                            } else {
                                throw new ParseException("Unexpected token", 0);
                            }
                        }
                        
                        public $Parser(InputStream in) throws IOException, ParseException {
                            lex = new $Lexer(in);
                        }
                    """.replace("$", name).replace("#", to));
            w.write(grammar.member);

            for (String nonTerminal : grammar.nonTerminals) {
                String access = nonTerminal.equals(grammar.s) ? "public" : "private";
                w.write("\t" + access + " " + grammar.signatures.get(nonTerminal) + " throws IOException, ParseException {\n");
                w.write("\t\tswitch (lex.curToken()) {\n");
                for (Rule rule : grammar.getRules(nonTerminal)) {
                    Set<String> tokens = grammar.getParserTokens(rule);
                    w.write("\t\t\tcase " + String.join(", ", tokens) + " -> {\n");
                    for (int i = 0; i < rule.right.size(); ++i) {
                        String part = rule.right.get(i);
                        String call = rule.calls.get(i);
                        if (part.equals(part.toLowerCase())) {
                            w.write("\t\t\t\tString _" + part + (i + 1) + " = lex.curObject();\n");
                            w.write("\t\t\t\texpect(" + part + ");\n");
                        } else {
                            if (!call.equals("")) {
                                w.write("\t\t\t\t" + call + ";\n");
                            }
                        }
                    }
                    w.write("\t\t\t\t" + rule.code + ";\n");
                    w.write("\t\t\t}\n");
                }
                w.write("\t\t}\n");
                w.write("\t\tthrow new ParseException(\"Token not found\", 0);\n\t}\n\n");
            }
            w.write("}\n");
        }
    }

    private void createFile(Path path) throws IOException {
        File file = new File(path.toUri());
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            createFile(path);
        }
    }


    private Grammar getGrammar() {
        String fileContent;
        try {
            fileContent = String.join("\n", Files.readAllLines(Path.of(from)));
        } catch (IOException e) {
            System.err.println("Error has occurred");
            throw new RuntimeException();
        }
        GrammarLexer lexer = new GrammarLexer(CharStreams.fromString(fileContent));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
        ParseTree tree = parser.file();
        Visitor visitor = new Visitor();
        visitor.visit(tree);
        return visitor.grammar;
    }


    public static void main(String[] args) {
        String from = args[0];
        String to = args[1];
        String name = args[2];

        Generator a = new Generator(from, to, name);
        a.grammar.dumpGrammar();
        try {
            a.start();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
