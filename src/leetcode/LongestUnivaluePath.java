package leetcode;

/**
Created by zhaochaoqun on 2017/12/18.
 */
public class LongestUnivaluePath {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int maxPath = 1;
    public int longestUnivaluePath(TreeNode root) {
        innerRecursion(root);
        return maxPath - 1;
    }
    private int innerRecursion(TreeNode node) {
        if(node == null)
            return 0;
        int path = 1;
        int left = innerRecursion(node.left);
        int right = innerRecursion(node.right);
        if(left > 0 && node.left.val == node.val)
            path += left;
        if(right> 0 && node.right.val == node.val)
            path += right;
        maxPath = Math.max(maxPath, path);
        return path;
    }

    public static void main(String[] args) {
        LongestUnivaluePath test = new LongestUnivaluePath();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        System.out.println(test.longestUnivaluePath(node1));

        test.maxPath = 1;
        node1 = new TreeNode(1);
        node2 = new TreeNode(4);
        node3 = new TreeNode(5);
        node4 = new TreeNode(4);
        node5 = new TreeNode(4);
        node6 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        System.out.println(test.longestUnivaluePath(node1));
        test.maxPath = 1;
        System.out.println(test.longestUnivaluePath(null));
    }
}
