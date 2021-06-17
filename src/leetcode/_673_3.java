package leetcode;

import java.util.Arrays;

public class _673_3 {
    public static void main(String[] args) {
//        System.out.println(new _673_3().findNumberOfLIS(new int[] {1,3,5,4,7}));
        System.out.println(new _673_3().findNumberOfLIS(new int[] {1,3,5,4,7,6,8}));
        System.out.println(new _673_3().findNumberOfLIS(new int[] {2,2,2,2,2}));
        System.out.println(new _673_3().findNumberOfLIS(new int[] {1,2,4,3,5,4,7,2}));
    }

    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] path = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            path[i] = dp[i] = 1;
            for (int j = i-1; j >= 0; --j) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 == dp[i]) {
                        path[i] += path[j];
                    } else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        path[i] = path[j];
                    }
                }
            }
        }
        int max = 1;
        for (int i = 0; i < nums.length; ++i) {
            max = Math.max(dp[i], max);
        }
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (dp[i] == max) {
                result += path[i];
            }
        }
        return result;
    }
}
