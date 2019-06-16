package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _301 {



    List<String> result = new ArrayList<>();
    int right;
    String s;
    List<Integer> leftIndex = new ArrayList<>(), rightIndex = new ArrayList<>();
    private void recursive(char[] c, int i, int begin, int left) {
        if(i == c.length) {
            if(left > right) {
                if(result.isEmpty()) {
                    for(int j : leftIndex) {
                        result.add(s.substring(begin, j) + s.substring(j + 1));
                    }
                } else {
                    List<String> newResult = new ArrayList<>();
                    for(String item : result) {
                        for(int j : leftIndex) {
                            newResult.add(item + s.substring(begin, j) + s.substring(j + 1));
                        }
                    }
                    result = newResult;
                }
            } else if(left == right) {
                if(result.isEmpty())
                    result.add("");
                else {
                    for (int j = 0; j < result.size(); j++) {
                        result.set(j, result.get(j) + s.substring(begin));
                    }
                }
                return;
            }
            return;
        }

        if(c[i] == ('(')) {
            left++;
            if(!leftIndex.isEmpty() && leftIndex.get(leftIndex.size() - 1) == i - 1) {
                leftIndex.set(leftIndex.size() - 1, i);
            } else {
                leftIndex.add(i);
            }
        } else if(c[i] == (')')) {
            right++;
            if(!rightIndex.isEmpty() && rightIndex.get(rightIndex.size() - 1) == i - 1) {
                rightIndex.set(rightIndex.size() - 1, i);
            } else {
                rightIndex.add(i);
            }
            if(right > left) {
                left = 0;
                right = 0;
                if(result.isEmpty()) {
                    for(int j : rightIndex) {
                        result.add(s.substring(begin, j) + s.substring(j + 1, i + 1));
                    }
                } else {
                    List<String> newResult = new ArrayList<>();
                    for(String item : result) {
                        for(int j : rightIndex) {
                            newResult.add(item + s.substring(begin, j) + s.substring(j + 1, i + 1));
                        }
                    }
                    result = newResult;
                }
                leftIndex = new ArrayList<>();
                rightIndex = new ArrayList<>();
                begin = i + 1;
            }
        }
        recursive(c, i + 1, begin, left);

    }
    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        char[] c = s.toCharArray();
        recursive(c, 0, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _301().removeInvalidParentheses("()())()"));
        System.out.println(new _301().removeInvalidParentheses("(a)())()"));
        System.out.println(new _301().removeInvalidParentheses(")("));
        System.out.println(new _301().removeInvalidParentheses(""));
        System.out.println(new _301().removeInvalidParentheses("(("));
    }
}
