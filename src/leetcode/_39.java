package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39 {
    List<List<Integer>> matrix = new ArrayList<>();
    List<Integer> row = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return matrix;
    }

    private void backtracking(int[] candidates, int target, int index) {
        if(target == 0) {
            List<Integer> copy = new ArrayList<>(row);
            matrix.add(copy);
        } else {
            for(int i = index; i < candidates.length && candidates[i] <= target; i++) {
                row.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i);
                row.remove(row.size() - 1);
            }
        }
    }
}
