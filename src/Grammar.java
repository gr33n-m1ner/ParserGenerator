import java.util.*;

public class Grammar {
    public static class Pair {
        public String token;
        public String regexp;

        public Pair(String token, String regexp) {
            this.token = token;
            this.regexp = regexp;
        }
    }

    public List<Rule> rules = new ArrayList<>();
    public List<Pair> tokens = new ArrayList<>();
    public String s;
    public Set<String> nonTerminals = new HashSet<>();
    public Map<String, String> signatures = new HashMap<>();
    public String annotation, member;
    public Set<String> skipTokens = new HashSet<>();

    public Map<String, Set<String>> first, follow;

    public void compute() {
        for (Rule r : rules) {
            nonTerminals.add(r.left);
            if (signatures.containsKey(r.left)) {
                if (!signatures.get(r.left).equals(r.signature) && !r.signature.equals("")) {
                    throw new RuntimeException();
                }
            } else {
                signatures.put(r.left, r.signature);
            }
        }
        computeFirst();
        computeFollow();
    }

    private void computeFirst() {
        first = new HashMap<>();
        for (Rule rule : rules) {
            if (!first.containsKey(rule.left)) {
                first.put(rule.left, new HashSet<>());
            }
        }

        boolean changes = true;
        while (changes) {
            changes = false;
            for (Rule rule : rules) {
                Set<String> curSet = first.get(rule.left);
                int oldSize = curSet.size();
                if (rule.right.isEmpty()) {
                    curSet.add("");
                } else if (Rule.isToken(rule.right.get(0))) {
                    curSet.add(rule.right.get(0));
                } else {
                    Set<String> toAdd = first.get(rule.right.get(0));
                    curSet.addAll(toAdd);
                    if (toAdd.contains("") && rule.right.size() > 1) {
                        curSet.addAll(first.get(rule.right.get(1)));
                    }
                }
                if (oldSize != curSet.size()) {
                    changes = true;
                }
            }
        }
    }

    private void computeFollow() {
        follow = new HashMap<>();

        for (Rule rule : rules) {
            if (!follow.containsKey(rule.left)) {
                follow.put(rule.left, new HashSet<>());
            }
        }
        follow.get(s).add("end");
        boolean changes = true;
        while (changes) {
            changes = false;
            for (Rule rule : rules) {
                for (int i = 0; i < rule.right.size(); ++i) {
                    String b = rule.right.get(i);
                    if (Rule.isToken(b)) {
                        continue;
                    }
                    Set<String> curSet = follow.get(b);
                    int oldSize = curSet.size();
                    if (i == rule.right.size() - 1) {
                        curSet.addAll(follow.get(rule.left));
                    } else if (Rule.isToken(rule.right.get(i + 1))) {
                        curSet.add(rule.right.get(i + 1));
                    } else {
                        Set<String> nextFirst = first.get(rule.right.get(i + 1));
                        curSet.addAll(nextFirst.stream().filter(str -> !str.isEmpty()).toList());
                        if (nextFirst.contains("")) {
                            curSet.addAll(follow.get(rule.right.get(i + 1)));
                        }
                    }
                    int newSize = curSet.size();
                    if (oldSize != newSize) {
                        changes = true;
                    }
                }
            }
        }
    }

    public Set<String> getParserTokens(Rule rule) {
        Set<String> tokens = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < rule.right.size(); ++i) {
            flag = true;
            if (Rule.isToken(rule.right.get(i))) {
                tokens.add(rule.right.get(i));
                break;
            } else {
                Set<String> toAdd = first.get(rule.right.get(i));
                if (toAdd.contains("")) {
                    if (i == rule.right.size() - 1) {
                        tokens.addAll(toAdd);
                        flag = false;
                    } else {
                        tokens.addAll(toAdd.stream().filter(str -> !str.isEmpty()).toList());
                    }
                } else {
                    tokens.addAll(toAdd);
                    break;
                }
            }
        }
        if (!flag) {
            tokens.addAll(follow.get(rule.left));
        }
        return tokens;
    }

    public Set<Rule> getRules(String nonTerminal) {
        Set<Rule> result = new HashSet<>();
        for (Rule rule : rules) {
            if (rule.left.equals(nonTerminal)) {
                result.add(rule);
            }
        }
        return result;
    }

    public boolean checkLL1() {
        boolean flag = true;
        for (String nonTerminal : nonTerminals) {
            List<Rule> ruleList = getRules(nonTerminal).stream().toList();
            for (int i = 0; i < ruleList.size(); ++i) {
                for (int j = 0; j < ruleList.size(); ++j) {
                    if (i == j) {
                        continue;
                    }
                    Set<String> intersect1 = getParserTokens(ruleList.get(i));
                    Set<String> intersect2 = getParserTokens(ruleList.get(j));
                    intersect1.retainAll(intersect2);
                    flag = flag && intersect1.size() == 0;
                }
            }

        }
        return flag;
    }

    public void dumpGrammar() {
        if (checkLL1()) {
            System.out.println("LL1");
        } else {
            System.out.println("Not LL1");
        }

        System.out.println("Start non-terminal: " + s);
        for (Rule r : rules) {
            System.out.println(r);
        }

        System.out.println("First");
        for (Map.Entry<String, Set<String>> e : first.entrySet()) {
            System.out.print(e.getKey() + ":");
            for (String qq : e.getValue()) {
                if (qq.equals("")) {
                    System.out.print("eps ");
                } else {
                    System.out.print(qq + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Follow");
        for (Map.Entry<String, Set<String>> e : follow.entrySet()) {
            System.out.print(e.getKey() + ":");
            for (String qq : e.getValue()) {
                if (qq.equals("")) {
                    System.out.print("eps ");
                } else {
                    System.out.print(qq + " ");
                }
            }
            System.out.println();
        }

        for (Rule rule : rules) {
            System.out.println(rule);
            Set<String> st = getParserTokens(rule);
            System.out.println(st);
        }
    }
}