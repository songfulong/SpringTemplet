import java.util.*;

public class TestTree {

    public static void main(String[] args) {
        // zhiTree();
        System.out.println(findParent(getTree(), 9, 3));

    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        if (pre == null ||pre.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int index = 0;
        for (int i = 0; i < vin.length; i++) {
            if (pre[0] == vin[i]){
                index = i;
                break;
            }
        }
        int[] leftVin = Arrays.copyOfRange(vin, 0, index);
        int[] rightVin = Arrays.copyOfRange(vin, index + 1, vin.length);
        int[] leftPre = Arrays.copyOfRange(pre, 1, index + 1);
        int[] rightPre = Arrays.copyOfRange(pre, index + 1, pre.length);
        root.left = reConstructBinaryTree(leftPre,leftVin);
        root.right = reConstructBinaryTree(rightPre,rightVin);
        return root;
    }



    private static void zhiTree() {
        Map<Integer, List<Integer>> stackMap = new HashMap<>();
        printTree(getTree(), 0, stackMap);
        for (int i = 0; i < stackMap.size(); i++) {
            List<Integer> stack = stackMap.get(i);
            if (i % 2 == 1) {
                Collections.reverse(stack);
            }
            stack.forEach(System.out::println);
        }
    }

    public static int findParent(TreeNode treeNode, int a, int b) {
        if (treeNode == null) {
            return -1;
        }
        Map<Integer, Integer> dataMap = new HashMap<>();
        findParent(treeNode, dataMap);
        Stack<Integer> aParent = getParents(dataMap, a);
        Stack<Integer> bParent = getParents(dataMap, b);
        int least = -1;
        while (!aParent.empty() && !bParent.empty()) {
            int aTemp = aParent.pop();
            if (aTemp != bParent.pop()) {
                return least;
            }
            least = aTemp;
        }
        return least;
    }

    private static Stack<Integer> getParents(Map<Integer, Integer> dataMap, int temp) {
        Stack<Integer> parents = new Stack<>();
        parents.push(temp);
        while (dataMap.containsKey(temp)) {
            temp = dataMap.get(temp);
            parents.push(temp);
        }
        return parents;
    }

    public static void findParent(TreeNode treeNode, Map<Integer, Integer> dataMap) {
        if (treeNode.right != null) {
            dataMap.put(treeNode.right.val, treeNode.val);
            findParent(treeNode.right, dataMap);
        }
        if (treeNode.left != null) {
            dataMap.put(treeNode.left.val, treeNode.val);
            findParent(treeNode.left, dataMap);
        }
    }


    public static void printTree(TreeNode treeNode, int level, Map<Integer, List<Integer>> stackMap) {
        if (treeNode == null) {
            return;
        }
        stackMap.computeIfAbsent(level, key -> new Stack<>()).add(treeNode.val);
        printTree(treeNode.left, level + 1, stackMap);
        printTree(treeNode.right, level + 1, stackMap);
    }

    private static TreeNode getTree() {
        TreeNode t0 = new TreeNode(9);
        TreeNode t01 = new TreeNode(5);
        TreeNode t02 = new TreeNode(16);
        t0.left = t01;
        t0.right = t02;
        TreeNode t11 = new TreeNode(3);
        TreeNode t12 = new TreeNode(6);
        t01.left = t11;
        t01.right = t12;
        TreeNode t21 = new TreeNode(12);
        TreeNode t22 = new TreeNode(20);
        t02.left = t21;
        t02.right = t22;
        TreeNode t0301 = new TreeNode(1);
        TreeNode t0302 = new TreeNode(4);
        TreeNode t0303 = new TreeNode(8);
        TreeNode t0304 = new TreeNode(18);
        TreeNode t0305 = new TreeNode(25);
        t11.left = t0301;
        t11.right = t0302;
        t12.right = t0303;
        t22.left = t0304;
        t22.right = t0305;
        return t0;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}