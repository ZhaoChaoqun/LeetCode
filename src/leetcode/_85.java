package leetcode;

import java.util.Arrays;

public class _85 {
    public static void main(String[] args) {
        _85 test = new _85();
        System.out.println(test.maximalRectangle(new char[][]{
                "10100".toCharArray(),
                "10111".toCharArray(),
                "11111".toCharArray(),
                "10010".toCharArray()
        }));
    }

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if(length == 0) return 0;
        int[] lessFromLeft = new int[length];
        int[] lessFromRight = new int[length];
        lessFromLeft[0] = -1;
        lessFromRight[length - 1] = length;
        for(int i = 1; i < length; i++) {
            int j = i - 1;
            for(; j >= 0 && heights[i] <= heights[j]; j = lessFromLeft[j]);
            lessFromLeft[i] = j;
        }
        for(int i = length - 2; i >= 0; i--) {
            int j = i + 1;
            for(; j < length && heights[i] <= heights[j]; j = lessFromRight[j]);
            lessFromRight[i] = j;
        }
        int max = 0;
        for(int i = 0; i < length; i++)
            max = Math.max(max, (lessFromRight[i] - lessFromLeft[i] - 1) * heights[i]);
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int length = matrix.length;
        if(length == 0) return 0;
        int[] height = new int[matrix[0].length];
        int max = 0;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            System.out.println(Arrays.toString(height));
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }
}
