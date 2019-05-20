package leetcode;

public class _633 {

    public static void main(String[] args) {
        _633 test = new _633();
        System.out.println(test.judgeSquareSum(2));
        System.out.println(test.judgeSquareSum(4));
        System.out.println(test.judgeSquareSum(42));
    }

    public boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.sqrt(c);
        int[] array = new int[sqrt + 1];
        for(int i = 1; i< array.length; i++) {
            array[i] = i * i;
        }
        for(int i = 0, j = sqrt; i <= j;) {
            if(array[i] + array[j] == c)
                return true;
            if(array[i] + array[j] < c)
                i++;
            else j--;
        }
        return false;
    }
}
