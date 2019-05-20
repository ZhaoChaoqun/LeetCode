package leetcode;

import java.util.Arrays;

public class _434 {
    public static void main(String[] args) {
        System.out.println(new _434().countSegments("  "));
        System.out.println(new _434().countSegments("Hello, my name is John"));
        System.out.println(new _434().countSegments("  Hello, my name is John  "));
    }
    public int countSegments(String s) {
        char[] chars = s.toCharArray();
        boolean isWord = false;
        int count = 0;
        for(char c : chars) {
            if(c == ' ') {
                isWord = false;
            } else {
                if(!isWord) {
                    count++;
                    isWord = true;
                }
            }
        }
        return count;
    }
}
