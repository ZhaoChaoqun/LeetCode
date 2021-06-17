package leetcode;

public class _152_3 {

    public static void main(String[] args) {
        System.out.println(new _152_3().maxProduct(new int[]{-2, 2, 3, -2, 4}));
        System.out.println(new _152_3().maxProduct(new int[]{-2, 0, -1}));
        System.out.println(new _152_3().maxProduct(new int[]{-2}));
        System.out.println(new _152_3().maxProduct(new int[]{-1,-2,-9,-6}));
        System.out.println(new _152_3().maxProduct(new int[]{0, -2}));
        System.out.println(new _152_3().maxProduct(new int[]{0, 2}));
    }

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int positive = max, negative = max;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] >= 0) {
                positive = nums[i] * Math.max(1, positive);
                negative = nums[i] * Math.min(1, negative);
            } else {
                int before = positive;
                positive = nums[i] * Math.min(1, negative);
                negative = nums[i] * Math.max(1, before);
            }
            max = Math.max(max, positive);
        }
        return max;
    }
}
