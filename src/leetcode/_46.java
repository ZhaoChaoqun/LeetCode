package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        backtracking(nums, 0, one, result);
        return result;
    }
    private void backtracking(int[] nums, int current, List<Integer> one, List<List<Integer>> result) {
        if(current == nums.length) result.add(new ArrayList<>(one));
        else {
            for(int i = 0; i < nums.length; i++) {
                boolean has = false;
                for(int num : one) {
                    if(num == nums[i]) {
                        has = true;
                        break;
                    }
                }
                if(!has) {
                    one.add(nums[i]);
                    backtracking(nums, current + 1, one, result);
                    one.remove(one.size() - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        _46 test = new _46();
        for(List<Integer> row : test.permute(new int[] {1,2,3}))
            System.out.println(row);
    }
}
