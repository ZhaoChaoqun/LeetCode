package leetcode;

import java.util.Arrays;

public class _75 {

    public void sortColors(int[] nums) {
        int zero = 0, one = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[i] = 2;
                nums[zero + one] = 1;
                nums[zero++] = 0;
            } else if(nums[i] == 1) {
                nums[i] = 2;
                nums[zero + one++] = 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        _75 test = new _75();
        test.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
