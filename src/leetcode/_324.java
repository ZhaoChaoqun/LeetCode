package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _324 {
    public static void main(String[] args) {
        _324 test = new _324();
        int[] nums;
        nums = new int[] {1, 5, 1, 1, 6, 4};
        test.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {1, 3, 2, 2, 3, 1};
        test.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {1,2,2,1,2,1,1,1,1,2,2,2};
        nums = new int[] {3,2,3,3,2,1,1,2,3,1,1,3,2,1,2,2,2,2,1};
        nums = new int[] {4,5,5,6};
        test.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        int length = nums.length;
        if(length == 0) return;
        PriorityQueue<Integer> max = new PriorityQueue<>();
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        int left = (length + 1) / 2;
        for(int i = 0; i < left; i++)
            min.offer(nums[i]);
        for(int i = left; i < length; i++) {
            if(min.peek() > nums[i]) {
                max.offer(min.poll());
                min.offer(nums[i]);
            } else {
                max.offer(nums[i]);
            }
        }
//        for(int i = 0; i < length; i += 2) {
//            nums[i] = min.poll();
//        }
//        for(int i = (length & 1) == 0 ? length - 1 : length - 2; i > 0; i -= 2) {
//            nums[i] = max.poll();
//        }
        for(int i = 1; i < length; i += 2) {
            nums[i] = max.poll();
        }
        for(int i = (length & 1) == 1 ? length - 1 : length - 2; i > 0; i -= 2) {
            nums[i] = min.poll();
        }
    }

}
