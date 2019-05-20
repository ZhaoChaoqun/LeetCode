package leetcode;

import java.util.Arrays;

public class _670_2 {

    public static void main(String[] args) {
        _670_2 test = new _670_2();
        System.out.println(test.maximumSwap(2736));
        System.out.println(test.maximumSwap(9973));
        System.out.println(test.maximumSwap(98368));
        System.out.println(test.maximumSwap(98836));
        System.out.println(test.maximumSwap(1993));
        System.out.println();
    }

    public int maximumSwap(int num) {
        int bits = 0;
        int[] array = new int[8];
        for (int tmp = num; tmp > 0; tmp /= 10, ++bits) {
            array[bits] = tmp % 10;
        }
        int[] array2 = new int[bits];
        System.arraycopy(array, 0, array2, 0, bits);
        Arrays.sort(array2);
        for (int i = --bits; i > 0; i--)
            if (array[i] != array2[i]) {
                int j = 0;
                for(; array[j] != array2[i]; j++);
                return num + (int) Math.pow(10, i) * (array[j] - array[i]) - (int) Math.pow(10, j) * (array[j] - array[i]);
            }
        return num;
    }
}
