package leetcode;

/**
 * Created by zhaochaoqun on 2017/6/24.
 */
public class DeleteOperationForTwoStrings {

    public static int minDistance(String word1, String word2) {
        char[] aChars = word1.toCharArray();
        char[] bChars = word2.toCharArray();
        int m = aChars.length, n = bChars.length;
        int[][] matrix = new int[m + 1][n + 1];
        for(int i = 1; i <=m; i++)
            matrix[i][0] = i;
        for(int j = 1; j <=n; j++)
            matrix[0][j] = j;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                matrix[i][j] = matrix[i-1][j-1];
                if(aChars[i-1] != bChars[j-1]) {
                    matrix[i][j] += 2;
                }
                matrix[i][j] = Math.min(matrix[i][j], Math.min(matrix[i][j-1], matrix[i-1][j]) + 1);
            }
        }
        return matrix[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat"));
    }
}
