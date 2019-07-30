package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < nums.length - 1; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                for(int k = j + 1; k < nums.length - 1; k++) {
                    if(k > j + 1 && nums[k] == nums[k-1]) continue;
                    int part = nums[i] + nums[j] + nums[k];
                    if(part + nums[k + 1] > target) break;
                    if(part + nums[nums.length - 1] < target) continue;
                    int three = Arrays.binarySearch(nums, k + 1, nums.length, target - part);
                    if(three >= 0)
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[three]));
                }
            }
        }
        return result;
    }
}
