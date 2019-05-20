package leetcode;

import java.util.LinkedList;

public class _385 {

    public static void main(String[] args) {
        _385 test = new _385();
//        System.out.println(test.deserialize("324"));
//        System.out.println(test.deserialize("[123,[456,[789]]]"));
        System.out.println(test.deserialize("[123,456,[788,799,833],[[]],10,[]]"));
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private NestedInteger deserialize(char[] chars) {
        LinkedList<NestedInteger> stack = new LinkedList<>();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '[') {
                stack.push(new NestedInteger());
            } else if(chars[i] == ']') {
                NestedInteger item = stack.pop();
                if(stack.isEmpty())
                    return item;
                stack.peek().add(item);
            } else if(chars[i] == ',') {
            } else {
                boolean negative = false;
                if(chars[i] == '-') {
                    negative = true;
                    i++;
                }
                int integer = 0;
                for(; i < chars.length && isNumber(chars[i]); i++) {
                    integer = integer * 10 + chars[i] - '0';
                }
                if(negative)
                    integer = -integer;
                if(stack.isEmpty())
                    return new NestedInteger(integer);
                stack.peek().add(new NestedInteger(integer));
                i--;
            }
        }
        return stack.peek();
    }


    public NestedInteger deserialize(String s) {
        char[] chars = s.toCharArray();
        return deserialize(chars);
    }
}
