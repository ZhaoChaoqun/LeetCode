package leetcode;

import java.util.Arrays;

/**
 * Created by zhaochaoqun on 2017/6/27.
 */
public class ZeroOneMatrix {
    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 1; i < rows; i++) {
            if(matrix[i][0] == 1) {
                matrix[i][0] = matrix[i-1][0] + 1;
            }
        }
        for(int j = 1; j < cols; j++) {
            if(matrix[0][j] == 1) {
                matrix[0][j] = matrix[0][j-1] + 1;
            }
        }
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - 1]) + 1;
                }
            }
        }
        for(int i = rows - 2; i >= 0; i--) {
            if(matrix[i][0] == 1) {
                matrix[i][0] = Math.min(matrix[i][0], matrix[i+1][0] + 1);
            }
        }
        for(int j = cols -2; j >= 0; j--) {
            if(matrix[0][j] == 1) {
                matrix[0][j] = Math.min(matrix[0][j], matrix[0][j+1] + 1);
            }
        }
        for(int i = rows - 2; i >= 0; i--) {
            for(int j = cols - 2; j >= 0; j--) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(matrix[i][j], Math.min(matrix[i + 1][j], matrix[i][j + 1]) + 1);
                }
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}
                        ,{0, 1, 1, 0, 1, 0, 1, 0, 1, 1}
                        ,{0, 0, 1, 0, 1, 0, 0, 1, 0, 0}
                        ,{1, 0, 1, 0, 1, 1, 1, 1, 1, 1}
                        ,{0, 1, 0, 1, 1, 0, 0, 0, 0, 1}
                        ,{0, 0, 1, 0, 1, 1, 1, 0, 1, 0}
                        ,{0, 1, 0, 1, 0, 1, 0, 0, 1, 1}
                        ,{1, 0, 0, 0, 1, 1, 1, 1, 0, 1}
                        ,{1, 1, 1, 1, 1, 1, 1, 0, 1, 0}
                        ,{1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        for(int[] row : updateMatrix(matrix))
            System.out.println(Arrays.toString(row));
    }
}
