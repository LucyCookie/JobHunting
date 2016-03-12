import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiqu on 2/15/16.
 */
public class Clue {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        List<char[]> clues = new ArrayList<>();
        for (int i = 0; i < N; i++) clues.add(in.readLine().toCharArray());
        List<char[]> result = orderClues(clues);
        for (char[] clue : result) System.out.println(new String(clue));
    }

    static List<char[]> orderClues(List<char[]> clues) {
        int l = clues.get(0).length;
        List<char[]> ordered = new ArrayList<>();
        char pre, cur, tmp;
        if (l == 0) ordered.add("NONE".toCharArray());
        for (int i = 0; i < l; i++) {
            if (ordered.size() > 0) {
                pre = '?';
                for (int j = 0; j < ordered.size(); j++) {
                    cur = ordered.get(j)[i];
                    if (cur != '?') {
                        if (pre == '?') pre = cur;
                        else if (cur < pre) {
                            ordered.clear();
                            ordered.add("NONE".toCharArray());
                            return ordered;
                        }
                    }
                }
            }
            for (int j = 0; j < clues.size(); ) {
                cur = clues.get(j)[i];
                if (cur != '?') {
                    int k;
                    for (k = 0; k < ordered.size(); k++) {
                        pre = ordered.get(k)[i];
                        if (pre != '?' && pre > cur) break;
                    }
                    if (k < ordered.size() || k == 0 || ordered.get(k - 1)[i] != '?') {
                        ordered.add(k, clues.get(j));
                        clues.remove(j);
                    } else j++;
                } else j++;
            }
        }
        boolean added;
        for (int i = 0; i < l; i++) {
            pre = 'A';
            for (int j = 0; j < ordered.size(); j++) {
                if (ordered.get(j)[i] == '?') ordered.get(j)[i] = pre;
                else pre = ordered.get(j)[i];
            }
        }
        int cut = ordered.size(), k;
        for (int j = 0; j < clues.size(); j++) {
            added = false;
            for (int i = 0; i < l; i++) {
                cur = clues.get(j)[i];
                if (cur == '?') {
                    cur = clues.get(j)[i] = 'A';
                    for (k = 0; k < cut; k++) {
                        pre = ordered.get(k)[i];
                        if (pre > cur) {
                            cut = k;
                            break;
                        }
                    }
                    continue;
                }
                if (!added) {
                    for (k = 0; k < cut; k++) {
                        pre = ordered.get(k)[i];
                        if (pre > cur) {
                            ordered.add(k, clues.get(j));
                            added = true;
                            break;
                        }
                    }
                    if (!added && cur > 'A') {
                        ordered.add(k, clues.get(j));
                        added = true;
                    }
                }
            }
            if (!added) ordered.add(0, clues.get(j));
        }
        return ordered;
    }
}
