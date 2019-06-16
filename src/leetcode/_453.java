package leetcode;

public class _453 {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for(int i = 0; i < nums.length; i++)
            min = Math.min(min, nums[i]);
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i] - min;
        return sum;
    }
}
