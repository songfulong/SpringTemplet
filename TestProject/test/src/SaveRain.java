public class SaveRain {
    public static void main(String[] args) {
        System.out.println(saveRainLeft(new int[]{3,1,2,5,2,4},1));
    }

    public static int saveRainLeft(int[] rains, int i) {
        int m = 0;
        int k = rains[0];
        int sum = 0;
        int total = 0;
        for (; i <= rains.length - 1; i++) {
            if (k <= rains[i]) {
                total += m * k - sum;
                k = rains[i];
                m = 0;
                sum = 0;
            } else {
                m++;
                sum += rains[i];
            }
        }
        if (m != 0){
            total += saveRainRight(rains, i- m - 1);
        }

        return total;
    }

    private static int saveRainRight(int[] rains, int i) {
        int m = 0;
        int k = rains[rains.length-1];
        int sum = 0;
        int total = 0;
        for (int j= rains.length - 2; j >= i; j--) {
            if (k <= rains[j]) {
                total += m * k - sum;
                k = rains[j];
                m = 0;
                sum = 0;
            } else {
                m++;
                sum += rains[j];
            }
        }
        return total;
    }

}
