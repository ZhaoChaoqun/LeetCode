package leetcode;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class BinaryNumberWithAlternatingBits2 {

    public boolean hasAlternatingBits(int n) {
        int previous = n & 1;
        for(int i = n >> 1; i > 0; i >>= 1) {
            int j = i & 1;
            if(previous == j)
                return false;
            previous = j;
        }
        return true;

    }

    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits2 test = new BinaryNumberWithAlternatingBits2();
        System.out.println(test.hasAlternatingBits(5));
        System.out.println(test.hasAlternatingBits(7));
        System.out.println(test.hasAlternatingBits(11));
        System.out.println(test.hasAlternatingBits(10));
    }
}
