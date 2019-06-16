package leetcode;

import java.util.LinkedList;

public class _430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }


    private Node dfs(Node node) {
        if(node.child != null) {
            Node right = node.next;
            node.child.prev = node;
            node.next = node.child;
            Node tail = dfs(node.child);
            node.child = null;
            if(right == null) {
                return tail;
            }
            tail.next = right;
            right.prev = tail;
            return dfs(right);
        } else {
            if(node.next == null)
                return node;
            return dfs(node.next);
        }
    }
    public Node flatten(Node head) {
        if(head == null) return null;
        dfs(head);
        return head;
    }

    public static void main(String[] args) {

    }
}
