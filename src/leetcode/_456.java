package leetcode;

import java.util.LinkedList;

public class _456 {

    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i-1], nums[i-1]);
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > min[i]) {
                for(; !stack.isEmpty() && stack.peek() <= nums[i];) {
                    int value = stack.pop();
                    if(value > min[i])
                        return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {1,0,1,-4,-3};
        int[] nums = new int[] {-2,1,2,-2,1,2};
        System.out.println(new _456().find132pattern(nums));
    }
}
