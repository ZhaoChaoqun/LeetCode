package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _392 {

    public static void main(String[] args) {
        _392 test = new _392();

        System.out.println(test.isSubsequence("abc", "ahbgdc"));
        System.out.println(test.isSubsequence("axc", "ahbgdc"));
    }
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()) return false;
        int prev = 0;
        for(int i = 0; i < s.length();i++)
        {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar,prev);
            if(prev == -1) return false;
            prev++;
        }

        return true;
    }
}
