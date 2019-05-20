package leetcode;

import java.util.Arrays;

public class _174_2 {

    public static void main(String[] args) {
        _174_2 test = new _174_2();
//        System.out.println(test.calculateMinimumHP(new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));

        System.out.println(test.calculateMinimumHP(new int[][] {{1,-3,3},{0,-2,0},{-3,-3,-3}}));
    }
    int backtracking(int[][] dungeon, int[][] blood, int[][] visit, int i, int j, int value) {
        if(i == 0 && j == 0) return blood[0][0];
        if(visit[i][j] == 1)
            return blood[i][j];
        visit[i][j] = 1;
        if(i == 0) {
            backtracking(dungeon, blood, visit, i, j-1, value + dungeon[i][j]);
            dungeon[i][j] += dungeon[i][j-1];
            if(dungeon[i][j] + value >= 0) {
                blood[i][j] = blood[i][j-1];
            } else {
                blood[i][j] = Math.min(blood[i][j-1], dungeon[i][j]);
            }
        } else if(j == 0) {
            backtracking(dungeon, blood, visit, i-1, j, value + dungeon[i][j]);
            dungeon[i][j] += dungeon[i-1][j];
            if(dungeon[i][j] + value >= 0) {
                blood[i][j] = blood[i-1][j];
            } else {
                blood[i][j] = Math.min(blood[i-1][j], dungeon[i][j]);
            }
        } else {
            backtracking(dungeon, blood, visit, i-1, j, value + dungeon[i][j]);
            backtracking(dungeon, blood, visit, i, j-1, value + dungeon[i][j]);
            if(blood[i-1][j] > blood[i][j-1]) {
                dungeon[i][j] += dungeon[i-1][j];
                if(dungeon[i][j] + value >= 0) {
                    blood[i][j] = blood[i-1][j];
                } else {
                    blood[i][j] = Math.min(blood[i-1][j], dungeon[i][j]);
                }
            } else {
                dungeon[i][j] += dungeon[i][j-1];
                if(dungeon[i][j] + value >= 0) {
                    blood[i][j] = blood[i][j-1];
                } else {
                    blood[i][j] = Math.min(blood[i][j-1], dungeon[i][j]);
                }
            }
        }
        return blood[i][j];
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] blood = new int[m][n];
        int[][] visit = new int[m][n];
        if(dungeon[0][0] < 0)
            blood[0][0] = dungeon[0][0];
        int result = -backtracking(dungeon, blood, visit,m-1, n-1, 0) + 1;
        for(int[] temp : blood)
            System.out.println(Arrays.toString(temp));
        return result;
    }
}
