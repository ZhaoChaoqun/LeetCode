package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _542_3 {

    int M;
    int N;
    int[][] mat;
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        M = mat.length;
        N = mat[0].length;
        this.mat = mat;
        List<int[]> availableSet = new ArrayList<>();
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (mat[i][j] == 0) {
                    availableSet.add(new int[] {i, j});
                }
            }
        }
        for (int path = -1; !availableSet.isEmpty(); --path) {
            List<int[]> newAvailableSet = new ArrayList<>();
            for (int[] position : availableSet) {
                for (int index = 0; index < 4; ++index) {
                    int newI = position[0] + directions[index][0], newJ = position[1] + directions[index][1];
                    if (available(newI, newJ)) {
                        mat[newI][newJ] = path;
                        newAvailableSet.add(new int[] {newI, newJ});
                    }
                }
            }
            availableSet = newAvailableSet;
        }
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                mat[i][j] = -mat[i][j];
            }
        }
        return mat;
    }

    private boolean available(int i, int j) {
        if (i < 0 || j < 0 || i == M || j == N || mat[i][j] <= 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _542_3 test = new _542_3();
        int[][] matrix = test.updateMatrix(new int[][] {{1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}});
        for (int i = 0; i < matrix.length; ++i) {
            System.out.println(i + ": " + Arrays.toString(matrix[i]));
        }
    }
}
