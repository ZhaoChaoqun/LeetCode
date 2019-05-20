package leetcode;

import java.util.Arrays;

public class _416 {

    public static void main(String[] args) {

        _416 test = new _416();
        System.out.println(test.canPartition(new int[] {1, 5, 11, 5}));
        System.out.println(test.canPartition(new int[] {1, 2, 3, 5}));
        System.out.println(test.canPartition(new int[] {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100}));

    }
    boolean backtracking(int[] nums, int target, int index) {
        if(target == 0) return true;
        if(target < 0) return false;
        for(int i = index - 1; i >= 0; i--) {
            if(backtracking(nums, target - nums[i], i - 1))
                return true;
        }
        return false;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        if((sum & 1) == 1)
            return false;
        Arrays.sort(nums);
        return backtracking(nums, sum / 2 - nums[nums.length - 1], nums.length - 1);
    }
}
