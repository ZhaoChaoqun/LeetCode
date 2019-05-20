package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _87 {

    public static void main(String[] args) {
//        System.out.println(new _87().isScramble("great", "rgeat"));
//        System.out.println(new _87().isScramble("abcde", "caebd"));
        System.out.println(new _87().isScramble("abc", "acb"));
        System.out.println(new _87().isScramble("abcdefghij", "efghijcadb"));
    }

    Set<StringBuilder> backtracking(char[] chars, int i, int j) {
        Set<StringBuilder> sb3 = new HashSet<>();
        if(i == j) {
            sb3.add(new StringBuilder(Character.toString(chars[i])));
            return sb3;
        };
        for(int k = i; k < j; k++) {
            Set<StringBuilder> sb1 = backtracking(chars, i, k);
            Set<StringBuilder> sb2 = backtracking(chars, k + 1, j);
            for(StringBuilder item1 : sb1) {
                for (StringBuilder item2 : sb2) {
                    sb3.add(new StringBuilder(item1).append(item2));
                    sb3.add(new StringBuilder(item2).append(item1));
                }
            }
        }
        return sb3;
    }

    public boolean isScramble(String s1, String s2) {
        Set<StringBuilder> result = backtracking(s1.toCharArray(), 0, s1.length()-1);
        for(StringBuilder sb : result)
            if (s2.equals(sb.toString()))
                return true;
        return false;
    }
}
