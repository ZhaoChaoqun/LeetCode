package leetcode;

import java.util.Arrays;

public class ValidTriangleNumber2 {
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int length = nums.length;
        for(int i = 0; i < length - 2; i++) {
            for(int j = i + 1, k = j + 1; j < length - 1; j++) {
                for(k = Math.max(k, j + 1); k < length && nums[i] + nums[j] > nums[k]; k++) {
                }
                if (k == length) {
                    int n = 0;
                    for(int m = 1; m < k - j;) {
                        n += m * ++m;
                    }
                    count += n / 2;
                    return count;
                }
                count += --k - j;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[] {84,94,72,38,69,8,53,45,88,52,58,82,25,78,17,93,67,7,61,34,10,58,61,41,58,17,15,64,7,96,74,43,15,95,62,76,0,3,64,54,68,61,85,38,61,14,58,63,30,4,87,2,56,10,70,97,11,81,53,82,39,30,0,84,85,35,17,5,0,33,66,21,26,16,94,59,81,0,1,26,14,62,16,50,49,54,49,5,26,84,13,73,53,48,30,34,90,11,85,57}));
    }
}