package leetcode;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                ++count;
                int j = 1;
                for (; i - j - 1 >= 0 && i + j < chars.length && chars[i] == chars[i + j] && chars[i] != chars[i - j - 1]; j++) {
                    ++count;
                }
                i += j - 1;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        CountBinarySubstrings test = new CountBinarySubstrings();
        System.out.println(test.countBinarySubstrings("00110011"));
        System.out.println(test.countBinarySubstrings("10101"));
    }
}
