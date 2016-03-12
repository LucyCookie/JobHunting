import java.util.Stack;

/**
 * Created by qiqu on 2/19/16.
 */
public class ImageFilePath {
    int solution(String S) {
        String[] fileList = S.split("\\n");
        int level = -1, length = 0, result = 0;
        Stack<String> dir = new Stack<>();
        for (String file : fileList) {
            if (level != -1 && !(file.length() > level + 1 && file.substring(0,level+1).matches("\\s+"))) {
                while (level >= 0 && !file.substring(0,level+1).matches("\\s+")) {
                    level--;
                    String preDir = dir.pop();
                    length -= preDir.length() + 1;
                }
            }
            if (file.contains(".")) {
                if (file.contains(".jpeg") || file.contains(".png") || file.contains(".gif")) result += length;
            } else {
                dir.push(file.substring(level + 1));
                length += file.length() - level;
                level++;
            }
        }
        return result;
    }
}
