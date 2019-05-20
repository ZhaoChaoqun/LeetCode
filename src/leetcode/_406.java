package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _406 {

    public static void main(String[] args) {
        _406 test = new _406();
        for(int[] row : test.reconstructQueue(new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}})) {
            System.out.println(Arrays.toString(row));
        }
        for(int[] row : test.reconstructQueue(new int[][] {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}})) {
            System.out.println(Arrays.toString(row));
        }
        for(int[] row : test.reconstructQueue(new int[][] {{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}})) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0] == o1[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
//        for(int[] item : people)
//            System.out.println(Arrays.toString(item));
        for(int i = 0; i < people.length; i++) {
            int count = 0, j = 0;
            for(; count <= people[i][1]; j++) {
                if(result[j] == null)
                    count++;
            }
            result[j-1] = people[i];
        }
        return result;
    }
}
