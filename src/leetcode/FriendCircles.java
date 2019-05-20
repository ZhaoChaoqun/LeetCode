package leetcode;

/**
 * Created by zhaochaoqun on 2017/6/27.
 */
public class FriendCircles {
    static int[][] matrix;
    static int rows, cols;

    public static int findCircleNum(int[][] M) {
        matrix = M;
        rows = M.length;
        cols = M[0].length;
        int result = 0;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][i] == 1) {
                result++;
                findCircleNum(i + 1, i);
            }
        }
        return result;
    }

    public static void findCircleNum(int i, int j) {
        matrix[j][j] = 0;
        for (int k = i; k < cols; k++) {
            if (matrix[j][k] == 1 && matrix[k][k] == 1) {
                findCircleNum(i, k);
            }
        }
    }

    public static void main(String[] args) {
//        int[][] M = new int[][]{
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}};
//        System.out.println(findCircleNum(M));
//        M = new int[][]{
//                {1, 1, 0},
//                {1, 1, 1},
//                {0, 1, 1}};
//        System.out.println(findCircleNum(M));
        int[][] M = new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        System.out.println(findCircleNum(M));
    }
}
