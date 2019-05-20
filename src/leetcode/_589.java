package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _589 {
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

    List<Integer> result = new ArrayList<>();
    private void recurse(Node node) {
        result.add(node.val);
        if(node.children != null) {
            for(Node child : node.children)
                recurse(child);
        }
    }
    public List<Integer> preorder(Node root) {
        if(root != null)
            recurse(root);
        return result;
    }
}
