package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30 {


    public static void main(String[] args) {
        _30 test = new _30();
        System.out.println(test.findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordSize = words[0].length();
        Map<String, Integer> wFreq = new HashMap<>();
        for(String word : words) {
            wFreq.put(word, wFreq.getOrDefault(word, 0) + 1);
        }
        int formed = 0, required = wFreq.size();
        Map<String, Integer> sFreq = new HashMap<>();
        String word;
        for(int l = 0, r = 0; r < s.length() - wordSize; r++) {
            word = s.substring(r, r + wordSize);
            if(wFreq.containsKey(word)) {
                if(sFreq.getOrDefault(word, 0) + 1 == wFreq.getOrDefault(word, 0)) {
                    formed++;
                }
                sFreq.put(word, sFreq.getOrDefault(word, 0) + 1);
                if(formed == required) {

                }
                r += wordSize - 1;
            } else {
                l = r + 1;
            }
        }
        if(formed < required) return result;
        return null;
    }
}
