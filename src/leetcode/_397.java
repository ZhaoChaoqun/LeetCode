package leetcode;

import java.util.HashMap;

public class _397 {
    public static void main(String[] args) {
        _397 test = new _397();
        System.out.println(test.integerReplacement(39));
        System.out.println(test.integerReplacement(40));
        System.out.println(test.integerReplacement(38));
        System.out.println(test.integerReplacement(25));
        System.out.println(test.integerReplacement(Integer.MAX_VALUE));
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        map.put(1, 0);
        return recursive(n);
    }
    private int recursive(int n) {
        if(map.containsKey(n))
            return map.get(n);
        int result;
        if((n & 1) == 0) {
            result = recursive(n >>> 1) + 1;
        } else
            result =  Math.min(recursive(n - 1), recursive(n + 1)) + 1;
        map.put(n, result);
        return result;
    }

    
}
