package leetcode;

public class _37 {
    public static void main(String[] args) {
        char[][] board = new char[][]{"41.5..3..".toCharArray(),
                "..31..754".toCharArray(),
                "52.43....".toCharArray(),
                "9.2..4.3.".toCharArray(),
                ".....584.".toCharArray(),
                ".......6.".toCharArray(),
                ".3..5.4..".toCharArray(),
                "..17436..".toCharArray(),
                "6....8..3".toCharArray()};
        new _37().solveSudoku(board);
        for(char[] row : board)
            System.out.println(new String(row));
    }

    int[] row = new int[9];
    int[] col = new int[9];
    int[][] block = new int[3][3];

    boolean isValid(int i, int j, int number) {
        return (row[i] >> number & 1) == 0 && (col[j] >> number & 1) == 0 && (block[i / 3][j / 3] >> number & 1) == 0;
    }

    void setValue(int i, int j, int number) {
        row[i] |= 1 << number;
        col[j] |= 1 << number;
        block[i / 3][j / 3] |= 1 << number;
    }

    void unSetValue(int i, int j, int number) {
        row[i] &= ~(1 << number);
        col[j] &= ~(1 << number);
        block[i / 3][j / 3] &= ~(1 << number);
    }

    boolean backtracking(char[][] board, int i, int j) {
        if(i == 9) return true;
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                if (isValid(i, j, k)) {
                    setValue(i, j, k);
                    if(j < 8 ? backtracking(board, i, j + 1) : backtracking(board, i + 1, 0)) {
                        board[i][j] = (char) (k + '0');
                        return true;
                    }
                    unSetValue(i, j, k);
                }
            }
            board[i][j] = '.';
            return false;
        }
        return j < 8 ? backtracking(board, i, j + 1) : backtracking(board, i + 1, 0);
    }
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    setValue(i, j, board[i][j] - '0');
                }
            }
        }
        backtracking(board, 0, 0);
    }
}
