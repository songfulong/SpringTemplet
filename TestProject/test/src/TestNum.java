import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNext()){
            list.add(sc.nextLine());
            if(list.size() >= 2){
                break;
            }
        }
        sc.close();
        System.out.println(solve(list.get(0),list.get(1)));
    }
    public static String solve (String s, String t) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(int i = 1; i< Integer.MAX_VALUE; i++){
            int isOver = 0;
            int x = 0;
            int y = 0;
            if(s.length() >= i){
                x = s.charAt(s.length()-i) - '0';
                isOver++;
            }
            if(t.length() >= i){
                y = t.charAt(t.length()-i) - '0';
                isOver++;
            }
            if(x ==0 && y==0 && num ==0 && isOver ==0){
                return sb.reverse().toString();
            }
            int sum = x + y + num;
            num = sum/10;
            sb.append(sum%10);
        }
        return null;

    }
}
