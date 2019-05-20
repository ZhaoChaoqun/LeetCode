package leetcode;

public class _188 {

    public static void main(String[] args) {
        System.out.println(new _188().maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(new _188().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(new _188().maxProfit(2, new int[]{1, 2, 4, 7}));
        System.out.println(new _188().maxProfit(0, new int[]{1, 3}));
        System.out.println(new _188().maxProfit(1, new int[]{1}));
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) return 0;
        if (k > prices.length / 2) {
            for (int i = prices.length - 1; i > 0; )
                prices[i] -= prices[--i];
            int sum = 0;
            for (int i = 1; i < prices.length; i++)
                if (prices[i] > 0)
                    sum += prices[i];
            return sum;
        }
        int[][] matrix = new int[k + 1][2];
        matrix[0][1] = -prices[0];
        matrix[1][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= Math.min(k, (i + 1) / 2); j++) {
                // i-1天有，i天卖出
                if (j > 0)
                    matrix[j][0] = Math.max(matrix[j][0], matrix[j - 1][1] + prices[i]);
                else
                    matrix[j][0] = matrix[j][0];
                // i-1没有，i天买入
                matrix[j][1] = Math.max(matrix[j][1], matrix[j][0] - prices[i]);
            }
        }
        int max = 0;
        for (int i = 0; i <= k; i++)
            max = Math.max(max, matrix[i][0]);
        return max;
    }
}
