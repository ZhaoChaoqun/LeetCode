package leetcode;

public class Trie {
//    private Node root;
//    /** Initialize your data structure here. */
//    public Trie() {
//        root = new Node();
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        if (word == null || "".equals(word)) return;
//        char[] charArray = word.toCharArray();
//        Node node = root;
//        outer:
//        for (char character : charArray) {
//            for(Node child : node.children) {
//                if(character == child.value) {
//                    node = child;
//                    continue outer;
//                }
//            }
//            Node child = new Node(character);
//            node.children.add(child);
//            node = child;
//        }
//        node.isLeaf = true;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        if (word == null || "".equals(word)) return false;
//        return search(word.toCharArray(), root, 0);
//    }
//
//    private boolean search(char[] array, Node node, int current) {
//        if(current == array.length)
//            if (node.isLeaf) return true;
//            else return false;
//        for(Node child : node.children) {
//            if(array[current] == child.value) {
//                if(search(array, child, current + 1))
//                    return true;
//                return false;
//            }
//        }
//        return false;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        if (prefix == null || "".equals(prefix)) return false;
//        return startsWith(prefix.toCharArray(), root, 0);
//    }
//    private boolean startsWith(char[] array, Node node, int current) {
//        if(current == array.length)
//            return true;
//        for(Node child : node.children) {
//            if(array[current] == child.value) {
//                if(startsWith(array, child, current + 1))
//                    return true;
//                return false;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Trie obj = new Trie();
//        obj.insert("ab");
//        System.out.println(obj.search("a"));
//        System.out.println(obj.startsWith("a"));
//    }
}
