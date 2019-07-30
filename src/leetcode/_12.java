package leetcode;

public class _12 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int m = num / 1000;
        for(int i = 0; i < m; i++) {
            sb.append("M");
        }
        num -= m * 1000;

        int c = num / 100;
        if(c < 4) {
            for(int i = 0; i < c; i++) {
                sb.append("C");
            }
        } else if(c == 4) {
            sb.append("CD");
        } else if(c >= 5 && c < 9) {
            sb.append("D");
            for(int i = c - 5; i > 0; i--) {
                sb.append("C");
            }
        } else {
            sb.append("CM");
        }
        num -= c * 100;

        int x = num / 10;
        if(x < 4) {
            for(int i = 0; i < x; i++) {
                sb.append("X");
            }
        } else if(x == 4) {
            sb.append("XL");
        } else if(x >= 5 && x < 9) {
            sb.append("L");
            for(int i = 0; i < x - 5; i++) {
                sb.append("X");
            }
        } else {
            sb.append("XC");
        }
        num -= x * 10;

        int i = num;
        if(i < 4) {
            for(int j = 0; j < i; j++) {
                sb.append("I");
            }
        } else if(i == 4) {
            sb.append("IV");
        } else if(i >= 5 && i < 9) {
            sb.append("V");
            for(int j = i - 5; j > 0; j--) {
                sb.append("I");
            }
        } else {
            sb.append("IX");
        }
        return sb.toString();
    }
}
