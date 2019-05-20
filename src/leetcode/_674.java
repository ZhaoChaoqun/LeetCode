package leetcode;

public class _674 {

    public static void main(String[] args) {
        _674 test = new _674();
        System.out.println(test.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(test.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(test.findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }

    public int findLengthOfLCIS(int[] nums) {
        int max = 0, i = 1, from = 0;
        for (; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (i - from > max)
                    max = i - from;
                from = i;
            }
        }
        if (i == nums.length) {
            if (nums.length - from > max)
                max = nums.length - from;
        }
        return max;
    }

}
