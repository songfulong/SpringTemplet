import java.util.HashSet;
import java.util.Set;

public class Main3 {
    public static void main(String[] args) {
        String str = "";
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        int max = 0;
        int tempLength = 0;
        int lastNum = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>= 0 && chars[i] <=9){
                if (chars[i] >= lastNum){
                    lastNum = chars[i];
                    tempLength ++ ;
                }else {
                    max = Math.max(tempLength, max) ;
                    tempLength = 0;
                    lastNum = -1;
                };
            }
        }
        max = Math.max(tempLength, max) ;
        System.out.print(max);
    }
}
