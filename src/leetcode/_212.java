package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _212 {

    public static void main(String[] args) {
//        System.out.println(new _212().findWords(new char[][]{
//                {'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}
//        }, new String[]{"oath","pea","eat","rain"}));
//        System.out.println(new _212().findWords(new char[][]{"bbaaba".toCharArray(), "bbabaa".toCharArray(), "bbbbbb".toCharArray(), "aaabaa".toCharArray(), "abaabb".toCharArray()}, new String[]{"aabbaaabaaabaabaaaaaabbaaaba"}));
//        System.out.println(new _212().findWords(new char[][]{"a".toCharArray(), "a".toCharArray()}, new String[]{"aa"}));
//        System.out.println(new _212().findWords(new char[][]{"bbaaba".toCharArray(), "bbabaa".toCharArray(), "bbbbbb".toCharArray(), "aaabaa".toCharArray(), "abaabb".toCharArray()}, new String[] {"abbbababaa"}));
        System.out.println(new _212().findWords(new char[][]{"ab".toCharArray(), "aa".toCharArray()}, new String[] {"aaab","aaa","aaaa","aaba"}));
    }

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
            }
            node.isLeaf = true;
        }
    }
    int m, n;
    void backtracking(char[][] board, int[][] visit, int i, int j, StringBuilder sb, TrieNode node, Set<String> result) {
//        对应单元格的字符已使用过
        if(visit[i][j] == 1)
            return;
        sb.append(board[i][j]);
        if(node.isLeaf) {
            result.add(sb.toString());
        }
        visit[i][j] = 1;

        if(i > 0 && node.children[board[i-1][j] - 'a'] != null) {
            backtracking(board, visit, i - 1, j, sb, node.children[board[i-1][j] - 'a'], result);
        }
        if(i < m -1 && node.children[board[i+1][j] - 'a'] != null) {
            backtracking(board, visit, i + 1, j, sb, node.children[board[i+1][j] - 'a'], result);
        }
        if(j > 0 && node.children[board[i][j-1] - 'a'] != null) {
            backtracking(board, visit, i, j-1, sb, node.children[board[i][j-1] - 'a'], result);
        }
        if(j < n -1 && node.children[board[i][j+1] - 'a'] != null) {
            backtracking(board, visit, i, j+1, sb, node.children[board[i][j+1] - 'a'], result);
        }
        visit[i][j] = 0;
        sb.deleteCharAt(sb.length()-1);
    }
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        int[][] visit;
        TrieNode root = new TrieNode();
        for(String word : words)
            root.insert(word);
        Set<String> result = new HashSet<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(root.children[board[i][j] - 'a'] != null) {
                    visit = new int[m][n];
                    backtracking(board, visit, i, j, new StringBuilder(), root.children[board[i][j] - 'a'], result);
                }
            }
        }
        List<String> list = new ArrayList<>(result.size());
        list.addAll(result);
        return list;
    }
}
