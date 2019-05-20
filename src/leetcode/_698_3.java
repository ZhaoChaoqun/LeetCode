package leetcode;

import java.util.Arrays;

public class _698_3 {

    public static void main(String[] args) {
        System.out.println(new _698_3().canPartitionKSubsets(new int [] {4, 3, 2, 3, 5, 2, 1}, 4));
//        System.out.println(new _698_3().canPartitionKSubsets(new int [] {10,10,10,7,7,7,7,7,7,6,6,6}, 3));
//        System.out.println(new _698_3().canPartitionKSubsets(new int [] {2,2,2,2,3,4,5}, 4));
//        System.out.println(new _698_3().canPartitionKSubsets(new int [] {4,15,1,1,1,1,3,11,1,10}, 3));
//        System.out.println(new _698_3().canPartitionKSubsets(new int [] {1,1,1,1,1,1,1,1,1,1}, 5));
    }

    boolean backtracking(int[] nums, int[] used, int target, int index, int count) {
        for(int i = index; i >= 0; i--) {
            if(target >= nums[i] && used[i] == 0) {
                target -= nums[i];
                used[i] = 1;
                if(backtracking(nums, used, target, i, count)) {
                    if(--count == 0)
                        return true;
                }
            }

        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % k != 0) return false;
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        sum /= k;
        boolean result = backtracking(nums, used, sum, nums.length - 1, k);
        System.out.println(Arrays.toString(used));
        return result;
    }

}
