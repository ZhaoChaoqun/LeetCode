package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _95 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<TreeNode> generateTrees(int n) {
        if(n < 1) return Collections.emptyList();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> children = helper(start, end - 1);
        for(TreeNode child : children) {
            TreeNode node = new TreeNode(end);
            node.left = child;
            list.add(node);

            TreeNode clone = clone(child);
            TreeNode another = new TreeNode(end);
            TreeNode right = clone;
            for(; right.right != null; right = right.right);
            right.right = another;
            list.add(clone);
        }
        for(int i = 0; i <= end - start - 2; i++) {
            List<TreeNode> upList = helper(start, start + i);
            List<TreeNode> downList = helper(start + i + 1, end - 1);
            for(TreeNode upNode : upList) {
                for(TreeNode downNode : downList) {
                    TreeNode upClone = clone(upNode);
                    TreeNode downClone = clone(downNode);
                    TreeNode node = new TreeNode(end);
                    TreeNode root = upClone;
                    for(; upClone.right != null; upClone = upClone.right);
                    upClone.right = node;
                    node.left = downClone;
                    list.add(root);
                }
            }
        }
        return list;
    }

    private TreeNode clone(TreeNode node) {
        TreeNode clone = new TreeNode(node.val);
        if(node.left != null) clone.left = clone(node.left);
        if(node.right != null) clone.right = clone(node.right);
        return clone;
    }
}
