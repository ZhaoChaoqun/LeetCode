package leetcode;

import java.util.*;

public class _480 {
    private int binarySearch(List<Integer> list, int left, int right, int target) {
        if(left > right)
            return left;
        int mid = (left + right) >>> 1;
        if((mid == left || list.get(mid - 1) <= target) && list.get(mid) >= target) {
            return mid;
        } else if(list.get(mid) < target) {
            return binarySearch(list, mid + 1, right, target);
        } else {
            return binarySearch(list, left, mid - 1, target);
        }
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        List<Integer> list = new ArrayList<>(k);
        for(int i = 0; i < k-1; i++)
            list.add(nums[i]);
        Collections.sort(list);
        for(int i = k - 1; i < nums.length; i++) {
            list.add(binarySearch(list, 0, k - 2, nums[i]), nums[i]);
            if((k & 1) == 1)
                result[i - k + 1] = list.get(k >> 1);
            else
                result[i - k + 1] = list.get(k >> 1) / 2.0 + list.get((k >> 1) - 1) / 2.0;
            list.remove(binarySearch(list, 0, k - 1, nums[i - k + 1]));
        }
        return result;
    }

    public static void main(String[] args) {
        _480 test = new _480();
        System.out.println(Arrays.toString(test.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(test.medianSlidingWindow(new int[] {1,4,2,3}, 4)));
        System.out.println(Arrays.toString(test.medianSlidingWindow(new int[] {1}, 1)));
        System.out.println(Arrays.toString(test.medianSlidingWindow(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE}, 2)));
    }
}
