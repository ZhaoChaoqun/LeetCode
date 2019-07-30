package leetcode;

public class _14 {
    public String longestCommonPrefix(String[] strs) {
        int arrayLength = strs.length;
        if(arrayLength == 0)
            return "";
        int i = 0;
        int[] strLength = new int[arrayLength];
        for(int j = 0; j < arrayLength; j++)
            strLength[j] = strs[j].length();
        for(; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < arrayLength; j++) {
                if(strLength[j] == i || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0].substring(0, i);
    }
}
