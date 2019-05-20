package leetcode;

public class Trie2 {
    static class Node {
        Node[] children = new Node[26];
        char value;
        boolean isLeaf = false;

        public Node() {
        }

        public Node(char value) {
            this.value = value;
        }
    }

    private Node root;


    public Trie2() {
        root = new Node();
    }


    public void insert(String word) {
        if (word == null || "".equals(word)) return;
        char[] charArray = word.toCharArray();
        Node node = root;
        for (char character : charArray) {
            if (node.children[character - 'a'] != null) {
                node = node.children[character - 'a'];
                continue;
            }
            Node child = new Node(character);
            node.children[character - 'a'] = child;
            node = child;
        }
        node.isLeaf =true;
    }


    public boolean search(String word) {
        if (word == null || "".equals(word)) return false;
        return search(word.toCharArray(), root, 0);
    }

    private boolean search(char[] array, Node node, int current) {
        if (current == array.length)
            if (node.isLeaf) return true;
            else return false;
        if(node.children[array[current] - 'a'] == null)
            return false;
        return search(array, node.children[array[current] - 'a'], current + 1);
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || "".equals(prefix)) return false;
        return startsWith(prefix.toCharArray(), root, 0);
    }

    private boolean startsWith(char[] array, Node node, int current) {
        if (current == array.length)
            return true;
        if(node.children[array[current] - 'a'] == null)
            return false;
        return startsWith(array, node.children[array[current] - 'a'], current + 1);
    }
}