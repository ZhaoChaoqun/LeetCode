package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/20 1:32 下午
 */
public class _873_2 {

    public static void main(String[] args) {
        _873_2 test = new _873_2();
        System.out.println(test.lenLongestFibSubseq(new int[] {1,2,3,4,5,6,7,8}));
        System.out.println(test.lenLongestFibSubseq(new int[] {1,3,7,11,12,14,18}));
        System.out.println(test.lenLongestFibSubseq(new int[] {2,4,7,8,9,10,14,15,18,23,32,50}));
        System.out.println(test.lenLongestFibSubseq(new int[] {2392,2545,2666,5043,5090,5869,6978,7293,7795}));
    }

    public int lenLongestFibSubseq(int[] arr) {
        int N = arr.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            index.put(arr[i], i);
        }
        Map<Integer, Integer> dp = new HashMap<>();
        int max = 0;
        for (int i = 0; i < N - 2; ++i) {
            for (int j = i + 1; j < N; ++j) {
                int k = arr[j] - arr[i];
                if (k < arr[i]) {
                    continue;
                }
                int kIndex = index.getOrDefault(k, -1);
                if (kIndex > i) {
                    // 技巧：使用(i * N + j)将二维数组索引存储到一维数组中去
                    // Encoding tuple (i, j) as integer (i * N + j)
                    int value = dp.getOrDefault(i * N + kIndex, 2) + 1;
//                    System.out.println(String.format("%d + %d = %d, count = %d", arr[i], arr[kIndex], arr[j], value));
                    dp.put(kIndex * N + j, value);
                    max = Math.max(max, value);
                }
            }
        }
//        System.out.println(dp);
        return max;
    }
}
