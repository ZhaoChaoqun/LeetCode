package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _46_2 {
    public List<List<Integer>> permute(int[] nums) {
        return backtracking(nums, 0, nums.length - 1);
    }
    private List<List<Integer>> backtracking(int[] nums, int left, int right) {
        List<List<Integer>> result = new ArrayList<>();
        if(left == right) {
            List<Integer> one = new ArrayList<>();
            one.add(nums[left]);
            result.add(one);
            return result;
        }
        for(int i = left; i <= right; i++) {
            List<List<Integer>> part1 = backtracking(nums, left, i);
            List<List<Integer>> part2 = backtracking(nums, i + 1, right);
            for(List<Integer> one : part1) {
                for(List<Integer> two : part2) {
                    List<Integer> three = new ArrayList<>(one);
                    three.addAll(two);
                    result.add(three);
                    three = new ArrayList<>(two);
                    three.addAll(one);
                    result.add(three);

                }
            }
        }
        return result;
    }
}
