package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _99 {

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
        new _99().recoverTree(node1);
    }


    void backtracking(List<Integer> list, TreeNode node) {
        if(node.left != null) {
            backtracking(list, node.left);
        }
        list.add(node.val);
        if(node.right != null)
            backtracking(list, node.right);
    }
    void switchVal(TreeNode node, int src, int desc, int count) {
        if(node != null) {
            if(node.val == src) {
                node.val = desc;
                if(++count == 2)
                    return;
            } else if(node.val == desc) {
                node.val = src;
                if(++count == 2)
                    return;
            }
            switchVal(node.left, src, desc, count);
            switchVal(node.right, src, desc, count);
        }
    }
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        backtracking(list, root);
        Integer a = null, b = null, c = null;
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) < list.get(i-1)) {
                if(a == null) {
                    a = list.get(i-1);
                    b = list.get(i);
                } else {
                    c = list.get(i);
                }
            }
        }
        if(c == null) {
            switchVal(root, a, b, 0);
        } else {
            switchVal(root, a, c, 0);
        }
    }
}
