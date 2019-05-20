package leetcode;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class BinaryNumberWithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == chars[i-1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits test = new BinaryNumberWithAlternatingBits();
        System.out.println(test.hasAlternatingBits(5));
        System.out.println(test.hasAlternatingBits(7));
        System.out.println(test.hasAlternatingBits(11));
        System.out.println(test.hasAlternatingBits(10));
    }
}
