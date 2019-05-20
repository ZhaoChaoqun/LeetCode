package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class LongestWordInDictionary3 {

    class TrieTree {
        TrieTree[] children = new TrieTree[26];

        int add(String word, int index) {
            if(word.length() == index)
                return 0;
            if(children[word.charAt(index) - 'a'] != null)
                return children[word.charAt(index) - 'a'].add(word, index + 1);
            if (index + 1 < word.length())
                return 0;
            children[word.charAt(index) - 'a'] = new TrieTree();
            return index + 1;
        }
    }
    public String longestWord(String[] words) {
        Arrays.sort(words);
        int maxLength = 0;
        String longestWord = null;
        TrieTree root = new TrieTree();
        int previous = -1;
        for(int i = 0; i < words.length; i++) {
            if(previous == 0 && words[i].length() >= words[i-1].length() && words[i].substring(0, words[i - 1].length()).equals(words[i - 1]))
                continue;
            int index = root.add(words[i], 0);
            previous = index;
            if(index > maxLength) {
                maxLength = index;
                longestWord = words[i];
            }
        }
        return longestWord;
    }



    public static void main(String[] args) {
        LongestWordInDictionary3 test = new LongestWordInDictionary3();
        System.out.println(test.longestWord(new String[] {"w","wo","wor","worl", "world"}));
        System.out.println(test.longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(test.longestWord(new String[] {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"}));
        String[] words = new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        words = new String[] {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
    }
}
