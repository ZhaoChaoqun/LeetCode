package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _992 {
    public static void main(String[] args) {
        _992 test = new _992();
        System.out.println(test.subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
        System.out.println(test.subarraysWithKDistinct(new int[]{1,2,1,3,4}, 2));
        System.out.println(test.subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        int result = 0;
        int l = 0, r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(; r < A.length;) {
            if(map.size() < K) {
                map.put(A[r], r++);
                continue;
            }
            if(map.size() == K) {
                result++;
                for(int i = l; map.get(A[i]) != i; i++) {
                    result++;
                }
                if(map.containsKey(A[r])) {
                    map.put(A[r], r++);
                } else {
                    for(; map.get(A[l]) != l; l++);
                    map.remove(A[l++]);
                }
            }
        }
        if(map.size() == K) {
            result++;
            for(int i = l; map.get(A[i]) != i; i++) {
                result++;
            }
        }
        return result;
    }
}
