package leetcode;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/15 5:16 下午
 */
public class Interview_17_24 {

    public static void main(String[] args) {
        Interview_17_24 test = new Interview_17_24();
        System.out.println(Arrays.toString(test.getMaxMatrix(new int[][]{{-1, 0}, {0, -1}})));
        System.out.println(Arrays.toString(test.getMaxMatrix(new int[][]{{9,-8,1,3,-2}, {-3,7,6,-2,4},{6,-4,-4,8,-7}})));
        System.out.println(Arrays.toString(test.getMaxMatrix(new int[][]{{1, -3}, {-4, 9}})));

    }

    static class T {
        int row;
        int col;
        int value;
        T(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public int[] getMaxMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        T[][] dp = new T[rows][cols];
        int[][] rowSum = new int[rows][cols];
        int[][] colSum = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            rowSum[i][0] = matrix[i][0];
            for (int j = 1; j < cols; ++j) {
                rowSum[i][j] = rowSum[i][j-1] + matrix[i][j];
            }
        }
        for (int i = 0; i < cols; ++i) {
            colSum[0][i] = matrix[0][i];
            for (int j = 1; j < rows; ++j) {
                colSum[j][i] = colSum[j-1][i] + matrix[j][i];
            }
        }
        int max = matrix[0][0];
        int[] result = new int[4];
        dp[0][0] = new T(0,0, matrix[0][0]);
        for (int j = 1; j < cols; ++j) {
            if (dp[0][j-1].value > 0) {
                dp[0][j] = new T(0,dp[0][j-1].col,matrix[0][j] + dp[0][j-1].value);
            } else {
                dp[0][j] = new T(0,j,matrix[0][j]);
            }
            if (dp[0][j].value > max) {
                max = dp[0][j].value;
                result = new int[] {dp[0][j].row, dp[0][j].col, 0, j};
            }
        }
        for (int i = 1; i < rows; ++i) {
            if (dp[i-1][0].value > 0) {
                dp[i][0] = new T(dp[i-1][0].row, 0,matrix[i][0] + dp[i-1][0].value);
            } else {
                dp[i][0] = new T(i,0,matrix[i][0]);
            }
            if (dp[i][0].value > max) {
                max = dp[i][0].value;
                result = new int[] {dp[i][0].row, dp[i][0].col, i, 0};
            }
        }
        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                int value1 = dp[i-1][j].value + rowSum[i][j];
                if (dp[i-1][j].col-1 >= 0) {
                    value1 -= rowSum[i][dp[i-1][j].col-1];
                }
                int value2 = dp[i][j-1].value + colSum[i][j];
                if (dp[i][j-1].row-1 >= 0) {
                    value2 -= colSum[dp[i][j-1].row-1][j];
                }
                if (Math.max(value1, value2) > matrix[i][j]) {
                    if (value1 >= value2) {
                        dp[i][j] = new T(dp[i-1][j].row, dp[i-1][j].col, value1);
                    } else if (value1 < value2) {
                        dp[i][j] = new T(dp[i][j-1].row, dp[i][j-1].col, value2);
                    } else {
                        // TODO
                    }
                } else {
                    dp[i][j] = new T(i, j, matrix[i][j]);
                }
                if (dp[i][j].value > max) {
                    max = dp[i][j].value;
                    result = new int[] {dp[i][j].row, dp[i][j].col, i, j};
                }
            }
        }
        return result;

    }
}
