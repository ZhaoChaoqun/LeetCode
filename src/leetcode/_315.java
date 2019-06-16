package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class _315 {

    public static void main(String[] args) {
        _315 test = new _315();
        System.out.println(test.countSmaller(new int[] {5}));
    }
    int n;
    int[] tree;
    int[] sortedIndex;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>(nums.length);
        if(nums.length == 0) return ret;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int num : nums)
            treeSet.add(num);
        n = treeSet.size();
        sortedIndex = new int[n];
        int i = 0;
        for(int num : treeSet)
            sortedIndex[i++] = num;
        int highestOneBit = Integer.highestOneBit(n);
        tree = new int[n << 1];
        for(i = nums.length - 1; i >= 0; i--) {
            int j = Arrays.binarySearch(sortedIndex, nums[i]);
            if(j > 0)
                nums[i] = query(0, j - 1);
            else
                nums[i] = 0;
            for(j += n; j > 0; j >>>= 1)
                tree[j]++;
        }
        for(int num : nums)
            ret.add(num);
        return ret;
    }

    private int query(int i, int j) {
        int sum = 0;
        for(int left = i + n, right = j + n; left <= right; left >>= 1, right >>= 1) {
            if((left & 1) == 1) {
                sum += tree[left++];
            }
            if((right & 1) == 0) {
                sum += tree[right--];
            }
        }
        return sum;
    }
}
