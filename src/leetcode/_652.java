package leetcode;

import java.util.*;

public class _652 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int index;

        TreeNode(int x, int index) {
            val = x;
            this.index = index;
        }
    }
    Map<String, TreeNode> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    List<TreeNode> result = new ArrayList<>();
    private String traverse(TreeNode node) {
        if(node == null) return "#";
        String s = node.val + "," + traverse(node.left) + "," + traverse(node.right);
        if(map.containsKey(s) && !set.contains(s)) {
            result.add(node);
            set.add(s);
        }
        map.put(s, node);
        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null) return result;
        traverse(root);
        return result;
    }
}
