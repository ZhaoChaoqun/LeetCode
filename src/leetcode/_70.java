package leetcode;

public class _70 {
    public static void main(String[] args) {
        _70 test = new _70();
//        System.out.println(test.climbStairs(2));
        System.out.println(test.climbStairs(44));
    }
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 2;
        return climbStairs(dp, n);
    }

    int climbStairs(int[] dp, int n) {
        if(dp[n] > 0) return dp[n];
        return dp[n] = climbStairs(dp, n - 1) + climbStairs(dp, n - 2);
    }
}
