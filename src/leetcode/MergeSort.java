package leetcode;

import java.util.Arrays;

public class MergeSort {

    private void sort(int[] nums, int left, int right) {
        if(left == right)
            return;
        int mid  = (left + right) >>> 1;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, right);

    }
    private void merge(int[] nums, int left, int right) {
        int[] array = new int[right - left + 1];
        int i = left, k = 0, mid = (left + right) >>> 1, j = mid + 1;
        for(; i <= mid && j <= right; k++) {
            if(nums[i] < nums[j]) {
                array[k] = nums[i++];
            } else {
                array[k] = nums[j++];
            }
        }
        for(; i <= mid; i++) {
            array[k++] = nums[i];
        }
        for(; j <= right; j++) {
            array[k++] = nums[j];
        }
        System.arraycopy(array, 0, nums, left, right - left + 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,2,6,3,5,7,1};
        new MergeSort().sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {3,2,1,5,6,4};
        new MergeSort().sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {3,2,3,1,2,4,5,5,6};
        new MergeSort().sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
