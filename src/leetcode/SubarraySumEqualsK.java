package leetcode;

/**
 * Created by zhaochaoqun on 2017/6/24.
 */
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        if(sum[0] == k)
            count++;
        for(int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
            if(sum[i] == k)
                count++;
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                sum[j] -= nums[i];
                if(sum[j] == k)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] {1,1,1}, 3));
    }
}
