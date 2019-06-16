package leetcode;

public class _130_2 {
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        if(m == 0) return;
        n = board[0].length;
        for(int i = 0; i < n; i++) {
            if(board[0][i] == 'O') {
                recursive(board, 0, i);
            }
            if(board[m-1][i] == 'O') {
                recursive(board, m-1, i);
            }
        }
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                recursive(board, i, 0);
            }
            if(board[i][n-1] == 'O') {
                recursive(board, i, n-1);
            }
        }
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] == '*')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
    }
    private void recursive(char[][] board, int i, int j) {
        board[i][j] = '*';
        if(i > 0 && board[i-1][j] == 'O')
            recursive(board, i-1, j);
        if(j > 0 && board[i][j-1] == 'O')
            recursive(board, i, j-1);
        if(i + 1 < m && board[i+1][j] == 'O')
            recursive(board, i+1, j);
        if(j + 1 < n && board[i][j+1] == 'O')
            recursive(board, i, j+1);
    }
}
