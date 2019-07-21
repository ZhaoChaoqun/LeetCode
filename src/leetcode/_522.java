package leetcode;

import java.util.*;

public class _522 {

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        Set<String> duplicates = getDuplicates(strs);
        for(int i = 0; i < strs.length; i++) {
            if(!duplicates.contains(strs[i])) {
                if(i == 0) return strs[0].length();
                int j = 0;
                for(; j < i && !isSubSequence(strs[j], strs[i]); j++);
                if(j == i) return strs[i].length();

            }
        }
        return -1;
    }

    public boolean isSubSequence(String a, String b) {
        int i = 0, j = 0;
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) == b.charAt(j)) j++;
            i++;
        }
        return j == b.length();
    }

    private Set<String> getDuplicates(String[] strs) {
        Set<String> set = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for(String s : strs)
            if(!set.add(s))
                duplicates.add(s);
        return duplicates;
    }


    public static void main(String[] args) {
        _522 test = new _522();
//        String[] strs = new String[] {"aaa", "aaa", "aa"};
        String[] strs = new String[]{"aba", "cdc", "eae"};
        System.out.println(test.findLUSlength(strs));
    }
}

