import java.util.*;

/**
 * 描述
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 例如，当输入5时，应该输出的三角形为：
 *
 * 1 3 6 10 15
 *
 * 2 5 9 14
 *
 * 4 8 13
 *
 * 7 12
 *
 * 11
 *
 *
 * 输入描述：
 * 输入正整数N（N不大于100）
 *
 * 输出描述：
 * 输出一个N行的蛇形矩阵。
 *
 * 示例1
 * 输入：
 * 4
 * 复制
 * 输出：
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 *
 */
public class TestHJ35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] out = getNum(in.nextInt());

        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[i].length; j++) {
                System.out.print(out[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][]  getNum(int level){
        int[][] out = new int[level][];
        for (int i = 0; i < level; i++) {
            out[i] = new int[level - i];
        }
        int i = 0;
        for (int j = 0; j < level; j++) {
            for (int k = 0; k <= j; k++) {
                out[k][level-k] = i++;
            }
        }
        // 00 10 01  20  11  02
        return out;
    }


}
