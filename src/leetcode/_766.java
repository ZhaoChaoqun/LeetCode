package leetcode;

public class _766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m-1; i++) {
            for(int j = 1; i + j < m && j < n; j++) {
                if(matrix[i+j][j] != matrix[i][0]) {
                    return false;
                }
            }
        }

        for(int j = 1; j < n; j++) {
            for(int i = 1; i < m && i + j < n; i++) {
                if(matrix[i][i + j] != matrix[0][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _766().isToeplitzMatrix(new int[][]{
                {1,2,3,4},
                {5,1,2,3},
                {9,5,1,2}
        }));
        System.out.println(new _766().isToeplitzMatrix(new int[][]{
                {1,2},
                {2,2}
        }));
    }
}
