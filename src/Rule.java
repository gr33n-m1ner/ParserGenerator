import java.util.ArrayList;
import java.util.List;

public class Rule {
    public final List<String> right = new ArrayList<>();
    public final List<String> calls = new ArrayList<>();
    public String left;
    public String code;
    public String signature;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(left).append(":").append(signature).append(" -> ");
        for (int i = 0; i < right.size(); ++i) {
            str.append(right.get(i));
            str.append(":").append(calls.get(i)).append(":");
            str.append(" ");
        }
        str.append(code);
        return str.toString();
    }

    public static boolean isToken(String name) {
        return Character.isLowerCase(name.charAt(0));
    }
}
