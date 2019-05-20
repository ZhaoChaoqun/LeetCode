package leetcode;

public class _693_2 {
    public static void main(String[] args) {
        _693_2 test = new _693_2();
        System.out.println(test.hasAlternatingBits(5));
        System.out.println(test.hasAlternatingBits(7));
        System.out.println(test.hasAlternatingBits(11));
    }
    public boolean hasAlternatingBits(int n) {
        int bit = n & 1;
        for(n >>= 1; n > 0; bit = n & 1, n >>= 1)
            if ((n & 1) == bit)
                return false;
        return true;
    }
}
