/**
 * Created by qiqu on 2/20/16.
 */
public class EquilibriumIndex {
    public int solution(int[] A) {
        // write your code in Java
        int size=A.length;
        long l=0, r=0, sum=0;
        for (int i = 1; i < size; i++) {
            r+=A[i];
        }
        if (r==0) return 0;
        for (int i = 1; i < size; i++) {
            l+=A[i-1];
            r-=A[i];
            if (l==r) return i;
        }
        return -1;
    }
}
