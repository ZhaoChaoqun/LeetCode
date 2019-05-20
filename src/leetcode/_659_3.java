package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _659_3 {

    public static void main(String[] args) {
        _659_3 test = new _659_3();
        int[] nums = new int[] {1,3,3,4,4,7,8,8,9,10};
        System.out.println(test.isPossible(nums));
//        int[] nums = new int[] {1,2,3,3,4,4,5,5};
//        System.out.println(test.isPossible(nums));

    }
    public boolean isPossible(int[] nums) {
        if(nums.length < 3)
            return false;
        List<int[]> list = new LinkedList<>();
        // list中的最后子数组（int[2]，index=0存子数组当前最大值，index=1存子数组长度）
        list.add(new int[] {nums[0], 1});
        for(int i = 1; i < nums.length; i++) {
            boolean added = false;
            for(int[] item : list) {
                if(nums[i] == item[0] + 1) {
                    item[0] = nums[i];
                    ++item[1];
                    added = true;
                    break;
                } else if(nums[i] > item[0] + 1) {
                    break;
                }
            }
            if(!added) {
                list.add(0, new int[] {nums[i], 1});
            }
        }
        for(int[] item : list)
            if(item[1] < 3)
                return false;
        return true;
    }
}
