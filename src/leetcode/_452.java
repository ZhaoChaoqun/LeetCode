package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _452 {


    public static void main(String[] args) {
        _452 test = new _452();
        System.out.println(test.findMinArrowShots(new int[][]{{10,16}, {2,8}, {1,6}, {7,12}}));
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 0;
        for(int index = 0; index < points.length;) {
            ++count;
            int i = index + 1;
            for(; i <points.length && points[i][0] <= points[index][1]; i++);
            index = i;
        }
        return count;
    }
}
