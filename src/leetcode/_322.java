package leetcode;

import java.util.Arrays;

public class _322 {

    public static void main(String[] args) {
        _322 test = new _322();
        System.out.println(test.coinChange(new int[] {1, 2, 5}, 11));
        System.out.println(test.coinChange(new int[] {2}, 3));
        System.out.println(test.coinChange(new int[] {186,419,83,408}, 6249));
        System.out.println(test.coinChange(new int[] {2147483647}, 2));

    }

    void backtracking(int[] coins, int[] dp, int amount) {
        if(dp[amount] >= 0) return;
        int min = Integer.MAX_VALUE;
        for(int i = coins.length - 1; i >= 0; i--) {
            if(amount < coins[i])
                continue;
            backtracking(coins, dp, amount- coins[i]);
            if(dp[amount- coins[i]] > 0)
                min = Math.min(min, dp[amount- coins[i]]);
        }
        if(min != Integer.MAX_VALUE)
            dp[amount] = min + 1;
        else
            dp[amount] = 0;
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++)
            dp[i] = -1;
        for(int i = 0; i < coins.length && coins[i] <= amount; i++)
            dp[coins[i]] = 1;
        backtracking(coins, dp, amount);
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
