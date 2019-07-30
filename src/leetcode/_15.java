package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int k = i + 1; k < nums.length - 1; k++) {
                if(k > i + 1 && nums[k] == nums[k-1]) continue;
                int part = nums[i] + nums[k];
                if(part + nums[k + 1] > 0) break;
                if(part + nums[nums.length - 1] < 0) continue;
                int three = binarySearch(nums, k + 1, nums.length - 1, -part);
                if(three != -1)
                    result.add(Arrays.asList(nums[i], nums[k], nums[three]));
            }
        }
        return result;
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] < target) {
                lo = mid + 1;
            } else if(nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,-2,1,0};
//        int[] nums = new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        _15 test = new _15();
        for(List<Integer> row : test.threeSum(nums))
            System.out.println(row);
    }
}
