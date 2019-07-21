package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _60_2 {

    public static void main(String[] args) {
        _60_2 test = new _60_2();
        System.out.println(test.getPermutation(3, 3));
        System.out.println(test.getPermutation(4, 9));
    }
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            nums.add(i);

        int[] one = new int[1];
        backtracking(n, k, nums, one, 9, 362880);
        return one[0] + "";
    }

    private void backtracking(int n, int k, List<Integer> nums, int[] one, int current, int factorial) {
        if(current == 0) return;
        else {
            factorial /= current;
            if(n >= current) {
                int num = (k-1) / factorial;
                one[0] = one[0] * 10 + nums.remove(num);
                k -= num * factorial;
            }
            backtracking(n, k, nums, one, current - 1, factorial);
        }
    }
}
