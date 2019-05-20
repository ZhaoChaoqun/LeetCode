package leetcode;

/**
 * Created by zhaochaoqun on 2018/1/16.
 */
public class SecondMinimumNodeInABinaryTree {


    public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public int findSecondMinimumValue(TreeNode root) {
        int minimum = recursive(root);
        if(minimum == root.val)
            return -1;
        return minimum;
    }
    private int recursive(TreeNode node) {
        if(node.left == null && node.right == null) {
            return node.val;
        }
        if(node.left.val == node.right.val) {
            int left = recursive(node.left);
            int right = recursive(node.right);
            if(left == node.left.val)
                return right;
            if(right == node.right.val)
                return left;
            return Math.min(left, right);

        }
        if(node.left.val > node.right.val) {
            int right = recursive(node.right);
            if(node.right.val != right) {
                return Math.min(node.left.val, right);
            }
            return node.left.val;
        }
        int left = recursive(node.left);
        if(node.left.val != left)
            return Math.min(node.right.val, left);
        return node.right.val;
    }

    public static void main(String[] args) {
        SecondMinimumNodeInABinaryTree test = new SecondMinimumNodeInABinaryTree();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
//        System.out.println(test.findSecondMinimumValue(node1));

        node1 = new TreeNode(2);
        node2 = new TreeNode(2);
        node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
//        System.out.println(test.findSecondMinimumValue(node1));

//[1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
        node1 = new TreeNode(1);
        node2 = new TreeNode(1);
        node3 = new TreeNode(3);
        node4 = new TreeNode(1);
        node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(1);
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(8);
        TreeNode node14 = new TreeNode(4);
        TreeNode node15 = new TreeNode(8);
        TreeNode node16 = new TreeNode(3);
        TreeNode node17 = new TreeNode(3);
        TreeNode node18 = new TreeNode(1);
        TreeNode node19 = new TreeNode(6);
        TreeNode node20 = new TreeNode(2);
        TreeNode node21 = new TreeNode(1);
        TreeNode[] array = new TreeNode[] {node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11, node12, node13, node14, node15, node16, node17, node18, node19, node20, node21};
        for(int i = array.length / 2 - 1; i >= 0; i--) {
            array[i].left = array[i * 2 + 1];
            array[i].right = array[(i + 1) * 2];
        }
        System.out.println(test.findSecondMinimumValue(node1));
    }
}
