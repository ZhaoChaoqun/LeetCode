package leetcode;

/**
 * Created by zhaochaoqun on 2017/7/9.
 */
public class SolveTheEquation2 {
    public static String solveEquation(String equation) {
        char[] chars = equation.toCharArray();
        int coefficient = 0, value = 0;
        int number = 0;
        boolean isRightSide = false;
        boolean isNegative = false;
        for (int i = 0; i < chars.length; i++) {
            if ('=' == chars[i] || '+' == chars[i] || '-' == chars[i]) {
                if (i != 0) {
                    isNegative ^= isRightSide;
                    if (chars[i - 1] != 'x') {
                        if (isNegative) {
                            value += number;
                        } else {
                            value -= number;
                        }
                    } else {
                        if (i == 1 || chars[i - 2] < '0' || chars[i - 2] > '9')
                            number = 1;
                        if (isNegative) {
                            coefficient -= number;
                        } else {
                            coefficient += number;
                        }
                    }
                }
                if ('=' == chars[i]) {
                    isRightSide = true;
                    isNegative = false;
                }
                if ('-' == chars[i])
                    isNegative = true;
                if ('+' == chars[i])
                    isNegative = false;
                number = 0;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                number = number * 10 + chars[i] - '0';
            }
        }
        if (chars[chars.length - 1] != 'x') {
            if (isNegative) {
                value -= number;
            } else {
                value += number;
            }
        } else {
            if (chars[chars.length - 2] < '0' || chars[chars.length - 2] > '9')
                number = 1;
            if (isNegative) {
                coefficient += number;
            } else {
                coefficient -= number;
            }
        }
        if (coefficient == 0) {
            if (value == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x=" + (value / coefficient);
    }

    public static void main(String[] args) {
        System.out.println(solveEquation("0x=0"));
//        Output: "x=2"

    }
}
