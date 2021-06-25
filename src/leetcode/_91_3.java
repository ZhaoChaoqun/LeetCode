package leetcode;

public class _91_3 {
    public int numDecodings(String s) {
        char[] array = s.toCharArray();
        if (array[0] == '0') return 0;
        int [] dp = new int[array.length];
        dp[0] = 1;
        for (int i = 1; i < array.length; ++i) {
            if (array[i] == '0') {
                if (array[i-1] != '1' && array[i-1] != '2') {
                    return 0;
                }
                // i-1无法跟i-2联合
                if (i >= 3 && (array[i-2] == '1' || array[i-2] == '2')) dp[i-1] -= dp[i-3];
                else if (i > 1 && (array[i-2] == '1' || array[i-2] == '2')) --dp[i-1];
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1];
                if (array[i - 1] == '1' || array[i-1] == '2' && array[i] <= '6') {
                    // i跟i-1联合
                    if (i >= 2) dp[i] += dp[i-2];
                    else ++dp[i];
                }
            }
        }
        return dp[array.length - 1];
    }

    public static void main(String[] args) {
        _91_3 test = new _91_3();
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
