package leetcode;

import java.util.Arrays;

public class _661 {
    public static void main(String[] args) {
        _661 test = new _661();
        int row = 10, col = 5;
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = (int) (Math.random() * 255);
            }
        }
        for (int[] item : matrix) {
            System.out.println(Arrays.toString(item));
        }

    }


}
