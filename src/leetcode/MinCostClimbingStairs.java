package leetcode;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        for(int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs test = new MinCostClimbingStairs();
        System.out.println(test.minCostClimbingStairs(new int[] {10, 15, 20}));
        System.out.println(test.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
