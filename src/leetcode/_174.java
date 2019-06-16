package leetcode;

import java.util.Arrays;

public class _174 {

    public static void main(String[] args) {
        _174 test = new _174();
//        System.out.println(test.calculateMinimumHP(new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        System.out.println(test.calculateMinimumHP(new int[][] {{1,-3,3}, {0,-2,0}, {-3,-3,-3}}));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] blood = new int[m][n];
        int[][] min = new int[m][n];
        int[][] sum = new int[m][n];
        sum[m-1][n-1] = dungeon[m-1][n-1];
        for(int i = n-2; i >= 0; i--) {
            sum[m-1][i] = dungeon[m-1][i] + sum[m-1][i+1];
        }
        for(int i = m-2; i >= 0; i--) {
            sum[i][n-1] = dungeon[i][n-1] + sum[i+1][n-1];
        }
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                sum[i][j] = dungeon[i][j] + Math.max(sum[i+1][j], sum[i][j+1]);
            }
        }
        blood[0][0] = dungeon[0][0];
        min[0][0] = dungeon[0][0];
        for(int i = 1; i < n; i++) {
            blood[0][i] = blood[0][i-1] + dungeon[0][i];
            min[0][i] = Math.min(min[0][i-1], blood[0][i]);
        }
        for(int i = 1; i < m; i++) {
            blood[i][0] = blood[i-1][0] + dungeon[i][0];
            min[i][0] = Math.min(min[i-1][0], blood[i][0]);
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                int up = Math.min(min[i-1][j], blood[i-1][j] + Math.min(dungeon[i][j], sum[i][j]));
                int left = Math.min(min[i][j-1], blood[i][j-1] + Math.min(dungeon[i][j], sum[i][j]));
                if(up >= left) {
                    blood[i][j] = blood[i-1][j] + dungeon[i][j];
                    min[i][j] = Math.min(min[i-1][j], blood[i-1][j] + dungeon[i][j]);;
                } else {
                    blood[i][j] = blood[i][j-1] + dungeon[i][j];
                    min[i][j] = Math.min(min[i][j-1], blood[i][j-1] + dungeon[i][j]);;
                }
            }
        }
//        for(int[] row : blood)
//            System.out.println(Arrays.toString(row));

        return min[m-1][n-1] > 0 ? 0 : -min[m-1][n-1] + 1;
    }
}
