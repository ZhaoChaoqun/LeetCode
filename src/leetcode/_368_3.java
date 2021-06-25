package leetcode;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/19 11:00 上午
 */
public class _368_3 {
    public static void main(String[] args) {
        _368_3 test = new _368_3();
        System.out.println(test.largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(test.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        System.out.println(test.largestDivisibleSubset(new int[]{4, 8, 10, 240}));
        System.out.println(test.largestDivisibleSubset(new int[]{2}));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int[] before = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (nums[j] % nums[i] == 0 && dp[i] + 1 > dp[j]) {
                    dp[j] = dp[i] + 1;
                    before[j] = i;
                }
            }
        }
        int max = 0, maxIndex = 0;
        for (int i = N-1; i >= 0; --i) {
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0, j = maxIndex; i <= max; ++i, j = before[j]) {
            result.add(nums[j]);
        }
        return result;
    }

}
