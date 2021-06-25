package leetcode;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/18 10:54 下午
 */
public class _256 {

    public static void main(String[] args) {
        int[][] costs = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        _256 test = new _256();
        System.out.println(test.minCost(costs));
    }

    public int minCost(int[][] costs) {
        for (int i = 1; i < costs.length; ++i) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]), costs[costs.length - 1][2]);
    }
}
