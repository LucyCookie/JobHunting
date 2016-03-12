import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by qiqu on 2/14/16.
 */
public class FingerCount {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        int weakFinger = Integer.parseInt(in.readLine());
        int count = Integer.parseInt(in.readLine());
        System.out.println(maxCount(weakFinger, count));
    }

    static int maxCount(int weakFinger, int count) {
        int max;
        if (weakFinger == 1 || weakFinger == 5) {
            max = count * 8 + weakFinger - 1;
        } else {
            max = count / 2 * 8;
            if (count % 2 == 0) max += weakFinger - 1;
            else max += 9 - weakFinger;
        }
        return max;
    }
}
