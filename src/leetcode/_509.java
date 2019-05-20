package leetcode;

public class _509 {

    public static void main(String[] args) {
        for(int i = 0; i <= 30; i++) {
            System.out.println(new _509().fib(i));
        }
    }

    public int fib(int N) {
        if(N < 2) return N;
        int a = 0, b = 1;
        for(int i = 1; i < N; i++) {
            b += a;
            a = b - a;
        }
        return b;
    }
}
