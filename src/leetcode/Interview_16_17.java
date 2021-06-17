package leetcode;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/15 5:16 下午
 */
public class Interview_16_17 {

    public static void main(String[] args) {
        Interview_16_17 test = new Interview_16_17();
        System.out.println(test.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            dp = nums[i] + Math.max(0, dp);
            max = Math.max(max, dp);
        }
        return max;
    }
}
