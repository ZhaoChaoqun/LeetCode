package leetcode;

public class _714 {

    public int maxProfit(int[] prices, int fee) {
        int buyin = -prices[0], sellout = 0;
        for(int i = 1; i < prices.length; i++) {
            sellout = Math.max(sellout, prices[i] + buyin - fee);
            buyin = Math.max(buyin, sellout - prices[i]);
        }
        return sellout;
    }

    public static void main(String[] args) {
        _714 test = new _714();
        System.out.println(test.maxProfit(new int[] {9,8,7,1,2}, 3));
        System.out.println(test.maxProfit(new int[] {1, 3, 2, 8, 4, 9}, 2));
    }
}
