package leetcode;

import java.util.ArrayList;
import java.util.List;


public class _236_2 {


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
        System.out.println(new _236_2().lowestCommonAncestor(node1, node4, node9).val);
    }


//    TreeNode backtracking(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null) return null;
//        if (root == p || root == q)
//            return root;
//        TreeNode left = backtracking(root.left, p, q);
//        TreeNode right = backtracking(root.right, p, q);
//        if(left != null && right != null)
//            return root;
//        return left == null ? right : left;
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)
            return root;
        return left == null ? right : left;
    }
}
