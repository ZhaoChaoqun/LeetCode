package leetcode;

public class _213_2 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; ++i) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        int[] dp2 = new int[nums.length];
        dp2[1] = nums[1];
        for (int i = 2; i < nums.length; ++i) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
        }
        return Math.max(dp[nums.length - 2], dp2[nums.length - 1]);
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {2,3,2};
        int[] nums = new int[] {1,2,3,4,5,1,2,3,4,5};
        _213_2 test = new _213_2();
        System.out.println(test.rob(nums));
    }
}
