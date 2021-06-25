package leetcode;

import java.util.*;

public class _301 {

    public static void main(String[] args) {
//        System.out.println(new _301().removeInvalidParentheses("()())()"));
//        System.out.println(new _301().removeInvalidParentheses("(a)())()"));
//        System.out.println(new _301().removeInvalidParentheses(")("));
//        System.out.println(new _301().removeInvalidParentheses(""));
//        System.out.println(new _301().removeInvalidParentheses("(()()"));
//        System.out.println(new _301().removeInvalidParentheses("()(("));
//        System.out.println(new _301().removeInvalidParentheses("(("));
//        System.out.println(new _301().removeInvalidParentheses(")(f"));
//        System.out.println(new _301().removeInvalidParentheses("f)"));
//        System.out.println(new _301().removeInvalidParentheses(")o(v("));
//        System.out.println(new _301().removeInvalidParentheses("(r(()()("));
        System.out.println(new _301().removeInvalidParentheses("())r)"));
    }

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        List<List<StringBuilder>> list = new ArrayList<>();
        int from = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '(') {
                ++left;
            } else if (chars[i] == ')') {
                if (left == 0) {
                    List<StringBuilder> subList = new ArrayList<>();
                    // 删除(from,i]范围的某个右括号
                    for (int j = from; j <= i; ++j) {
                        if (chars[j] == ')') {
                            // StringBuilder append(char[] str, int offset, int len)
                            StringBuilder sb = new StringBuilder().append(chars, from, j - from);
                            if (j <= i) {
                                sb.append(chars,j + 1, i - j);
                            }
                            if (sb.length() > 0) {
                                subList.add(sb);
                            }
                        }
                    }
                    if (subList.size() > 0) {
                        list.add(subList);
                    }
                    from = i + 1;
                } else {
                    --left;
                }
            }
        }
        if (left == 0) {
            if (chars.length > from) {
                List<StringBuilder> subList = new ArrayList<>();
                subList.add(new StringBuilder().append(chars, from, chars.length - from));
                list.add(subList);
            }
        } else {
            list.addAll(reverse(chars, from));
        }
        return mergeResult(list);
    }

    private List<String> mergeResult(List<List<StringBuilder>> list) {
        if (list.isEmpty()) {
            return Arrays.asList("");
        }
        int resultSize = 1;
        for (int i = 0; i < list.size(); ++i) {
            resultSize *= list.get(i).size();
        }
        List<String> result = new ArrayList<>(resultSize);
        for (int i = 0; i < resultSize; ++i) {
            StringBuilder sb = new StringBuilder();
            for (List<StringBuilder> part : list) {
                sb.append(part.get(i % part.size()));
            }
            result.add(sb.toString());

        }
        return new ArrayList<>(new HashSet<>(result));
    }

    private List<List<StringBuilder>> reverse(char[] chars, int from) {
        List<List<StringBuilder>> list = new ArrayList<>();
        int right = 0, to = chars.length - 1;
        for (int i = chars.length - 1; i >= from; --i) {
            if (chars[i] == ')') {
                ++right;
            } else if (chars[i] == '(') {
                if (right == 0) {
                    List<StringBuilder> subList = new ArrayList<>();
                    // 删除(i,to]范围的某个左括号
                    for (int j = i; j <= to; ++j) {
                        if (chars[j] == '(') {
                            // StringBuilder append(char[] str, int offset, int len)
                            StringBuilder sb = new StringBuilder("");
                            sb.append(chars, i, j - i);
                            if (j + 1 <= to) {
                                sb.append(chars,j + 1, to - j);
                            }
                            if (sb.length() > 0) {
                                subList.add(sb);
                            }
                        }
                    }
                    if (subList.size() > 0) {
                        list.add(0, subList);
                    }
                    to = i-1;
                } else {
                    --right;
                }
            }
        }
        if (to + 1 > from) {
            List<StringBuilder> subList = new ArrayList<>();
            subList.add(new StringBuilder().append(chars, from, to + 1 - from));
            list.add(0, subList);
        }
        return list;
    }

}
