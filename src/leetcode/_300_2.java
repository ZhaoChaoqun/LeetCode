package leetcode;

public class _300_2 {

    public static void main(String[] args) {
        _300_2 test = new _300_2();
//        System.out.println(test.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        System.out.println(test.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
//        System.out.println(test.lengthOfLIS(new int[] {4,10,4,3,8,9}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 1;
        int temp = 1;
        int[] bigger = new int[nums.length];
        bigger[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            temp = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    if (bigger[j] + 1 > temp)
                        temp = bigger[j] + 1;
                }
            }
            bigger[i] = temp;
            max = max < temp ? temp : max;
        }
//		System.out.println(Arrays.toString(bigger));
        return max;
    }
}
