package leetcode;

public class _695_2 {

    public static void main(String[] args) {
        _695_2 test = new _695_2();
        System.out.println(test.maxAreaOfIsland(new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
        System.out.println(test.maxAreaOfIsland(new int[][] {{0,0,0,0,0,0,0,0}}));
    }

    int backtracking(int[][] grid, int i, int j, int row, int col) {
        grid[i][j] = -1;
        int area = 1;
        if(i > 0 && grid[i-1][j] == 1)
            area += backtracking(grid, i - 1, j, row, col);
        if(i < row - 1 && grid[i+1][j] == 1)
            area += backtracking(grid, i + 1, j, row, col);
        if(j > 0 && grid[i][j-1] == 1)
            area += backtracking(grid, i, j - 1, row, col);
        if(j < col - 1 && grid[i][j+1] == 1)
            area += backtracking(grid, i, j + 1, row, col);
        return area;

    }
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int max = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    int area = backtracking(grid, i, j, row, col);
                    if (area > max)
                        max = area;
                }
            }
        }
        return max;
    }
}
