package leetcode;

public class _36 {
    public static void main(String[] args) {
        System.out.println(new _36().isValidSudoku(new char[][]{{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}
        }));
        System.out.println(new _36().isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}));

    }

    int[] row = new int[9];
    int[] col = new int[9];
    int[][] block = new int[3][3];
    boolean isValid(int i, int j, int number) {
        return (row[i] >> number & 1) == 0 && (col[j] >> number & 1) == 0 && (block[i/3][j/3] >> number & 1) == 0;
    }
    void setValue(int i, int j, int number) {
        row[i] |= 1 << number;
        col[j] |= 1 << number;
        block[i/3][j/3] |= 1 << number;
    }
    void unSetValue(int i, int j, int number) {
        row[i] &= ~(1 << number);
        col[j] &= ~(1 << number);
        block[i/3][j/3] &= ~(1 << number);
    }


    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(!isValid(i, j, board[i][j] - '0'))
                        return false;
                    setValue(i, j, board[i][j] - '0');
                }
            }
        }
        return true;
    }
}
