package leetcode;

public class _409 {
    public static void main(String[] args) {
        _409 test = new _409();
        System.out.println(test.longestPalindrome("abccccdd"));
    }
    public int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] array = new int[52];
        for(char c: chars) {
            if(c >= 'a') {
                array[c - 'a']++;
            } else {
                array[c - 'A' + 26]++;
            }
        }
        int sum = 0, max = 0;
        for(int value : array) {
            if((value & 1) == 0)
                sum += value;
            else {
                sum += value - 1;
                max = 1;
            }
        }
        sum += max;
        return sum;
    }
}
