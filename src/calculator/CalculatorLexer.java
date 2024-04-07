package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import static calculator.CalculatorToken.*;

public class CalculatorLexer { 
    private final BufferedReader in;
    private int currentChar;
    private CalculatorToken currentToken;
    private String currentObject;

    public CalculatorLexer(InputStream in) throws IOException, ParseException {
        this.in = new BufferedReader(new InputStreamReader(in));
        nextChar();
        nextToken();
    }

    private void nextChar() throws IOException {
        currentChar = in.read();
    }

    public CalculatorToken curToken() {
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
        CalculatorToken prev = end;
        CalculatorToken cur = end;
        while (true) {
            str += (char) currentChar;
            if (str.matches("^[+]$")) {
                cur = plus;
            } else
            if (str.matches("^[-]$")) {
                cur = minus;
            } else
            if (str.matches("^[/]$")) {
                cur = slash;
            } else
            if (str.matches("^[l][g]$")) {
                cur = sslash;
            } else
            if (str.matches("^[1-9][0-9]*|0$")) {
                cur = number;
            } else
            if (str.matches("^[*]$")) {
                cur = star;
            } else
            if (str.matches("^[(]$")) {
                cur = left;
            } else
            if (str.matches("^[)]$")) {
                cur = right;
            } else
            if (str.matches("^[ ]+$")) {
                cur = whitespace;
            } else
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
}
