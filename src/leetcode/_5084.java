package leetcode;

public class _5084 {


    private boolean recursive(TreeNode node, int limit, int sum) {
        if(node == null) return true;
        if(node.left == null && node.right == null) {
            if(sum + node.val < limit)
                return true;
            return false;
        }
        boolean left = recursive(node.left, limit, sum + node.val);
        boolean right = recursive(node.right, limit, sum + node.val);
        if(left)
            node.left = null;
        if(right)
            node.right = null;
        if(left && right) {
            return true;
        }
        return false;
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean result = recursive(root, limit, 0);
        if(result)
            return null;
        return root;
    }
}
