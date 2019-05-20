package leetcode;

/**
 * Created by zhaochaoqun on 2017/6/9.
 */
public class MaximumXorOfTwoNumbersInAnArray {
//    static class Node {
//        Node[] children = new Node[2];
//        char value;
//        boolean isLeaf = false;
//
//        public Node() {
//        }
//
//        public Node(char value) {
//            this.value = value;
//        }
//    }
//
//    private Node root = new Node();
//
//    public void insert(int num) {
//        Integer.toBinaryString(num);
//        if (word == null || "".equals(word)) return;
//        char[] charArray = word.toCharArray();
//        Node node = root;
//        for (char character : charArray) {
//            if (node.children[character - '0'] != null) {
//                node = node.children[character - '0'];
//                continue;
//            }
//            Node child = new Node(character);
//            node.children[character - '0'] = child;
//            node = child;
//        }
//        node.isLeaf =true;
//    }
//
//
//    public boolean search(String word) {
//        if (word == null || "".equals(word)) return false;
//        return search(word.toCharArray(), root, 0);
//    }
//
//    private boolean search(char[] array, Node node, int current) {
//        if (current == array.length)
//            if (node.isLeaf) return true;
//            else return false;
//        if(node.children[array[current] - '0'] == null)
//            return false;
//        return search(array, node.children[array[current] - '0'], current + 1);
//    }
//    public int findMaximumXOR(int[] nums) {
//
//    }
}
