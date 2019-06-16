package leetcode;

public class Codec {

    static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeRecursive(root, sb);
        return sb.toString();
    }

    private void serializeRecursive(TreeNode node, StringBuilder sb) {
        if(node == null) return;
        sb.append(node.val).append(",");
        serializeRecursive(node.left, sb);
        serializeRecursive(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("".equals(data)) return null;
        String[] valuesStr = data.split(",");
        int[] values = new int[valuesStr.length];
        for(int i = 0; i < values.length; i++)
            values[i] = Integer.valueOf(valuesStr[i]);
        return deserializeRecursive(values, 0, values.length - 1);
    }
    private TreeNode deserializeRecursive(int[] values, int start, int end) {
        if(start > end) return null;
        int i = start + 1;
        for(; i <= end && values[i] < values[start]; i++);
        TreeNode root = new TreeNode(values[start]);
        root.left = deserializeRecursive(values, start + 1, i - 1);
        root.right = deserializeRecursive(values, i, end);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.right = node8;
        node7.left = node9;
        Codec test = new Codec();
        System.out.println(test.serialize(null));
//        TreeNode root = test.deserialize(test.serialize(node1));
//        System.out.println(root);
    }
}
