package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _140 {

    public static void main(String[] args) {
        System.out.println(new _140().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(new _140().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new _140().wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(new _140().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    boolean backtracking(int[][] matrix, int i, int length, StringBuilder sb, String s) {
        if(i == length) {
            result.add(sb.substring(0, sb.length() - 1));
            return true;
        }
        boolean flag = false;
        int k = i;
        for(; k < length; k++) {
            if(matrix[i][k] == 1) {
                sb.append(s, i, k + 1).append(' ');
                if(!backtracking(matrix, k + 1, length, sb, s))
                    matrix[i][k] = -1;
                else
                    flag = true;
                sb.delete(sb.length() + i - k - 2, sb.length());
            }
        }
        return flag;
    }
    List<String> result = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        int[][] matrix = new int[length][length];
        for(String word : wordDict) {
            int wordSize = word.length() - 1;
            for(int index = s.indexOf(word, 0); index != -1; index = s.indexOf(word, index+1)) {
                matrix[index][index + wordSize] = 1;
            }
        }
        int i = 0;
        for(; i < length && matrix[0][i] == 0; i++);
        if(i == length) return result;
        for(i = 0; i < length && matrix[i][length - 1] == 0; i++);
        if(i == length) return result;
        backtracking(matrix, 0, length, new StringBuilder(), s);
        return result;
    }
}
