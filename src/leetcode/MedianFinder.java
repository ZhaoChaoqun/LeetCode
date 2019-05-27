package leetcode;

import java.util.*;

public class MedianFinder {
    private int binarySearch(List<Integer> list, int left, int right, int target) {
        if(left > right)
            return left;
        int mid = (left + right) >>> 1;
        if((mid == 0 || list.get(mid - 1) <= target) && list.get(mid) >= target) {
            return mid;
        } else if(list.get(mid) < target) {
            return binarySearch(list, mid + 1, right, target);
        } else {
            return binarySearch(list, left, mid - 1, target);
        }
    }
    List<Integer> list = new ArrayList<>();
    public MedianFinder() {
    }

    public void addNum(int num) {
        list.add(binarySearch(list, 0, list.size() - 1, num), num);
    }

    public double findMedian() {
        return list.get(list.size() >> 1) / 2.0 + list.get((list.size() + 1 >> 1) - 1) / 2.0;
    }
}
