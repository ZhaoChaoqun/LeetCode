package leetcode;

public class _70_2 {
    public static void main(String[] args) {
        _70_2 test = new _70_2();
//        System.out.println(test.climbStairs(2));
        System.out.println(test.climbStairs(44));
    }
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int a = 1, b = 2;
        for(int i = 3; i <= n; i++) {
            b += a;
            a = b - a;
        }
        return b;
    }
}
