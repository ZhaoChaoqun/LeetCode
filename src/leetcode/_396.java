package leetcode;

public class _396 {
    public static void main(String[] args) {
        System.out.println(new _396().maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    public int maxRotateFunction(int[] A) {
        int f = 0, sum = 0, length = A.length;
        for (int i = 0; i < length; i++) {
            f += i * A[i];
            sum += A[i];
        }
        int max = f;
        for (int i = length - 1; i > 0; i--) {
            f += sum - length * A[i];
            max = Math.max(max, f);
        }
        return max;
    }
}
