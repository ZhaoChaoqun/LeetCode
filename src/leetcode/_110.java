package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _110 {
    public boolean isBalanced(TreeNode root) {
        if(degree(root) == -1) return false;
        return true;
    }

    private int degree(TreeNode node) {
        if(node == null) return 0;
        int left = degree(node.left);
        if(left == -1) return -1;
        int right = degree(node.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
