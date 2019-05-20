package leetcode;

import java.util.*;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class FindAnagramMappings {

    public int[] anagramMappings(int[] A, int[] B) {
        int[] mapping = new int[A.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < B.length; i++) {
            if(!map.containsKey(B[i])) {
                map.put(B[i], new ArrayList<>());
            }
            map.get(B[i]).add(i);
        }
        for(int i = 0; i < A.length; i++) {
            mapping[i] = map.get(A[i]).get(0);
            map.get(A[i]).remove(0);
        }
        return mapping;
    }

    public static void main(String[] args) {
        FindAnagramMappings test = new FindAnagramMappings();
        int[] A = new int[] {12, 28, 46, 32, 50};
        int[] B = new int[] {50, 12, 32, 46, 28};
        System.out.println(Arrays.toString(test.anagramMappings(A, B)));
    }
}
