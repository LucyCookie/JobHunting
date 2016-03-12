import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiqu on 2/20/16.
 */
public class Permutation {
    public String getPermutation(int n, long k) {
        List<Integer> ori = new ArrayList<>();
        for (int i = 0; i < n; i++) ori.add(i);
        long t = factorial(n - 1);
        String result = "";
        int digit, i = 1;
        while (ori.size() > 1) {
            digit = (int) (k / t);
            result += ori.get(digit) + " ";
            ori.remove(digit);
            k = k % t;
            t /= n - i;
            i++;
        }
        result += ori.get(0);
        return result;
    }

    private long factorial(int n) {
        long t = 1;
        for (long i = 1; i <= n; i++) t *= i;
        return t;
    }
}
