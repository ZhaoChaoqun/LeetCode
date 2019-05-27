package leetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class _402_2 {
    public static void main(String[] args) throws IOException {
        _402_2 test = new _402_2();
        System.out.println(test.removeKdigits("112", 1));
        System.out.println(test.removeKdigits("1432219", 3));
        System.out.println(test.removeKdigits("10200", 1));
        System.out.println(test.removeKdigits("10", 2));
        System.out.println(test.removeKdigits("000", 2));
        System.out.println(test.removeKdigits("1234567890", 9));
        BufferedReader  br = new BufferedReader(new FileReader("/Users/zhaochaoqun/IdeaProjects/LeetCode/src/leetcode/402.txt"));
        String number = br.readLine();
        System.out.println(test.removeKdigits(number, 1000));
    }

    public String removeKdigits(String num, int k) {
        if(k == 0) return num;
        if(num.length() == k)
            return "0";
        char[] chars = num.toCharArray();
        StringBuilder stack = new StringBuilder();

        for(int i = 0; i < chars.length; i++) {
            while(k > 0 && stack.length() != 0 && stack.charAt(stack.length() - 1) > chars[i]) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            if(chars[i] != '0' || stack.length() != 0)
                stack.append(chars[i]);
        }
        if(stack.length() == 0) return "0";
        for(; k > 0; k--)
            stack.deleteCharAt(stack.length() - 1);
        return stack.toString();
    }
}
