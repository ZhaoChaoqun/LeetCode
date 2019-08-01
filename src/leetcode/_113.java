package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        List<Integer> one = new ArrayList<>();
        traverse(root, 0, sum, one, result);
        return result;
    }
    private void traverse(TreeNode node, int currentVal, int sum, List<Integer> one, List<List<Integer>> result) {
        if(node != null) {
            currentVal += node.val;
            one.add(node.val);
            if(node.left == null && node.right == null) {
                if(currentVal == sum) result.add(new ArrayList<>(one));
            } else {
                traverse(node.left, currentVal, sum, one, result);
                traverse(node.right, currentVal, sum, one, result);
            }
            one.remove(one.size() - 1);
        }
    }
}
