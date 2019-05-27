package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _438_2 {

    public static void main(String[] args) {
        _438_2 test = new _438_2();
        System.out.println(test.findAnagrams("cbaebabacd", "abc"));
        System.out.println(test.findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return Collections.emptyList();  // 排除不可能的情况

        int[] pFreq = new int[26];
        for (int i = 0; i < p.length(); i++)
            pFreq[p.charAt(i) - 'a']++;

        List<Integer> ret = new ArrayList<>();
        int[] sFreq = new int[26];
        int l = 0, r = 0;   // [l, r]区间是我们需要判定的区间，但是只需要扫描频率数组即可。
        while (l <= s.length() - p.length()) {
            //窗口大小<p.length()，扩大窗口
            if (r - l + 1 <= p.length()) {
                sFreq[s.charAt(r++) - 'a']++;
                continue;
            }
            int i;
            for (i = 0; i < 26 && sFreq[i] == pFreq[i]; i++) ;
            if (i == 26)
                ret.add(l);  // 符合条件
            sFreq[s.charAt(l++) - 'a']--; // 缩小窗口
        }
        return ret;
    }
}
