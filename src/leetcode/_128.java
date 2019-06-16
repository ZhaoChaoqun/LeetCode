package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _128 {

    public static void main(String[] args) {
        _128 test = new _128();
        System.out.println(test.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    }
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)) {
                int left = num, right = num;
                if(map.containsKey(num - 1)) {
                    left = map.get(num - 1);
                    if(left >= num)
                        continue;
                    map.remove(num - 1);
                }
                if(map.containsKey(num + 1)) {
                    right = map.get(num + 1);
                    if(right <= num)
                        continue;
                    map.remove(num + 1);
                }
                map.put(left, right);
                map.put(right, left);
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }
}
