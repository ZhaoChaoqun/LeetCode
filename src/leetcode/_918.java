package leetcode;

import java.util.Arrays;

public class _918 {

    public static void main(String[] args) {
        System.out.println(new _918().maxSubarraySumCircular(new int[]{-2}));
        System.out.println(new _918().maxSubarraySumCircular(new int[]{-2,-3,-1}));
//        System.out.println(new _918().maxSubarraySumCircular(new int[]{5,-3,5}));
//        System.out.println(new _918().maxSubarraySumCircular(new int[]{5,3,5}));
//        System.out.println(new _918().maxSubarraySumCircular(new int[]{3,-1,2,-1}));
//        System.out.println(new _918().maxSubarraySumCircular(new int[]{3,-2,2,-3}));
//        System.out.println(new _918().maxSubarraySumCircular(new int[]{6,9,-3}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int min1 = nums[0];
        for (int i = 1; i < nums.length - 1; ++i) {
            dp[i] = nums[i] + Math.min(0, dp[i-1]);
            min1 = Math.min(min1, dp[i]);
        }
        int min2 = nums[1];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; ++i) {
            dp[i] = nums[i] + Math.min(0, dp[i-1]);
            min2 = Math.min(min2, dp[i]);
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = nums[i] + Math.max(0, dp[i-1]);
            max = Math.max(max, dp[i]);
        }
//        System.out.println(Arrays.toString(dp));
        return Math.max(max, sum - Math.min(min2, Math.min(0, min1)));
    }
}
