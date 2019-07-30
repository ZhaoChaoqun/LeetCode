package leetcode;

public class _11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int max = 0;
        for(int i = 0; i < height.length-1; i++) {
            if(height[i] > max) {
                max = height[i];
                for(int j = height.length - 1; j > i; j--) {
                    if(maxArea >= height[i] * (j - i))
                        break;
                    int minHeight = height[i] < height[j] ? height[i] : height[j];
                    maxArea = maxArea < minHeight * (j - i) ? minHeight * (j - i) : maxArea;
                }
            }
        }
        return maxArea;
    }
}
