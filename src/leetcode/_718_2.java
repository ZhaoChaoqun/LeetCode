package leetcode;

public class _718_2 {

    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[] memo = new int[A.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[j] = memo[j + 1] + 1;
                    if (ans < memo[j]) ans = memo[j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _718_2 test = new _718_2();
//        int[] A = new int[] {1,2,3,2,1};
//        int[] B = new int[] {3,2,1,4,7};
        int[] A = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] B = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
//        int[] A = new int[]{0, 1, 1, 1, 1};
//        int[] B = new int[]{1, 0, 1, 0, 1};
        System.out.println(test.findLength(A, B));
    }
}
