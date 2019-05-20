package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _135 {

    public static void main(String[] args) {
        System.out.println(new _135_2().candy(new int [] {1,6,10,8,7,3,2}));
    }
    void right(int minIndex, int right, int[] ratings, int[] candies) {
        for(int i = minIndex + 1; i <= right; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
    }
    void left(int minIndex, int left, int[] ratings, int[] candies) {
        for(int i = minIndex - 1; i >= left; i--) {
            if(ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
        }
    }
    public int candy(int[] ratings) {
        int min = ratings[0];
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] < min) {
                min = ratings[i];
            }
        }
        int[] minIndex = new int[ratings.length + 2];
        minIndex[0] = 0;
        minIndex[1] = 0;
        int count = 2;
        for(int i = 1; i < ratings.length-1; i++) {
            if(ratings[i] == min)
                minIndex[count++] = i;
        }
        minIndex[count++] = ratings.length-1;
        minIndex[count] = ratings.length-1;

        int[] candies = new int[ratings.length];
        for(int i = 1; i < count; i++) {
            right(minIndex[i], minIndex[i+1], ratings, candies);
            left(minIndex[i], minIndex[i-1], ratings, candies);

        }
        int sum = ratings.length;
        for(int candy : candies)
            sum += candy;
        return sum;
    }
}
