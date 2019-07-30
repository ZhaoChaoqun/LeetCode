package leetcode;

public class _7 {
    public int reverse(int x) {
        int rev = 0;
        for(; x != 0; x /= 10) {
            if(rev * 10 / 10 != rev)
                return 0;
            rev = rev * 10 + x % 10;
        }
        return rev;
    }
}
