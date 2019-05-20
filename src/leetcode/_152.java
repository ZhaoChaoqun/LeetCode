package leetcode;

public class _152 {

    public static void main(String[] args) {
//        System.out.println(new _152().maxProduct(new int[]{-2, 2, 3, -2, 4}));
//        System.out.println(new _152().maxProduct(new int[]{-2, 0, -1}));
//        System.out.println(new _152().maxProduct(new int[]{-2}));
        System.out.println(new _152().maxProduct(new int[]{-1,-2,-9,-6}));
    }

    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (max <= 0)
                    max = nums[i];
                else
                    max *= nums[i];
                if (min >= 0)
                    min = nums[i];
                else
                    min *= nums[i];
            } else {
                int temp = max;
                if (min >= 0)
                    max = nums[i];
                else
                    max = min * nums[i];
                if (temp <= 0)
                    min = nums[i];
                else
                    min = temp * nums[i];
            }
            result = Math.max(max, result);
        }
        return result;
    }
}
