package leetcode;

public class _55 {

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int i = 0;
        for (; i < nums.length - 1 && nums[i] > 0; i++) {
            // nums[i]表示到第i个位置后，还可以前进几步
            nums[i + 1] = Math.max(nums[i] - 1, nums[i + 1]);
        }
        return i == nums.length - 1;
    }
}
