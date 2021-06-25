package leetcode;

import java.util.Arrays;

public class _413_2 {

    public static void main(String[] args) {
        _413_2 test = new _413_2();
        System.out.println(test.numberOfArithmeticSlices(new int[] {1,3,5,7,9}));
        System.out.println(test.numberOfArithmeticSlices(new int[] {7,7,7,7}));
        System.out.println(test.numberOfArithmeticSlices(new int[] {3,-1,-5,-9}));
        System.out.println(test.numberOfArithmeticSlices(new int[] {1,1,2,5,7}));
        System.out.println(test.numberOfArithmeticSlices(new int[] {1,2,3,4}));
        System.out.println(test.numberOfArithmeticSlices(new int[] {1,2,3,8,9,10}));
    }
    public int numberOfArithmeticSlices(int[] array) {
        int result = 0;
        for (int i = 2, dp = 0; i < array.length; ++i) {
            if (array[i] + array[i-2] == array[i-1] << 1) {
                result += ++dp;
            } else {
                dp = 0;
            }
        }
        return result;
    }
}
