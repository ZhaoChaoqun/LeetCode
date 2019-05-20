package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {

    }
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() > 0) {
            List<Integer> level = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                root = queue.poll();
                level.add(root.val);
                if(root.children != null)
                    queue.addAll(root.children);

            }
            result.add(level);
        }

        return result;
    }
}
