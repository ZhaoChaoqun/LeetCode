package leetcode;

public class _8 {
    public int myAtoi(String str) {
        if(str.equals("")) return 0;
        char[] array = str.toCharArray();
        int i = 0;
        for(; i < array.length && (array[i] == ' ' || array[i] == '\t'); i++);
        if(i == array.length) return 0;
        boolean negative = false;
        if(array[i] == '-') {
            i++;
            negative = true;
        } else if(array[i] == '+')
            i++;
        int num = 0;
        for(int digit = 0; i < array.length && array[i] >= '0' && array[i] <= '9'; i++) {
            digit = array[i] - '0';
            if(num * 10 + digit < 0 || num * 10 / 10 != num) {
                if(negative) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            num = num * 10 + digit;
        }
        if(negative) return -num;
        return num;
    }
}
