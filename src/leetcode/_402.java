package leetcode;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

public class _402 {
    public static void main(String[] args) throws IOException {
        _402 test = new _402();
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
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < chars.length; i++) {
            while(k > 0 && !stack.isEmpty() && stack.peekLast() > chars[i]) {
                stack.pollLast();
                k--;
            }
            if(chars[i] != '0' || !stack.isEmpty())
                stack.offerLast(chars[i]);
        }
        for(; k > 0; k--)
            stack.pollLast();
        if(stack.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder(stack.size());
        for(Iterator<Character> iterator = stack.iterator(); iterator.hasNext();) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }
}
