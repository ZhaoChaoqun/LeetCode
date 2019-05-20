package leetcode;

import java.util.Arrays;

public class _673_2 {
    public static void main(String[] args) {
//        System.out.println(new _673_2().findNumberOfLIS(new int[] {1,3,5,4,7,6,8}));
        System.out.println(new _673_2().findNumberOfLIS(new int[] {2,2,2,2,2}));
//        System.out.println(new _673_2().findNumberOfLIS(new int[] {1,2,4,3,5,4,7,2}));
    }

    private int backtracking(int index, int[] nums, int[] array, int[] dp) {
        if(dp[index] > 0) return dp[index];
        for(int i = 0; i < index; i++) {
            if(array[index] == array[i] + 1 && nums[index] > nums[i]) {
                dp[index] += backtracking(i, nums, array, dp);
            }
        }
        if(dp[index] == 0)
            dp[index] = 1;
        return dp[index];
    }
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] array = new int[nums.length];
        array[0] = 1;
        int max = array[0];
        for(int i = 1; i < nums.length; i++) {
            int maxInBefore = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    maxInBefore = Math.max(array[j], maxInBefore);
            }
            array[i] = maxInBefore + 1;
            max = Math.max(max, array[i]);
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 0;
        for(int i = 0; i < nums.length; i++)
            if(array[i] == max)
                result += backtracking(i, nums, array, dp);
        return result;
    }
}
