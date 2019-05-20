package leetcode;

public class _678 {
    public static void main(String[] args) {
        System.out.println(new _678().checkValidString("()"));
        System.out.println(new _678().checkValidString("(*)"));
        System.out.println(new _678().checkValidString("(*))"));
        System.out.println(new _678().checkValidString("((*)"));
        System.out.println(new _678().checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        System.out.println(new _678().checkValidString("((*)(*))((*)"));
    }

    private boolean checkValidString(char[] chars, int index, int left) {
        if(index == chars.length) return left == 0;
        if(chars[index] == '(') {
            return checkValidString(chars, index + 1, left + 1);
        } else if(chars[index] == ')') {
            if(left == 0)
                return false;
            return checkValidString(chars, index + 1, left - 1);
        } else {
            // *当做空字符串
            if(checkValidString(chars, index + 1, left))
                return true;
            // *当做左括号
            if(checkValidString(chars, index + 1, left + 1))
                return true;
            // *当做右括号
            if(left > 0)
                return checkValidString(chars, index + 1, left - 1);

        }
        return false;
    }

    public boolean checkValidString(String s) {
        String newS = s;
        do {
            s = newS;
            newS = s.replaceAll("\\(\\)", "");
        } while(!newS.equals(s));
        s = s.replaceAll("\\(\\*+$", "").replaceAll("^\\*+\\)", "");
//        System.out.println(s);
        if(s.isEmpty())
            return true;
        char[] chars = s.toCharArray();
        if(chars[0] == ')' || chars[chars.length - 1] == '(')
            return false;
        return checkValidString(chars, 0, 0);
    }
}
