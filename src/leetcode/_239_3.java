package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class _239_3 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i])
                stack.pollLast();
            stack.offerLast(i);
        }
        for (int i = k, j = 0; i < nums.length; i++, j++) {
            if(stack.peekFirst() + k == i) {
                result[j] = nums[stack.pollFirst()];
            } else {
                result[j] = nums[stack.peekFirst()];
            }
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i])
                stack.pollLast();
            stack.offerLast(i);
        }
        result[result.length - 1] = nums[stack.pollFirst()];
        return result;
    }

    public static void main(String[] args) {
        _239_3 test = new _239_3();
//        System.out.println(Arrays.toString(test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(test.maxSlidingWindow(new int[]{7,2,4}, 2)));
    }
}
