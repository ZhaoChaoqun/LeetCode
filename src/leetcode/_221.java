package leetcode;

public class _221 {
    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] side = new int[rows][cols];
        int[] max = {0};
        for(int i = 0; i < cols; i++)
            if(matrix[0][i] == '1') {
                max[0] = 1;
                break;
            }
        if(max[0] == 0)
            for(int i = 0; i < rows; i++)
                if(matrix[i][0] == '1') {
                    max[0] = 1;
                    break;
                }
        maximalSquare(matrix, side, rows - 1, cols - 1, max);
        return max[0] * max[0];
    }

    public static int maximalSquare(char[][] matrix, int[][] side, int i, int j, int[] max) {
        if(i == 0 || j == 0) {
            return matrix[i][j] - '0';
        }
        if(matrix[i][j] == '1') {
            if(side[i][j] == 0) {
                side[i][j] = Math.min(maximalSquare(matrix, side, i-1, j, max), maximalSquare(matrix, side, i, j-1, max));
                if(matrix[i-side[i][j]][j-side[i][j]] == '1')
                    side[i][j]++;
                max[0] = Math.max(max[0], side[i][j]);
            }
        } else {
            maximalSquare(matrix, side, i-1, j, max);
            maximalSquare(matrix, side, i, j-1, max);
        }
        return side[i][j];
    }
}
