package leetcode;

public class _978 {

    public int maxTurbulenceSize(int[] A) {
        if(A.length == 1) return 1;
        int max = 2, l = 0;
        int compare = A[1] - A[0];
        if(compare == 0) {
            l = 1;
            max = 1;
        }

        for(int r = 2; r < A.length; r++) {
            if(A[r-1] == A[r]) {
                max = Math.max(max, r - l);
                l = r;
            } else if(A[r] > A[r-1]) {
                if(compare > 0) {   // 符合
                    max = Math.max(max, r - l);
                    l = r - 1;
                }
            } else {
                if(compare < 0) {   // 符合
                    max = Math.max(max, r - l);
                    l = r - 1;
                }
            }
            compare = A[r] - A[r-1];
        }
        return Math.max(max, A.length - l);
    }

    public static void main(String[] args) {
        _978 test = new _978();
//        System.out.println(test.maxTurbulenceSize(new int[] {9,4,2,10,7,8,8,1,9}));
//        System.out.println(test.maxTurbulenceSize(new int[] {4,8,12,16}));
//        System.out.println(test.maxTurbulenceSize(new int[] {100}));
        System.out.println(test.maxTurbulenceSize(new int[] {0,8,45,88,48,68,28,55,17,24}));
    }
}
