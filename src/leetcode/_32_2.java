package leetcode;

import java.util.LinkedList;

public class _32_2 {
    public static void main(String[] args) {
        System.out.println(new _32_2().longestValidParentheses("(()"));
        System.out.println(new _32_2().longestValidParentheses(")()())"));
        System.out.println(new _32_2().longestValidParentheses(""));
        System.out.println(new _32_2().longestValidParentheses("()(()"));
        System.out.println(new _32_2().longestValidParentheses(")()(((())))("));
        System.out.println(new _32_2().longestValidParentheses("()"));
    }
    public int longestValidParentheses(String s) {
        char[] array = s.toCharArray();
        int[] dp = new int[array.length];
        int max = 0;
        for (int i = 1; i < dp.length; ++i) {
            int leftIndex;
            if (array[i] == ')' && (leftIndex = i - dp[i-1] - 1) >= 0 && array[leftIndex] == '(') {
                dp[i] = 2 + dp[i-1] + (leftIndex > 0 ? dp[leftIndex - 1] : 0);
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
