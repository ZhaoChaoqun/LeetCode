package leetcode;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
return 0;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland test = new MaxAreaOfIsland();
        int[][] grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(test.maxAreaOfIsland(grid));
        grid = new int[][] {{0,0,0,0,0,0,0,0}};
        System.out.println(test.maxAreaOfIsland(grid));
    }
}
