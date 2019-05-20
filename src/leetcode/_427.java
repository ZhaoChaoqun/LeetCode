package leetcode;

public class _427 {
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    private Node recursive(int m, int n, int length) {
        if(length == 1)
            return new Node(grid[m][n] == 1, true, null, null, null, null);
        Node topLeft = recursive(m, n, length >> 1);
        Node topRight = recursive(m, n + (length >> 1), length >> 1);
        Node bottomLeft = recursive(m + (length >> 1), n, length >> 1);
        Node bottomRight = recursive(m + (length >> 1), n + (length >> 1), length >> 1);
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
    int[][] grid;
    int length;
    public Node construct(int[][] grid) {
        this.grid = grid;
        this.length = grid.length;
        return recursive(0, 0, length);
    }
}
