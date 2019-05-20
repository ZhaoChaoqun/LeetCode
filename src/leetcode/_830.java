package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _830 {

    public static void main(String[] args) {
        _830 test = new _830();
//        List<List<Integer>> duplicateSubtrees = test.largeGroupPositions("abbxxxxzzy");
//        List<List<Integer>> duplicateSubtrees = test.largeGroupPositions("abc");
        List<List<Integer>> result = test.largeGroupPositions("abcdddeeeeaabbbcd");
        for(List<Integer> item : result) {
            System.out.println(item);
        }
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        char before = chars[0];
        int from = 0;
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == before) {
                continue;
            } else {
                if(i - from >= 3) {
                    result.add(Arrays.asList(from, i-1));
                }
                from = i;
                before = chars[i];
            }
        }
        return result;
    }
}
