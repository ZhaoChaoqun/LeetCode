package leetcode;

public class _712 {

    public int minimumDeleteSum(String s1, String s2) {
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        int[][] dp = new int[chars1.length+1][chars2.length+1];
        for(int i = 1; i <= chars1.length; i++)
            dp[i][0] = dp[i-1][0] + chars1[i-1];
        for(int j = 1; j <= chars2.length; j++)
            dp[0][j] = dp[0][j-1] + chars2[j-1];

        for(int i = 1; i <= chars1.length; i++) {
            for(int j = 1; j <= chars2.length; j++) {
                dp[i][j] = Math.min(dp[i-1][j] + chars1[i-1], dp[i][j-1] + chars2[j-1]);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + (chars1[i-1] == chars2[j-1] ? 0 : (chars1[i-1] + chars2[j-1])));
            }
        }
        return dp[chars1.length][chars2.length];
    }

    public static void main(String[] args) {
        _712 test = new _712();
        System.out.println(test.minimumDeleteSum("sea", "eat"));
        System.out.println(test.minimumDeleteSum("delete", "leet"));
    }
}
