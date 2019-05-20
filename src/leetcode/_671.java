package leetcode;

public class _671 {

    public static void main(String[] args) {
        _671 test = new _671();
        TreeNode node1 = new TreeNode((2));
        TreeNode node2 = new TreeNode((2));
        TreeNode node3 = new TreeNode((2));
        TreeNode node4 = new TreeNode((2));
        TreeNode node5 = new TreeNode((2));
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(test.findSecondMinimumValue(node1));
    }

    int backtracking(TreeNode node, int min) {
        if(node == null)
            return -1;
        if(node.val > min) {
            return node.val;
        } else {
            int left = backtracking(node.left, min);
            int right = backtracking(node.right, min);
            if(left == -1)
                return right;
            if(right == -1)
                return left;
            return Math.min(left, right);
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        return backtracking(root, root.val);
    }
}
