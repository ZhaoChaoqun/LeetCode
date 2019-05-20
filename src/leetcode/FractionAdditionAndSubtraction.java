package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhaochaoqun on 2017/6/23.
 */
public class FractionAdditionAndSubtraction {

    public static String fractionAddition(String expression) {
        char[] charArray = expression.toCharArray();
        List<Integer> numerator = new ArrayList<>();
        List<Integer> denominator = new ArrayList<>();
        boolean negative = false;
        boolean isNumerator = true;
        for(char i : charArray) {
            switch(i) {
                case '-':
                    negative = true;
                    break;
                case '+':
                    negative = false;
                    break;
                case '/':
                    isNumerator = false;
                    break;
                default:
                    if(isNumerator) {
                        if(negative) {
                            numerator.add(0 - i);
                        } else {
                            numerator.add((int) i);
                        }
                    } else {
                        denominator.add((int) i);
                    }
            }
        }
        int greatestCommonDivisor = greatestCommonDivisor(denominator);
        int lowestCommonMultiple = lowestCommonMultiple(denominator);
        return null;
    }

    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor(Arrays.asList(2, 3)));
        System.out.println(lowestCommonMultiple(Arrays.asList(2, 3)));

        System.out.println(greatestCommonDivisor(Arrays.asList(5, 10)));
        System.out.println(lowestCommonMultiple(Arrays.asList(5, 10)));


    }

    private static int greatestCommonDivisor(int a, int b) {
        for(; a % b != 0;) {
            int c = b;
            b = a % b;
            a = c;
        }
        return b;
    }

    private static int greatestCommonDivisor(List<Integer> list) {
        int divisor = list.get(0);
        for(int i: list) {
            divisor = greatestCommonDivisor(divisor, i);
            if(divisor == 1)
                return 1;
        }
        return divisor;
    }

    private static int lowestCommonMultiple(int a, int b) {
        return a * b / greatestCommonDivisor(a, b);
    }

    private static int lowestCommonMultiple(List<Integer> list) {
        int greatestCommonDivisor = greatestCommonDivisor(list);
        int multiple = 1;
        if(greatestCommonDivisor == 1) {
            for(int i : list) {
                multiple *= i;
            }
        } else {
            for(int i : list) {
                multiple *= i / greatestCommonDivisor;
            }
        }
        return multiple;
    }
}
