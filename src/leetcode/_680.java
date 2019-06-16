package leetcode;

public class _680 {

    public boolean validPalindrome(String s) {
        char[] c = s.toCharArray();
        int length = c.length;
        for(int i = 0, j = length - 1; i < j; i++, j--) {
            if(c[i] != c[j]) {
                int m = i + 1, n = j;
                for(; m < n && c[m] == c[n]; m++, n--);
                if(m >= n) return true;
                m = i; n = j - 1;
                for(; m < n && c[m] == c[n]; m++, n--);
                return m >= n;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _680 test = new _680();
        System.out.println(test.validPalindrome("aba"));
        System.out.println(test.validPalindrome("abca"));
        System.out.println(test.validPalindrome("abbca"));
    }
}
