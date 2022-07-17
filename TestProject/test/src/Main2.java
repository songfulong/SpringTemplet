// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] apples = in.nextLine().split(",");
        int length = 0;
        int ok = Integer.valueOf(in.nextLine());
        int sum =0;
        List<int[]> indexs = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < apples.length; i++) {
            if (Integer.valueOf(apples[i]) < Integer.valueOf(apples[i-1])){
                indexs.add(new int[]{start, i-1});
                start = i;
            }
        }
        indexs.add(new int[]{start, apples.length-1});
        for (int[] index : indexs) {
            out:
            for (int j = index[0]; j <= index[1]; j++) {
                for (int i = j; i < index[1]; i++) {
                    sum += Integer.valueOf(apples[i]);
                    if (sum == ok) {
                        length = Math.max(length, i - j + 1);
                        sum = 0;
                        continue out;
                    } else if (sum > ok) {
                        sum = 0;
                        break;
                    }
                }
            }
        }
        System.out.print(length == 0 ? -1 : length);
    }
}