package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class LongestWordInDictionary2 {

    class TrieTree {
        char value;
        List<TrieTree> children = new ArrayList<>();
        TrieTree(char value) {
            this.value = value;
        }

        int add(String word, int index) {
            for(TrieTree child : children) {
                if (child.value == word.charAt(index)) {
                    return child.add(word, index + 1);
                }
            }
            if (index + 1 < word.length() || index == word.length())
                return 0;
            children.add(new TrieTree(word.charAt(index)));
            return index + 1;
        }
    }
    public String longestWord(String[] words) {
        Arrays.sort(words);
        int maxLength = 0;
        String longestWord = null;
        TrieTree root = new TrieTree((char) 0);
        for(int i = 0; i < words.length; i++) {
            int index = root.add(words[i], 0);
            if(index > maxLength) {
                maxLength = index;
                longestWord = words[i];
            }
        }
        return longestWord;
    }



    public static void main(String[] args) {
        LongestWordInDictionary2 test = new LongestWordInDictionary2();
        System.out.println(test.longestWord(new String[] {"w","wo","wor","worl", "world"}));
        System.out.println(test.longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(test.longestWord(new String[] {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"}));
        String[] words = new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        words = new String[] {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
    }
}
