package leetcode;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/18 11:32 下午
 */
public class _276 {

    public static void main(String[] args) {
        _276 test = new _276();
        System.out.println(test.numWays(3, 2));
        System.out.println(test.numWays(2, 3));
    }


    public int numWays(int n, int k) {
        // k 颜色素，n 栅栏数
        int dp1 = k, dp2 = 0;
        for (int i = 1; i < n; ++i) {
            int temp = dp1;
            dp1 = (dp1 + dp2) * (k-1);
            dp2 = temp;
        }
        return dp1 + dp2;
    }
}
