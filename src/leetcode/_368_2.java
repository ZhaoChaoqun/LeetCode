package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/19 11:00 上午
 */
public class _368_2 {
    public static void main(String[] args) {
        _368_2 test = new _368_2();
        System.out.println(test.largestDivisibleSubset(new int[] {1,2,3}));
        System.out.println(test.largestDivisibleSubset(new int[] {1,2,4,8}));
        System.out.println(test.largestDivisibleSubset(new int[] {4,8,10,240}));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][2];
        dp[0][1] = -1;
        for (int i = 1; i < nums.length; ++i) {
            dp[i][1] = -1;
            for (int j = i - 1; dp[i][1] >= 0 ? j > dp[dp[i][1]][1] : j >= 0; --j) {
                if (nums[i] % nums[j] == 0 && dp[j][0] + 1 > dp[i][0]) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (dp[i][0] > max) {
                max = dp[i][0];
                maxIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = dp[i][1]) {
            result.add(nums[i]);
        }
        return result;
    }
}
