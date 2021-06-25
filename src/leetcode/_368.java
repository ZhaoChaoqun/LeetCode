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
public class _368 {
    public static void main(String[] args) {
        _368 test = new _368();
        System.out.println(test.largestDivisibleSubset(new int[] {1,2,3}));
        System.out.println(test.largestDivisibleSubset(new int[] {1,2,4,8}));
        System.out.println(test.largestDivisibleSubset(new int[] {4,8,10,240}));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; --i) {
            if (nums[maxIndex] % nums[i] == 0 && dp[i] == max) {
                maxIndex = i;
                --max;
                result.add(nums[i]);
            }
        }
        return result;
    }
}
