package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
                    {10, 15, 18},
                    {11, 16, 19}
            },i));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < length; i++)
            for(int j = 0; j < length; j++) {
                if(i + j + 1 <= k) {
                    if(length * (i + j) + 1 >= k)
                        list.add(matrix[i][j]);
                    else
                        ++count;

                }
            }
        Collections.sort(list);
//        System.out.println(list);
        return list.get(k - count - 1);
    }
}
