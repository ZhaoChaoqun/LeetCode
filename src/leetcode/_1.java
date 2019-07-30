package leetcode;

import java.util.Arrays;

public class _1 {
    public int[] twoSum(int[] nums, int target) {
        int[] clone = new int[nums.length];
        System.arraycopy(nums, 0, clone, 0, nums.length);
        Arrays.sort(nums);
        for(int i = 0, j = nums.length - 1; true;) {
            if(nums[i] + nums[j] > target) {
                --j;
            } else if(nums[i] + nums[j] == target) {
                int m = 0;
                for(; clone[m] != nums[i]; ++m);
                int n = 0;
                for(; m == n || clone[n] != nums[j]; ++n);
                if(m < n)
                    return new int[] {m, n};
                return new int[] {n, m};
            } else {
                i++;
            }
        }
    }
}
