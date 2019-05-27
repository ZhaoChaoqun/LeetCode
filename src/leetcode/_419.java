package leetcode;

public class _419 {

    public int countBattleships(char[][] board) {
        int m = board.length;
        if(m == 0) return 0;
        int n = board[0].length;
        if(n == 0) return 0;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'X') {
                    if((i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.'))
                        count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
