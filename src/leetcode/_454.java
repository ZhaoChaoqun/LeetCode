package leetcode;

import java.util.Arrays;

public class _454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int count = 0;
        int length = A.length;

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                for(int m = 0; m < length; m ++) {
                    int n = length-1;
                    for(; n >= 0 && A[i] + B[j] + C[m] + D[n] > 0; n--);
                    if(n < 0)
                        continue;
                    if(A[i] + B[j] + C[m] + D[n] == 0)
                        count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _454 test = new _454();
        int[] A = new int[]{-1, -1};
        int[] B = new int[]{-1,1};
        int[] C = new int[]{-1,1};
        int[] D = new int[]{1,-1};
        System.out.println(test.fourSumCount(A, B, C, D));
    }
}
