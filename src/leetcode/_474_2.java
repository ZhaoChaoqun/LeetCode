package leetcode;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/19 4:27 下午
 */
public class _474_2 {

    public static void main(String[] args) {
        _474_2 test = new _474_2();
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
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < l; ++i) {
            char[] chars = strs[i].toCharArray();
            int zeros = 0;
            for (char c : chars) {
                if (c == '0') ++zeros;
            }
            int ones = chars.length - zeros;
            // 技巧：由于 dp[i][][] 的每个元素值的计算只和 dp[i−1][][] 的元素值有关，因此可以使用滚动数组的方式，去掉 dp 的第一个维度，将空间复杂度优化到 O(mn)。
            // 实现时，内层循环需采用倒序遍历的方式，这种方式保证转移来的是 dp[i−1][][] 中的元素值。
            // 链接：https://leetcode-cn.com/problems/ones-and-zeroes/solution/yi-he-ling-by-leetcode-solution-u2z2/
            for (int j = m; j >= zeros; --j) {
                for (int k = n; k >= ones; --k) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeros][k-ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

}
