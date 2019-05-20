package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhaochaoqun on 2017/6/24.
 */
public class ValidSquare {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] array = new int[4][2];
        array[0] = p1;
        array[1] = p2;
        array[2] = p3;
        array[3] = p4;
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0])
                    return 1;
                if(o1[0] < o2[0])
                    return -1;
                return o1[1] - o2[1];
            }
        });
        int a = (array[0][0] - array[1][0]) * (array[0][0] - array[1][0]) + (array[0][1] - array[1][1]) * (array[0][1] - array[1][1]);
        int b = (array[1][0] - array[3][0]) * (array[1][0] - array[3][0]) + (array[1][1] - array[3][1]) * (array[1][1] - array[3][1]);
        int c = (array[0][0] - array[2][0]) * (array[0][0] - array[2][0]) + (array[0][1] - array[2][1]) * (array[0][1] - array[2][1]);
        int d = (array[1][0] - array[3][0]) * (array[1][0] - array[3][0]) + (array[1][1] - array[3][1]) * (array[1][1] - array[3][1]);
        if(a != b || a != c || a != d || a == 0)
            return false;
        int e = (array[1][0] - array[2][0]) * (array[1][0] - array[2][0]) + (array[1][1] - array[2][1]) * (array[1][1] - array[2][1]);
        if (a + c == e)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] p1 = new int[] {0,0}, p2 = new int[] {1,1}, p3 = new int[] {1,0}, p4 = new int[] {0,1};
        System.out.println(validSquare(p1, p2, p3, p4));
    }
}
