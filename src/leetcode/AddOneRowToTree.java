package leetcode;

/**
 * Created by zhaochaoqun on 2017/7/1.
 */
public class AddOneRowToTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            if(root.left != null) {
                TreeNode node = new TreeNode(v);
                node.left = root.left;
                root.left = node;
            }
            if(root.right != null) {
                TreeNode node = new TreeNode(v);
                node.right = root.right;
                root.right = node;
            }
        } else {
            if(root.left != null)
                addOneRow(root.left, v, d - 1);
            if(root.right != null)
                addOneRow(root.right, v, d - 1);
        }
        return root;
    }
}
