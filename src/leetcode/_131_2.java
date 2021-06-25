package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/25 5:23 下午
 */
public class _131_2 {

    public static void main(String[] args) {
        boolean[][] flag = new boolean[3][3];
        System.out.println(flag[1][1]);
//        for (List<String> row : new _131_2().partition("aab")) {
//            System.out.println(row);
//        }
//        System.out.println();
//        for (List<String> row : new _131_2().partition("cdd")) {
//            System.out.println(row);
//        }
//        System.out.println();
    }

    char[] array;
    boolean[][] flag;
    int N;
    List<List<String>> result = new ArrayList<>();
    List<String> answer = new ArrayList<>();


    public List<List<String>> partition(String s) {
        array = s.toCharArray();
        N = array.length;
        flag = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(flag[i], true);
        }
        for (int i = N - 1; i >= 0; --i) {
            for (int j = i + 1; j < N; ++j) {
                flag[i][j] = array[i] == array[j] && flag[i+1][j-1];
            }
        }
        backtracking(0);
        return result;
    }

    private void backtracking(int i) {
        if (i == N) {
            result.add(new ArrayList<>(answer));
        }
        for (int j = i; j < N; ++j) {
            if (flag[i][j]) {
                answer.add(new String(array, i, j - i + 1));
                backtracking(j + 1);
                answer.remove(answer.size() - 1);
            }
        }
    }
}
