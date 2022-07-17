// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;
public class Main {
    public static int[] used = null;
    public static int max = -1;
    public static int usedNum = 0;
    public  static void dfs(int[] apple, int i ){
        if (i == apple.length - 1){
            isOk(apple);
            used[i] = 1;
            usedNum++ ;
            isOk(apple);
            used[i] = 0;
            usedNum--;
            return;
        }
        dfs(apple, i + 1);
        used[i] = 1 ;
        usedNum++ ;
        dfs(apple, i + 1);
        used[i] = 0;
        usedNum--;
    }

    private static void isOk(int[] apple) {
        if (usedNum == 0  || usedNum == used.length){
            return;
        }
        int a = 0;
        int b = 0;
        int sumA=0;
        int sumB=0;
        for (int j = 0; j < used.length; j++) {
            if (used[j] == 1){
                a ^= apple[j];
                sumA += apple[j];
            }else {
                b ^= apple[j];
                sumB += apple[j];
            }
        }
        int maxWeight = Math.max(sumA, sumB);
        if (a == b  && maxWeight > max) {
            max = maxWeight;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int [] apples = new int[total];
        for (int i = 0; in.hasNextInt(); i++) {
            apples[i] = in.nextInt();
        }
        used = new int[total];
        dfs(apples, 0);
        System.out.print(max);
    }



}