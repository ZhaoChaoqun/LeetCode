package leetcode;

public class _52 {

    public static void main(String[] args) {
//        System.out.println(new _52().totalNQueens(8));
        System.out.println(Float.floatToIntBits(+0.0F));
        System.out.println(Float.floatToIntBits(-0.0F));
        System.out.println(Float.intBitsToFloat(0x80000000) == Float.intBitsToFloat(0));
        System.out.println(Float.intBitsToFloat(0x7F800000));
        System.out.println(Float.intBitsToFloat(0xFF800000));
        System.out.println(Float.floatToIntBits(Float.NaN));
        System.out.println(Float.NaN == 0.0f / 0.0f);

    }


    int row;
    int col;
    long diagonal;
    long antiDiagonal;

    boolean isValid(int i, int j, int n) {
        return (row >> i & 1) == 0 && (col >> j & 1) == 0 && (diagonal >> (i + j) & 1) == 0 && (antiDiagonal >> (j - i + n - 1) & 1) == 0;
    }

    void setValue(int i, int j, int n) {
        row |= 1 << i;
        col |= 1 << j;
        diagonal |= 1 << i + j;
        antiDiagonal |= 1 << j - i + n - 1;
    }

    void unSetValue(int i, int j, int n) {
        row &= ~(1 << i);
        col &= ~(1 << j);
        diagonal &= ~(1 << i + j);
        antiDiagonal &= ~(1 << j - i + n - 1);
    }

    void backtracking(int n, int level) {
        if (level == n) {
            result++;
        } else {
            for (int j = 0; j < n; j++) {
                if (isValid(level, j, n)) {
                    setValue(level, j, n);
                    backtracking(n, level + 1);
                    unSetValue(level, j, n);
                }
            }
        }

    }
    int result;
    public int totalNQueens(int n) {
        backtracking(n, 0);
        return result;
    }
}
