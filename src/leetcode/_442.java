package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _442 {


    public static void main(String[] args) {
        _442 test = new _442();
        System.out.println(new _442().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(new _442().findDuplicates(new int[]{1, 1}));
        System.out.println(new _442().findDuplicates(new int[]{2, 1}));
    }

    void backtracking(int[] nums, int i, int start) {
        if (nums[i - 1] == 0) {
            result.add(i);
        } else {
            int tmp = nums[i - 1];
            nums[i - 1] = 0;
            // i - 1 > start：保证i-1索引的元素之前没访问过
            if (i - 1 > start)
                backtracking(nums, tmp, start);
        }
    }

    List<Integer> result = new ArrayList<>();
    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                backtracking(nums, nums[i], i);
        return result;
    }
}
