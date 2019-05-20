package leetcode;


public class _130 {

    public static void main(String[] args) {
        char[][] board = new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new _130().solve(board);
        for(char[] row : board) {
            System.out.println(new String(row));
        }
    }

    void backtracking(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i >= m || j >= n)
            return;
        if(board[i][j] == 'O') {
            board[i][j] = 'Y';
            backtracking(board, i - 1, j);
            backtracking(board, i + 1, j);
            backtracking(board, i, j + 1);
            backtracking(board, i, j - 1);
        }
    }
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        if(m == 0) return;
        n = board[0].length;
        for(int i = 0; i < m; i++) {
            backtracking(board, i, 0);
            backtracking(board, i, n-1);
        }
        for(int i = 0; i < n; i++) {
            backtracking(board, 0, i);
            backtracking(board, m-1, i);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'Y')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';

            }
        }
    }
}
