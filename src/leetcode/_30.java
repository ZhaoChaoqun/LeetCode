package leetcode;

import java.util.*;

public class _30 {

    public static void main(String[] args) {
        _30 test = new _30();
//        System.out.println(test.findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
//        System.out.println(test.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}));
        System.out.println(test.findSubstring("aaa", new String[] {"a","b"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0)
            return Collections.emptyList();
        char[] chars = s.toCharArray();
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        for(String word : words)
            count.put(word, count.getOrDefault(word, 0) + 1);
        int wordLength = words[0].length();
        int length = wordLength * words.length;
        for(int i = 0; i <= chars.length - length; i++) {
            compare(i, i + length - 1, count, wordLength, chars, result);
        }
        return result;
    }

    private void compare(int from, int end, Map<String, Integer> count, int wordLength, char[] chars, List<Integer> result) {
        Map<String, Integer> seen = new HashMap<>();
        for(int i = from; i <= end; i += wordLength) {
            String word = new String(chars, i, wordLength);
            if(!count.containsKey(word))
                return;
            seen.put(word, seen.getOrDefault(word, 0) + 1);
            if(seen.get(word) > count.get(word))
                return;
        }
        result.add(from);
    }
}
