package leetcode;

/**
 * Created by zhaochaoqun on 2017/7/9.
 */
public class SolveTheEquation {
    public static String solveEquation(String equation) {
        char[] chars = equation.toCharArray();
        int coefficient = 0, value = 0;
        int number = 0;
        boolean isRightSide = false;
        boolean isNegative = false;
        for(int i = 0; i < chars.length; i++) {
            if('=' == chars[i]) {
                isRightSide = true;
                number = 0;
            } else if('+' == chars[i]) {
                if(i != 0 && chars[i-1] != 'x') {
                    if(isRightSide) {
                        if(isNegative) {
                            value -= number;
                        } else {
                            value += number;
                        }
                    } else {
                        if(isNegative) {
                            value += number;
                        } else {
                            value -= number;
                        }
                    }
                }
                isNegative = false;
                number = 0;
            } else if('-' == chars[i]) {
                if(i != 0 && chars[i-1] != 'x') {
                    if(isRightSide) {
                        if(isNegative) {
                            value -= number;
                        } else {
                            value += number;
                        }
                    } else {
                        if(isNegative) {
                            value += number;
                        } else {
                            value -= number;
                        }
                    }
                }
                number = 0;
                isNegative = true;
            } else if('x' == chars[i]) {
                if(number == 0)
                    number = 1;
                if(isRightSide) {
                    if(isNegative) {
                        coefficient += number;
                    } else {
                        coefficient -= number;
                    }
                } else {
                    if(isNegative) {
                        coefficient -= number;
                    } else {
                        coefficient += number;
                    }
                }
                number = 0;
            } else {
                number = number * 10 + chars[i] - '0';
            }
        }
        if(chars[chars.length - 1] != 'x') {
            if(isNegative) {
                value += number;
            } else {
                value -= number;
            }
        }
        if(coefficient == 0) {
            if(value == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x=" + (value / coefficient);
    }

    public static void main(String[] args) {
        System.out.println(solveEquation("x+5-3+x=6+x-2"));
//        Output: "x=2"
        System.out.println(solveEquation("x=x"));
//        Output: "Infinite solutions"
        System.out.println(solveEquation("2x=x"));
//        Output: "x=0"
        System.out.println(solveEquation("2x+3x-6x=x+2"));
//        Output: "x=-1"
        System.out.println(solveEquation("x=x+2"));
//        Output: "No solution"

    }
}
