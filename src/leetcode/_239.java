package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _239 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _239().maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(new _239().maxSlidingWindow(new int[] {1,-1}, 1)));
        System.out.println(Arrays.toString(new _239().maxSlidingWindow(new int[] {7,2,4}, 2)));

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return nums;
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for(int j = 0; j < nums.length;) {
            if(!deque.isEmpty() && j - deque.peekFirst() == k)
                deque.pollFirst();
            while(!deque.isEmpty() && nums[j] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(j);
            if(++j >= k) {
                result[j - k] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
