package leetcode;

public class _643 {
    public static void main(String[] args) {
        _643 test = new _643();
        System.out.println(test.findMaxAverage(new int [] {1,12,-5,-6,50,3}, 4));
    }

    public double findMaxAverage(int[] nums, int k) {
        int max = 0;

        for(int i = 0; i < k; i++) {
            max += nums[i];
        }
        int sum = max;
        for(int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            if(sum > max)
                max = sum;
        }
        return 1.0 * max / k;
    }
}
