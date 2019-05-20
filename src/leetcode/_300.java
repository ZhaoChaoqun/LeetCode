package leetcode;

import java.util.Arrays;

public class _300 {

    public static void main(String[] args) {
        _300 test = new _300();
        System.out.println(test.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        System.out.println(test.lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6}));
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] array = new int[nums.length];
        int max = 0;
        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= array[i]; j--)
                if(nums[i] > nums[j])
                    array[i] = Math.max(array[i], array[j] + 1);
            max = Integer.max(max, array[i]);
        }
        return max + 1;
    }
}
