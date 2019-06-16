package leetcode;

public class _1004 {

    public static void main(String[] args) {
        _1004 test = new _1004();
        System.out.println(test.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(test.longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println(test.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1}, 0));
    }
    public int longestOnes(int[] A, int K) {
        if(K == A.length) return K;
        int max = 0, left = 0, right = 0;
        for(; right < A.length; right++) {
            if(A[right] == 0) {
                if(--K < 0) {
                    max = Math.max(max, right - left);
                    for(; A[left] == 1; left++);
                    left++;
                }
            }
        }
        return Math.max(max, right - left);
    }
}
