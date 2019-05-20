package leetcode;

public class _413 {

    public static void main(String[] args) {
        _413 test = new _413();
        System.out.println(test.numberOfArithmeticSlices(new int[] {1,3,5,7,9}));
        System.out.println(test.numberOfArithmeticSlices(new int[] {7,7,7,7}));
        System.out.println(test.numberOfArithmeticSlices(new int[] {3,-1,-5,-9}));
        System.out.println(test.numberOfArithmeticSlices(new int[] {1,1,2,5,7}));
        System.out.println(test.numberOfArithmeticSlices(new int[] {1,2,3,4}));
    }
    public int numberOfArithmeticSlices(int[] array) {
        int n = array.length;
        if(n < 3) return 0;
        int diff = array[1] - array[0], count = 2, sum = 0;
        for(int i = 2; i < n; i++) {
            if(array[i] - array[i-1] == diff) {
                count++;
            } else {
                sum += (count - 2) * (count - 1) / 2;
                diff = array[i] - array[i-1];
                count = 2;
            }
        }
        sum += (count - 2) * (count - 1) / 2;
        return sum;
    }
}
