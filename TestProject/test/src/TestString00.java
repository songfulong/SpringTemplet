public class TestString00 {

    public static void main(String[] args) {
        //System.out.println(longestCommonPrefix(new String[]{"abca", "abc", "abca", "abc", "abcc"}));
        System.out.println(LIS(new int[]{7,8,9,1,2,3,4,10,11,5,6}));
    }
    public static int[] LIS (int[] arr) {
        int n  = arr.length;
        int[] tail = new int[n + 1];
        // tail[i]是个辅助数组，tail[i]存储LIS长度为i的最小结尾数字
        tail[0] = Integer.MIN_VALUE;
        int end = 0;
        //dp[i]表示以arr[i]结尾的最长递增子序列长度
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (num > tail[end]) {
                end++;
                tail[end] = num;
                dp[i] = end;
            } else {
                // 在tail中找第一个大于num的数字
                int left = 1; int right = end;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tail[mid] < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = num;
                // dp[i]表示i位置最长序列
                dp[i] = left;

            }

        }
        //System.out.println(Arrays.toString(dp));
        // 字典序最小:若dp[i] = dp[j], i < j 那么一定有arr[j] < arr[i]
        int[] res = new int[end];
        int len = end;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == len) {
                res[len - 1] = arr[i];
                len--;
            }
        }
        return res;
    }
    public static String longestCommonPrefix(String[] strs) {
        // write code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        char[][] data = new char[strs.length][];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            data[i] = strs[i].toCharArray();
            if (min > data[i].length) {
                min = data[i].length;
            }
        }
        int left = 0;
        int right = min-1;
        int mid;
        k:
        while (true) {
            mid = (left + right) / 2 + 1;
            if (right <= left) {
                break;
            }
            char s = data[0][mid];
            for (char[] strData : data) {
                if (s != strData[mid]) {
                    right = mid;
                    continue k;
                }
            }
            left = mid;
        }

        return strs[0].substring(0, mid);
    }

}
