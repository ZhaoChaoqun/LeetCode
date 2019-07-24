package leetcode;

public class _213 {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] max = new int[nums.length];
        int[] noHeadMax = new int[nums.length];
        int result = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            max[i] = nums[i];
            noHeadMax[i] = nums[i];
            for(int j = 0; j < i - 1; j++) {
                if(max[j] + nums[i] > max[i])
                    max[i] = max[j] + nums[i];
            }
            for(int j = 1; j < i - 1; j++) {
                if(noHeadMax[j] + nums[i] > noHeadMax[i])
                    noHeadMax[i] = noHeadMax[j] + nums[i];
            }
            if(max[i] > result)
                result = max[i];

        }
        int i = nums.length - 1;
        noHeadMax[i] = nums[i];
        for(int j = 1; j < i - 1; j++) {
            if(noHeadMax[j] + nums[i] > noHeadMax[i])
                noHeadMax[i] = noHeadMax[j] + nums[i];
        }
        if(noHeadMax[i] > result)
            result = noHeadMax[i];
        return result;
    }
}
