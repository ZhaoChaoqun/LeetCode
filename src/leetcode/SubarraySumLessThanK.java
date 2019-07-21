package leetcode;

public class SubarraySumLessThanK {


    private int binarySearch(int[] array, int begin, int end, int target) {
        if (begin >= end) return end;
        int mid = (begin + end) >> 1;
        if ((mid == 0 || array[mid - 1] <= target) && array[mid] > target) {
            return mid;
        }
        if (array[mid] > target)
            return binarySearch(array, begin, mid - 1, target);
        return binarySearch(array, mid + 1, end, target);
    }

    public int numSubarraySumLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int[] sum = new int[nums.length + 1];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
            int mid = binarySearch(sum, 0, i, sum[i + 1] - k);
            count += i - mid + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumLessThanK test = new SubarraySumLessThanK();
//        int[] nums = new int[] {10,5,2,6};
//        System.out.println(test.numSubarraySumLessThanK(nums, 11));
        int[] array = new int[] {1,2,3,4,5,6,7};
        System.out.println(test.binarySearch(array, 0, array.length - 1, 8));
    }
}
