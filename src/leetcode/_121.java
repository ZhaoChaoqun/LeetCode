package leetcode;


public class _121 {

    public static void main(String[] args) {
        _121 test = new _121();
        System.out.println(test.maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i-1], prices[i] - min);
            }
        }
        return dp[prices.length - 1];
    }
}
