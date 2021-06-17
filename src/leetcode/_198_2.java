package leetcode;

public class _198_2 {

    public static void main(String[] args) {
        _198_2 test = new _198_2();

        System.out.println(test.rob(new int[]{1, 2, 3, 1}));
        System.out.println(test.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(test.rob(new int[]{2, 1}));
        System.out.println(test.rob(new int[]{2,1,1,2}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 不包含当前值
        int dp1 = nums[0];
        // 包含当前值
        int dp2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; ++i) {
            int temp = dp1;
            dp1 = Math.max(dp1, dp2);
            dp2 = Math.max(dp2, temp + nums[i]);
        }
        return Math.max(dp1, dp2);
    }

//    public int rob(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < nums.length; ++i) {
//            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
//        }
//        return dp[nums.length - 1];
//    }
}
