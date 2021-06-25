package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/21 6:43 下午
 */
public class _316_2 {

    public static void main(String[] args) {
        _316_2 test = new _316_2();
        System.out.println(test.removeDuplicateLetters("bcabc"));
        System.out.println(test.removeDuplicateLetters("cbacdcbc"));
        System.out.println(test.removeDuplicateLetters("cdadabcc"));
        System.out.println(test.removeDuplicateLetters("acbac"));
    }

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] exist = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            if (exist[s.charAt(i) - 'a'] == 1) {
                continue;
            }
            if (stack.isEmpty() || s.charAt(i) > stack.peek()) {
                exist[s.charAt(i) - 'a'] = 1;
                stack.push(s.charAt(i));
            } else {
                Character c;
                for (; !stack.isEmpty() && s.charAt(i) < stack.peek(); ) {
                    c = stack.peek();
                    if (s.indexOf(c, i+1) >= 0) {
                        stack.pop();
                        exist[c - 'a'] = 0;
                    } else {
                        break;
                    }
                }
                exist[s.charAt(i) - 'a'] = 1;
                stack.push(s.charAt(i));
            }

        }
        char[] array = new char[stack.size()];
        for(int i = array.length - 1; i>= 0; --i) {
            array[i] = stack.pop();
        }
        return new String(array);
    }
}
