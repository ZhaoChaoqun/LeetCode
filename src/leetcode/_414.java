package leetcode;

public class _414 {


    public static void main(String[] args) {
        _414 test = new _414();
        System.out.println(test.thirdMax(new int[] {3,2,1}));
        System.out.println(test.thirdMax(new int[] {1,2}));
        System.out.println(test.thirdMax(new int[] {2, 2, 3, 1}));
    }
    public int thirdMax(int[] nums) {
        int max = nums[0], min = nums[0];
        for(int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int secondMax = min;
        for(int num : nums) {
            if(num != max) {
                secondMax = Math.max(secondMax, num);
            }
        }
        int thirdMax = min;
        for(int num : nums) {
            if(num != max && num != secondMax) {
                thirdMax = Math.max(thirdMax, num);
            }
        }
        return thirdMax == secondMax ? max : thirdMax;
    }
}
