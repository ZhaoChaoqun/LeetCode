package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _559 {
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

    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        int max = 0;
        if(root.children != null) {
            for(Node child : root.children)
                max = Math.max(max, maxDepth(child));
        }
        return max + 1;
    }
}
