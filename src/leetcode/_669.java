package leetcode;

public class _669 {


    public static void main(String[] args) {
        _669 test = new _669();
        TreeNode node1 = new TreeNode((1));
        TreeNode node2 = new TreeNode((0));
        TreeNode node3 = new TreeNode((2));
        node1.left = node2;
        node1.right = node3;
        System.out.println(test.trimBST(node1, 1, 2));
    }

    TreeNode backtracking(TreeNode node, int L, int R) {
        if(node == null) return null;
        node.left = backtracking(node.left, L, R);
        node.right = backtracking(node.right, L, R);
        if(node.val < L) {
            return node.right;
        } else if(node.val > R) {
            return node.left;
        }
        return node;

    }
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return backtracking(root, L, R);
    }
}
