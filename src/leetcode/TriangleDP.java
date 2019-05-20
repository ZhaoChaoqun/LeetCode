package leetcode;

public class TriangleDP {

    public static void main(String[] args) {
        int[][] triangle = new int[][]{
                {1}, {3, 2}, {4, 10, 1}, {4, 3, 2, 20}
        };
        TriangleDP test = new TriangleDP();
        System.out.println(test.dp(triangle));
    }


    int dp(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle[triangle.length - 1].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return dp(triangle, dp, 0, 0);
    }

    int dp(int[][] triangle, int[][] dp, int i, int j) {
        if (i == triangle.length)
            return 0;
        if(dp[i][j] >= 0) return dp[i][j];
        dp[i][j] = triangle[i][j] + Math.max(dp(triangle, dp, i + 1, j), dp(triangle, dp, i + 1, j+ 1));
        return dp[i][j];
    }
}
