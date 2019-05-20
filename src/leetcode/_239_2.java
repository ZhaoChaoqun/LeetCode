package leetcode;

import java.util.*;

public class _239_2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _239_2().maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(new _239_2().maxSlidingWindow(new int[] {1,-1}, 1)));
        System.out.println(Arrays.toString(new _239_2().maxSlidingWindow(new int[] {7,2,4}, 2)));

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return nums;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++)
            priorityQueue.offer(nums[i]);
        for(int i = k; i < nums.length; i++) {
            result[i - k] = priorityQueue.peek();
            priorityQueue.remove(nums[i-k]);
            priorityQueue.offer(nums[i]);

        }
        result[nums.length - k] = priorityQueue.peek();
        return result;
    }
}
