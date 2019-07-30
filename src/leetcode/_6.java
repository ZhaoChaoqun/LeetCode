package leetcode;

public class _6 {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int interval = 2 * numRows - 2;
        int length = s.length();
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            if(i == 0 || i == numRows - 1) {
                for(int j = i; j < length; j += interval) {
                    sb.append(charArray[j]);
                }
            } else {
                for(int j = i, k = interval - i; j < length;
                    j += interval, k += interval) {
                    sb.append(charArray[j]);
                    if(k < length) {
                        sb.append(charArray[k]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
