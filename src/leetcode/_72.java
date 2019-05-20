package leetcode;

public class _72 {

    public static void main(String[] args) {
        System.out.println(new _72().minDistance("horse", "ros"));
        System.out.println(new _72().minDistance("intention", "execution"));
    }


    int backtracking(int i, int j) {
        if(i == 0) {
            return j;
        }
        if(j == 0) {
            return i;
        }
        if(matrix[i][j] != null)
            return matrix[i][j];
        if(chars1[i-1] == chars2[j-1]) {
            matrix[i][j] = backtracking(i-1, j-1);
        } else {
            matrix[i][j] = 1 + Math.min(Math.min(backtracking(i-1, j-1), backtracking(i, j-1)), backtracking(i-1, j));
        }
        return matrix[i][j];
    }
    Integer[][] matrix;
    char[] chars1;
    char[] chars2;
    public int minDistance(String word1, String word2) {
        chars1 = word1.toCharArray();
        chars2 = word2.toCharArray();
        int m = chars1.length;
        int n = chars2.length;
        matrix = new Integer[m+1][n+1];
        return backtracking(m, n);
    }
}
