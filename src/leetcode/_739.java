package leetcode;

import java.util.Arrays;

public class _739 {

    public int[] dailyTemperatures(int[] t) {
        int[] result = new int[t.length];
        for(int i = t.length - 2; i >= 0; i--) {
            if(t[i] < t[i+1])
                result[i] = 1;
            else if(result[i+1] == 0)
                result[i] = 0;
            else {
                int j = i + 1 + result[i+1];
                for(; t[j] < t[i] && result[j] > 0; j += result[j]);
                if(t[j] > t[i]) {
                    result[i] = j - i;
                } else if(result[j] == 0) {
                    result[i] = 0;
                } else {
                    result[i] = result[j] + j - i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _739 test = new _739();
        System.out.println(Arrays.toString(test.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(test.dailyTemperatures(new int[] {34,80,80,34,34,80,80,80,80,34})));
    }
}
