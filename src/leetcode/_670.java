package leetcode;

public class _670 {

    public static void main(String[] args) {
        _670 test = new _670();
        System.out.println(test.maximumSwap(2736));
        System.out.println(test.maximumSwap(9973));
        System.out.println(test.maximumSwap(8368));
        System.out.println();
    }
    public int maximumSwap(int num) {

        int max = 0, index = 0, bits = 0;
        int[] array = new int[8];
        for(int tmp = num; tmp > 0; tmp /= 10, ++bits) {
            array[bits] = tmp % 10;
            if(array[bits] > max) {
                max = array[bits];
                index = bits;
            }
        }
        for(int j = --bits; j > index; j--) {
            if(array[j] != max) {
                num += Math.pow(10, j) * (max - array[j]) - Math.pow(10, index) * (max - array[j]);
                return num;
            }
        }
        return num;
    }
}
