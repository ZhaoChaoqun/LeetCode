package leetcode;

/**
 * Created by zhaochaoqun on 2017/6/27.
 */
public class ConvertBSTToGreaterTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode convertBST(TreeNode root) {
        if(root != null) help(0, root);
        return root;
    }

    private static int help(int base, TreeNode node) {
        if(node == null) return base;
        node.val += help(base, node.right);
        return help(node.val, node.left);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        node1 = convertBST(node1);
        System.out.println(node1);
    }
}
