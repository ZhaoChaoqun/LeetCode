package leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _22 {


    public static void main(String[] args) {
        System.out.println(new _22().generateParenthesis(3));
    }
    List<String> result = new ArrayList<>();
    List<StringBuilder> backtracing(int n) {
        if(matrix.size() > n)
            return matrix.get(n);
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++)
            sb.append('(');
        for(int i = 1; i <= n; i++)
            sb.append(')');
        list.add(sb);
        for(int i = 1; i < n; i++) {
            for (StringBuilder left : backtracing(i)) {
                for (StringBuilder right : backtracing(n - i)) {
                    sb = new StringBuilder();
                    sb.append(left);
                    sb.append(right);
                    list.add(sb);
                }
            }
        }
        matrix.add(list);
        return list;
    }

    List<List<StringBuilder>> matrix = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0)
            return result;
        List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder("()"));
        matrix.add(list);
        matrix.add(list);
        for(StringBuilder sb : backtracing(n))
            result.add(sb.toString());
        return result;
    }
}
