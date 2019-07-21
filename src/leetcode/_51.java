package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _51 {

    public static void main(String[] args) {
        for (List<String> row : new _51().solveNQueens(4)) {
            System.out.println(row);
        }
    }


    int row;
    int col;
    long diagonal;
    long antiDiagonal;
    List<List<String>> result = new ArrayList<>();
    char[][] matrix;

    boolean isValid(int i, int j, int n) {
        return (row >> i & 1) == 0 && (col >> j & 1) == 0 && (diagonal >> (i + j) & 1) == 0 && (antiDiagonal >> (j - i + n - 1) & 1) == 0;
    }

    void setValue(int i, int j, int n) {
        row |= 1 << i;
        col |= 1 << j;
        diagonal |= 1 << i + j;
        antiDiagonal |= 1 << j - i + n - 1;
    }

    void unSetValue(int i, int j, int n) {
        row &= ~(1 << i);
        col &= ~(1 << j);
        diagonal &= ~(1 << i + j);
        antiDiagonal &= ~(1 << j - i + n - 1);
    }

    void backtracking(int n, int level) {
        if (level == n) {
            List<String> current = new ArrayList<>(n);
            for (char[] row : matrix)
                current.add(new String(row));
            result.add(current);
        } else {
            for (int j = 0; j < n; j++) {
                if (isValid(level, j, n)) {
                    matrix[level][j] = 'Q';
                    setValue(level, j, n);
                    backtracking(n, level + 1);
                    matrix[level][j] = '.';
                    unSetValue(level, j, n);
                }
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        matrix = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = '.';
        backtracking(n, 0);
        return result;
    }
}
