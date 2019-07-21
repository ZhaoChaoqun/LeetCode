package leetcode;

import java.util.Arrays;

public class _647_2 {

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int result = length;
        for(int i = 1; i < length - 1; i++) {
            for(int j = 1; i >= j && i + j < length && chars[i-j] == chars[i+j]; j++) {
                result++;
            }
        }
        for(int i = 0; i < length - 1; i++) {
            for(int j = 0; i >= j && i + j + 1 < length && chars[i-j] == chars[i+1+j]; j++) {
                result++;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        _647_2 test = new _647_2();
        System.out.println(test.countSubstrings("abc"));
        System.out.println(test.countSubstrings("aaa"));
        System.out.println(test.countSubstrings("leetcode"));
    }
}
