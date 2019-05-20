package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i))
                result.add(i);
        }
        return result;
    }

    boolean isSelfDividingNumber(int number) {
        if(number == 0)
            return false;
        for (int value = number; value > 0; value /= 10) {
            int divid = value % 10;
            if (divid == 0 || number % divid != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SelfDividingNumbers test = new SelfDividingNumbers();
        System.out.println(Arrays.toString(test.selfDividingNumbers(1, 22).toArray()));
        System.out.println(Arrays.toString(test.selfDividingNumbers(0, 0).toArray()));
    }
}
