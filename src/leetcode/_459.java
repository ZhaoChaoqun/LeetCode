package leetcode;

public class _459 {
    public static void main(String[] args) {
        _459 test = new _459();
        System.out.println(test.repeatedSubstringPattern("ababab"));
        System.out.println(test.repeatedSubstringPattern("bb"));
        System.out.println(test.repeatedSubstringPattern("abab"));
        System.out.println(test.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(test.repeatedSubstringPattern("babbaaabbbbabbaaabbbbabbaaabbbbabbaaabbbbabbaaabbbbabbaaabbbbabbaaabbbbabbaaabbbbabbaaabbbbabbaaabbb"));
        System.out.println(test.repeatedSubstringPattern("a"));
        System.out.println(test.repeatedSubstringPattern("aba"));
        System.out.println(test.repeatedSubstringPattern("abac"));

    }
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() < 2) return false;
        char[] chars = s.toCharArray();
        for(int length = chars.length, i = 2; i <= length; i++) {
            if(length % i == 0 && isPrime(i)) {
                int left = 0, right = length / i;
                for(; right < length && arrayEquals(chars, left, right, length / i); left += length / i, right += length / i);
                if(right == length)
                    return true;
            }
        }
        return false;
    }

    private boolean arrayEquals(char[] chars, int from1, int from2, int length) {
        int i = from1;
        for(; i < from2 && chars[i] == chars[i + length]; i++);
        return i == from2;
    }
    private boolean isPrime(int num) {
        for(int j = 2; j <= num >> 1; j ++)
            if(num % j == 0)
                return false;
        return true;
    }

}
