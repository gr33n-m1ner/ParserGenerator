package logic;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Tree {
    String node;
    List<Tree> children;

    public Tree(String node, Tree... children) {
        this.node = node;
        this.children = Arrays.asList(children);
    }

    public Tree(String node) {
        this.node = node;
    }

    @Override
    public String toString() {
        if (Objects.equals(node, "eps")) {
            return "";
        }
        if (children == null) {
            return node;
        }
        return children.stream().map(Tree::toString)
                .filter(str -> !"".equals(str))
                .collect(Collectors.joining(" "));
    }
}
