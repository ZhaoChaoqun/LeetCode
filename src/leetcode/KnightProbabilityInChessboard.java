package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaochaoqun on 2017/12/18.
 */
public class KnightProbabilityInChessboard {

    public double knightProbability(int N, int K, int r, int c) {
        matrix = new double[K][N][N];
        return innerRecursion(N, K - 1, r, c) / Math.pow(8, K);
    }
    private double[][][] matrix;
    public double innerRecursion(int N, int K, int r, int c) {
        if(r < 0 || c < 0 || r >= N || c >= N || K < -1)
            return 0;
        if(K == -1)
            return 1;
        if(matrix[K][r][c] > 0)
            return matrix[K][r][c];
        double probability = innerRecursion(N, K - 1, r - 2, c - 1) + innerRecursion(N, K - 1, r - 2, c + 1)
                + innerRecursion(N, K - 1, r + 2, c - 1) + innerRecursion(N, K - 1, r + 2, c + 1)
                + innerRecursion(N, K - 1, r - 1, c - 2) + innerRecursion(N, K - 1, r - 1, c + 2)
                + innerRecursion(N, K - 1, r + 1, c - 2) + innerRecursion(N, K - 1, r + 1, c + 2);
        matrix[K][r][c] = probability;
        matrix[K][c][r] = probability;
        matrix[K][N - 1- r][c] = probability;
        matrix[K][N - 1 - c][r] = probability;
        matrix[K][r][N - 1 - c] = probability;
        matrix[K][c][N - 1 - r] = probability;
        matrix[K][N - 1 - r][N - 1 - c] = probability;
        matrix[K][N - 1 - c][N - 1 - r] = probability;
        return probability;
    }

    public static void main(String[] args) {
        KnightProbabilityInChessboard test = new KnightProbabilityInChessboard();
        System.out.println(test.knightProbability(3, 2, 0, 0));
        System.out.println(test.knightProbability(8, 30, 6, 4));
        System.out.println(test.knightProbability(3, 3, 0, 0));
    }
}
