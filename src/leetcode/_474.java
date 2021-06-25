package leetcode;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/19 4:27 下午
 */
public class _474 {

    public static void main(String[] args) {
        _474 test = new _474();
        System.out.println(test.findMaxForm(new String[] {"10", "0001", "1", "0"}, 5, 3));
        System.out.println(test.findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(test.findMaxForm(new String[] {"10", "0", "1"}, 1, 1));
        System.out.println(test.findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 4, 3));
        System.out.println(test.findMaxForm(new String[] {"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"}, 90, 66));
        System.out.println(test.findMaxForm(new String[] {"011111","001","001"}, 4, 5));

    }

    public int findMaxForm(String[] strs, int m, int n) {
        // 定义三维数组dp，其中 dp[i][j][k] 表示在前 i 个字符串中，使用 j 个 0 和 k 个 1 的情况下最多可以得到的字符串数量。
        int l = strs.length;
        int[][][] dp = new int[l+1][m+1][n+1];
        for (int i = 0; i < l; ++i) {
            char[] chars = strs[i].toCharArray();
            int zeros = 0;
            for (char c : chars) {
                if (c == '0') ++zeros;
            }
            int ones = chars.length - zeros;
            for (int j = 0; j <= m; ++j) {
                for (int k = 0; k <= n; ++k) {
                    dp[i+1][j][k] = dp[i][j][k];
                    if (zeros <= j && ones <= k) {
                        dp[i+1][j][k] = Math.max(dp[i+1][j][k], dp[i][j-zeros][k-ones] + 1);
                    }
                }
            }
        }
        return dp[l][m][n];
    }

}
