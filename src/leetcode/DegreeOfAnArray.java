package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int maxDegree = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new int[] {i, i, 0});
            else
                map.get(nums[i])[1] = i;
            ++map.get(nums[i])[2];
            maxDegree = Math.max(maxDegree, map.get(nums[i])[2]);
        }
        int subArraySize = nums.length;
        for(int[] degree : map.values()) {
            if(degree[2] == maxDegree) {
                subArraySize = Math.min(subArraySize, degree[1] - degree[0] + 1);
            }
        }
        return subArraySize;
    }

    public static void main(String[] args) {
        DegreeOfAnArray test = new DegreeOfAnArray();
//        System.out.println(test.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
//        System.out.println(test.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        System.out.println(test.findShortestSubArray(new int[]{2, 1}));
    }
}
