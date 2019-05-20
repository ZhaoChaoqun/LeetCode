package leetcode;

public class _198 {

    public static void main(String[] args) {
        _198 test = new _198();

        System.out.println(test.rob(new int[]{1, 2, 3, 1}));
        System.out.println(test.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(test.rob(new int[]{2, 1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        for (int i = 1; i < nums.length; i++) {
            if(i > 1)
                nums[i] += nums[i-2];
            nums[i] = Math.max(nums[i - 1], nums[i]);
        }
        return nums[nums.length - 1];
    }
}
