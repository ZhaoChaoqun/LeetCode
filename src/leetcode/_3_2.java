package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _3_2 {
    public int lengthOfLongestSubstring(String s) {
        if("".equals(s) || s == null) return 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int max = 0, from = 0;
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                max = Math.max(max, i - from);
                from = Math.max(from, map.get(c[i]) + 1);
            }
            map.put(c[i], i);
        }
        return Math.max(max, c.length - from);
    }

    public static void main(String[] args) {
        _3_2 test = new _3_2();
//        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(test.lengthOfLongestSubstring("bbbbb"));
        System.out.println(test.lengthOfLongestSubstring("abba"));
//        System.out.println(test.lengthOfLongestSubstring("a"));
//        System.out.println(test.lengthOfLongestSubstring("dvdf"));
    }
}

