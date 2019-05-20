package leetcode;

public class _55 {

    public static void main(String[] args) {
        _55 test = new _55();
//        System.out.println(test.canJump(new int[] {2,3,1,1,4}));
//        System.out.println(test.canJump(new int[] {3,2,1,0,4}));
        System.out.println(test.canJump(new int[] {2, 0}));
    }

    boolean backtracking(int[] nums, int index) {
        if(index >= nums.length - 1) return true;
        for(int i = nums[index]; i > 0; i--) {
            if(backtracking(nums, index + i))
                return true;
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        return backtracking(nums, 0);
    }
}
