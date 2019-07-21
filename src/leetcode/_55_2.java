package leetcode;

public class _55_2 {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        boolean[] canJump = new boolean[length];
        canJump[0] = true;
        for(int i = 1; i < length; i++) {
            for(int j = 1; j <= i; j++) {
                if(canJump[i-j] && nums[i-j] >= j) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[length-1];
    }
}
