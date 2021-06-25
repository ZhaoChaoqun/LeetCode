package leetcode;

import java.util.LinkedList;

public class _32_3 {
    public static void main(String[] args) {
        System.out.println(new _32_3().longestValidParentheses("(()"));
        System.out.println(new _32_3().longestValidParentheses(")()())"));
        System.out.println(new _32_3().longestValidParentheses(""));
        System.out.println(new _32_3().longestValidParentheses("()(()"));
        System.out.println(new _32_3().longestValidParentheses(")()(((())))("));
        System.out.println(new _32_3().longestValidParentheses("()"));
    }
    public int longestValidParentheses(String s) {
        char[] array = s.toCharArray();
        LinkedList<Integer> deque = new LinkedList<>();
        int max = 0;
        deque.offer(-1);
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == '(') {
                deque.offerLast(i);
            } else {
                deque.pollLast();
                if (deque.isEmpty()) {
                    deque.offerLast(i);
                } else {
                    max = Math.max(max, i - deque.peekLast());
                }
            }
        }
        return max;
    }
}
