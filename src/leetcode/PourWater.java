package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaochaoqun on 2017/12/31.
 */
public class PourWater {

    public int[] pourWater(int[] heights, int V, int K) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 2000;
        for(int i = 0; i < heights.length; i++) {
            if (!map.containsKey(heights[i])) {
                map.put(heights[i], new ArrayList<>());
            }
            map.get(heights[i]).add(i);
            min = Math.min(min, heights[i]);
        }
        List<Integer> kList = map.get(heights[K]);
        for(int i = 0; i < V; i++) {
            if (min == heights[K]) {
                kList.remove(new Integer(heights[K]));
                if (kList.isEmpty()) {
                    map.remove(heights[K]);
                    min++;
                }
                binaryInsert(K, map.get(++heights[K]), 0, map.get(++heights[K]).size() - 1);
            } else {
                int index = map.get(min).get(0);

            }
            heights[K]++;

        }
        return heights;
    }

    private void binaryInsert(int index, List<Integer> list, int left, int right) {
        if (left >= right) {
            if (index < list.get(left)) {
                list.add(left, index);
            } else {
                list.add(left + 1, index);
            }
        }
        int mid = (left + right) / 2;
        if (list.get(mid) > index) {
            binaryInsert(index, list, left, mid - 1);
        } else {
            binaryInsert(index, list, mid + 1, right);
        }
    }

    public static void main(String[] args) {

    }

}
