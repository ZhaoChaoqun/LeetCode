package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _784_2 {

    public static void main(String[] args) {
        _784_2 test = new _784_2();
        System.out.println(test.letterCasePermutation("a1b2"));
        System.out.println(test.letterCasePermutation("A1B2"));
        System.out.println(test.letterCasePermutation("3z4"));
        System.out.println(test.letterCasePermutation("3Z4"));
        System.out.println(test.letterCasePermutation(""));
    }

    void backtracking(List<String> result, char[] chars, int index) {
        if(index == chars.length) {
            result.add(new String(chars));
            return;
        }
        backtracking(result, chars, index + 1);
        if (chars[index] >= 'a' && chars[index] <= 'z') {
            chars[index] -= 32;
            backtracking(result, chars, index + 1);
        } else if (chars[index] >= 'A' && chars[index] <= 'Z') {
            chars[index] += 32;
            backtracking(result, chars, index + 1);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtracking(result, s.toCharArray(), 0);
        return result;
    }

}
