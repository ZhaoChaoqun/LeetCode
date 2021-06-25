package leetcode;

import java.util.Arrays;

public class _454_2 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int M = nums1.length, N = nums2.length, X = nums3.length, Y = nums4.length;
        int[] ab = new int[M * N];
        int[] cd = new int[X * Y];
        int index = 0;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                ab[index++] = nums1[i] + nums2[j];
            }
        }
        index = 0;
        for (int i = 0; i < X; ++i) {
            for (int j = 0; j < Y; ++j) {
                cd[index++] = nums3[i] + nums4[j];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);
//        System.out.println(Arrays.toString(ab));
//        System.out.println(Arrays.toString(cd));
        int count = 0;
        for (int i = 0; i < ab.length; ++i) {
            for (int start = binarySearch(cd, 0, cd.length - 1, -ab[i]); start >= 0; start = binarySearch(cd, start + 1, cd.length - 1, -ab[i])) {
                ++count;
            }
//            System.out.println(String.format("%d, count=%d", -ab[i], count));
        }
        return count;
    }

    private static int binarySearch(int[] array, int fromIndex, int toIndex, int key) {
        return binarySearch(array, fromIndex, fromIndex, toIndex, key);
    }

    private static int binarySearch(int[] array, int realFrom, int fromIndex, int toIndex, int key) {
        if (fromIndex > toIndex) {
            return -1;
        }
        int mid = (fromIndex + toIndex) >> 1;
        if (array[mid] > key) {
            return binarySearch(array, realFrom, fromIndex, mid-1, key);
        } else if (array[mid] == key) {
            int i = mid - 1;
            for (; i >= realFrom && array[i] == key; --i);
            return i + 1;
        }
        return binarySearch(array, realFrom, mid + 1, toIndex, key);
    }

    public static void main(String[] args) {
        _454_2 test = new _454_2();
        int[] nums1 = new int[]{-1, -1};
        int[] nums2 = new int[]{-1,1};
        int[] nums3 = new int[]{-1,1};
        int[] nums4 = new int[]{1,-1};
        System.out.println(test.fourSumCount(nums1, nums2, nums3, nums4));
        nums1 = new int[]{ 1, 2};
        nums2 = new int[]{-2,-1};
        nums3 = new int[]{-1, 2};
        nums4 = new int[]{ 0, 2};
        System.out.println(test.fourSumCount(nums1, nums2, nums3, nums4));
        nums1 = new int[]{0,1,-1};
        nums2 = new int[]{-1,1,0};
        nums3 = new int[]{0,0,1};
        nums4 = new int[]{-1,1,1};
        System.out.println(test.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
