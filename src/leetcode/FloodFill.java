package leetcode;

import java.util.Arrays;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class FloodFill {
    int rows;
    int cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        rows = image.length;
        cols = image[0].length;
        int oldColor = image[sr][sc];
        if(oldColor == newColor)
            return image;
        recursive(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void recursive(int[][] image, int i, int j, int oldColor, int newColor) {
        if(i >= 0 && i < rows && j >= 0 && j < cols && image[i][j] == oldColor) {
            image[i][j] = newColor;
            recursive(image, i - 1, j, oldColor, newColor);
            recursive(image, i + 1, j, oldColor, newColor);
            recursive(image, i, j - 1, oldColor, newColor);
            recursive(image, i, j + 1, oldColor, newColor);
        }
    }

    public static void main(String[] args) {
        FloodFill test = new FloodFill();

        for (int[] row : test.floodFill(new int[][] {{0,0,0}, {0,1,1}}, 1, 1, 1))
            System.out.println(Arrays.toString(row));
    }
}
