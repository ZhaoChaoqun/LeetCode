package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _354 {

    private int compare(int[] a, int[] b) {
        if (a[0] > b[0] && a[1] > b[1]) {
            return 1;
        } else if (a[0] < b[0] && a[1] < b[1]) {
            return -1;
        }
        return 0;
    }

    private int compare2(int[] a, int[] b) {
        if (a[0] > b[0]) {
            return 1;
        } else if (a[0] == b[0]) {
            if (a[1] > b[1]) {
                return 1;
            } else if (a[1] == b[1]) {
                return 0;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, this::compare2);
        for (int[] envelope : envelopes) {
            System.out.println(Arrays.toString(envelope));
        }
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) {
            dp[i] = 1;
        }
        for (int i = 1; i < envelopes.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (compare(envelopes[i], envelopes[j]) == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < dp.length; ++i) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][] {{5,4},{6,4},{6,7},{2,3}};
        envelopes = new int[][] {{10,17},{10,19},{16,2},{19,18},{5,6}};
        System.out.println(new _354().maxEnvelopes(envelopes));
    }
}
