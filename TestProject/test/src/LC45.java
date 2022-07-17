import java.util.*;
import java.util.stream.Stream;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳3步到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC45 {
    public static void main(String[] args) {
       // System.out.println(getStep(new int[]{1,1,1,1}));
        //System.out.println(getStep(new int[]{2,3,1,1,4}));
       // System.out.println(getStep(new int[]{1,2}));
       // System.out.println(getStep(new int[]{2,9,6,5,7,0,7,2,7,9,3,2,2,5,7,8,1,6,6,6,3,5,2,2,6,3}));
        //[2],  [9]  ,6,5,7 ,0,7,2, 7,[9],  3,2,2,5,7,8,1,6,[6],  6,3,5,2,2,6,3

        System.out.println(minFallingPathSum(new int[][]{{2,1,3}, {6,5,4}, {7,8,9}}));
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        System.out.println(minimumTotal(Arrays.asList(Arrays.asList(2),Arrays.asList(3,4),Arrays.asList(6,5,7),Arrays.asList(4,1,8,3))));
        System.out.println(minimumTotal(Arrays.asList(Arrays.asList(-10))));

    }
    private static int getStep(int[] nums){
        if (nums == null || nums.length <= 1){
            return 0;
        }
        // 每一步,选择最优解
        // nums[i]  + i == max
        //结束条件 -->任一跳跃到达最末值
        // i + nums[i]>= nums.length -1
        // 每次选出一个最大值,然后从最大值里选择一段距离, 这段距离选择最大值,
        int max = 0;
        int input = -1;
        Queue<Integer> result = new ArrayDeque<>(nums.length);
        for (int i = 0, reset = 0; i < nums.length; i++) {
            if (i + nums[i] >= nums.length -1){
                result.offer(nums[i]);
                break;
            }
            if (i == 0){
                result.offer(nums[0]);
                reset = result.peek();
                continue;
            }
            reset--;
            if (nums[i]  + i > max){
                max = nums[i]  + i;
                input = i;
            }
            if (reset == 0){
                result.offer(nums[input]);
                reset = nums[input] - (i - input);
                input = -1;
                max = 0;
            }
        }
        return result.size();
    }


    // 找最大值, 添加到queue中  (array, 开始index ,长度 , 对列)
    // 返回最大index,
    //

    public static int minFallingPathSum(int[][] matrix) {
        // dp[n][n] = n,n最小
        // dp[n][n] = matrix[n][n] + Max(dp[n-1][n-1], dp[n-1][n],dp[n-1][n+1])
        // dp[0][n] = matrix[0][n]
        int[][] dp = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int[] oneRow = matrix[i];
            for (int j = 0; j < oneRow.length; j++) {
                if (i== 0){
                    dp[i][j] = oneRow[j];
                }else {
                    if (j==0){
                        dp[i][j] = oneRow[j] + Math.min(dp[i-1][j+1], dp[i-1][j]);
                    }else if (j== oneRow.length-1){
                        dp[i][j] = oneRow[j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                    }else {
                        dp[i][j] = oneRow[j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
                    }
                }
            }
        }
        return  Arrays.stream(dp[matrix.length-1]).min().getAsInt();
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        // dp[0][0] = n,n最小
        // dp[n][n] = matrix[n][n] + Max(dp[n-1][n], dp[n-1][n+1])
        // dp[n][n] = matrix[n][n]
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = triangle.size()-1; i >=0; i--) {
            List<Integer> oneRow = triangle.get(i);
            for (int j = 0; j < oneRow.size(); j++) {
                if (i== triangle.size()- 1 ){
                    dp[i][j] = oneRow.get(j);
                }else {
                    dp[i][j] = oneRow.get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }


    public int[][] updateMatrix(int[][] mat) {
        int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int boundaryForY = mat[0].length;
        int boundaryForX = mat.length;
        Queue<int[]> searchQueue = new ArrayDeque<>();
        for (int i = 0; i < boundaryForX; i++) {
            int[] oneRow = mat[i];
            for (int j = 0; j < boundaryForY; j++) {
                if (oneRow[j] == 0) {
                    searchQueue.offer(new int[]{i, j});
                    // 标记已使用
                    oneRow[j] = 2;
                }
            }

        }
        int[][] result = new int[boundaryForX][boundaryForY];
        int distance = 0;
        while (!searchQueue.isEmpty()) {
            int size = searchQueue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] index = searchQueue.poll();
                int x = index[0];
                int y = index[1];
                for (int j = 0; j < move.length; j++) {
                    int moveForX = x + move[j][0];
                    int moveForY = y + move[j][1];
                    // 边界
                    if (moveForX >= 0 && moveForX < boundaryForX && moveForY >= 0 && moveForY < boundaryForY
                            // 跳过已使用,只找未使用状态
                            && mat[moveForX][moveForY] == 1) {
                        searchQueue.offer(new int[]{moveForX, moveForY});
                        result[moveForX][moveForY] = distance;
                        // 标记已使用
                        mat[moveForX][moveForY] = 2;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
     *
     * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     *
     * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     *
     * 注意：不允许旋转信封。
     *
     *  
     * 示例 1：
     *
     * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
     * 输出：3
     * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxEnvelopes(int[][] envelopes) {
      
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1]: o1[0] - o2[0]);

        return 0;
    }

}
