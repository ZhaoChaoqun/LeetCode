package leetcode;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/15 5:16 下午
 */
public class Interview_17_24_3 {

    public static void main(String[] args) {
        Interview_17_24_3 test = new Interview_17_24_3();
        System.out.println(Arrays.toString(test.getMaxMatrix(new int[][]{{-1, 0}, {0, -1}})));
        System.out.println(Arrays.toString(test.getMaxMatrix(new int[][]{{9,-8,1,3,-2}, {-3,7,6,-2,4},{6,-4,-4,8,-7}})));
        System.out.println(Arrays.toString(test.getMaxMatrix(new int[][]{{1, -3}, {-4, 9}})));
        System.out.println(Arrays.toString(test.getMaxMatrix(new int[][]{{-1, -2, -9, 6}, {8, -9, -3, -6}, {2, 9, -7, -6}})));
    }

    public int[] getMaxMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = matrix[0][0];
        int[] result = new int[4];
        // 单个
        int[][] colAccumulate = new int[rows+1][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                colAccumulate[i+1][j] = matrix[i][j] + colAccumulate[i][j];
            }
        }
        for (int i = 0; i < rows; ++i) {
            for (int j = i + 1; j <= rows; ++j) {
                int dp = Integer.MIN_VALUE;
                int startCol = 0;
                for (int k = 0; k < cols; ++k) {
                    if (dp <= 0) {
                        startCol = k;
                        dp = colAccumulate[j][k] - colAccumulate[i][k];
                    } else {
                        dp += colAccumulate[j][k] - colAccumulate[i][k];
                    }
                    if (dp > max) {
                        max = dp;
                        result = new int[] {i, startCol, j-1, k};
                    }
                }
            }
        }
        return result;
    }
}
