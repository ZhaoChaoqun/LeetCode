package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _417 {

    public static void main(String[] args) {
        _417 test = new _417();
        List<int[]> result = new _417().pacificAtlantic(new int[][]{{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}});
//        System.out.println(Arrays.toString(item));
//        System.out.println();
//        for(int[] item : new _417().pacificAtlantic(new int[][]{{1, 1}, {1, 1}}))
//            System.out.println(Arrays.toString(item));
//        System.out.println();
//
//        for(int[] item : new _417().pacificAtlantic(new int[][]{{1, 2}, {4, 3}}))
//            System.out.println(Arrays.toString(item));
//        System.out.println();
//
//        for(int[] item : new _417().pacificAtlantic(new int[][]{{1}}))
//            System.out.println(Arrays.toString(item));
//        System.out.println();
//        List<int[]> duplicateSubtrees = new _417().pacificAtlantic(new int[][]{{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}});
        result.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];

            }
        });
        for (int[] item : result)
            System.out.println(Arrays.toString(item));
    }

    List<int[]> result = new ArrayList<>();

    void backtracking(int i, int j, int m, int n, int[][] matrix, int[][] used) {
        if (used[i][j] == 0) {
            used[i][j] = 1;
            result.add(new int[]{i, j});
            if (i > 0 && matrix[i - 1][j] >= matrix[i][j]) {
                backtracking(i - 1, j, m, n, matrix, used);
            }
            if (i < m - 1 && matrix[i + 1][j] >= matrix[i][j]) {
                backtracking(i + 1, j, m, n, matrix, used);
            }
            if (j > 0 && matrix[i][j - 1] >= matrix[i][j]) {
                backtracking(i, j - 1, m, n, matrix, used);
            }
            if (j < n - 1 && matrix[i][j + 1] >= matrix[i][j]) {
                backtracking(i, j + 1, m, n, matrix, used);
            }
        }
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        int[][] used = new int[m][n];
        backtracking(0, n - 1, m, n, matrix, used);
        backtracking(m - 1, 0, m, n, matrix, used);
        return result;
    }
}
