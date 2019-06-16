package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class _327 {
    static class TreeNode {
        int count;
        long min;
        long max;
    }
    TreeNode[] tree;
    int n;
    long[] sortedIndex;
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length == 0) return 0;
        long[] sum = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
            sum[i + 1] = sum[i] + nums[i];
        TreeSet<Long> treeSet = new TreeSet<>();
        for(int i = 1; i < sum.length; i++)
            treeSet.add(sum[i]);
        n = treeSet.size();
        sortedIndex = new long[n];
        int i = 0;
        for(long num : treeSet)
            sortedIndex[i++] = num;
        Integer highestOneBit = Integer.highestOneBit(n);
        if(highestOneBit < n)
            n  = highestOneBit << 1;
        // 初始化线段树
        tree = new TreeNode[n << 1];
        for(i = 1; i < n << 1; i++)
            tree[i] = new TreeNode();
        for(i = n; i < sortedIndex.length; i++) {
            tree[i].min = sum[i - n + 1];
            tree[i].max = sum[i - n + 1];
            for (int j = i >> 1; j > 0; j >>= 1) {
                tree[i].min = Math.min(tree[i << 1].min, tree[i << 1 | 1].min);
                tree[i].min = Math.max(tree[i << 1].max, tree[i << 1 | 1].max);
            }
        }
        int count = 0;
        for(i = sum.length - 1; i > 0; i--) {
            int index = Arrays.binarySearch(sortedIndex, sum[i]) + n;
            tree[index].count = 1;
            for(int j = index >> 1; j > 0; j >>= 1)
                tree[j].count++;
            count += query(sum[i] - lower, sum[i] - upper, 1);
        }
        return count;
    }

    int query(long l, long r, int index) {
        if(l > tree[index].max)
            return 0;
        if(r < tree[index].min)
            return 0;
        if(index >= n) {
            return 1;
        }
        if(l < tree[index].min && r > tree[index].max)
            return tree[index].count;
        return query(l, r, index << 1) + query(l, r, index << 1 | 1);
    }

    public static void main(String[] args) {
        _327 test = new _327();
        System.out.println(test.countRangeSum(new int[] {-2,5,-1}, -2, 2));
//        System.out.println(test.countRangeSum(new int[] {-2147483647,0,-2147483647,2147483647}, -564, 3864));
    }
}
