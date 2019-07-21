package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _738_3 {
    public int monotoneIncreasingDigits(int n) {
        int value = n;
        int[] number = new int[10];
        for(int i = 0; value > 0; value /= 10)   // 按照倒序存
            number[i++] = value % 10;
        for(int i = number.length - 2; i > 0; i--) {
            if(number[i] > number[i - 1]) { // 前一位大于后一位
                for(int j = i; j < number.length; j++) {
                    if(number[j] - 1 >= number[j+1]) {
                        int base = (int) Math.pow(10, j);
                        int result = number[j] * base - 1;
                        for(j++, base *= 10; j < number.length; j++, base *= 10)
                            result += number[j] * base;
                        return result;
                    }
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        _738_3 test = new _738_3();
        System.out.println(test.monotoneIncreasingDigits(10));
        System.out.println(test.monotoneIncreasingDigits(327));
        System.out.println(test.monotoneIncreasingDigits(332));
        System.out.println(test.monotoneIncreasingDigits(1234));
        System.out.println(test.monotoneIncreasingDigits(120));
    }
}
