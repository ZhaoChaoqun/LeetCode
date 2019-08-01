package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _94 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    private static void traverse(TreeNode node, List<Integer> result) {
        if(node != null) {
            traverse(node.left, result);
            result.add(node.val);
            traverse(node.right, result);
        }
    }
}
