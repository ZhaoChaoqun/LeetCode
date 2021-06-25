package leetcode;

import java.util.Arrays;

public class _413 {

    public static void main(String[] args) {
        _413 test = new _413();
//        System.out.println(test.numberOfArithmeticSlices(new int[] {1,3,5,7,9}));
//        System.out.println(test.numberOfArithmeticSlices(new int[] {7,7,7,7}));
//        System.out.println(test.numberOfArithmeticSlices(new int[] {3,-1,-5,-9}));
//        System.out.println(test.numberOfArithmeticSlices(new int[] {1,1,2,5,7}));
//        System.out.println(test.numberOfArithmeticSlices(new int[] {1,2,3,4}));
        System.out.println(test.numberOfArithmeticSlices(new int[] {1,2,3,8,9,10}));
    }
    public int numberOfArithmeticSlices(int[] array) {
        for (int i = array.length - 1; i > 0; --i) {
            array[i] -= array[i-1];
        }
        System.out.println(Arrays.toString(array));
        int max = 0, startIndex = 1;
        for (int i = 2; i < array.length; ++i) {
            if (array[i] == array[startIndex]) {
                max = Math.max(max, i - startIndex);
            } else {
                startIndex = i;
            }
        }
        System.out.println(max);
        if (max == 0) return 0;
        int result = 0;
        max += 3;
        for (int i = max - 1; i >= 3; --i) {
            result += max - i;
        }
        return result;
    }
}
