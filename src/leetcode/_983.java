package leetcode;

public class _983 {

    public static void main(String[] args) {
        int[] days, costs;
        days = new int[]{1, 4, 6, 7, 8, 20};
        costs = new int[]{2, 7, 15};
        System.out.println(new _983().mincostTickets(days, costs));

        days = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        costs = new int[]{2, 7, 15};
        System.out.println(new _983().mincostTickets(days, costs));


    }

    private int backtracking(int from, int to, int[] days, int[] costs) {
        if (dp[from][to] > 0)
            return dp[from][to];
        int min = Integer.MAX_VALUE;
        if (days[to] - days[from] < 7)
            min = Math.min(min, costs[1]);
        if (days[to] - days[from] < 30)
            min = Math.min(min, costs[2]);
        for (int i = 0; from + i < to; i++)
            min = Math.min(min, backtracking(from, from + i, days, costs) + backtracking(from + i + 1, to, days, costs));
        dp[from][to] = min;
        return min;
    }

    int[][] dp;

    public int mincostTickets(int[] days, int[] costs) {
        int length = days.length;
        dp = new int[length][length];
        int min = Math.min(Math.min(costs[0], costs[1]), costs[2]);
        for (int i = 0; i < length; i++)
            dp[i][i] = min;
        return backtracking(0, length - 1, days, costs);
    }
}
