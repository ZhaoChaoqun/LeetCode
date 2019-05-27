package leetcode;

import java.util.*;

public class _480_2 {

    private int remove(TreeMap<Integer, Integer> heap, int key, int[] heapSize) {
        heapSize[0]--;
        if(heap.put(key, heap.get(key) - 1) == 1) heap.remove(key);
        return key;
    }
    private void add(TreeMap<Integer, Integer> heap, int key, int[] heapSize) {
        heapSize[0]++;
        heap.put(key, heap.getOrDefault(key, 0) + 1);
    }
    private void move(TreeMap<Integer, Integer> heap1, TreeMap<Integer, Integer> heap2, int[] heap1Size, int[] heap2Size) {
        add(heap2, remove(heap1, heap1.firstEntry().getKey(), heap1Size), heap2Size);
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        TreeMap<Integer, Integer> maxHeap = new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer, Integer> minHeap = new TreeMap<>();
        for(int i = 0; i < k; i++)
            maxHeap.put(nums[i], maxHeap.getOrDefault(nums[i], 0) + 1);
        int[] minHeapSize = new int[]{0};
        int[] maxHeapSize = new int[]{k};
        for(int i = 0; i < k / 2; i++)
            move(maxHeap, minHeap, maxHeapSize, minHeapSize);
        int minCapacity = k / 2;
        for(int i = k - 1; true; i++) {
            double media;
            if((k & 1) == 1)
                media = (double) maxHeap.firstEntry().getKey();
            else
                media = ((double) maxHeap.firstEntry().getKey() + minHeap.firstEntry().getKey()) / 2;
            result[i - k + 1] = media;
            if(i + 1 == nums.length)
                return result;
            if(nums[i - k + 1] != nums[i + 1]) {
                if(!maxHeap.isEmpty() && nums[i-k+1] <= maxHeap.firstEntry().getKey()) {
                    remove(maxHeap, nums[i-k+1], maxHeapSize);
                } else {
                    remove(minHeap, nums[i-k+1], minHeapSize);
                }
                if(!maxHeap.isEmpty() && nums[i+1] <= maxHeap.firstEntry().getKey()) {
                    add(maxHeap, nums[i+1], maxHeapSize);
                } else {
                    add(minHeap, nums[i+1], minHeapSize);
                }
                if(minHeapSize[0] < minCapacity) {
                    move(maxHeap, minHeap, maxHeapSize, minHeapSize);
                } else if(minHeapSize[0] > minCapacity) {
                    move(minHeap, maxHeap, minHeapSize, maxHeapSize);
                }
            }
        }
    }

    public static void main(String[] args) {
        _480_2 test = new _480_2();
        System.out.println(Arrays.toString(test.medianSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(test.medianSlidingWindow(new int[] {1,4,2,3}, 4)));
        System.out.println(Arrays.toString(test.medianSlidingWindow(new int[] {1}, 1)));
        System.out.println(Arrays.toString(test.medianSlidingWindow(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE}, 2)));
        System.out.println(Arrays.toString(test.medianSlidingWindow(new int[] {2147483647,1,2,3,4,5,6,7,2147483647}, 2)));
    }
}
