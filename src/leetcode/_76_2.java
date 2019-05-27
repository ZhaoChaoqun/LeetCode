package leetcode;

import java.util.LinkedList;

public class _76_2 {

    public static void main(String[] args) {
        _76_2 test = new _76_2();
//        System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(test.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
//        System.out.println(test.minWindow("ab", "b"));
//        System.out.println(test.minWindow("a", "a"));
        System.out.println(test.minWindow("a", "b"));
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] sFreq = new int[58], tFreq = new int[58];  // frequency数组
        for(char c : t.toCharArray())
            tFreq[c - 'A']++;
        char[] c = s.toCharArray();
        int l = 0, r = t.length() - 1;
        for(int i = l; i <= r; i++) {
            sFreq[c[i] - 'A']++;
        }
        int min = Integer.MAX_VALUE;
        int minL = -1;
        int i = 0;
        for(; i < 58 && sFreq[i] == tFreq[i]; i++);
        if(i == 58) for(; i < 58 && sFreq[i] == tFreq[i]; i++);
        if(i == 58) return new String(c, l, r + 1);
        for(r++; r < c.length; r++) {
            if(tFreq[c[r] - 'A'] != 0 && ++sFreq[c[r] - 'A'] >= tFreq[c[r] - 'A']) {
                // 最右的字符满足条件，需要看一下整体是否满足
                for(i = 0; i < 58 && sFreq[i] >= tFreq[i]; i++);
                if(i == 58) {   // 窗口满足s包含t
                    // l尽量右移，压缩窗口大小
                    for(; l < c.length; l++) {
                        if(tFreq[c[l] - 'A'] == 0) {
                            continue;
                        } else if(sFreq[c[l] - 'A'] > tFreq[c[l] - 'A']) {  // 确认l最多右移的位置
                            --sFreq[c[l] - 'A'];
                        } else
                            break;
                    }
                    if(r + 1 - l == t.length()) return new String(c, l , r + 1 - l);
                    if(r + 1 - l < min) {
                        min = r + 1 - l;
                        minL = l;
                    }
                }
            }
        }
        return minL == -1 ? "" : new String(c, minL, min);
    }
}
