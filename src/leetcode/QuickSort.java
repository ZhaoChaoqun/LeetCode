package leetcode;

import java.util.Arrays;

public class QuickSort {

    private void sort(int[] nums, int left, int right) {
        if(left >= right) return;
        for(int i = left + 1, j = right;; i++, j--) {
            for(; i <= right && nums[i] < nums[left]; i++);
            for(; nums[j] > nums[left]; j--);
            if(i > j) {
                exchange(nums, left, j);
                sort(nums, left, j - 1);
                sort(nums, j + 1, right);
                return;
            }
            exchange(nums, i, j);
        }

    }
    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {4,2,6,3,5,7,1};
        new QuickSort().sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {3,2,1,5,6,4};
        new QuickSort().sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {3,2,3,1,2,4,5,5,6};
        new QuickSort().sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
