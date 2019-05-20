package leetcode;

import java.util.Arrays;

public class _378 {

    public static void main(String[] args) {
//        System.out.println(new _378().kthSmallest(new int[][] {
//                { 1,  5,  9},
//                {10, 11, 13},
//                {12, 13, 15}
//        },8));
        for(int i = 1; i < 10; i++)
            System.out.println(new _378().kthSmallest(new int[][] {
                    { 1,  5,  9},
                    {10, 11, 13},
                    {12, 13, 15}
            },i));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int count = 0;
        int i = 1;
        int[] array;
        for(; i <= length && count < k; i++) {
            count += i;
        }
        if(count >= k) {
            array = new int[--i];
            for(int j = 0; i > 0; i--, j++) {
                array[j] = matrix[i-1][j];
            }
        } else {
            i = length - 1;
            for(; i > 0 && count < k; i--) {
                count += i;
            }
            array = new int[i + 1];
            for(int j = 0; i < length; i++, j++) {
                array[j] = matrix[length-1-j][i];
            }
        }
        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));

        return array[array.length - 1 - count + k];
    }
}
