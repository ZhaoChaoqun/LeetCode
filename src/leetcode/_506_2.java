package leetcode;

import java.util.Arrays;

public class _506_2 {

    private void exchange(int i, int j) {
        int value = nums[i];
        nums[i] = nums[j];
        nums[j] = value;
    }
    int[] nums;
    public String[] findRelativeRanks(int[] nums) {
        this.nums = nums;
        String[] ranks = new String[nums.length];
        for(int i = 1; i <= nums.length; i++) {
            int max = nums[0], maxIndex = 0;
            for(int j = 1; j <= nums.length - i; j++) {
                if(nums[j] > max) {
                    max = nums[j];
                    maxIndex = j;
                }
            }
            exchange(maxIndex, nums.length - i);
            if(i == 1) {
                ranks[maxIndex] = "Gold Medal";
            } else if(i == 2) {
                ranks[maxIndex] = "Silver Medal";

            } else if(i == 3) {
                ranks[maxIndex] = "Bronze Medal";
            } else {
                ranks[maxIndex] = Integer.toString(i);
            }
        }
        System.out.println(Arrays.toString(ranks));
        return ranks;
    }

    public static void main(String[] args) {
        _506_2 test = new _506_2();
//        System.out.println(Arrays.toString(test.findRelativeRanks(new int[] {5,4,3,2,1})));
        test.findRelativeRanks(new int[] {7,2,4,6,8,5});
        test.findRelativeRanks(new int[] {5,4,3,2,1});
    }
}
