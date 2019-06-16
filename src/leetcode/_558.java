package leetcode;

public class _558 {

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf) {
            val = _val;
            isLeaf = _isLeaf;
        }

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
    private Node recursive(Node node1, Node node2) {
        if(node1.isLeaf) {
            if(node1.val)
                return node1;
            return node2;
        }
        if(node2.isLeaf) {
            if(node2.val)
                return node2;
            return node1;
        }
        Node topLeft = recursive(node1.topLeft, node2.topLeft);
        Node topRight = recursive(node1.topRight, node2.topRight);
        Node bottomLeft = recursive(node1.bottomLeft, node2.bottomLeft);
        Node bottomRight = recursive(node1.bottomRight, node2.bottomRight);
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }
        return new Node(node1.val || node2.val, false, topLeft, topRight, bottomLeft, bottomRight);
    }
    public Node intersect(Node quadTree1, Node quadTree2) {
        return recursive(quadTree1, quadTree2);
    }
}
