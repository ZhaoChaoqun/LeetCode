package leetcode;

import java.util.*;

public class _542 {


    int M;
    int N;
    int[][] mat;
    int[][] visit;
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        M = mat.length;
        N = mat[0].length;
        this.mat = mat;
        visit = new int[M][N];
        for (int i = 0; i < M; ++i) {
            visit[i] = new int[N];
        }
        Set<Integer> availableSet = new HashSet<>();
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (mat[i][j] == 0) {
                    availableSet.add(i * N + j);
                }
            }
        }
        bfs(1, availableSet);
//        for (int i = 0; i < visit.length; ++i) {
//            System.out.println(i + ": " + Arrays.toString(visit[i]));
//        }
//        System.out.println();
        return mat;
    }

    private boolean available(int i, int j) {
        if (i < 0 || j < 0 || i == M || j == N || mat[i][j] == 0 || visit[i][j] == 1) {
            return false;
        }
        return true;
    }

    // 从0往开扩散
    private void bfs(int path, Set<Integer> availableSet) {
        if (availableSet.isEmpty()) {
            return;
        }
        Set<Integer> newAvailableSet = new HashSet<>();
        for (Integer position : availableSet) {
            int i = position / N;
            int j = position % N;
            for (int index = 0; index < 4; ++index) {
                int newI = i + directions[index][0], newJ = j + directions[index][1];
                if (available(newI, newJ)) {
                    visit[newI][newJ] = 1;
                    mat[newI][newJ] = path;
                    newAvailableSet.add(newI * N + newJ);
                }
            }
        }
        bfs(path + 1, newAvailableSet);
    }

    public static void main(String[] args) {
        _542 test = new _542();
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
