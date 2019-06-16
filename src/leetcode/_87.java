package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _87 {

    public static void main(String[] args) {
        System.out.println(new _87().isScramble("great", "rgeta"));
        System.out.println(new _87().isScramble("abcde", "caebd"));
        System.out.println(new _87().isScramble("abc", "acb"));
        System.out.println(new _87().isScramble("abcdefghij", "efghijcadb"));
        System.out.println(new _87().isScramble("abc", "bca"));
    }



    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int[] array = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            array[s1.charAt(i) - 'a']++;
            array[s2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++)
            if(array[i] != 0)
                return false;
        for(int i = 1; i < s1.length(); i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if(isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }
}
