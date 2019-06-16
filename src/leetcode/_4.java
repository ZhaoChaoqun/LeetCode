package leetcode;

public class _4 {

    public static void main(String[] args) {
        System.out.println(new _4().findMedianSortedArrays(new int[] {1,2}, new int[] {-1,3}));
    }
    int m, n;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            m = nums2.length;
            n = nums1.length;
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        } else {
            m = nums1.length;
            n = nums2.length;
        }
        int i = binarySearch(0, m, nums1, nums2);
        int j = ((m + n + 1) >> 1) - i;
        int maxOfLeft;
        if(i == 0) {
            maxOfLeft = nums2[j-1];
        } else if(j == 0)
            maxOfLeft = nums1[i-1];
        else
            maxOfLeft = Math.max(nums1[i-1], nums2[j-1]);
        if(((m + n) & 1) == 1)
            return maxOfLeft;
        int minOfRight;
        if(i == m)
            minOfRight = nums2[j];
        else if(j == n)
            minOfRight = nums1[i];
        else
            minOfRight = Math.min(nums1[i], nums2[j]);
        return (maxOfLeft + minOfRight) / 2.0;
    }

    private int binarySearch(int left, int right, int[] nums1, int[] nums2) {
        int i = (left + right) >> 1;
        int j = ((m + n + 1) >> 1) - i;
        if(j < n + 1 && i < m && nums2[j-1] > nums1[i]) {
            return binarySearch(i + 1, right, nums1, nums2);
        } else if(i > 0 && i < m + 1 && nums1[i-1] > nums2[j])
            return binarySearch(left, i - 1, nums1, nums2);
        return i;
    }
}
