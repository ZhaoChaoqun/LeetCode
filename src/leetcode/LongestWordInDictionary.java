package leetcode;

import java.util.Arrays;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class LongestWordInDictionary {

    public String longestWord(String[] words) {
        Arrays.sort(words);
        int maxLength = 0;
        String longestWord = null;
        for(int i = 0; i < words.length; i++) {
            if(words[i].length() == 1) {
                Object[] result = backtrack(words, i);
                String word = (String) result[0];
                if(word.length() > maxLength) {
                    maxLength = word.length();
                    longestWord = word;
                }
                i = (int) result[1] - 1;
            }
        }
        return longestWord;
    }
    private Object[] backtrack(String[] words, int previous) {
        String longestWord = words[previous];
        int length = words[previous].length() + 1;
        int i = previous + 1;
        for(; i < words.length && words[i].length() > 1; i++) {
            if(words[i].length() == length && words[i].substring(0, words[i].length() - 1).equals(words[previous])) {
                String word = (String) backtrack(words, i)[0];
                if(word.length() > longestWord.length())
                    longestWord = word;
            }
        }
        return new Object[] {longestWord, i};
    }

    public static void main(String[] args) {
        LongestWordInDictionary test = new LongestWordInDictionary();
        System.out.println(test.longestWord(new String[] {"w","wo","wor","worl", "world"}));
        System.out.println(test.longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(test.longestWord(new String[] {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"}));
        String[] words = new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        words = new String[] {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
    }
}
