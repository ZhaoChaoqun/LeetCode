package leetcode;

public class _718 {

    public int findLength(int[] A, int[] B) {
        int maxLength = 0;
        for (int start = 0; start + maxLength < A.length; start++) {
            for (int i = start, j = 0; j < B.length; i = start) {
                int k = j;
                for (; k < B.length && B[k] != A[start]; k++);
                j = k + 1;
                for (; i < A.length && k < B.length && A[i] == B[k]; i++, k++);
                maxLength = Math.max(maxLength, i - start);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        _718 test = new _718();
//        int[] A = new int[] {1,2,3,2,1};
//        int[] B = new int[] {3,2,1,4,7};
        int[] A = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] B = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
//        int[] A = new int[]{0,1,1,1,1};
//        int[] B = new int[]{1,0,1,0,1};
        System.out.println(test.findLength(A, B));
    }
}
