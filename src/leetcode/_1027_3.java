package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/20 3:46 下午
 */
public class _1027_3 {
    public static void main(String[] args) {
        _1027_3 test = new _1027_3();
        System.out.println(test.longestArithSeqLength(new int[] {3,6,9,12}));
        System.out.println(test.longestArithSeqLength(new int[] {9,4,7,2,10}));
        System.out.println(test.longestArithSeqLength(new int[] {20,1,15,3,10,5,8}));
        System.out.println(test.longestArithSeqLength(new int[] {83,20,17,43,52,78,68,45}));
        System.out.println(test.longestArithSeqLength(new int[] {24,13,1,100,0,94,3,0,3}));
        System.out.println(test.longestArithSeqLength(new int[]{0, 8, 45, 88, 48, 68, 28, 55, 17, 24}));
        System.out.println(test.longestArithSeqLength(new int[] {44,46,22,68,45,66,43,9,37,30,50,67,32,47,44,11,15,4,11,6,20,64,54,54,61,63,23,43,3,12,51,61,16,57,14,12,55,17,18,25,19,28,45,56,29,39,52,8,1,21,17,21,23,70,51,61,21,52,25,28}));
    }

    public int longestArithSeqLength(int[] nums) {
        int N = nums.length;
        int[] index = new int[10001];
        Arrays.fill(index, -1);
        int[][] dp = new int[N+1][N+1];
        int max = 0;
        for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                int k = (nums[i] << 1) - nums[j];
                if (k >= 0) {
                    int kIndex = index[k];
                    if (kIndex > -1) {
                        dp[i][j] = dp[kIndex][i] + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
            // 【重要】技巧：因为nums中包含重复元素，故边遍历nums，边给index填入值，这是重复出现的元素的index一定是已经遍历的index中最大的
            // 【重要】技巧：选择nums[j] - nums[i] == nums[i] - nums[kIndex]，保证kIndex出现在i之前
            index[nums[i]] = i;
        }
        return max + 2;
    }
}
