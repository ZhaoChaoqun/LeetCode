package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _373_2 {

    public static void main(String[] args) {
        _373_2 test = new _373_2();
//        for (int[] array : test.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 9))
//            System.out.print(Arrays.toString(array) + "\t");
//        System.out.println();
        for (int[] array : test.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 9))
            System.out.print(Arrays.toString(array) + "\t");
        System.out.println();
        for (int[] array : test.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3))
            System.out.print(Arrays.toString(array) + "\t");
//        System.out.println();
//
//        for (int[] array : test.kSmallestPairs(new int[]{34,774,1640,1814}, new int[]{801,933,1093,1498,2384,2665,3310}, 50))
//            System.out.print(Arrays.toString(array) + "\t");
//        System.out.println();
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        k = Math.min(k, nums1.length * nums2.length);
        List<int[]> result = new ArrayList<>(k);
        if(nums1.length == 0 || nums2.length == 0)
            return result;
        int[] index1 = new int[nums1.length];
        int[] index2 = new int[nums2.length];
        result.add(new int[] {nums1[0], nums2[0]});
        index1[0] = 1;
        index2[0] = 1;
        for(int i = 0, j = 0; k > 1; k--) {
            if(i == nums1.length - 1) {
                for (; k > 1; k--)
                    result.add(new int[]{nums1[i], nums2[index1[i]++]});
                return result;
            }
            if(j == nums2.length - 1) {
                for (; k > 1; k--)
                    result.add(new int[]{nums1[index2[j]++], nums2[j]});
                return result;
            }
            if(i == nums1.length - 1) {
                for (; k > 1; k--)
                    result.add(new int[]{nums1[i], nums2[index1[i]++]});
                return result;
            }

            if (nums1[i] + nums2[index1[i]] <= nums1[i + 1] + nums2[index1[i + 1]]) {
                result.add(new int[]{nums1[i], nums2[index1[i]]});
                if (++index1[i] == nums2.length) i++;
            } else {
                result.add(new int[]{nums1[i + 1], nums2[index1[i + 1]]});
                ++index1[i + 1];
            }

        }
        return result;
    }
}
