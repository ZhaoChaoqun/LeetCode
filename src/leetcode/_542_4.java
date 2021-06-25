package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _542_4 {

    int M;
    int N;
    int[][] mat;
    int[][] result;

    public int[][] updateMatrix(int[][] mat) {
        M = mat.length;
        N = mat[0].length;
        this.mat = mat;
        result = new int[M][N];
        for (int i = 0; i < M; ++i) {
            result[i] = new int[N];
            for (int j = 0; j < N; ++j) {
                if (mat[i][j] == 0) {
                    continue;
                }
                result[i][j] = Math.min(i > 0 ? result[i-1][j] : 10000, j > 0 ? result[i][j-1] : 10000) + 1;
            }
        }
        for (int i = M - 1; i >= 0; --i) {
            for (int j = N - 1; j >= 0; --j) {
                if (mat[i][j] == 0) {
                    continue;
                }
                result[i][j] = Math.min(result[i][j], Math.min(i < M - 1 ? result[i+1][j] : 10000, j < N - 1 ? result[i][j+1] : 10000) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _542_4 test = new _542_4();
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
