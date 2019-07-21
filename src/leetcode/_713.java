package leetcode;

public class _713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for(int product = 1, left = 0, right = 0; right < nums.length; right++) {
            product *= nums[right];
            for(; product >= k && left <= right; product /= nums[left++]);
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10,5,2,6};
        _713 test = new _713();
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
