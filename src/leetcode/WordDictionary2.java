package leetcode;


public class WordDictionary2 {
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

    public WordDictionary2() {
        root = new Node();
    }

    public void addWord(String word) {
        if (word == null || "".equals(word)) return;
        char[] charArray = word.toCharArray();
        Node node = root;
        for (char character : charArray) {
            if(node.children[character - 'a'] != null) {
                node = node.children[character - 'a'];
                continue;
            }
            Node child = new Node(character);
            node.children[character - 'a'] = child;
            node = child;
        }
        node.isLeaf = true;
    }

    public boolean search(String word) {
        if (word == null || "".equals(word)) return false;
        return search(word.toCharArray(), root.children, 0);
    }

    private boolean search(char[] array, Node[] children, int current) {
        if(array[current] == '.') {
            if(current + 1 == array.length) {
                for(Node child : children) {
                    if(child != null && child.isLeaf) {
                        return true;
                    }
                }
                return false;
            }
            for(Node child : children) {
                if(child != null && search(array, child.children, current + 1)) {
                    return true;
                }
            }
        } else {
            if(children[array[current] - 'a'] == null)
                return false;
            if(current + 1 == array.length)
                if (children[array[current] - 'a'].isLeaf) return true;
                else return false;
            return search(array, children[array[current] - 'a'].children, current + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary2 wd = new WordDictionary2();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));
        System.out.println(wd.search("bad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("b.."));
    }
}