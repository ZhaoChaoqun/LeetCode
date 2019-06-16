package leetcode;


import java.math.BigInteger;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        for(int i = 1; i <= 25; i++)
            extraLongFactorials(i);
    }

    static void extraLongFactorials(int n) {

        long factorials = 1;
        for(int i = 1; i <= Math.min(n, 19); i++)
            factorials *= i;
        if(n < 20) {
            System.out.println(factorials);
        } else {
            BigInteger bigInteger = new BigInteger(Long.toString(factorials));
            for(int i = 20; i <= n; i++)
                bigInteger = bigInteger.multiply(new BigInteger(Integer.toString(i)));
            System.out.println(bigInteger);
        }

    }
}
