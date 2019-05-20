package leetcode;

public class MinimumSwapsToMakeSequencesIncreasing {

    public static void main(String[] args) {
        MinimumSwapsToMakeSequencesIncreasing test = new MinimumSwapsToMakeSequencesIncreasing();
        System.out.println(test.minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}));
        System.out.println(test.minSwap(new int[]{1, 2, 9, 7, 8}, new int[]{3, 4, 5, 10, 11}));
        System.out.println(test.minSwap(new int[]{3, 3, 8, 9, 10}, new int[]{1, 7, 4, 6, 8}));
        System.out.println(test.minSwap(new int[]{3, 3, 8, 6, 8}, new int[]{1, 7, 4, 9, 10}));
    }

    public int minSwap(int[] a, int[] b) {
        int[] acopy = new int[a.length];
        int[] bcopy = new int[b.length];
        System.arraycopy(a, 0, acopy, 0, a.length);
        System.arraycopy(b, 0, acopy, 0, b.length);
        int result1 = 0, result2 = 0;
        for (int i = 1; i < a.length; i++) {
            if ((a[i] <= a[i - 1] && a[i] <= b[i]) || (b[i] <= b[i - 1] && b[i] <= a[i])) {
                    swap(a, b, i-1);
                result1++;

            }
        }
        for (int i = 1; i < acopy.length; i++) {
            if ((acopy[i] <= acopy[i - 1] && acopy[i] <= bcopy[i]) || (bcopy[i] <= bcopy[i - 1] && bcopy[i] <= acopy[i])) {
                swap(acopy, bcopy, i);
                result2++;

            }
        }
        return result1 > result2 ? result2: result1;
    }

    public void swap(int[] a, int[] b, int i) {
        int tmp = a[i];
        a[i] = b[i];
        b[i] = tmp;
    }
}
