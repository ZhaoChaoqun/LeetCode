package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _77 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(k, 1, n, new ArrayList<>());
        return result;
    }

    private void backtracking(int k, int from, int to, List<Integer> one) {
        if(to - from + 1 == k) {
            for(int i = from; i <= to; i++)
                one.add(i);
            result.add(one);
        } else {
            for(int i = from; i + k <= to; i++) {
                one.add(i);
            }
        }
    }

    public static void main(String[] args) {
        for(List<Integer> row : new _77().combine(4, 2))
            System.out.println(row);
    }
}
