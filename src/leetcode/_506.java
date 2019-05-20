package leetcode;

import java.util.Arrays;

public class _506 {


    private void sort(int left, int right) {
        if(left == right)
            ranks[left] = nums[right];
        if(left >= right)
            return;
        int value = nums[left];
        int i = left + 1, j = right;
        while (true) {
            for(; i <= j && nums[i] <= value; i++);
            for(; i <= j && nums[j] >= value; j--);
            if(i >= j)
                break;
            exchange(i, j);
        }
        exchange(left, j);
//        System.out.println(Arrays.toString(nums));
        sort(left, j-1);
        sort(i, right);
        // left元素最终位置是j
        ranks[j] = nums[left];
    }
    private void exchange(int i, int j) {
        int value = nums[i];
        nums[i] = nums[j];
        nums[j] = value;
    }
    int[] ranks;
    int[] nums;
    public String[] findRelativeRanks(int[] nums) {
        this.nums = nums;
        ranks = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            ranks[i] = i;
        }
        sort(0, nums.length - 1);
        System.out.println(Arrays.toString(ranks));
//        System.out.println(Arrays.toString(nums));
        return null;
    }

    public static void main(String[] args) {
        _506 test = new _506();
//        System.out.println(Arrays.toString(test.findRelativeRanks(new int[] {5,4,3,2,1})));
        test.findRelativeRanks(new int[] {7,2,4,6,8,5});
        test.findRelativeRanks(new int[] {5,4,3,2,1});
    }
}
