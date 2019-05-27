package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _496_3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _496_3().nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2})));
        System.out.println(Arrays.toString(new _496_3().nextGreaterElement(new int[] {2,4}, new int[] {1,2,3,4})));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        LinkedList<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
            nums1[i] = -1;
        }
        for(int j = 0; j < nums2.length; j++) {
            while (!stack.isEmpty() && stack.peek() < nums2[j]) {
                if (map.containsKey(stack.peek()))
                    nums1[map.get(stack.peek())] = nums2[j];
                stack.pop();
            }
            stack.push(nums2[j]);
        }
        return nums1;
    }
}
