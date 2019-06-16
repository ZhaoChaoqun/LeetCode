package leetcode;


import java.util.HashSet;
import java.util.Set;

public class _395 {

    public static void main(String[] args) {

    }
    public int longestSubstring(String s, int k) {
        char[] c = s.toCharArray();
        int[] frequency = new int[26];
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < c.length; i++) {
            if(++frequency[c[i] - 'a'] == k)
                set.add(c[i]);
        }
        int max = 0;
        for(int left = 0, right = 0; right < c.length; right++) {
            if(set.contains(c[right])) {

            } else {
                if(right - left > max) {

                }
                left = right + 1;
            }
        }
        return max;
    }
}
