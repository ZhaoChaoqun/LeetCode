package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _995 {


    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        // Tell when to close an interval
        boolean[] needClose = new boolean[n];
        int ans = 0, nIntervals = 0;
        for (int i = 0; i < n; i++) {
            // Close this interval if needed
            if (needClose[i]) nIntervals--;
            // When meet following two situations, we need flipping here
            // if nums[i] is 0 and number of intervals is even 
            // --> means the flippings are totally cancelled. We need another flip
            // if nums[i] is 1 and number of intervals is odd
            // --> means we have 1 before but being flipped to 0. Need flip again.
            if ((nums[i] == 0 && nIntervals % 2 == 0) || (nums[i] == 1 && nIntervals % 2 == 1)) {
                // Need flip again. Update answer count
                ++ans;
                // Generate an interval
                ++nIntervals;
                if (i > n - k) {
                    // nums[n-k] is the final possible flipping position
                    // i > n-k means we need to flip the subarray is less than k elements
                    // impossible!
                    return -1;
                }
                // Update needClose, so the current interval will be closed at nums[i+k]
                if (i + k < n) needClose[i + k] = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _995 test = new _995();
//        System.out.println(test.minKBitFlips(new int[] {}, 1));
//        System.out.println(test.minKBitFlips(new int[] {0}, 1));
//        System.out.println(test.minKBitFlips(new int[] {0,1,0}, 1));
//        System.out.println(test.minKBitFlips(new int[] {1,1,0}, 2));
//        System.out.println(test.minKBitFlips(new int[] {0,0,0,1,0,1,1,0}, 3));
        System.out.println(test.minKBitFlips(new int[]{0, 1, 0, 0, 1, 0}, 4));
        System.out.println(test.minKBitFlips(new int[]{0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0}, 8));
    }
}
