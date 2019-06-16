package leetcode;

import java.util.LinkedList;

public class _45 {


    public static void main(String[] args) {
        System.out.println(new _45().jump(new int[]{}));
        System.out.println(new _45().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new _45().jump(new int[] {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }


    public int jump(int[] nums) {
        int length = nums.length;
        if (length <= 1) return 0;
        int level = 0, currentMax = 0, i = 0, nextMax = 0;

        while (i <= currentMax) {        //nodes count of current level>0
            level++;
            for (; i <= currentMax; i++) {    //traverse current level , and update the max reach of next level
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= length - 1) return level;   // if last element is in level+1,  then the min jump=level
            }
            currentMax = nextMax;
        }
        return 0;
    }
}
