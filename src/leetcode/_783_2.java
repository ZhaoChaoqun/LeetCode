package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _783_2 {
    private int[] traverse(TreeNode node) {
        if (node.left == null && node.right == null)
            return new int[]{node.val, node.val, Integer.MAX_VALUE};
        int[] left, right;
        if (node.left == null && node.right != null) {
            right = traverse(node.right);
            return new int[]{node.val, right[1], Math.min(right[2], right[0] - node.val)};
        }
        if (node.left != null && node.right == null) {
            left = traverse(node.left);
            return new int[]{left[0], node.val, Math.min(left[2], node.val - left[1])};
        }
        left = traverse(node.left);
        right = traverse(node.right);
        int min = Math.min(left[2], right[2]);
        return new int[]{left[0], right[1], Math.min(min, Math.min(node.val - left[1], right[0] - node.val))};

    }

    public int minDiffInBST(TreeNode root) {
        return traverse(root)[2];
    }
}
