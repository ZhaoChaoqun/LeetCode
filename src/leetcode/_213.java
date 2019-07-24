package leetcode;

public class _213 {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        if(length == 1) return nums[0];
        // 从前往后开始打劫，截止到到倒数第二间
        int a = nums[0], b = Math.max(nums[0], nums[1]);
        for(int i = 2; i < length - 1; i++) {
            int tmp = b;
            b = Math.max(b, a + nums[i]);
            a = tmp;
        }
        int max = b;
        // 从后往前开始打劫，截止到第二间
        a = nums[nums.length - 1];
        b = Math.max(nums[nums.length - 2], nums[nums.length - 1]);
        for(int i = nums.length - 3; i > 0; i--) {
            int tmp = b;
            b = Math.max(b, a + nums[i]);
            a = tmp;
        }
        return Math.max(max, b);
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {2,3,2};
        int[] nums = new int[] {1,2,3,4,5,1,2,3,4,5};
        _213 test = new _213();
        System.out.println(test.rob(nums));
    }
}
