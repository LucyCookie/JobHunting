import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by qiqu on 2/20/16.
 */
public class TreeGraph {
    public boolean isTree(Map<String, String> edges) {
        Set<String> visited = new HashSet<>();
        String one, two;
        for (Map.Entry<String, String> entry : edges.entrySet()) {
            one = entry.getKey();
            two = entry.getValue();
            if (visited.contains(one) && visited.contains(two)) return false;
            if (!visited.contains(one)) visited.add(one);
            if (!visited.contains(two)) visited.add(two);
        }
        return true;
    }
}
