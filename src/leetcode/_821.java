package leetcode;

import java.util.Arrays;

public class _821 {
    public static void main(String[] args) {
        _821 test = new _821();
//        System.out.println(Arrays.toString("loveleetcodeccc".toCharArray()));
        System.out.println(Arrays.toString(test.shortestToChar("loveleetcodeccc", 'e')));
        System.out.println(Arrays.toString(test.shortestToChar("baab", 'b')));
    }

    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        int[] result = new int[chars.length];
        int from = -1;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == c) {
                result[i] = 0;
                if (from == -1) {
                    for (int j = 0; j < i; j++) {
                        result[j] = i - j;
                    }
                } else {
                    for (int j = from + 1; j <= (from + i) / 2; j++) {
                        result[j] = j - from;
                    }
                    for (int j = (from + i) / 2 + 1; j < i; j++) {
                        result[j] = i - j;
                    }
                }
                from = i;
            }
        }
        int count = 0;
        for(int j = from + 1; j < chars.length; j++) {
            result[j] = ++count;
        }
        return result;
    }
}
