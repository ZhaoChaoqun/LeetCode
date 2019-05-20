package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    static TreeNode node1 = new TreeNode(0,1);
    static TreeNode node2 = new TreeNode(0,2);
    static TreeNode node3 = new TreeNode(0,3);
    static TreeNode node4 = new TreeNode(0,4);
    static TreeNode node5 = new TreeNode(0,5);
    static TreeNode node6 = new TreeNode(0,6);
    static TreeNode node7 = new TreeNode(0,7);
    static TreeNode node8 = new TreeNode(0,8);
    static TreeNode node9 = new TreeNode(0,9);
    
    public static void main(String[] args) {
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;
        node5.left = node8;
        node5.right = node9;
        List<TreeNode> duplicateSubtrees = new _652().findDuplicateSubtrees(node1);
        System.out.println(duplicateSubtrees);

    }

    private void traverse(TreeNode node, StringBuilder sb) {
        if(node == null) return;
        traverse(node.left, sb);
        sb.append(node.val);
        traverse(node.right, sb);
    }
    Set<String> set = new HashSet<>();
    private boolean isEqual(TreeNode left, TreeNode right) {
        if(left != null && right != null) {
            if(left.val == right.val) {
                if(isEqual(left.left, right.left))
                    if(isEqual(left.right, right.right)) {
                        StringBuilder sb = new StringBuilder();
                        traverse(left, sb);
                        if(!set.contains(sb.toString())) {
                            set.add(sb.toString());
                            result.add(left);
                        }
                        return true;
                    }
            }
            return false;
        } else if(left == null && right == null) {
            return true;
        }
        return false;
    }
    List<TreeNode> result = new ArrayList<>();

    private boolean backtracking(TreeNode left, TreeNode right) {
        if(left == null || right == null)
            return false;
        if(isEqual(left, right) || backtracking(left, right.left) || backtracking(left, right.right))
            return true;
        return false;
    }
    private void bb(TreeNode left, TreeNode right) {
        if(left == null) return;
        if(!backtracking(left, right)) {
            bb(left.left, right);
            bb(left.right, right);
        }
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null)
            return result;
        bb(root.left, root.right);
        return result;
    }
}
