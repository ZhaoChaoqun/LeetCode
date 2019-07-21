package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _3_2 {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int[] map = new int[128];
        for(int i = 0; i < 128; i++)
            map[i] = -1;
        int max = 0;
        int i = 0, left = 0, temp = 0;
        for(; i < array.length; i++) {
            if(map[array[i]] != -1) {
                temp = i - left;
                max = max > temp ? max : temp;
                temp = map[array[i]] + 1;
                left = temp > left ? temp : left;
            }
            map[array[i]] = i;
        }
        return max >= i - left ? max : i - left;
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

