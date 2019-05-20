package leetcode;

public class _124 {


    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
////        TreeNode node = new TreeNode();
//        node1.left = node2;
//        node1.right = node3;

        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(new _124().maxPathSum(node1));
    }

    int max = Integer.MIN_VALUE;
    int backtracking(TreeNode node) {
        if(node == null) return 0;
        int left = backtracking(node.left);
        int right = backtracking(node.right);
        max = Math.max(max, node.val + Math.max(0, left) + Math.max(0, right));
        return Math.max(0, node.val + Math.max(0, Math.max(left, right)));
    }
    public int maxPathSum(TreeNode root) {
        backtracking(root);
        return max;
    }
}
