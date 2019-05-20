package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _590 {
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
        if(node.children != null) {
            for(Node child : node.children)
                recurse(child);
        }
        result.add(node.val);
    }
    public List<Integer> postorder(Node root) {
        if(root != null)
            recurse(root);
        return result;
    }
}
