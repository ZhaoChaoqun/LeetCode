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
public class _106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        return helper(postorder, inorder, postorder.length - 1, 0, 0);
    }

    private TreeNode helper(int[] postorder, int[] inorder, int start, int end, int level) {
        int value = postorder[start - level];
        TreeNode node = new TreeNode(value);
        int i = start;
        for(; inorder[i] != value; i--);
        if(i < start)
            node.right = helper(postorder, inorder, start, i + 1, level + 1);
        if(i > end)
            node.left = helper(postorder, inorder, i - 1, end, level);
        return node;
    }
}
