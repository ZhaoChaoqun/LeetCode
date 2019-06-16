package leetcode;

import java.util.PriorityQueue;

public class _215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < k; i++)
            priorityQueue.offer(nums[i]);
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        _215 test = new _215();
        System.out.println(test.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        System.out.println(test.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }

}
