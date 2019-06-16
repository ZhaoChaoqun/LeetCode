public class _236 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private boolean recursive(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return false;
        boolean result = false;
        if(node.val == p.val)
            result = true;
        if(node.val == q.val)
            result = true;
        boolean left = recursive(node.left, p, q);
        if(result && left)
            this.result = node;
        boolean right = recursive(node.right, p, q);
        if((result || left) && right)
            this.result = node;
        return result || left || right;
    }
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursive(root, p, q);
        return result;
    }

    public static void main(String[] args) {
        
    }
}
