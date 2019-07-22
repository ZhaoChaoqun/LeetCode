package leetcode;

public class _64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        for(int i = 1; i < m; i++)
            grid[i][0] += grid[i-1][0];
        for(int j = 1; j < n; j++)
            grid[0][j] += grid[0][j-1];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
        return grid[m-1][n-1];
    }
}
