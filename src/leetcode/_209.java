package leetcode;

public class _209 {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int sum = nums[0];
        int l = 0, r = 0;
        while(r < nums.length - 1) {
            for (; r < nums.length - 1 && sum < s; ) {
                sum += nums[++r];
            }
            for (; l <= r && sum >= s; ) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        _209 test = new _209();
        System.out.println(test.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }
}
