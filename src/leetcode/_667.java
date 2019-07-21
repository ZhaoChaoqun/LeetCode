package leetcode;

import java.util.Arrays;

public class _667 {

    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        for (int i = k + 1; i < n; i++)
            result[i] = i + 1;
        for(int i = 0, number = 1; i <= k; i += 2, number++)
            result[i] = number;
        for(int i = 1, number = k + 1; i <= k; i += 2, number--)
            result[i] = number;
        return result;
    }

    public static void main(String[] args) {
        _667 test = new _667();
        System.out.println(Arrays.toString(test.constructArray(3, 1)));
        System.out.println(Arrays.toString(test.constructArray(3, 2)));
        System.out.println(Arrays.toString(test.constructArray(6, 2)));
        System.out.println(Arrays.toString(test.constructArray(10, 3)));
    }
}
