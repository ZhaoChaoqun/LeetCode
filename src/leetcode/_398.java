package leetcode;

import java.util.Random;

public class _398 {

    public _398(int[] nums) {
        this.nums = nums;
    }
    int[] nums;
    Random random = new Random();
    public int pick(int target) {
        int count = 1, result = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == target && random.nextInt(count++) == 0)
                result = i;
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new _398(new int[] {1,2,3,3,3}).pick(3));
    }
}
