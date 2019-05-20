package leetcode;

/**
 * Created by zhaochaoqun on 2017/6/23.
 */
public class ArrayNesting {

    public static int arrayNesting(int[] nums) {
        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0 || i == nums[i]) {
                continue;
            }
            int count = 1;
            nums[i] = -nums[i];
            for(int j = -nums[i]; nums[j] >= 0; j = -nums[j]) {
                nums[j] = -nums[j];
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2};
        System.out.println(arrayNesting(nums));
    }
}
