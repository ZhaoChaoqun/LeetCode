package leetcode;

import java.util.Arrays;

public class _605 {
    public static void main(String[] args) {
        _605 test = new _605();
        System.out.println(test.canPlaceFlowers(new int[] {1,0,0,0,1}, 1));
        System.out.println(test.canPlaceFlowers(new int[] {1,0,0,0,1}, 2));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1) {
            return flowerbed[0] + n <= 1;
        }
        if(flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        for(int i = 1; i < flowerbed.length - 1 && n > 0; i++) {
            if(flowerbed[i] == 0) {
                if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        if(flowerbed[flowerbed.length - 1] == 0  && flowerbed[flowerbed.length - 2] == 0) {
            n--;
        }
        return n <= 0;
    }
}
