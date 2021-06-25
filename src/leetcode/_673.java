package leetcode;

import java.util.Arrays;

public class _673 {
    public static void main(String[] args) {
        System.out.println(new _673().findNumberOfLIS(new int[] {1,3,5,4,7,6,8}));
        System.out.println(new _673().findNumberOfLIS(new int[] {2,2,2,2,2}));
        System.out.println(new _673().findNumberOfLIS(new int[] {1,2,4,3,5,4,7,2}));
    }

    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[][] array = new int[nums.length][2];
        array[0] = new int[]{1,1};
        for(int i = 1; i < nums.length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    max = Math.max(array[j][0], max);
            }
            if(max == 0)
                array[i][1] = 1;
            else {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j] && array[j][0] == max)
                        array[i][1] += array[j][1];
                }
            }
            array[i][0] = max + 1;
        }
        for(int[] row : array)
            System.out.println(Arrays.toString(row));
        int max = 0;
        for(int j = 0; j < array.length; j++) {
            max = Math.max(array[j][0], max);
        }
        int result = 0;
        for(int j = 0; j < array.length; j++) {
            if(array[j][0] == max)
                result += array[j][1];
        }
        return result;
    }
}
