package leetcode;

import java.util.Arrays;

public class _738 {
    public int monotoneIncreasingDigits(int n) {
        int value = n;
        int i = 0;
        for(; value > 0; value /= 10, i++) {

        }
        int[] number = new int[i + 1];
        for(value = n; value > 0; value /= 10) {
            number[i--] = value % 10;
        }
        for(i = 1; i < number.length - 1; i++) {
            if(number[i] > number[i+1]) {
                number[i]--;
                int j = i;
                for(; j >= 0; ) {
                    if(number[j] >= number[j-1]) {
                        break;
                    }
                    number[--j]--;
                }

                for(j++; j < number.length; j++)
                    number[j] = 9;
            }
        }
        int result = 0;
        for(int base = 1, j = number.length - 1; j >= 0; j--, base *= 10)
            result += number[j] * base;
        return result;
    }

    public static void main(String[] args) {
        _738 test = new _738();
        System.out.println(test.monotoneIncreasingDigits(10));
        System.out.println(test.monotoneIncreasingDigits(327));
        System.out.println(test.monotoneIncreasingDigits(332));
        System.out.println(test.monotoneIncreasingDigits(1234));
        System.out.println(test.monotoneIncreasingDigits(120));
    }
}
