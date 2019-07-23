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
public class _98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return recursive(root.left, Long.MIN_VALUE, root.val) && recursive(root.right, root.val, Long.MAX_VALUE);
    }
    private boolean recursive(TreeNode node, long min, long max) {
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;
        return recursive(node.left, min, node.val) && recursive(node.right, node.val, max);
    }
}
