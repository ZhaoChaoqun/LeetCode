package leetcode;

public class _264 {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        int[] array = new int[n];
        int two = 0;
        int three = 0;
        int five = 0;
        array[0] = 1;
        int min = 0;
        int minIndex = 0;
        for(int i = 1; i < n; i++) {
            minIndex = 0;
            min = array[two] * 2;
            if(array[three] * 3 < min) {
                minIndex = 1;
                min = array[three] * 3;
            } else if(array[three] * 3 == min) {
                ++three;
            }
            if(array[five] * 5 < min) {
                minIndex = 2;
                min = array[five] * 5;
            } else if(array[five] * 5 == min) {
                ++five;
            }
            if(minIndex == 0) {
                two++;
            } else if(minIndex == 1) {
                three++;
            } else {
                five++;
            }
            array[i] = min;
        }
        return array[n-1];
    }
}
