package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _740_3 {

//    public int deleteAndEarn(int[] nums) {
////        Map<Integer, Integer> map = new HashMap<>();
//        int[] dp = new int[20001];
//        for (int num : nums) {
//            dp[num] += num;
//        }
//        dp[1] = Math.max(dp[0], dp[1]);
//        for (int i = 2; i < dp.length; ++i) {
//            dp[i] = Math.max(dp[i-2] + dp[i], dp[i-1]);
//        }
//        return dp[dp.length - 1];
//    }

    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();
        return 0;
    }

    public static void main(String[] args) {
        _740_3 test = new _740_3();
        System.out.println(test.deleteAndEarn(new int[] {3, 4, 2}));
        System.out.println(test.deleteAndEarn(new int[] {2, 2, 3, 3, 3, 4}));
        System.out.println(test.deleteAndEarn(new int[] {8,10,4,9,1,3,5,9,4,10}));
        System.out.println(test.deleteAndEarn(new int[] {1,2,3,15,16,17,18}));
    }
}
