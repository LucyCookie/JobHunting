import java.util.List;

/**
 * Created by qiqu on 2/28/16.
 */
public class SumWithBase {
    public String binaryAdd(String a, String b) {
        char[] aC = a.toCharArray(), bC = b.toCharArray();
        int inf = 0, aL = aC.length, bL = bC.length, tmp, aT, bT;
        String result = "";
        for (int i = 0; i < aL || i < bL; i++) {
            if (i >= aL) aT = 0;
            else aT = aC[aL - 1 - i] - '0';
            if (i >= bL) bT = 0;
            else bT = bC[bL - 1 - i] - '0';
            tmp = aT + bT + inf;
            inf = tmp / 2;
            result = tmp % 2 + result;
        }
        if (inf != 0) result = inf + result;
        return result;
    }

    public String baseAdd(String a, String b, int base) {
        char[] aC = a.toCharArray(), bC = b.toCharArray();
        int inf = 0, aL = aC.length, bL = bC.length, tmp, aT, bT;
        String result = "";
        for (int i = 0; i < aL || i < bL; i++) {
            if (i >= aL) aT = 0;
            else aT = aC[aL - 1 - i] - '0';
            if (i >= bL) bT = 0;
            else bT = bC[bL - 1 - i] - '0';
            tmp = aT + bT + inf;
            inf = tmp / base;
            result = tmp % base + result;
        }
        if (inf != 0) result = inf + result;
        return result;
    }

    public String baseListSum(List<String> list, int base) {
        int size = list.size();
        int[] ls = new int[size], ts = new int[size];
        int inf = 0, tmp, max = 0;
        char[][] cs = new char[size][];
        String result = "";
        for (int i = 0; i < size; i++) {
            cs[i] = list.get(i).toCharArray();
            ls[i] = cs[i].length;
            max = Math.max(max, ls[i]);
        }
        for (int i = 0; i < max; i++) {
            tmp = inf;
            for (int j = 0; j < size; j++) {
                if (i >= ls[j]) ts[j] = 0;
                else ts[j] = cs[j][ls[j] - 1 - i] - '0';
                tmp += ts[j];
            }
            inf = tmp / base;
            result = tmp % base + result;
        }
        while (inf != 0) {
            result = inf % base + result;
            inf /= base;
        }
        return result;
    }
}
