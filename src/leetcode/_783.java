package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _783 {
    List<Integer> list = new ArrayList<>();
    private void traverse(TreeNode node) {
        if(node != null) {
            traverse(node.left);
            list.add(node.val);
            traverse(node.right);
        }
    }
    public int minDiffInBST(TreeNode root) {
        traverse(root);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++)
            min = Math.min(min, list.get(i) - list.get(i-1));
        return min;
    }
}
