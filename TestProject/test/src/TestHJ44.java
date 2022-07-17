import java.util.*;

/**
 * HJ44 Sudoku
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、每一个3X3粗线宫内的数字均含1-9，并且不重复。
 * 数据范围：输入一个 9*9 的矩阵
 * 输入描述：
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 *
 * 输出描述：
 * 完整的9X9盘面数组
 *
 * 示例1
 * 输入：
 * 0 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 0 4 5 2 7 6 8 3 1
 * 复制
 * 输出：
 * 5 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 9 4 5 2 7 6 8 3 1
 *
 */
public class TestHJ44 {
    public static void main(String[] args) {
        int [][] input = new int[9][9];
        List<int []> waitWrite = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                input [i][j] = in.nextInt();
                if (input [i][j] == 0){
                    waitWrite.add(new int[]{i,j});
                }
            }
        }

        getNum(input, 0, waitWrite);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean   getNum(int [][] input, int index, List<int []> waitWrite){
        if (index == waitWrite.size()){
            return true;
        }
        // 获取可选的值
        int[] pos = waitWrite.get(index);
        int x = pos[0];
        int y = pos[1];
        Set<Integer> selectInt = getSelectInt(input, x, y);
        for (int i = 1; i <= 9; i++) {
            if (selectInt.contains(i)){
                continue;
            }
            input[x][y] = i;
            if (getNum(input, index + 1, waitWrite)){
                return true;
            }
        }
        // 不满足 修改其他可用值
        input[x][y] = 0;
        return false;
    }

    private static Set<Integer> getSelectInt(int[][] input, int x, int y) {
        Set<Integer> selectInt = new HashSet<>();
        for (int i = 0; i < 9 ;i++ ){
            selectInt.add(input[x][i]);
            selectInt.add(input[i][y]);
        }
        int xHome = x / 3;
        int yHome = y / 3;
        for (int i = xHome * 3 ; i < xHome * 3 + 3; i++) {
            for (int j = yHome * 3; j < yHome * 3 + 3; j++) {
                selectInt.add(input[i][j]);
            }
        }
        return selectInt;
    }

}
