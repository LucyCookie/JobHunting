import java.util.Stack;

/**
 * Created by qiqu on 2/20/16.
 */
public class Parenthesis {
    public boolean match(String s) {
        char[] parts = s.toCharArray();
        Stack<Character> pre = new Stack<>();
        for (char part : parts) {
            switch (part) {
                case '(':
                    pre.push(part);
                    break;
                case ')':
                    if (pre.size() == 0) return false;
                    if (pre.pop() != '(') return false;
                    break;
                case '{':
                    pre.push(part);
                    break;
                case '}':
                    if (pre.size() == 0) return false;
                    if (pre.pop() != '{') return false;
                    break;
                case '[':
                    pre.push(part);
                    break;
                case ']':
                    if (pre.size() == 0) return false;
                    if (pre.pop() != '[') return false;
                    break;
                case '<':
                    pre.push(part);
                    break;
                case '>':
                    if (pre.size() == 0) return false;
                    if (pre.pop() != '<') return false;
                    break;
            }
        }
        return pre.size() == 0;
    }
}
