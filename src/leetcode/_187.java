package leetcode;

import java.util.*;

public class _187 {

    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 10) return Collections.emptyList();
        Set<Integer> set = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();
        List<String> list = new ArrayList<>();
        char[] c = s.toCharArray();
        int bitMap = 0;
        for(int i = 0; i < c.length; i++) {
            bitMap <<= 2;
            switch (c[i]) {
                case 'C':
                    bitMap |= 1;
                    break;
                case 'G':
                    bitMap |= 2;
                    break;
                case 'T':
                    bitMap |= 3;
                    break;
            }
            if(i >= 9) {
                bitMap &= 0xfffff;
                if(!set.add(bitMap) && secondSet.add(bitMap)) {
                    list.add(new String(c, i - 9, 10));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new _187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
