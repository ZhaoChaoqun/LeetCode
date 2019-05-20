package leetcode;

import java.util.Stack;

public class _394 {

    public static void main(String[] args) {
//        System.out.println(new _394().decodeString("3[a]2[bc]"));
        System.out.println(new _394().decodeString("3[a2[c]]"));
//        System.out.println(new _394().decodeString("2[abc]3[cd]ef"));
    }
    void backtracking(String s, char[] charArray, int i, int numberStart) {
        if(i == charArray.length) {
            return;
        }
        if(charArray[i] == '[') {
            times.push(Integer.parseInt(s.substring(numberStart, i)));
            numberStart = -1;
            startIndex.push(new StringBuilder());
        } else if(charArray[i] >= '0' && charArray[i] <= '9') {
            if(numberStart == -1)
                numberStart = i;
        } else if(charArray[i] == ']') {
            int time = times.pop();
            StringBuilder sb = startIndex.pop();
            for(int j = 0; j < time; j++)
                startIndex.peek().append(sb);
        } else {
            startIndex.peek().append(charArray[i]);
        }
        backtracking(s, charArray, i + 1, numberStart);
    }
    StringBuilder result = new StringBuilder();
    Stack<Integer> times = new Stack<>();
    Stack<StringBuilder> startIndex = new Stack<>();
    public String decodeString(String s) {
        char[] charArray = s.toCharArray();
        startIndex.push(new StringBuilder());
        backtracking(s, charArray, 0,-1);
        return startIndex.pop().toString();
    }
}
