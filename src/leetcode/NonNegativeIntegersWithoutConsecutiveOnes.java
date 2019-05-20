package leetcode;

/**
 * Created by zhaochaoqun on 2017/6/19.
 */
public class NonNegativeIntegersWithoutConsecutiveOnes {
    public static int findIntegers(int num) {
        if(num < 2) return num;
        int i = 0;
        for(; num > 0; i++) {
            num >>= 1;
        }
        int result = num - i + 2;
        if(num == (1 << i) - 1) {
            result--;
        }
        return result;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++)
            System.out.println(findIntegers(i));
    }
}
