import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiqu on 2/19/16.
 */
public class PreToPost {
    public void preToPost(Integer[] ele, int l, int r) {
        if (l >= r - 1) return;
        int root = ele[l], m, a = l + 1, b = r;
        while (a != b) {
            m = (a + b) / 2;
            if (ele[m] < root) a = m + 1;
            else b = m;
        }
        System.arraycopy(ele, l + 1, ele, l, r - l - 1);
        ele[r - 1] = root;
        preToPost(ele, l, a - 1);
        preToPost(ele, a - 1, r - 1);
    }
}
