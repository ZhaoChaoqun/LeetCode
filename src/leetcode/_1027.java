package leetcode;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/20 3:46 下午
 */
public class _1027 {
    public static void main(String[] args) {
        _1027 test = new _1027();
        System.out.println(test.longestArithSeqLength(new int[] {3,6,9,12}));
        System.out.println(test.longestArithSeqLength(new int[] {9,4,7,2,10}));
        System.out.println(test.longestArithSeqLength(new int[] {20,1,15,3,10,5,8}));
        System.out.println(test.longestArithSeqLength(new int[] {83,20,17,43,52,78,68,45}));
        System.out.println(test.longestArithSeqLength(new int[] {24,13,1,100,0,94,3,0,3}));
        System.out.println(test.longestArithSeqLength(new int[]{0, 8, 45, 88, 48, 68, 28, 55, 17, 24}));
        System.out.println(test.longestArithSeqLength(new int[] {44,46,22,68,45,66,43,9,37,30,50,67,32,47,44,11,15,4,11,6,20,64,54,54,61,63,23,43,3,12,51,61,16,57,14,12,55,17,18,25,19,28,45,56,29,39,52,8,1,21,17,21,23,70,51,61,21,52,25,28}));
    }

    /**
     * 跟最长的斐波那契子序列解法相似，不同点在于斐波那契数列题目中原数组没有重复原理，此题有重复元素，所以只能一边遍历一边给hash字典填加
     * @param nums
     * @return
     */
    public int longestArithSeqLength(int[] nums) {
        int N = nums.length;
        Map<Integer, Integer> index = new HashMap<>(N);
        Map<Integer, Integer> dp = new HashMap<>(N);
        int max = 0;
        for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                int k = (nums[i] << 1) - nums[j];
                int kIndex = index.getOrDefault(k, -1);
                if (kIndex > -1) {
//                    int before = dp.getOrDefault(i * N + j, 2);
                    int current = dp.getOrDefault(kIndex * N + i, 0) + 1;
                    dp.put(i * N + j, current);
                    max = Math.max(max, current);
                }
            }
            // 【重要】技巧：因为nums中包含重复元素，故边遍历nums，边给index填入值，这是重复出现的元素的index一定是已经遍历的index中最大的
            // 【重要】技巧：选择nums[j] - nums[i] == nums[i] - nums[kIndex]，保证kIndex出现在i之前
            index.put(nums[i], i);
        }
        return max + 2;
    }
}
