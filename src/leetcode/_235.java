package leetcode;

import java.util.ArrayList;
import java.util.List;


public class _235 {


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        System.out.println(new _235().lowestCommonAncestor(node1, node4, node9).val);
    }


    boolean backtracking(List<TreeNode> stack, TreeNode node, TreeNode target) {
        stack.add(node);
        if(node == target) return true;
        if(node.left != null && node.val > target.val && backtracking(stack, node.left, target))
            return true;
        if(node.right != null && node.val < target.val && backtracking(stack, node.right, target))
            return true;
        stack.remove(stack.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> stack1 = new ArrayList<>();
        List<TreeNode> stack2 = new ArrayList<>();
        backtracking(stack1, root, p);
        backtracking(stack2, root, q);
        int i = 0;
        for(int size = Math.min(stack1.size(), stack2.size()); i < size && stack1.get(i) == stack2.get(i); i++);
        return stack1.get(i - 1);
    }
}
