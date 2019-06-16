package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _60 {

    public static void main(String[] args) {
        _60 test = new _60();
        System.out.println(test.getPermutation(3, 3));
        System.out.println(test.getPermutation(4, 9));
    }
    public String getPermutation(int n, int k) {
        int factorial = 1;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            factorial *= i;
            list.add(i);
        }
        k--;
        int result = 0;
        for(int index; n > 0;) {
            factorial /= n--;
            index = k / factorial;
            result = result * 10 + list.remove(index);
            k -= index * factorial;
        }
        return Integer.toString(result);
    }
}
