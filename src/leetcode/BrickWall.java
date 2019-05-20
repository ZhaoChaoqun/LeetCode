package leetcode;

import java.util.*;

/**
 * Created by zhaochaoqun on 2017/6/26.
 */
public class BrickWall {

    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(List<Integer> row : wall) {
            int sum = 0, value = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                if (map.containsKey(sum)) {
                    value = map.get(sum) + 1;
                } else {
                    value = 1;
                }
                map.put(sum, value);
                if (value > max)
                    max = value;
            }
        }
        return wall.size() - max;
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(2, 4));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,1,1));
        System.out.println(leastBricks(wall));
    }
}
