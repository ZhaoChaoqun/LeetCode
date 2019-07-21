package leetcode;

import java.util.LinkedList;

public class _32 {
    public int longestValidParentheses(String s) {
        char[] array = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        int[] nums = new int[array.length];
        int max = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == ')') {
                if(!stack.isEmpty() && stack.pop() == '(') {
                    nums[i] = nums[i-1] + 2;
                    if(i - nums[i] >= 0)
                        nums[i] += nums[i - nums[i]];
                    if(nums[i] > max)
                        max = nums[i];
                }
            } else {
                stack.push('(');
            }
        }
        return max;
    }
}
