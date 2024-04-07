package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import static logic.LogicToken.*;

public class LogicLexer { 
    private final BufferedReader in;
    private int currentChar;
    private LogicToken currentToken;
    private String currentObject;

    public LogicLexer(InputStream in) throws IOException, ParseException {
        this.in = new BufferedReader(new InputStreamReader(in));
        nextChar();
        nextToken();
    }

    private void nextChar() throws IOException {
        currentChar = in.read();
    }

    public LogicToken curToken() {
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
        LogicToken prev = end;
        LogicToken cur = end;
        while (true) {
            str += (char) currentChar;
            if (str.matches("^not$")) {
                cur = not;
            } else
            if (str.matches("^or$")) {
                cur = or;
            } else
            if (str.matches("^xor$")) {
                cur = xor;
            } else
            if (str.matches("^and$")) {
                cur = and;
            } else
            if (str.matches("^[(]$")) {
                cur = left;
            } else
            if (str.matches("^[)]$")) {
                cur = right;
            } else
            if (str.matches("^[a-z]+$")) {
                cur = var;
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
