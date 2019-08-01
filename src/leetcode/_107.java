package leetcode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Collections.reverse(traverse(queue, result));
        return result;
    }
    private List<List<Integer>> traverse(Queue<TreeNode> queue, List<List<Integer>> result) {
        TreeNode node = null;
        Queue<TreeNode> newQueue = new LinkedList<>();
        List<Integer> row = new ArrayList<>();
        while(!queue.isEmpty()) {
            node = queue.poll();
            row.add(node.val);
            if(node.left != null) newQueue.offer(node.left);
            if(node.right != null) newQueue.offer(node.right);
        }
        result.add(row);
        if(newQueue.isEmpty()) return result;
        return traverse(newQueue, result);
    }
}
