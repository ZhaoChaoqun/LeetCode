package leetcode;

import java.util.*;

public class _373_2 {

    public static void main(String[] args) {
        _373_2 test = new _373_2();
        for (int[] array : test.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 4))
            System.out.print(Arrays.toString(array) + "\t");
        System.out.println();
        for (int[] array : test.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 3))
            System.out.print(Arrays.toString(array) + "\t");
        System.out.println();
        for (int[] array : test.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3))
            System.out.print(Arrays.toString(array) + "\t");
        System.out.println();

        for (int[] array : test.kSmallestPairs(new int[]{34,774,1640,1814}, new int[]{801,933,1093,1498,2384,2665,3310}, 50))
            System.out.print(Arrays.toString(array) + "\t");
        System.out.println();
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        int size = nums1.length * nums2.length;
        if(size == 0) return result;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(size, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });
        for(int num1 : nums1) {
            for(int num2 : nums2) {
                priorityQueue.offer(new int[] {num1, num2});
            }
        }
        for(k = Math.min(k, size); k > 0 ; k--)
            result.add(priorityQueue.poll());
        return result;
    }
}
