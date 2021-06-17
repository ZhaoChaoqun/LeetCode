package leetcode;

public class _152_2 {

    public static void main(String[] args) {
        System.out.println(new _152_2().maxProduct(new int[]{-2, 2, 3, -2, 4}));
        System.out.println(new _152_2().maxProduct(new int[]{-2, 0, -1}));
        System.out.println(new _152_2().maxProduct(new int[]{-2}));
        System.out.println(new _152_2().maxProduct(new int[]{-1,-2,-9,-6}));
        System.out.println(new _152_2().maxProduct(new int[]{0, -2}));
        System.out.println(new _152_2().maxProduct(new int[]{0, 2}));
    }

    public int maxProduct(int[] nums) {
        int[] positive = new int[nums.length + 1];
        int[] negative = new int[nums.length + 1];
        positive[0] = negative[0] = 1;
        for (int i = 0; i < nums.length; ++i) {
            positive[i+1] = nums[i];
            negative[i+1] = nums[i];
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= 0) {
                positive[i+1] *= Math.max(1, positive[i]);
                negative[i+1] *= Math.min(1, negative[i]);
            } else {
                positive[i+1] *= Math.min(1, negative[i]);
                negative[i+1] *= Math.max(1, positive[i]);
            }
            max = Math.max(max, positive[i+1]);
        }
        return max;
    }
}
