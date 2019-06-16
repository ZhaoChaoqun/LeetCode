package leetcode;

public class _200_3 {
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    recursive(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    private void recursive(char[][] board, int i, int j) {
        board[i][j] = '0';
        if(i > 0 && board[i-1][j] == '1')
            recursive(board, i-1, j);
        if(j > 0 && board[i][j-1] == '1')
            recursive(board, i, j-1);
        if(i + 1 < m && board[i+1][j] == '1')
            recursive(board, i+1, j);
        if(j + 1 < n && board[i][j+1] == '1')
            recursive(board, i, j+1);
    }
}
