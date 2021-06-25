package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _454_3 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int M = nums1.length;
        Map<Integer, Integer> ab = new HashMap<>();
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < M; ++j) {
                ab.merge(nums1[i] + nums2[j], 1, Integer::sum);
            }
        }
        int count = 0;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < M; ++j) {
                count += ab.getOrDefault(-nums3[i] - nums4[j], 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _454_3 test = new _454_3();
        int[] nums1 = new int[]{-1, -1};
        int[] nums2 = new int[]{-1, 1};
        int[] nums3 = new int[]{-1, 1};
        int[] nums4 = new int[]{1, -1};
        System.out.println(test.fourSumCount(nums1, nums2, nums3, nums4));
        nums1 = new int[]{1, 2};
        nums2 = new int[]{-2, -1};
        nums3 = new int[]{-1, 2};
        nums4 = new int[]{0, 2};
        System.out.println(test.fourSumCount(nums1, nums2, nums3, nums4));
        nums1 = new int[]{0, 1, -1};
        nums2 = new int[]{-1, 1, 0};
        nums3 = new int[]{0, 0, 1};
        nums4 = new int[]{-1, 1, 1};
        System.out.println(test.fourSumCount(nums1, nums2, nums3, nums4));
        nums1 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        nums2 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        nums3 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        nums4 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(test.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
