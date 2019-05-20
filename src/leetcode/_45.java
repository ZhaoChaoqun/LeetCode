package leetcode;

public class _45 {


    public static void main(String[] args) {
        System.out.println(new _45().jump(new int[] {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
    boolean backtracking(int[] nums, int[] array, int index, int step) {
        if(step < array[index] || array[index] == 0) {
            array[index] = step;
//            if(index == nums.length - 1)
//                return true;
        }
        for(int i = Math.min(nums[index] + index, nums.length - 1); i > index; i--) {
            backtracking(nums, array, i, step + 1);
//                return true;
        }
        return false;
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int[] array = new int[length];
        backtracking(nums, array, 0, 0);
        return array[length - 1];
    }
}
