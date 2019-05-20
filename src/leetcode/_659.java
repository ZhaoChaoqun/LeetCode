package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _659 {

    public static void main(String[] args) {
        _659 test = new _659();
        int[] nums = new int[] {1,3,3,4,4,7,8,8,9,10};
        System.out.println(test.isPossible(nums));
//        int[] nums = new int[] {1,2,3,3,4,4,5,5};
//        System.out.println(test.isPossible(nums));

    }
    public boolean isPossible(int[] nums) {
        if(nums.length < 3)
            return false;
        List<int[]> list = new ArrayList<>();
        // list中的最后子数组（int[2]，index=0存子数组当前最大值，index=1存子数组长度）
        list.add(new int[] {nums[0], 1});
        for(int i = 1; i < nums.length; i++) {
            boolean added = false;
            for(int j = list.size() - 1; j >= 0; j--) {
                if(nums[i] == list.get(j)[0] + 1) {
                    list.get(j)[0] = nums[i];
                    ++list.get(j)[1];
                    added = true;
                    break;
                } else if(nums[i] > list.get(j)[0] + 1) {
                    break;
                }
            }
            if(!added) {
                list.add(new int[] {nums[i], 1});
            }
        }
        for(int[] item : list)
            if(item[1] < 3)
                return false;
        return true;
    }
}
