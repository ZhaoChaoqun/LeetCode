package leetcode;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        int max = 0, maxIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] * 2 > max && i != maxIndex)
                return -1;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceOfOthers test = new LargestNumberAtLeastTwiceOfOthers();
        System.out.println(test.dominantIndex(new int[] {3, 6, 1, 0}));
        System.out.println(test.dominantIndex(new int[] {1, 2, 3, 4}));
    }
}
