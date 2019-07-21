package leetcode;

import java.util.LinkedList;

public class _117 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        for(; !queue.isEmpty();) {
            Node prev = null;
            for(int i = 0, length = queue.size(); i < length; i++) {
                Node node = queue.poll();
                if(prev != null) {
                    prev.next = node;
                }
                prev = node;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                queue.add(node.right);
            }
        }
        return root;
    }
}
