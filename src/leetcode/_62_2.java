package leetcode;

public class _62_2 {

    public static void main(String[] args) {
        _62_2 test = new _62_2();
        System.out.println(test.uniquePaths(3, 2));
        System.out.println(test.uniquePaths(7, 3));
    }
    public int uniquePaths(int m, int n) {
        int[] matrix = new int[n];
        for(int i = 0; i < n; i++)
            matrix[i] = 1;

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                // matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                matrix[j] += matrix[j-1];
            }
        }
        return matrix[n-1];
    }
}
