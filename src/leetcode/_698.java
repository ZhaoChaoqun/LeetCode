package leetcode;

import java.util.Arrays;

public class _698 {

    public static void main(String[] args) {
//        _698 test = new _698();
//        System.out.println(test.canPartitionKSubsets(new int [] {4, 3, 2, 3, 5, 2, 1}, 4));
    }

//    boolean backtracking(int[] nums, int[] used, int index, int target) {
//        if(target == 0) {
//            used[index] = 1;
//            return true;
//        }
//        for(int i = index + 1; i < nums.length; i++) {
//            if (backtracking(nums, used, i, target - nums[i])) {
//                used[index] = 1;
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    public boolean canPartitionKSubsets(int[] nums, int k) {
//        int sum = 0;
//        for (int num : nums)
//            sum += num;
//        if (sum % k != 0) return false;
//        sum /= k;
//        int[] used = new int[nums.length];
//        Arrays.sort(nums);
//        if (nums[nums.length - 1] > sum) return false;
//        for(int i = 0; i < nums.length; i++) {
//            if(used[i] == 0)
//                if(!backtracking(nums, used, i, sum - nums[i]))
//                    return false;
//        }
//        return true;
//    }
//
//    int search(int[] nums, int[] used, int target, int left, int right) {
//        if (left > right) return -1;
//        int mid = (left + right) / 2;
//        if(nums[mid] == target) {
//            if(used[mid] == 0)
//                return mid;
//            int leftFind = search(nums, used, target,mid + 1, right);
//            if(leftFind != -1) return leftFind;
//            return search(nums, used, target, left, mid - 1);
//        }
//        if (nums[mid] < target)
//            return search(nums, used, target,mid + 1, right);
//        return search(nums, used, target, left, mid - 1);
//    }
}
