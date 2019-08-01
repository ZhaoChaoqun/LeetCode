package leetcode;

public class _96 {
    public int numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        for(int i = 1; i < n; i++) {
            result[i] = 2 * result[i-1];
            for(int j = 0; j < i - 1; j++) {
                result[i] += result[j] * result[i-2-j];
            }
        }
        return result[n-1];
    }
}
