package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _438 {

    public static void main(String[] args) {
        _438 test = new _438();
        System.out.println(test.findAnagrams("cbaebabacd", "abc"));
        System.out.println(test.findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;
        int[] array = new int[26];
        for(char c : p.toCharArray()) {
            array[c - 'a']++;
        }
        int length1 = p.length();
        int length2 = s.length();
        char[] c = s.toCharArray();
        LinkedList<Integer>[] index = new LinkedList[26];
        for(int i = 0; i < 26; i++)
            index[i] = new LinkedList<>();
        int i = 0, from = 0;
        LinkedList<Integer> list;
        for(; i < length2; i++) {
            if(from + length1 == i)
                result.add(from);
            list = index[c[i] - 'a'];
            list.offer(i);
            while(list.peek() < from)
                list.poll();

            if(list.size() > array[c[i] - 'a']) {
                from = list.poll() + 1;
            }
        }
        if(from + length1 == i)
            result.add(from);
        return result;
    }
}
