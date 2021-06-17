package leetcode;

import java.util.Arrays;

public class _918_2 {

    public static void main(String[] args) {
        System.out.println(new _918_2().maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println(new _918_2().maxSubarraySumCircular(new int[]{5,-3,5}));
        System.out.println(new _918_2().maxSubarraySumCircular(new int[]{3,-1,2,-1}));
        System.out.println(new _918_2().maxSubarraySumCircular(new int[]{3,-2,2,-3}));
        System.out.println(new _918_2().maxSubarraySumCircular(new int[]{6,9,-3}));
        System.out.println(new _918_2().maxSubarraySumCircular(new int[]{-2,-3,-1}));
        System.out.println(new _918_2().maxSubarraySumCircular(new int[]{3,1,3,2,6}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0];
        int[] front = new int[nums.length];
        int[] maxRight = new int[nums.length+2];
        front[0] = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            front[i] = nums[i] + Math.max(0, front[i-1]);
            max = Math.max(max, front[i]);
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            maxRight[i] = maxRight[i+1] + nums[i];
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            maxRight[i] = Math.max(maxRight[i], maxRight[i+1]);
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            leftSum += nums[i];
            max = Math.max(max, leftSum + maxRight[i+2]);
        }
        return max;
    }
}
