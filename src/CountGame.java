import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qiqu on 2/20/16.
 */
public class CountGame {
    public List<Integer> win(int N, int K){
        List<Integer> win=new ArrayList<>();
        for (int i = 1; i <= N; i++) win.add(i);
        int cur=0;
        while (win.size()>=K){
            cur+=K;
            cur--;
            cur%=win.size();
            win.remove(cur);
        }
        return win;
    }

}
