package leetcode;

import java.util.*;
import java.util.stream.Collectors;

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

//    public int deleteAndEarn(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + num);
//        }
//        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().collect(Collectors.toList());
//        if (list.get(1).getKey() - list.get(0).getKey() == 1) {
//            list.get(1).setValue(list.get(0).getValue() + list.get(1).getValue());
//        } else {
//            list.get(1).setValue(Math.max(list.get(0).getValue(), list.get(1).getValue()));
//        }
//        for (int i = 2; i < list.size(); ++i) {
//            if (list.get(i).getKey() - list.get(i-1).getKey() == 1) {
//                list.get(i).setValue(Math.max(list.get(i-1).getValue(), list.get(i-2).getValue() + list.get(i).getValue()));
//            } else {
//                list.get(i).setValue(list.get(i-1).getValue() + list.get(i).getValue());
//            }
//        }
//        return list.get(list.size() - 1).getValue();
//    }

//    public int deleteAndEarn(int[] nums) {
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + num);
//        }
////        System.out.println(map);
//        int dp0 = 0; int dp1 = 0;
//        Integer key;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            key = entry.getKey();
//            if (map.containsKey(key - 1)) {
//                int temp = dp1;
//                dp1 = dp0 + entry.getValue();
//                dp0 = Math.max(dp0, temp);
//            } else {
//                dp0 = Math.max(dp0, dp1);
//                dp1 += entry.getValue();
//            }
//        }
//        return Math.max(dp0, dp1);
//    }

//    public int deleteAndEarn(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + num);
//        }
//        List<Integer> sortedKey = map.keySet().stream().sorted().collect(Collectors.toList());
////        System.out.println(map);
//        int dp0 = 0; int dp1 = 0;
//        for (Integer key : sortedKey) {
//            Integer value = map.get(key);
//            if (map.containsKey(key - 1)) {
//                int temp = dp1;
//                dp1 = dp0 + value;
//                dp0 = Math.max(dp0, temp);
//            } else {
//                dp0 = Math.max(dp0, dp1);
//                dp1 = dp0 + value;
//            }
//        }
//        return Math.max(dp0, dp1);
//    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int value = 0; int last = 0; int lastLast = 0;
        int dp0 = 0; int dp1 = 0;
        for (int num : nums) {
            if (last != num) {
                if (lastLast + 1 == last) {
                    int temp = dp1;
                    dp1 = dp0 + value;
                    dp0 = temp;
                } else {
                    dp0 = Math.max(dp0, dp1);
                    dp1 = dp0 + value;
                }
                // 重新累加
                lastLast = last;
                last = num;
                value = num;
            } else {
                value += num;
            }
        }
        if (lastLast + 1 == last) {
            return Math.max(dp0 + value, dp1);
        } else {
            return Math.max(dp0, dp1) + value;
        }
    }

    public static void main(String[] args) {
        _740_3 test = new _740_3();
        System.out.println(test.deleteAndEarn(new int[] {3, 4, 2}));
        System.out.println(test.deleteAndEarn(new int[] {2, 2, 3, 3, 3, 4}));
        System.out.println(test.deleteAndEarn(new int[] {8,10,4,9,1,3,5,9,4,10}));
        System.out.println(test.deleteAndEarn(new int[] {1,2,3,15,16,17,18}));
        System.out.println(test.deleteAndEarn(new int[] {1,1,1,2,4,5,5,5,6}));
    }
}
