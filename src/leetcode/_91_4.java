package leetcode;

public class _91_4 {
    public int numDecodings(String s) {
        char[] array = s.toCharArray();
        if (array[0] == '0') return 0;
        int [] dp = new int[array.length+1];
        dp[0] = dp[1] = 1;
        for (int i = 1; i < array.length; ++i) {
            if (array[i] != '0')
                dp[i+1] = dp[i];
            if (array[i-1] == '1' || array[i-1] == '2' && array[i] <= '6') {
                // i跟i-1联合
                dp[i+1] += dp[i-1];
            }
        }
        return dp[array.length];
    }

    public static void main(String[] args) {
        _91_4 test = new _91_4();
//        System.out.println(test.numDecodings("12"));
//        System.out.println(test.numDecodings("226"));
//        System.out.println(test.numDecodings("10"));
//        System.out.println(test.numDecodings("27"));
//        System.out.println(test.numDecodings("99"));
        System.out.println(test.numDecodings("110"));
//        System.out.println(test.numDecodings("1212"));
//        System.out.println(test.numDecodings("101"));
//        System.out.println(test.numDecodings("1010"));
//        System.out.println(test.numDecodings("2020"));
//        System.out.println(test.numDecodings("3030"));
//        System.out.println(test.numDecodings("611"));
    }
}
