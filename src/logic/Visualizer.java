package logic;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

public class Visualizer {
    private final String fileName;
    private final InputStream is;

    public Visualizer(String fileName, InputStream is) {
        this.fileName = fileName;
        this.is = is;
    }

    void start() {
        Tree tree;
        try {
            LogicParser parser = new LogicParser(is);
            tree = parser.Expr();
        } catch (IOException | ParseException e) {
            System.err.println("Error while parsing");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, Charset.defaultCharset()))) {
            writer.write("digraph {\n");
            visualise(0, tree, writer);
            writer.write("}\n");
        } catch (IOException e) {
            System.err.println("IO Exception occurred");
        }
    }

    int visualise(int id, Tree tree, Writer writer) throws IOException {
        String line = "\tnode" + id + " [label=\"" + tree.node + "\"]\n";
        writer.write(line);
        int newId = id + 1;
        if (tree.children == null) {
            return newId;
        }
        for (Tree subtree : tree.children) {
            line = "\tnode" + id + " -> node" + newId + "\n";
            writer.write(line);
            newId = visualise(newId, subtree, writer);
        }
        return newId;
    }

    public static void main(String[] args) {
        Visualizer vis = new Visualizer("input.txt", new ByteArrayInputStream(args[0].getBytes(StandardCharsets.UTF_8)));
        vis.start();
        try {
            Process p = new ProcessBuilder("dot", "-Tsvg", "input.txt").redirectOutput(new File("output.svg")).start();
            p.waitFor();
            new ProcessBuilder("cmd.exe", "/c", "output.svg").start();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}