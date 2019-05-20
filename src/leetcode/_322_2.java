package leetcode;

import java.util.Arrays;

public class _322_2 {

    public static void main(String[] args) {
        _322_2 test = new _322_2();
        System.out.println(test.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(test.coinChange(new int[]{2}, 3));
        System.out.println(test.coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(test.coinChange(new int[]{2147483647}, 2));

    }

    int backtracking(int[] coins, int[] dp, int amount) {
        if (dp[amount] != 0) return dp[amount];
        dp[amount] = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length && amount >= coins[i]; i++) {
            dp[amount] = Math.min(dp[amount], backtracking(coins, dp, amount - coins[i]));
        }
        return dp[amount] != Integer.MAX_VALUE ? ++dp[amount] : Integer.MAX_VALUE;
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length && coins[i] <= amount; i++)
            dp[coins[i]] = 1;
        return backtracking(coins, dp, amount) == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
