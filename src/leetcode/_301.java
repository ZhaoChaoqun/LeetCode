package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _301 {


    private void backtracking(List<List<String>> matrix, int index, int start, StringBuilder sb) {
        if(index == matrix.size())
            result.add(sb.toString());
        else {
            for(String row : matrix.get(index)) {
                sb.append(row);
                backtracking(matrix, index + 1, start + row.length(), sb);
                sb.delete(start, start + row.length());
            }
        }
    }
    List<String> result = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        List<List<String>> matrix = new ArrayList<>();
        int fromIndex = 0;
        for(int i = 0; i < c.length; i++) {
            if(c[i] == '(') {
                left++;
            } else if(c[i] == ')') {
                if(--left < 0) {
                    List<String> row = new ArrayList<>();
                    for(int index = s.indexOf(')', fromIndex); index != i;) {
                        if(index == i - 1)
                            break;
                        row.add(new StringBuilder().append(c, fromIndex, index - fromIndex).append(c, index + 1, i - index).toString());
                        index = s.indexOf(')', index + 1);
                    }
                    row.add(new StringBuilder().append(c, fromIndex, i - fromIndex).toString());
                    matrix.add(row);
                    fromIndex = i + 1;
                    left = 0;
                }
            }
        }
        if(left > 0) {

        }
        if(fromIndex < c.length) {
            List<String> row = new ArrayList<>();
            row.add(s.substring(fromIndex, c.length));
            matrix.add(row);
        }
        StringBuilder sb = new StringBuilder();
        backtracking(matrix, 0, 0, sb);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _301().removeInvalidParentheses("()())()"));
        System.out.println(new _301().removeInvalidParentheses("(a)())()"));
        System.out.println(new _301().removeInvalidParentheses(")("));
    }
}
