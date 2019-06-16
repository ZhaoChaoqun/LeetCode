package leetcode;

import java.util.Arrays;

public class _542 {



    private int recursive(int[][] matrix, int i, int j) {
        if(i < 0 || i == m || j < 0 || j == n) return Integer.MAX_VALUE;
        if(matrix[i][j] == 0) return 0;
        if(visit[i][j] == 1) return Integer.MAX_VALUE;
        if(visit[i][j] == 2) return matrix[i][j];
        visit[i][j] = 1;
        matrix[i][j] = Integer.MAX_VALUE;
        int up = recursive(matrix, i - 1, j);
        int down = recursive(matrix, i + 1, j);
        int left = recursive(matrix, i, j - 1);
        int right = recursive(matrix, i, j + 1);
        matrix[i][j] = Math.min(Math.min(up, down), Math.min(left, right)) + 1;
        visit[i][i] = 2;
        return matrix[i][j];
    }
    int m, n;
    int[][] visit;
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        if(m == 0) return matrix;
        n = matrix[0].length;
        visit = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(matrix[i][j] > 0 && visit[i][j] < 2) {
                    recursive(matrix, i, j);
                    visit[i][j] = 2;
                }
        return matrix;
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
        for(int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}
