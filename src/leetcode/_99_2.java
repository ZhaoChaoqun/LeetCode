package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _99_2 {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(2);
//        node1.left = node2;
//        node2.right = node3;

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        new _99_2().recoverTree(node1);
    }

    TreeNode a, b;
    TreeNode backtracking(TreeNode last, TreeNode current) {
        if(current.left != null) {
            last = backtracking(last, current.left);
        }
        if(last != null && last.val > current.val) {
            if(a == null)
                a = last;
            b = current;
        }
        last = current;
        if(current.right != null)
            last = backtracking(current, current.right);
        return last;
    }

    public void recoverTree(TreeNode root) {
        backtracking(null, root);
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
