package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _830_2 {

    public static void main(String[] args) {
        _830_2 test = new _830_2();
//        List<List<Integer>> duplicateSubtrees = test.largeGroupPositions("abbxxxxzzy");
//        List<List<Integer>> duplicateSubtrees = test.largeGroupPositions("abc");
        List<List<Integer>> result = test.largeGroupPositions("abcdddeeeeaabbbcd");
        for(List<Integer> item : result) {
            System.out.println(item);
        }
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] array = new List[26];
        char[] chars = s.toCharArray();
        char before = chars[0];
        int from = 0;
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == before) {
                continue;
            } else {
                if(i - from >= 3) {
                    array[before - 'a'] = Arrays.asList(from, i-1);
                }
                from = i;
                before = chars[i];
            }
        }
        for(List<Integer> item : array){
            if(item != null)
                result.add(item);
        }
        return result;
    }
}
