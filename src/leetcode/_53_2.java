package leetcode;

public class _53_2 {


    public static void main(String[] args) {
        _53_2 test = new _53_2();
        System.out.println(test.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(test.maxSubArray(new int[]{1}));
        System.out.println(test.maxSubArray(new int[]{0}));
        System.out.println(test.maxSubArray(new int[]{-1}));
        System.out.println(test.maxSubArray(new int[]{-100000}));
    }

    public int maxSubArray(int[] nums) {
//        int[] nums2 = new int[nums.length];
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += Math.max(0, nums[i-1]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
