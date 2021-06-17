package leetcode;

public class _213_3 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 不包含当前值
        int dp1 = nums[0];
        // 包含当前值
        int dp2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; ++i) {
            int temp = dp1;
            dp1 = Math.max(dp1, dp2);
            dp2 = Math.max(dp2, temp + nums[i]);
        }
        int dp3 = 0;
        // 包含当前值
        int dp4 = nums[1];
        for (int i = 2; i < nums.length; ++i) {
            int temp = dp3;
            dp3 = Math.max(dp3, dp4);
            dp4 = Math.max(dp4, temp + nums[i]);
        }
        return Math.max(Math.max(dp1, dp2), Math.max(dp3, dp4));
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {2,3,2};
        int[] nums = new int[] {1,2,3,4,5,1,2,3,4,5};
        _213_3 test = new _213_3();
        System.out.println(test.rob(nums));
    }
}
