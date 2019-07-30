package leetcode;

public class _9 {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int div = 1;
        for(; x / div >= 10; div *= 10);
        do {
            if(x / div != x % 10)
                return false;
            // 掐头去尾
            x = (x % div) / 10;
            div /= 100;
        } while(x > 0);
        return true;
    }

    public static void main(String[] args) {
        _9 test = new _9();
        System.out.println(test.isPalindrome(1000021));
    }
}
