package leetcode;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int[] right = new int[nums.length + 1];
        for (int i = nums.length - 1; i > 0; i--)
            right[i] = nums[i] + right[i + 1];
        if (right[1] == 0)
            return 0;
        for (int i = 1; i < nums.length; i++) {
            if (right[i + 1] == nums[i - 1])
                return i;
            nums[i] += nums[i - 1];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex test = new FindPivotIndex();
        System.out.println(test.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(test.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(test.pivotIndex(new int[]{-1, -1, -1, 0, 1, 1}));
        System.out.println(test.pivotIndex(new int[]{-1, -1, 0, 0, -1, -1}));
        System.out.println(test.pivotIndex(new int[]{5}));
        System.out.println(test.pivotIndex(new int[]{}));
    }
}
