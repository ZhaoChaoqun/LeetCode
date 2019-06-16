package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _754 {

    public static void main(String[] args) {
        _754 test = new _754();
//        System.out.println(test.reachNumber(0));
//        System.out.println(test.reachNumber(4));
//        System.out.println(test.reachNumber(3));
//        System.out.println(test.reachNumber(-3));
        System.out.println(test.reachNumber(5));
    }

    public int reachNumber(int target) {
        if(target < 0) target = -target;
        int sum = 0;
        int i = 0;
        for(; sum < target;)
            sum += ++i;
        if(sum == target)
            return i;
        int delta = sum - target;
        if((delta & 1) == 0)
            return i;
        return (sum + ++i - target) % 2 == 0 ? i : i + 1;
    }
}
