package leetcode;

public class _397_2 {
    public static void main(String[] args) {
        _397_2 test = new _397_2();
//        for (int i = 1; i < 20; i++)
//        System.out.println(test.integerReplacement(39) + " " + test.integerReplacement2(39));
//        System.out.println(test.integerReplacement(40) + " " + test.integerReplacement2(40));
        System.out.println(test.integerReplacement(Integer.MAX_VALUE));
        System.out.println(-10 >>> 1);
        System.out.println(-10 >> 1);
//        System.out.println(test.integerReplacement(25));
//        System.out.println(test.integerReplacement(27));
    }
    public int integerReplacement(int n) {
        return recursive(n);
    }
    private int recursive(int n) {
        if(n == 1) return 0;
        if((n & 1) == 0)
            return recursive(n >>> 1) + 1;
        return Math.min(recursive(n - 1), recursive(n + 1)) + 1;
    }

}
