package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaochaoqun on 2017/6/23.
 */
public class FractionAdditionAndSubtraction3 {

    public static String fractionAddition(String expression) {
        char[] charArray = expression.toCharArray();
        List<Integer> numerator = new ArrayList<>();
        List<Integer> denominator = new ArrayList<>();
        boolean negative = false;
        int num = 0;
        for(int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '-') {
                if(i > 0) {
                    denominator.add(num);
                    num = 0;
                }
                negative = true;
            } else if(charArray[i] == '+') {
                if(i > 0) {
                    denominator.add(num);
                    num = 0;
                }
                negative = false;
            } else if(charArray[i] == '/') {
                if(negative)
                    numerator.add(-num);
                else
                    numerator.add(num);
                num = 0;
            } else {
                num = num * 10 + (charArray[i] - '0');
            }
        }
        denominator.add(num);
        int multiple = 1;
        for(int i : denominator) {
            multiple *= i;
        }
        int result = 0;
        for(int i = 0; i < numerator.size(); i++) {
            result += numerator.get(i) * multiple / denominator.get(i);
        }
        if(result == 0)
            return "0/1";
        if(result < 0) {
            result = -result;
            int commonDivisor = greatestCommonDivisor(multiple, result);
            result /= commonDivisor;
            multiple /= commonDivisor;
            return "-" + result + "/" + multiple;
        }
        int commonDivisor = greatestCommonDivisor(multiple, result);
        result /= commonDivisor;
        multiple /= commonDivisor;
        return result + "/" + multiple;
    }

    public static void main(String[] args) {
        System.out.println(fractionAddition("-1/2+1/2"));
//        Output: "0/1"
        System.out.println(fractionAddition("-1/2+1/2+1/3"));
//        Output: "1/3"
        System.out.println(fractionAddition("1/3-1/2"));
//        Output: "-1/6"
        System.out.println(fractionAddition("5/3+1/3"));
//        Output: "2/1"
    }

    private static int greatestCommonDivisor(int a, int b) {
        for(; a % b != 0;) {
            int c = b;
            b = a % b;
            a = c;
        }
        return b;
    }

}
