package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> row = new ArrayList<Integer>();
        backtracking(candidates, target, 0, matrix, row);
        return matrix;
    }

    private void backtracking(int[] candidates, int target, int index, List<List<Integer>> matrix, List<Integer> row) {
        if(target == 0) {
            List<Integer> copy = new ArrayList<>(row);
            matrix.add(copy);
        } else {
            for(int i = index; i < candidates.length && candidates[i] <= target; i++) {
                if(i != index && candidates[i] == candidates[i-1]) continue;
                row.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i + 1, matrix, row);
                row.remove(row.size() - 1);
            }
        }
    }
}
