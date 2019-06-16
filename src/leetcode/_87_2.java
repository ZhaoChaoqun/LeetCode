package leetcode;

import java.util.Arrays;

public class _87_2 {

    public static void main(String[] args) {
        System.out.println(new _87_2().isScramble("great", "rgeta"));
        System.out.println(new _87_2().isScramble("abcde", "caebd"));
        System.out.println(new _87_2().isScramble("abc", "acb"));
        System.out.println(new _87_2().isScramble("abcdefghij", "efghijcadb"));
        System.out.println(new _87_2().isScramble("abc", "bca"));
    }


    private boolean recursive(int l1, int r1, int l2, int r2) {
        if(l1 == r1 && c1[l1] == c2[l2]) return true;
        int[] array = new int[26];
        for (int i = l1; i <= r1; i++)
            array[c1[i] - 'a']++;
        for (int i = l2; i <= r2; i++)
            array[c2[i] - 'a']--;
        for (int i = 0; i < 26; i++)
            if (array[i] != 0)
                return false;
        for (int i = 1; i <= r1 - l1; i++) {
            if (recursive(l1, l1 + i - 1, l2, l2 + i - 1)
                    && recursive(l1 + i, r1, l2 + i, r2))
                return true;
            if (recursive(l1, l1 + i - 1, r2 - i + 1, r2)
                    && recursive(l1 + i, r1, l2, r2 - i))
                return true;
        }
        return false;
    }
    char[] c1, c2;
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        return recursive(0, c1.length - 1, 0, c2.length - 1);
    }
}
