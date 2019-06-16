import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _865 {
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
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursive(root, p, q);
        return result;
    }
    int maxDepth = 1;
    List<TreeNode> list = new ArrayList<>();
    private void recursive(TreeNode node, int depth) {
        if(node.left == null && node.right == null) {
            if(depth > maxDepth) {
                maxDepth = depth;
                list = new ArrayList<>();
                list.add(node);
            } else if(depth == maxDepth) {
                list.add(node);
            }
        }
        if(node.left != null) {
            recursive(node.left, depth + 1);
        }
        if(node.right != null)
            recursive(node.right, depth + 1);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;
        recursive(root, 1);
        if(list.size() == 1) {
            return list.get(0);
        }
        TreeNode p = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            TreeNode q = list.get(i);
            p = lowestCommonAncestor(root, p, q);
        }
        return p;
    }
}
