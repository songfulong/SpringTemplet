import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test06 {


    public int diameterOfBinaryTree(TreeNode root) {
        return maxDepth(root,1) -1 ;
    }
    private static int maxDepth(TreeNode node, int n){
        if(node == null){
            return n;
        }
        n++;
        return Math.max(maxDepth(node.left,n), maxDepth(node.left,n));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (sc.hasNext())
        {
            input.add(sc.nextLine());
        }
        int m = Integer.valueOf(input.get(2));
        List<String> list = Arrays.asList(input.get(1).split(" "));
        long max = 0l;
        long sum = 0l;

        for (String l: list.subList(0,m)) {
            sum += Long.valueOf(l);
        }

        for (int k =0; k<= list.size() -m; k++)
        {
            List<String> tmp = list.subList(k,k+m);
            if(k!=0)
            {
                sum = sum + Long.valueOf(tmp.get(tmp.size()-1))- Long.valueOf(list.get(k-1));
            }
            if(max < sum)
            {
                max =sum;
            }
        }
        System.out.println(max);

       /* for (int i = 0; i< list.size();i++ )
        {
            if(i < m)
            {
                sum += Long.valueOf(list.get(i));
            }else
            {
                sum +=Integer.valueOf(list.get(i));
                sum -=Integer.valueOf(list.get(i-m));
            }
            if(max < sum)
            {
                max =sum;
            }

        }
       System.out.println(max);*/
    }

}
