package leetcode;

public class _687 {
    public static void main(String[] args) {
        _687 test = new _687();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        System.out.println(test.longestUnivaluePath(node1));
    }
    int maxPath = 1;
    public int longestUnivaluePath(TreeNode root) {
        innerRecursion(root);
        return maxPath - 1;
    }
    private int innerRecursion(TreeNode node) {
        if(node == null)
            return 0;
        int path = 1, sumPath = 1;
        int left = innerRecursion(node.left);
        int right = innerRecursion(node.right);
        if(left > 0 && node.left.val == node.val && right> 0 && node.right.val == node.val) {
            if(left > right)
                path += left;
            else
                path += right;
            sumPath += left;
            sumPath += right;
        } else {
            if(left > 0 && node.left.val == node.val) {
                path += left;
                sumPath += left;
            }
            if(right> 0 && node.right.val == node.val) {
                path += right;
                sumPath += right;

            }
        }
        maxPath = Math.max(maxPath, sumPath);
        return path;
    }
}
