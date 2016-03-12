import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qiqu on 2/21/16.
 */
public class MarsColony {
    public List<Integer> findSame(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0, j=0;
        List<Integer> result=new ArrayList<>();
        while (i<a.length && j<b.length){
            if (a[i]<b[j]) i++;
            else if (a[i]>b[j]) j++;
            else {
                result.add(a[i]);
                i++;
                j++;
            }
        }
        return result;
    }
}
