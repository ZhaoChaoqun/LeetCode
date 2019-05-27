package leetcode;

import java.util.*;

public class _373_3 {

    public static void main(String[] args) {
        _373_3 test = new _373_3();
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
        int size = nums1.length * nums2.length;
        if(size == 0) return Collections.emptyList();

        ArrayList<int[]> list = new ArrayList<>(size);
        for(int num1 : nums1) {
            for(int num2 : nums2) {
                list.add(new int[] {num1, num2});
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });
        return list.subList(0, Math.min(k, size));
    }
}
