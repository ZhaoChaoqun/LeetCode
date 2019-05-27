package leetcode;

import java.util.LinkedList;

public class _567 {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] array = new int[26];
        for(char c : s1.toCharArray()) {
            array[c - 'a']++;
        }
        int length1 = s1.length();
        int length2 = s2.length();
        char[] c = s2.toCharArray();
        LinkedList<Integer>[] index = new LinkedList[26];
        for(int i = 0; i < 26; i++)
            index[i] = new LinkedList<>();
        int i = 0, from = 0;
        LinkedList<Integer> list;
        for(; i < length2 && from + length1 != i; i++) {
            list = index[c[i] - 'a'];
            list.offer(i);
            while(list.peek() < from)
                list.poll();
            if(list.size() > array[c[i] - 'a']) {
                from = list.poll() + 1;
            }
        }
        return from + length1 == i;
    }
    public static void main(String[] args) {
        _567 test = new _567();
        System.out.println(test.checkInclusion("ab", "eidbaooo"));
        System.out.println(test.checkInclusion("abc", "eidbaooo"));
        System.out.println(test.checkInclusion("abod", "eidbaooo"));
    }
}
