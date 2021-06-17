package leetcode;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/15 5:16 下午
 */
public class Interview_17_24_2 {

    public static void main(String[] args) {
        Interview_17_24_2 test = new Interview_17_24_2();
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
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    result = new int[] {i,j,i,j};
                }
            }
        }
        // 单行
        for (int i = 1; i < rows; ++i) {
            matrix[i][0] += matrix[i-1][0];
            if (matrix[i][0] > max) {
                max = matrix[i][0];
                result = new int[] {0,0,i,0};
            }
        }
        // 单列
        for (int j = 1; j < cols; ++j) {
            matrix[0][j] += matrix[0][j-1];
            if (matrix[0][j] > max) {
                max = matrix[0][j];
                result = new int[] {0,0,0,j};
            }
        }

        // 从左上角到[i,j]的整块矩阵
        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                matrix[i][j] += matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1];
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    result = new int[] {0,0,i,j};
                }
            }
        }
//        for (int[] row : matrix) {
//            System.out.println(Arrays.toString(row));
//        }

        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                for (int m = 0; m < i; ++m) {
                    for (int n = 0; n < j; ++n) {
                        int value = matrix[i][j] - matrix[m][j] - matrix[i][n] + matrix[m][n];
                        if (value > max) {
                            max = value;
                            result = new int[] {m+1, n+1, i, j};
                        }
                    }
                }
                for (int n = 0; n < j; ++n) {
                    int value = matrix[i][j] - matrix[i][n];
                    if (value > max) {
                        max = value;
                        result = new int[] {0, n+1, i, j};
                    }
                }
                for (int m = 0; m < i; ++m) {
                    int value = matrix[i][j] - matrix[m][j];
                    if (value > max) {
                        max = value;
                        result = new int[] {m+1, 0, i, j};
                    }
                }
            }
        }
        return result;
    }
}
