package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class _493_2 {

    static class TreeNode {
        int count;
        long min;
        long max;
    }
    TreeNode[] tree;
    int n;
    int[] sortedIndex;
    public int reversePairs(int[] nums) {
        if(nums.length == 0) return 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < nums.length; i++)
            treeSet.add(nums[i]);
        n = treeSet.size();
        sortedIndex = new int[n];
        int i = 0;
        for(int num : treeSet)
            sortedIndex[i++] = num;
        // 初始化线段树
        Integer highestOneBit = Integer.highestOneBit(n);
        if(highestOneBit < n)
            n = highestOneBit << 1;
        tree = new TreeNode[n << 1];
        for(i = 1; i < n << 1; i++)
            tree[i] = new TreeNode();
        for(i = n; i < sortedIndex.length + n; i++) {
            tree[i].min = 2l * sortedIndex[i - n];
            tree[i].max = 2l * sortedIndex[i - n];
            for (int j = i >> 1; j > 0; j >>= 1) {
                tree[j].min = tree[j << 1].min;
                tree[j].max = tree[j << 1 | 1].max;
            }
        }
        int count = 0;
        for(i = nums.length - 1; i > 0; i--) {
            count += query(nums[i], 1);
            int index = Arrays.binarySearch(sortedIndex, nums[i]) + n;
            tree[index].count = 1;
            for(int j = index >> 1; j > 0; j >>= 1)
                tree[j].count++;
        }
        return count;
    }

    int query(long target, int index) {
        if(index >= 2 * n)
            return 0;
        if(tree[index].max < target)
            return tree[index].count - query(tree[index].min, index << 1);
//        if(tree[index].min >= target)
//            return query(target, index << 1);
        return query(target, index << 1 | 1);
    }

    public static void main(String[] args) {
        _493_2 test = new _493_2();
        System.out.println(test.reversePairs(new int[] {1,3,2,3,1}));
        System.out.println(test.reversePairs(new int[] {2,4,3,5,1}));
    }
}
