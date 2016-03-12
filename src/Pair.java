import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiqu on 2/21/16.
 */
public class Pair {
    public List<int[]> getClosest(int[] a) {
        long min = 2l * Integer.MAX_VALUE + 1;
        int[] pair;
        List<int[]> result;
        Map<Long, List<int[]>> difMap = new HashMap<>();
        for (int i = 0; i < a.length - 1; i++) {
            if (Math.abs(a[i] - a[i + 1]) <= min) {
                min = Math.abs(a[i] - a[i + 1]);
                pair = new int[2];
                pair[0] = a[i];
                pair[1] = a[i + 1];
                if (difMap.containsKey(min)) {
                    result = difMap.get(min);
                    result.add(pair);
                } else {
                    result = new ArrayList<>();
                    result.add(pair);
                    difMap.put(min, result);
                }
            }
        }
        return difMap.get(min);
    }
}
