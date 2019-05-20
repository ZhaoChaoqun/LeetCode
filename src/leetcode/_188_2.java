package leetcode;

public class _188_2 {

    public static void main(String[] args) {
        System.out.println(new _188_2().maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(new _188_2().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(new _188_2().maxProfit(2, new int[]{1, 2, 4, 7}));
        System.out.println(new _188_2().maxProfit(0, new int[]{1, 3}));
        System.out.println(new _188_2().maxProfit(1, new int[]{1}));
    }

    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if(length <= 1 || k <= 0) return 0;
        if(k > length / 2) {
            int result = 0;
            for(int i = length - 1; i >= 1; i--) {
                prices[i] -= prices[i-1];
                if(prices[i] > 0)
                    result += prices[i];
            }
            return result;
        }
        int[][] global = new int[length][];
        int[][] local = new int[length][];
        global[0] = new int[2];
        local[0] = new int[2];
        for(int i = 1; i < length; i++) {
            int diff = prices[i] - prices[i-1];
            global[i] = new int[i+2];
            local[i] = new int[i+2];
            for(int j = 1; j <= Math.min(i, k); j++) {
                local[i][j] = Math.max(local[i-1][j] + diff,
                        global[i-1][j-1] + Math.max(diff, 0));
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[length-1][Math.min(length-1, k)];
    }
}
