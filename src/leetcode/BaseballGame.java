package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by zhaochaoqun on 2018/1/15.
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        int score = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for(String op : ops) {
            if(op == "C") {
                stack.pop();
            } else if(op.equals("D")) {
                stack.push(stack.peekFirst() * 2);
            } else if(op.equals("+")) {
                stack.push(stack.peekFirst() + stack.get(1));
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        for(Integer i : stack)
            score += i;
        return score;
    }

    public static void main(String[] args) {
        BaseballGame test = new BaseballGame();
        Arrays.toString(new int[0]);
//        System.out.println(test.calPoints(new String[] {"5","2","C","D","+"}));
        System.out.println(test.calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
    }
}
