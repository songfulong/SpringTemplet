import java.util.HashMap;
import java.util.Map;

public class LC337 {

    private static Map<TreeNode, Integer> res = new HashMap<>();

    public static void main(String[] args) {
        // 选择  不选的最大

        // 不选择  选和不选的最大
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(1);
        root.right = a;
        root.left = b;
        a.left = c;
        b.left = d;
        //
        System.out.println(Math.max(getMax(root)[0], getMax(root)[1]));
    }

    public static int[] getMax(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] right = getMax(node.right);
        int[] left = getMax(node.left);

        int i = right[0] + left[0] + node.val;
        int j = Math.max(right[0], right[1]) +
                Math.max(left[0], left[1]);
        return new int[]{i, j};
    }


    public static void is(TreeNode node) {
        if (compare(node.left, node.right)) {

        }

    }

    public static boolean compare(TreeNode nodea, TreeNode nodeb) {
        if (nodea == null && nodeb == null) {
            return true;
        }
        if (nodea.val != nodeb.val) {
             return compare(nodea, nodeb.right) || compare(nodea, nodeb.left);
        }

        return compare(nodea.left, nodeb.left) && compare(nodea.right, nodeb.right);
        }
}
