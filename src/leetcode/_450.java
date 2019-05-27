package leetcode;

public class _450 {

    private TreeNode leftRotate(TreeNode node) {
        if(node.right == null)
            return rightRotate(node);
        TreeNode parent = node.right;
        for(; parent.left != null; parent = parent.left);
        parent.left = node.left;
        return node.right;
    }
    private TreeNode rightRotate(TreeNode node) {
        if(node.left == null)
            return null;
        TreeNode parent = node.left;
        for(; parent.right != null; parent = parent.right);
        parent.right = node.right;
        return node.left;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root.val == key) {
            return leftRotate(root);
        }
        if(root.val > key)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);
        return root;
    }
}
