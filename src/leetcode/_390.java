package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _390 {


    public static void main(String[] args) {
        _390 test = new _390();
        for(int i = 0; i <= 8; i++)
            System.out.println(i + " " + test.lastRemaining(i));
    }
    public int lastRemaining(int n) {
        int fromLeft = 1, head = 1;
        for(int step = 1; n > 1; step <<= 1, n >>= 1, fromLeft ^= 1)
            if(fromLeft == 1 || n % 2 == 1) head += step;
        return head;
    }
}
