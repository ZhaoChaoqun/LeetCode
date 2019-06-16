package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _436 {

    public int[] findRightInterval(int[][] intervals) {
        int[][] matrix = new int[intervals.length][3];
        for(int i = 0; i < intervals.length; i++) {
            matrix[i] = new int[3];
            matrix[i][0] = intervals[i][0];
            matrix[i][1] = intervals[i][1];
            matrix[i][2] = i;
        }
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] result = new int[intervals.length];
        for(int i = 0; i < matrix.length; i++) {
            int index = binarySearch(0, matrix.length - 1, matrix, matrix[i][1]);
            if(index == -1) {
                result[matrix[i][2]] = -1;
            } else {
                result[matrix[i][2]] = matrix[index][2];
            }
        }
        return result;
    }

    private int binarySearch(int left, int right, int[][] matrix, int target) {
        if(left > right) return -1;
        int mid = (left + right) >> 1;
        if((mid == 0 || matrix[mid - 1][0] < target) && matrix[mid][0] >= target) {
            return mid;
        }
        if(matrix[mid][0] >= target) {
            return binarySearch(left, mid - 1, matrix, target);
        } else {
            return binarySearch(mid + 1, right, matrix, target);
        }
    }

    public static void main(String[] args) {
        _436 test = new _436();
//        System.out.println(Arrays.toString(test.findRightInterval(new int[][] {{1,2}})));
        System.out.println(Arrays.toString(test.findRightInterval(new int[][] {{3,4}, {2,3}, {1,2}})));
//        System.out.println(Arrays.toString(test.findRightInterval(new int[][] {{1,4}, {2,3}, {3,4}})));
    }
}
