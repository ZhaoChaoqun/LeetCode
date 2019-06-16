package leetcode;

import java.util.Arrays;

public class _75 {

    public void sortColors(int[] nums) {
        int second = nums.length - 1, zero = 0;
        for (int i = 0; i <= second; i++) {
            while (nums[i] == 2 && i < second) swap(nums, i, second--);
            while (nums[i] == 0 && i > zero) swap(nums, i, zero++);
        }
    }
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        _75 test = new _75();
        test.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
