package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _354_2 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        dp[0] = nums[0];
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len + 1, num);
            if (i < 0) {
                dp[-i-1] = num;
                if (- i - 1 > len) {
                    ++len;
                }
            } else if (i <= len) {
                dp[i] = num;
            }
        }
        return len + 1;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
//        for (int[] envelope : envelopes) {
//            System.out.println(Arrays.toString(envelope));
//        }
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) {
            height[i] = envelopes[i][1];
        }
//        System.out.println(Arrays.toString(height));
        return lengthOfLIS(height);
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][] {{5,4},{6,4},{6,7},{2,3}};
        envelopes = new int[][] {{4,5},{4,6},{6,7},{2,3},{1,1},{1,1}};
//        envelopes = new int[][] {{10,17},{10,19},{16,2},{19,18},{5,6}};
        System.out.println(new _354_2().maxEnvelopes(envelopes));
    }
}
