package leetcode;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/21 6:43 下午
 */
public class _316 {

    public static void main(String[] args) {
        _316 test = new _316();
        System.out.println(test.removeDuplicateLetters("bcabc"));
        System.out.println(test.removeDuplicateLetters("cbacdcbc"));
        System.out.println(test.removeDuplicateLetters("cdadabcc"));
        System.out.println(test.removeDuplicateLetters("acbac"));
    }

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] exist = new int[26];
        int[] lastIndex = new int[26];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            lastIndex[charArray[i] - 'a'] = i;
        }
        for (int i = 0; i < charArray.length; ++i) {
            int current = charArray[i] - 'a';
            if (exist[current] == 1) {
                continue;
            }
            for (; !stack.isEmpty() && charArray[i] < stack.peek() && lastIndex[stack.peek() - 'a'] > i; ) {
                exist[stack.pop() - 'a'] = 0;
            }
            exist[current] = 1;
            stack.push(s.charAt(i));

        }
        charArray = new char[stack.size()];
        for(int i = charArray.length - 1; i>= 0; --i) {
            charArray[i] = stack.pop();
        }
        return new String(charArray);
    }
}
