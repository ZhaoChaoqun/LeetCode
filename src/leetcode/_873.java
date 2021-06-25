package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/20 1:32 下午
 */
public class _873 {

    public static void main(String[] args) {
        _873 test = new _873();
//        System.out.println(test.lenLongestFibSubseq(new int[] {1,2,3,4,5,6,7,8}));
//        System.out.println(test.lenLongestFibSubseq(new int[] {1,3,7,11,12,14,18}));
//        System.out.println(test.lenLongestFibSubseq(new int[] {2,4,7,8,9,10,14,15,18,23,32,50}));
        System.out.println(test.lenLongestFibSubseq(new int[] {2392,2545,2666,5043,5090,5869,6978,7293,7795}));
    }

    public int lenLongestFibSubseq(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            index.put(arr[i], i);
        }
        int max = 0;
        for (int i = 0; i < arr.length - 2; ++i) {
            for (int j = i + 2; j < arr.length; ++j) {
                int k = arr[j] - arr[i];
                if (k < arr[i]) {
                    continue;
                }
                int kIndex = index.getOrDefault(k, -1);
                if (kIndex > i) {
                    dp[kIndex][j] = dp[i][kIndex] == 0 ? 3 : dp[i][kIndex] + 1;
                    max = Math.max(max, dp[kIndex][j]);
                }
            }
        }
        return max;
    }
}
