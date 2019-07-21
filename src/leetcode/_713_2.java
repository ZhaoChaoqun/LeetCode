package leetcode;

public class _713_2 {

    private int binarySearch(double[] array, int begin, int end, double target) {
        if (begin >= end) return end;
        int mid = (begin + end) >> 1;
        if ((mid == 0 || array[mid - 1] <= target) && array[mid] > target) {
            return mid;
        }
        if (array[mid] > target)
            return binarySearch(array, begin, mid - 1, target);
        return binarySearch(array, mid + 1, end, target);
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        double[] sum = new double[nums.length + 1];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + Math.log(nums[i]);
            int mid = binarySearch(sum, 0, i, sum[i + 1] - Math.log(k) + 1e-9);
            count += i - mid + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10,5,2,6};
        _713_2 test = new _713_2();
        int[] array = new int[47220];
        for(int i = 0; i < 47220; i++)
            array[i] = 1;
        array[12808] = 6;
        array[24832] = 67;
        array[867] = 67;
        array[21913] = 67;
        System.out.println(test.numSubarrayProductLessThanK(array, 5));
        System.out.println(test.numSubarrayProductLessThanK(nums, 100));
//        System.out.println(test.numSubarrayProductLessThanK(new int[] {1,2,3}, 0));
    }
}
