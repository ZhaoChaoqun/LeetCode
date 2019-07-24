package leetcode;

import java.util.List;

public class _120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        int j = 0;
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        for(int i : lastRow)
            dp[j++] = i;
        return minimumTotal(triangle, dp, triangle.size() - 2);
    }

    public static int minimumTotal(List<List<Integer>> triangle, int[] dp, int lvlidx) {
        if(lvlidx == -1) return dp[0];
        List<Integer> list = triangle.get(lvlidx);
        for (int i = 0; i <= lvlidx; i++) {
            dp[i] = list.get(i) + Math.min(dp[i], dp[i + 1]);
        }
        return minimumTotal(triangle, dp, lvlidx - 1);
    }
}
