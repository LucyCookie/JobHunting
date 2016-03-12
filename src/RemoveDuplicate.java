/**
 * Created by qiqu on 2/19/16.
 */
public class RemoveDuplicate {
    int solution(int X) {
        char[] digits = (X + "").toCharArray();
        int size = digits.length, max = 0;
        for (int i = 0; i < size - 1; i++) {
            if (digits[i] == digits[i + 1])
                max = Math.max(max, Integer.parseInt(new String(digits, 0, i) + new String(digits, i + 1, size - i - 1)));
        }
        return max;
    }
}
