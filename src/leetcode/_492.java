package leetcode;

import java.util.Arrays;

public class _492 {

    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        if(sqrt * sqrt == area)
            return new int[] {sqrt, sqrt};
        int i = sqrt;
        for(; i >= 1 && area % i != 0; i--);
        return new int[] {area / i, i};
    }

    public static void main(String[] args) {
        _492 test = new _492();
//        System.out.println(Arrays.toString(test.constructRectangle(4)));
        System.out.println(Arrays.toString(test.constructRectangle(7)));
    }
}
