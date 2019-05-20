package leetcode;

public class _693 {

    public boolean hasAlternatingBits(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        for(int i = 1; i < chars.length; i++)
            if(chars[i] == chars[i-1])
                return false;
        return true;
    }
}
