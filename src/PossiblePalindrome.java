import java.util.HashSet;
import java.util.Set;

/**
 * Created by qiqu on 2/21/16.
 */
public class PossiblePalindrome {
    public boolean checkPossible(String s) {
        Set<Character> single = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (single.contains(c)) single.remove(c);
            else single.add(c);
        }
        return single.size() < 2;
    }
}
