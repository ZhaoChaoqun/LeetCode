package leetcode;

public class _647 {

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int count = chars.length;
        for(int i = 0; i < chars.length - 1; i++) {
            for(int j = i + 1; j < chars.length; j++) {
                if(isPalindrome(chars, i, j))
                    count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(char[] chars, int left, int right) {
        for(; left <= right && chars[left] == chars[right]; left++, right--);
        return left > right;
    }

    public static void main(String[] args) {
        _647 test = new _647();
        System.out.println(test.countSubstrings("abc"));
        System.out.println(test.countSubstrings("aaa"));
    }
}
