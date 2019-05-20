package leetcode;

import java.util.List;

public class _30 {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf = false;

        void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode node = this;
            for(int i = 0; i < chars.length; i++) {
                if(node.children[chars[i] - 'a'] == null)
                    node.children[chars[i] - 'a'] = new TrieNode();
                node = node.children[chars[i] - 'a'];
                if(i == chars.length - 1)
                    node.isLeaf = true;

            }

        }
    }
    public static void main(String[] args) {

    }

    public List<Integer> findSubstring(String s, String[] words) {
        for(String word : words) {

        }
        return null;
    }
}
