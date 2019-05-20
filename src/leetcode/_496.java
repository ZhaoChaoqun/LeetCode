package leetcode;

import java.util.Arrays;

public class _496 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _496().nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2})));
        System.out.println(Arrays.toString(new _496().nextGreaterElement(new int[] {2,4}, new int[] {1,2,3,4})));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums2[j] == nums1[i]) {
                    for(j++; j < nums2.length && nums2[j] < nums1[i]; j++);
                    if(j == nums2.length)
                        nums1[i] = -1;
                    else
                        nums1[i] = nums2[j];
                }
            }
        }
        return nums1;
    }
}
