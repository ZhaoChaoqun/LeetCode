package leetcode;

import java.util.Arrays;

public class _174 {

    public static void main(String[] args) {
        _174 test = new _174();
        System.out.println(test.calculateMinimumHP(new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
    }
    void backtracking(int[][] dungeon, int[][] blood, int i, int j, int m, int n) {

    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] blood = new int[m][n];
        if(dungeon[0][0] < 0)
            blood[0][0] = dungeon[0][0];
//        初始化第一行
        for(int i = 1; i < n; i++) {
            dungeon[0][i] += dungeon[0][i-1];
            if(blood[0][i-1] < 0) {
                blood[0][i] = Math.min(blood[0][i-1], dungeon[0][i]);
            } else {
                blood[0][i] = Math.min(0, dungeon[0][i]);
            }
        }
//        初始化第一列
        for(int i = 1; i < m; i++) {
            dungeon[i][0] += dungeon[i-1][0];
            if(blood[i-1][0] < 0) {
                blood[i][0] = Math.min(blood[i-1][0], dungeon[i][0]);
            } else {
                blood[i][0] = Math.min(0, dungeon[i][0]);
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(dungeon[i][j] < 0) {
//                    丛上走流的血多
                    if(blood[i-1][j] < blood[i][j-1]) {
                        if(dungeon[i][j] + dungeon[i][j-1] < blood[i-1][j]) {
//                            从上走
                            dungeon[i][j] += dungeon[i-1][j];
                            blood[i][j] = Math.min(blood[i-1][j], dungeon[i][j]);
                        } else {
                            dungeon[i][j] += dungeon[i][j-1];
                            blood[i][j] = Math.min(blood[i][j-1], dungeon[i][j]);
                        }
                    } else {
                        if(dungeon[i][j] + dungeon[i-1][j] < blood[i][j-1]) {
//                            从左走
                            dungeon[i][j] += dungeon[i][j-1];
                            blood[i][j] = Math.min(blood[i][j-1], dungeon[i][j]);
                        } else {
                            dungeon[i][j] += dungeon[i-1][j];
                            blood[i][j] = Math.min(blood[i-1][j], dungeon[i][j]);
                        }
                    }

                } else {
                    if(blood[i-1][j] > blood[i][j-1]) {
                        dungeon[i][j] += dungeon[i-1][j];
                        blood[i][j] = blood[i-1][j];
                    } else {
                        dungeon[i][j] += dungeon[i][j-1];
                        blood[i][j] = blood[i][j-1];
                    }
                }
            }
        }
        for(int[] temp : dungeon)
            System.out.println(Arrays.toString(temp));
        for(int[] temp : blood)
            System.out.println(Arrays.toString(temp));
        return -blood[m-1][n-1] + 1;
    }
}
