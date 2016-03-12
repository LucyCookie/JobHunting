/**
 * Created by qiqu on 2/21/16.
 */
public class Compression {
    public String compress(String s){
        int num=0;
        char cur=s.charAt(0);
        String result="";
        for (char c:s.toCharArray()){
            if (c==cur) num++;
            else {
                result+=cur;
                if (num>1) result+=num;
                cur=c;
                num=1;
            }
        }
        result+=cur;
        if (num>1) result+=num;
        return result;
    }
}
