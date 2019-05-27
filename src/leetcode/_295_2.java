package leetcode;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class _295_2 {

    private int removeTop(TreeMap<Integer, Integer> heap, int[] heapSize) {
        heapSize[0]--;
        Map.Entry<Integer, Integer> top = heap.pollFirstEntry();
        if(top.getValue() > 1)
            heap.put(top.getKey(), top.getValue() - 1);
        return top.getKey();
    }

    private void add(TreeMap<Integer, Integer> heap, int key, int[] heapSize) {
        heapSize[0]++;
        heap.put(key, heap.getOrDefault(key, 0) + 1);
    }
    private void move(TreeMap<Integer, Integer> heap1, TreeMap<Integer, Integer> heap2, int[] heap1Size, int[] heap2Size) {
        add(heap2, removeTop(heap1, heap1Size), heap2Size);
    }
    TreeMap<Integer, Integer> maxHeap;
    TreeMap<Integer, Integer> minHeap;
    int[] maxHeapSize;
    int[] minHeapSize;
    public _295_2() {
        minHeapSize = new int[]{0};
        maxHeapSize = new int[]{0};
        maxHeap = new TreeMap<>(Collections.reverseOrder());
        minHeap = new TreeMap<>();
    }

    public void addNum(int num) {
        if(!maxHeap.isEmpty() && num <= maxHeap.firstEntry().getKey()) {
            add(maxHeap, num, maxHeapSize);
        } else {
            add(minHeap, num, minHeapSize);
        }
        if(minHeapSize[0] < (maxHeapSize[0] + minHeapSize[0]) >>> 1) {
            move(maxHeap, minHeap, maxHeapSize, minHeapSize);
        } else if(minHeapSize[0] > (maxHeapSize[0] + minHeapSize[0]) >>> 1) {
            move(minHeap, maxHeap, minHeapSize, maxHeapSize);
        }
    }

    public double findMedian() {
        double media;
        if((maxHeapSize[0] + minHeapSize[0] & 1) == 1)
            media = (double) maxHeap.firstEntry().getKey();
        else
            media = ((double) maxHeap.firstEntry().getKey() + minHeap.firstEntry().getKey()) / 2;
        return media;
    }
}
