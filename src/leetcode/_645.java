package leetcode;

import java.util.Arrays;

public class _645 {

    public static void main(String[] args) {
        _645 test = new _645();
        System.out.println(Arrays.toString(test.findErrorNums(new int[] {1, 2, 2, 4})));
    }
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] array = new int[nums.length + 1];
        for(int i = 0; i < array.length; i++)
            array[i] = i;
        for(int num : nums) {
            if(array[num] == 0) {
                result[0] = num;
            }
            array[num] = 0;
        }
        for(int i : array)
            if(i != 0)
                result[1] = i;
        return result;
    }

}
