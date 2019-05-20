package leetcode;

import java.util.Arrays;

public class _324 {
    public static void main(String[] args) {
        _324 test = new _324();
        int[] nums;
//        nums = new int[] {1, 5, 1, 1, 6, 4};
//        test.wiggleSort(nums);
//        System.out.println(Arrays.toString(nums));
//        nums = new int[] {1, 3, 2, 2, 3, 1};
//        test.wiggleSort(nums);
//        System.out.println(Arrays.toString(nums));
//        nums = new int[] {1,2,2,1,2,1,1,1,1,2,2,2};
        nums = new int[] {3,2,3,3,2,1,1,2,3,1,1,3,2,1,2,2,2,2,1};
//        nums = new int[] {4,5,5,6};
        test.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if(i == 0)
                continue;
            if((i & 1) == 1) {  // index=奇数，nums[i-1] < nums[i] > nums[i+1]
                if(nums[i] < nums[i-1]) {
                    exchange(nums, i-1, i);
                } else if(nums[i] == nums[i-1]) {
                    int j = i + 1;
                    for(; j < nums.length && nums[j] == nums[i]; j++);
                    if(j == nums.length) {
                        int k = i - 3;
                        for(; k >= 0; k -= 2) {
                            if(nums[k] != nums[i]) {
                                exchange(nums, k, i);
                                i = k-1;
                                break;
                            }
                        }
                    } else {
                        exchange(nums, i, j);
                        i--;
                    }
                }
            } else {            // index=偶数，nums[i-1] > nums[i] < nums[i+1]
                if(nums[i] > nums[i-1]) {
                    exchange(nums, i-1, i);
                } else if(nums[i] == nums[i-1]) {
                    int j = i + 1;
                    for(; j < nums.length && nums[j] == nums[i]; j++);
                    if(j == nums.length) {
                        int k = i - 3;
                        for(; k >= 0; k -= 2) {
                            if(nums[k] != nums[i]) {
                                exchange(nums, k, i);
                                i = k-1;
                                break;
                            }
                        }
                    } else {
                        exchange(nums, i, j);
                        i--;
                    }
                }
            }
        }
    }
    private void exchange(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
