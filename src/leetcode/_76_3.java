package leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _76_3 {

    public static void main(String[] args) {
        _76_3 test = new _76_3();
        System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(test.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
        System.out.println(test.minWindow("ab", "b"));
        System.out.println(test.minWindow("a", "a"));
        System.out.println(test.minWindow("a", "b"));
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] sFreq = new int[58], tFreq = new int[58];  // frequency数组
        for(char c : t.toCharArray())
            tFreq[c - 'A']++;
        char[] c = s.toCharArray();

        int min = Integer.MAX_VALUE;
        int minL = -1;
        int required = t.length(), formed = 0;
        int l = 0, r = 0;
        for(; r < c.length && formed < required; r++) {
            if(++sFreq[c[r] - 'A'] <= tFreq[c[r] - 'A'])
                formed++;
        }
        if(formed < required) return "";
        // s[l~r-1]满足包含t
        for(; ; r++) {
            if(required == formed) {
                // 最右的字符满足条件，需要看一下整体是否满足
                // l尽量右移，压缩窗口大小
                for (; l < r; l++) {
                    if (tFreq[c[l] - 'A'] == 0) {
                        continue;
                    } else if (sFreq[c[l] - 'A'] > tFreq[c[l] - 'A']) {
                        --sFreq[c[l] - 'A'];
                    } else {    // 确认l最多右移的位置sFreq[c[l] - 'A'] == tFreq[c[l] - 'A']
                        --sFreq[c[l] - 'A'];
                        formed--;
                        break;
                    }
                }
                if (r - l == t.length()) return new String(c, l, r - l);
                if (r - l < min) {
                    min = r - l;
                    minL = l;
                }
                l++;
            }
            if(r == c.length)
                break;
            if(tFreq[c[r] - 'A'] != 0) {
                if(++sFreq[c[r] - 'A'] == tFreq[c[r] - 'A'])
                    formed++;
            }
        }
        return minL == -1 ? "" : new String(c, minL, min);
    }
}
