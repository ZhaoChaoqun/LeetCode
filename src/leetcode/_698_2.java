package leetcode;

import java.util.Arrays;

public class _698_2 {

    public static void main(String[] args) {
        _698_2 test = new _698_2();
        System.out.println(test.canPartitionKSubsets(new int [] {4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(test.canPartitionKSubsets(new int [] {10,10,10,7,7,7,7,7,7,6,6,6}, 3));
    }

    boolean backtracking(int[] nums, int[] used, int index, int target) {
        if(target < 0) return false;
        used[index] = 1;
        if(target == 0) {
            return true;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i] == 0) {
                if (backtracking(nums, used, i, target - nums[i])) {
                    return true;
                }
            }
        }
        used[index] = 0;
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int target = 0;
        for (int num : nums)
            target += num;
        if (target % k != 0) return false;
        target /= k;
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) return false;
        for(; k > 0; k--) {
            for(int i = nums.length - 1; i > 0; i--)
                if(used[i] == 0) {
                    if (!backtracking(nums, used, nums.length - 1, target - nums[i]))
                        return false;
                }
        }
        return true;
    }

}
