package leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class _5086 {

    public String smallestSubsequence(String text) {
        int[] array = new int[26];
        char[] c = text.toCharArray();
        LinkedList<Character> linkedList = new LinkedList<>();
        for(int i = c.length - 1; i >= 0; i--) {
            if(array[c[i] - 'a'] == 0) {
                array[c[i] - 'a'] = 1;
                linkedList.push(c[i]);
            } else {
                if(c[i] < linkedList.peek()) {
                    LinkedList<Character> stack = new LinkedList<>();
                    for(; linkedList.peek() != c[i];)
                        stack.push(linkedList.pop());
                    linkedList.pop();
                    while(!stack.isEmpty())
                        linkedList.push(stack.pop());
                    linkedList.push(c[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!linkedList.isEmpty())
            sb.append(linkedList.pop());
        return new String(sb);
    }

    public static void main(String[] args) {
        _5086 test = new _5086();
//        System.out.println(test.smallestSubsequence("cdadabcc"));
//        System.out.println(test.smallestSubsequence("abcd"));
//        System.out.println(test.smallestSubsequence("ecbacba"));
//        System.out.println(test.smallestSubsequence("leetcode"));
        System.out.println(test.smallestSubsequence("cbaacabcaaccaacababa"));
    }
}
