package leetcode;

import java.util.Arrays;

public class _363_2 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        // 单个
        int[][] colAccumulate = new int[rows+1][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                colAccumulate[i+1][j] = matrix[i][j] + colAccumulate[i][j];
            }
        }
        int[] array = new int[cols+1];
        for (int i = 0; i < rows; ++i) {
            for (int j = i + 1; j <= rows; ++j) {
                for (int m = 0; m < cols; ++m) {
                    array[m+1] = array[m] + colAccumulate[j][m] - colAccumulate[i][m];
                }
                for (int x = 0; x < cols; ++x) {
                    for (int y = x + 1; y <= cols; ++y) {
                        int value = array[y] - array[x];
                        if (value <= k) {
                            max = Integer.max(max, value);
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,0,1},{0,-2,3}};
        int k = 2;
//        int[][] matrix = new int[][] {{2,2,-1}};
//        int k = 0;
//        int[][] matrix = new int[][] {{28,4,-19,18,-7,-10,27,19,1,16,0,10,-17,11,11,27,-1,10,12,-1},{-2,-19,17,4,25,-20,4,3,4,28,-10,7,16,-14,-3,-19,6,17,-4,-7},{2,8,18,-17,-2,10,-6,-5,11,10,22,-6,19,-16,6,-4,18,5,22,-17},{-14,-7,-20,13,-19,-20,-15,21,-11,-10,-8,-9,10,13,6,-10,15,9,-15,-2},{-18,26,12,8,2,16,-17,12,0,-5,9,-3,-12,-11,3,-6,-18,16,-7,-14},{5,29,25,22,11,-3,-2,-15,4,13,-17,-2,0,-2,20,10,-18,6,25,-20},{5,-7,8,5,15,22,8,-5,22,-18,-5,-14,23,2,-8,12,-16,-18,12,-12},{27,18,4,11,-3,12,-4,-8,-3,25,-9,24,-14,5,11,-9,-17,0,25,-15},{26,-7,18,4,4,18,-17,9,-19,-9,-19,-8,-4,-13,10,-11,6,-16,-12,12},{28,22,7,11,-6,13,8,22,7,-14,17,14,10,29,16,9,-3,18,-9,10},{27,19,-10,-9,1,3,14,1,7,3,-3,16,-2,9,14,-7,-19,-5,23,19},{-17,7,-20,8,-5,-6,-2,25,29,16,23,4,4,27,16,17,9,20,-6,22},{2,9,-13,1,-18,25,4,7,25,26,-4,8,-19,18,6,-7,-5,7,21,-8},{-2,11,1,29,6,-16,-8,3,7,11,10,-2,-1,-20,20,4,19,5,29,-7},{29,-12,-3,17,6,19,23,12,-19,13,19,5,27,22,-17,27,10,-12,12,23},{24,16,4,25,15,13,24,-19,1,-7,-19,13,-13,14,13,26,9,18,-9,-18},{-17,4,-18,-18,-19,3,-13,12,23,-17,-10,-20,14,2,18,21,-12,27,-3,4},{27,13,12,14,16,-9,-2,-15,-20,8,-2,24,18,15,26,21,27,17,-15,-3},{25,-8,17,-10,-16,13,26,-11,-15,6,-5,-13,23,2,24,-4,5,8,-15,-1},{15,-12,18,5,-3,7,5,11,-4,-13,28,20,0,-4,-13,-5,-13,-8,-16,3}};
//        int k = -99;
        System.out.println(new _363_2().maxSumSubmatrix(matrix, k));
    }
}
