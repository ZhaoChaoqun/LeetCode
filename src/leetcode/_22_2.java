package leetcode;


import java.util.ArrayList;
import java.util.List;

public class _22_2 {


    public static void main(String[] args) {
        System.out.println(new _22_2().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        char[] solution = new char[n * 2];
        List<String> solutions = new ArrayList<>();
        backtracking(0, 0, solution, solutions);
        return solutions;

    }

    private void backtracking(int currentIndex, int leftCnt, char[] solution, List<String> solutions) {
        if (currentIndex == solution.length) solutions.add(new String(solution));
        else {
            if (leftCnt < solution.length / 2) {
                solution[currentIndex] = '(';
                backtracking(currentIndex + 1, leftCnt + 1, solution, solutions);
            }
            if (2 * leftCnt > currentIndex) {
                solution[currentIndex] = ')';
                backtracking(currentIndex + 1, leftCnt, solution, solutions);
            }
        }
    }
}
