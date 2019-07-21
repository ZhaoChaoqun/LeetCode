package leetcode;

public class _84 {

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

    public static void main(String[] args) {
        _84 test = new _84();
        System.out.println(test.largestRectangleArea(new int[] {2,1,5,6,2,3}));
        System.out.println(test.largestRectangleArea(new int[] {4,2,0,3,2,4,3,4}));
    }
}
