package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _738_2 {
    public int monotoneIncreasingDigits(int n) {
        int value = n;
        List<Integer> number = new ArrayList<>();
        for(; value > 0; value /= 10)   // 按照倒序存
            number.add(value % 10);
        number.add(0);
        for(int i = number.size() - 2; i > 0; i--) {
            if(number.get(i) > number.get(i - 1)) { // 前一位大于后一位
                number.set(i, number.get(i) - 1);
                int j = i;
                for(; j < number.size(); j++) {
                    if(number.get(j) >= number.get(j+1))
                        break;
                    number.set(j+1, number.get(j+1) - 1);
                }
                for(j--; j >= 0; j--)
                    number.set(j, 9);
                int result = 0;
                for(int base = 1, bit = 0; j < number.size(); bit++, base *= 10)
                    result += number.get(bit) * base;
                return result;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        _738_2 test = new _738_2();
        System.out.println(test.monotoneIncreasingDigits(10));
        System.out.println(test.monotoneIncreasingDigits(327));
        System.out.println(test.monotoneIncreasingDigits(332));
        System.out.println(test.monotoneIncreasingDigits(1234));
        System.out.println(test.monotoneIncreasingDigits(120));
    }
}
