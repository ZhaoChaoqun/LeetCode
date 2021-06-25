package leetcode;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/25 5:23 下午
 */
public class _131 {

    public static void main(String[] args) {
//        System.out.println(new _131().partition("aab"));
        System.out.println();
        for (List<String> row : new _131().partition("cdd")) {
            System.out.println(row);
        }
        System.out.println();
    }

    char[] array;

    public List<List<String>> partition(String s) {
        array = s.toCharArray();
        return backtracking(0, array.length - 1);
    }

    private List<List<String>> backtracking(int i, int j) {
        if (i == j) {
            return new ArrayList<>(Arrays.asList(Arrays.asList(new String(array, i, 1))));
        }
        boolean isPalindrome = palindrome(i, j);
        List<List<String>> result = new ArrayList<>();
        for (int k = i; k < j; ++k) {
            List<List<String>> left;
            if (palindrome(i, k)) left = Arrays.asList(Arrays.asList(new String(array, i, k - i + 1)));
            else continue;
            List<List<String>> right = backtracking(k + 1, j);
            if (left.isEmpty()) {
                result.addAll(right);
            } else if (right.isEmpty()) {
                result.addAll(left);
            } else {
                for (int m = 0; m < left.size() * right.size(); ++m) {
                    List<String> list = new ArrayList<>(left.get(m % left.size()));
                    list.addAll(right.get(m % right.size()));
                    result.add(list);
                }
            }
        }
        if (isPalindrome) result.add(Arrays.asList(new String(array, i, j - i + 1)));
        return result;
    }

    private boolean palindrome(int i, int j) {
        for (; i < j && array[i] == array[j]; ++i, --j);
        return i >= j;
    }
}
