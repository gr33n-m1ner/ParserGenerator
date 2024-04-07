package calculator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

public class Calculator {
    public static void main(String[] args) {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String str = r.readLine();
                InputStream stream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
                try {
                    CalculatorParser p = new CalculatorParser(stream);
                    System.out.println(p.Sum());
                } catch (IOException | ParseException e) {
                    System.err.println("Error while parsing");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
