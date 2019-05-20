package leetcode;

import java.util.Arrays;

public class _85 {
    public static void main(String[] args) {
        _85 test = new _85();
        System.out.println(test.maximalRectangle(new char[][]{
                "10100".toCharArray(),
                "10111".toCharArray(),
                "11111".toCharArray(),
                "10010".toCharArray()
        }));
    }


    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        int[][] rows = new int[row][col];
        int[][] cols = new int[row][col];
        int[][] areas = new int[row][col];

        if (matrix[0][0] == '1') {
            rows[0][0] = 1;
            cols[0][0] = 1;
            areas[0][0] = 1;
        }
        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == '1') {
                rows[0][i] = 1;
                cols[0][i] = cols[0][i - 1] + 1;
                areas[0][i] = cols[0][i];
            }
        }
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == '1') {
                cols[i][0] = 1;
                rows[i][0] = rows[i - 1][0] + 1;
                areas[i][0] = rows[i][0];
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                areas[i][j] = Math.max(areas[i - 1][j], areas[i][j - 1]);
                if (matrix[i][j] == '1') {
                    if(matrix[i][j-1] == '0')
                        rows[i][j] = rows[i - 1][j] + 1;
                    else
                        rows[i][j] = Math.min(rows[i - 1][j] + 1, rows[i][j - 1]);
                    cols[i][j] = Math.max(cols[i][j - 1] + 1, cols[i - 1][j]);
                    areas[i][j] = Math.max(areas[i][j], rows[i][j] * cols[i][j]);
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    rows[i][j] = Math.max(rows[i - 1][j] + 1, rows[i][j - 1]);
                    if(cols[i - 1][j] == '0')
                        cols[i][j] = cols[i][j - 1] + 1;
                    else
                        cols[i][j] = Math.min(cols[i][j - 1] + 1, cols[i - 1][j]);
                    areas[i][j] = Math.max(areas[i][j], rows[i][j] * cols[i][j]);
                }
            }
        }
        for(int[] temp : areas)
            System.out.println(Arrays.toString(temp));
        return areas[row - 1][col - 1];
    }
}
