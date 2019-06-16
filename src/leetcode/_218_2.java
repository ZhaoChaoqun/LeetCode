package leetcode;

import java.util.*;

public class _218_2 {
    int[] tree;
    int n;
    List<List<Integer>> result;
    int[] sortedIndex;
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if(buildings.length == 0) return Collections.emptyList();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int[] building : buildings) {
            treeSet.add(building[0]);
            treeSet.add(building[1]);
        }
        n = treeSet.size();
        int highestOneBit = Integer.highestOneBit(n);
        sortedIndex = new int[n];
        int i = 0;
        for(int num : treeSet)
            sortedIndex[i++] = num;
        if(highestOneBit < n)
            n = highestOneBit << 1;
        tree = new int[n << 1];
        for(int[] building : buildings) {
            build(building);
        }
        result = new ArrayList<>();
        update(1);
        tree[n-1] = 0;
        for(i = n; i < n + sortedIndex.length; i++) {
            if(tree[i] != tree[i-1]) {
                List<Integer> item = new ArrayList<>();
                item.add(sortedIndex[i - n]);
                item.add(tree[i]);
                result.add(item);
            }
        }
        return result;
    }

    private void update(int index) {
        if(index >= (n << 1))
            return;
        tree[index] = Math.max(tree[index >> 1], tree[index]);
        update(index << 1);
        update(index << 1 | 1);
    }

    private void build(int[] building) {
        for(int left = n + Arrays.binarySearch(sortedIndex, building[0]), right = n + Arrays.binarySearch(sortedIndex, building[1]) - 1; left <= right; left >>= 1, right >>= 1) {
            if((left & 1) == 1) {
                if(tree[left] < building[2])
                    tree[left] = building[2];
                left++;
            }
            if((right & 1) == 0) {
                if(tree[right] < building[2])
                    tree[right] = building[2];
                right--;
            }
        }
    }

    public static void main(String[] args) {
        _218_2 test = new _218_2();
        int[][] buildings = new int[][]{{0, Integer.MAX_VALUE, Integer.MAX_VALUE}};
//        buildings = new int[][]{{0,2,3},{2,5,3}};
        buildings = new int[][]{ {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
        for(List<Integer> item : test.getSkyline(buildings)) {
            System.out.println(item);
        }
    }
}
