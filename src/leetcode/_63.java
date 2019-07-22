package leetcode;

public class _63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        int i = 0;
        for(; i < m && obstacleGrid[i][0] == 0; i++)
            obstacleGrid[i][0] = 1;
        for(; i < m; i++)
            obstacleGrid[i][0] = 0;
        int j = 1;
        for(; j < n && obstacleGrid[0][j] == 0; j++)
            obstacleGrid[0][j] = 1;
        for(; j < n; j++)
            obstacleGrid[0][j] = 0;
        for(i = 1; i < m; i++)
            for(j = 1; j < n; j++)
                if(obstacleGrid[i][j] == 0)
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                else obstacleGrid[i][j] = 0;
        return obstacleGrid[m-1][n-1];
    }
}
