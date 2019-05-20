package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _135_2 {

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
        List<Integer> minIndex = new ArrayList<>();
        minIndex.add(0);
        minIndex.add(0);
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] == min)
                minIndex.add(i);
        }
        minIndex.add(ratings.length-1);
        minIndex.add(ratings.length-1);

        int[] candies = new int[ratings.length];
        for(int i = 1; i < minIndex.size() - 1; i++) {
            right(minIndex.get(i), minIndex.get(i+1), ratings, candies);
            left(minIndex.get(i), minIndex.get(i-1), ratings, candies);

        }
        int sum = ratings.length;
        for(int candy : candies)
            sum += candy;
        return sum;
    }
}
