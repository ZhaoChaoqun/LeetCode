package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _804 {

    public static void main(String[] args) {
        _804 test = new _804();
        System.out.println(test.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}));
    }
    String[] array = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word : words) {
            StringBuilder sb = new StringBuilder();
            char[] chars = word.toCharArray();
            for(char c :chars) {
                sb.append(array[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
