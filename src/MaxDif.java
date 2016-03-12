/**
 * Created by qiqu on 2/13/16.
 */
public class MaxDif {
    public int maxDiff(int[] a){
        int s=Integer.MAX_VALUE, l=Integer.MIN_VALUE, max=-1;
        for (int i = 0; i < a.length-1; i++) {
            s=Math.min(s, a[i]);
            l=Math.max(l, a[i+1]);
            if (s<l && l-s>max) max=l-s;
        }
        return max;
    }
}
