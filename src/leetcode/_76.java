package leetcode;

import java.util.LinkedList;

public class _76 {

    public static void main(String[] args) {
        _76 test = new _76();
        System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(test.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
        System.out.println(test.minWindow("ab", "b"));
        System.out.println(test.minWindow("a", "a"));
    }
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] frequencies = new int[58];
        for(char c : t.toCharArray()) {
            frequencies[c - 'A']++;
        }
        int min = Integer.MAX_VALUE;
        int minFrom = 0;
        char[] c = s.toCharArray();
        int lengthS = c.length;
        LinkedList<Integer>[] index = new LinkedList[58];
        for(int i = 0; i < lengthS; i++) {
            if(frequencies[c[i] - 'A'] != 0) {
                if(index[c[i] - 'A'] == null)
                    index[c[i] - 'A'] = new LinkedList<>();
                index[c[i] - 'A'].offer(i);
                if(index[c[i] - 'A'].size() - 1 == frequencies[c[i] - 'A']) {
                    index[c[i] - 'A'].poll();
                }
                if(index[c[i] - 'A'].size() == frequencies[c[i] - 'A']) {
                    if(equals(frequencies, index)) {
                        int from = i;
                        for(int j = 0; j < 58; j++)
                            if(index[j] != null) {
                                from = Math.min(from, index[j].peek());
                            }
                        if(i - from + 1 < min) {
                            minFrom = from;
                            min = i - from + 1;
                        }
                    }
                }
            }

        }
        if(min != Integer.MAX_VALUE)
            return new String(c, minFrom, min);
        return "";
    }

    private boolean equals(int[] frequencies, LinkedList<Integer>[] index) {
        for(int i = 0; i < 58; i++) {
            if(frequencies[i] == 0)
                continue;
            if(index[i] == null || index[i].size() != frequencies[i])
                return false;
        }
        return true;
    }
}
