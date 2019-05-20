package leetcode;

public class _309 {
    public static void main(String[] args) {
        System.out.println(new _309().maxProfit(new int[] {1,2,3,0,2}));
        System.out.println(new _309().maxProfit(new int[] {1,2}));
    }

    public int maxProfit(int[] prices) {
//  matrix[i][j][k] i表示第天，j表示是否持有，k取0和1 1表示存在卖出
// 第i天有 = max(
// 1. 第i-1天有
// 2. 第i-1天没有，第i天买入
// matrix[i][1] = Math.max(matrix[1][0], matrix[0][0] - prices[i])

// 第i天没有 = max(
// 1. 第i-1天没有
// 2. 第i-1天有，第i天卖出
//        matrix[i][0][0] = matrix[0]
//        matrix[i][0][1] = matrix[1] + prices[i])
        int length = prices.length;
        if(length <= 1) return 0;
        int[][] matrix = new int[2][2];
        matrix[1][0] = -prices[0];
        for(int i = 1; i < length; i++) {
            matrix[1][0] = Math.max(matrix[1][0], matrix[0][0] - prices[i]);
            matrix[0][0] = Math.max(matrix[0][0], matrix[0][1]);
            matrix[0][1] = Math.max(Math.max(matrix[0][0], matrix[0][1]), matrix[1][0] + prices[i]);
        }
        return Math.max(matrix[0][0], matrix[0][1]);
    }
}
