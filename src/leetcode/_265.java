package leetcode;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/18 11:02 下午
 */
public class _265 {

    public static void main(String[] args) {
        int[][] costs = new int[][]{{1,5,3},{2,9,4}};
        _265 test = new _265();
        System.out.println(test.minCostII(costs));
    }

    public int minCostII(int[][] costs) {
        int k = costs[0].length;
        if (k == 1) {
            return costs[0][0];
        }
        int[] minValue;
        for (int i = 1; i < costs.length; ++i) {
            minValue = minValue(costs[i-1]);
            for (int j = 0; j < k; ++j) {
                if (j != minValue[2]) {
                    costs[i][j] += minValue[0];
                } else {
                    costs[i][j] += minValue[1];
                }
            }
        }
        return minValue(costs[costs.length - 1])[0];
    }

    private int[] minValue(int[] costs) {
        int min1, min2;
        int index1;
        if (costs[0] > costs[1]) {
            min1 = costs[1];
            min2 = costs[0];
            index1 = 1;
        } else {
            min1 = costs[0];
            min2 = costs[1];
            index1 = 0;
        }
        for (int i = 2; i < costs.length; ++i) {
            if (costs[i] <= min1) {
                min2 = min1;
                min1 = costs[i];
                index1 = i;
            } else if (costs[i] <= min2) {
                min2 = costs[i];
            }
        }
        return new int[] {min1, min2, index1};
    }
}
