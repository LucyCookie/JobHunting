import java.io.*;
import java.util.*;

/**
 * Created by qiqu on 2/14/16.
 */
public class Lock {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        String str = in.readLine();
        int L = Integer.parseInt(in.readLine());
        char[] rid = new char[L];
        Arrays.fill(rid, '0');
        String lock = str.replace(new String(rid), "");
        if (lock.length() <= L) {
            char[] test=new char[lock.length()];
            Arrays.fill(test,'0');
            if (lock.equals(new String(test))){
                System.out.println(L);
                return;
            }
            lock += new String(rid);
        }
        System.out.println(maxDistance(L, lock));
    }

    static int maxDistance(int L, String lock) {
        int o = lock.indexOf('0'), dis = Integer.MAX_VALUE;
        char target;
        for (int i = 0; i < lock.length(); i++) {
            target = lock.charAt(i);
            if (target == '0') continue;
            int next = lock.indexOf(target, i + 1);
            if (next != -1) {
                dis = Math.min(next - i, dis);
                if (dis == 1) return dis;
            }
        }
        if (o == -1) return dis;
        String tmp;
        dis = 0;
        for (int i = 1; i <= L; i++) {
            tmp = o == lock.length() - 1 ? lock.substring(0, o) + i : lock.substring(0, o) + i + lock.substring(o + 1);
            dis = Math.max(dis, maxDistance(L, tmp));
        }
        return dis;
    }
}
