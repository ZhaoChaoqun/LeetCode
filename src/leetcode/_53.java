package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _53 {


    public static void main(String[] args) {
        _53 test = new _53();
        System.out.println(test.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            if (nums[i] > max)
                max = nums[i];
        }
        return max;
    }
}
