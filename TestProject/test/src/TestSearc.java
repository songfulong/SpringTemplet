import java.util.ArrayList;

public class TestSearc {
    public static void main(String[] args) {
        //System.out.println(search(new int[]{-2,1,2}, 2));

        //getLCS("2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80","U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2");

        spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});

    }
    public static int search (int[] nums, int target) {
        int max = nums.length-1;
        int min = 0;
        for(int i =nums.length/2;min!= max;){
            if(nums[i] == target){
                if(i>=1 && nums[i-1]== target){
                    i--;
                    continue;
                }
                return i;
            }else if(nums[i]> target){
                max = i;
                i = (min + i)/2;

            }else{
                min = i;
                i = (max + i + 1)/2;

            }
        }
        return 0;
    }
    public static String getLCS (String str1, String str2) {
        // write code here
        if(str2.contains(str1)){
            return str1;
        }
        String maxStr = "";
        for(int i = 0;i<str1.length()-1 -maxStr.length();i++){
            for(int j = i+maxStr.length();j<=str1.length();j+=2){
                String temp = str1.substring(i,j);
                if(str2.contains(temp)){
                    maxStr = temp;
                }else{
                    temp = str1.substring(i,j-1);
                    if(str2.contains(temp)){
                        if(temp.length()>maxStr.length()){
                            maxStr = temp;
                        }
                    }
                    break;
                }
            }
        }
        return maxStr;
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer> ();
        if(matrix == null || matrix.length == 0){
            return res;
        }
        // 定义[x][y]
        int xMin = 0;
        int xMax = matrix.length-1;
        int yMin = 0;
        int yMax = matrix[0].length-1;
        for(int i =0; i<matrix.length/2 + 1; i++){
            // 正横
            for(int yi = yMin; yi<= yMax && yMin<yMax; yi++){
                res.add(matrix[xMin][yi]);
            }
            yMin++;
            // 正纵
            for(int xi = xMin; xi<= xMax && xMin<xMax; xi++){
                res.add(matrix[xi][yMax]);
            }
            xMax--;
            // 反横
            for(int yi = yMax; yi>= yMin && yMin<yMax; yi--){
                res.add(matrix[xMax][yi]);
            }
            yMax--;
            // 反纵
            for(int xi = xMax; xi>= xMin && xMin<xMax; xi--){
                res.add(matrix[xi][yMin]);
            }
            xMin++;
        }

        return res;
    }
}
