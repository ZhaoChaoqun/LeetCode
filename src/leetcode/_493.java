package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class _493 {

    int n;
    long[] sortedIndex;
    int[] tree;
    public int reversePairs(int[] nums) {
        if(nums.length == 0) return 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < nums.length; i++)
            treeSet.add(nums[i]);
        n = treeSet.size();
        sortedIndex = new long[n];
        int i = 0;
        for(long num : treeSet)
            sortedIndex[i++] = num;
        Integer highestOneBit = Integer.highestOneBit(n);
        if(highestOneBit < n)
            n = highestOneBit << 1;
        tree = new int[n << 1];
        int count = 0;
        for(i = nums.length - 1; i >= 0; i--) {
            int index = Arrays.binarySearch(sortedIndex, nums[i]);
            int j = binarySearch(0, sortedIndex.length - 1, 2 * nums[i]);
            if(j > 0) {
                count += query(0, j - 1);
            }
            update(index);
        }
        return count;
    }
    // 找到第一个满足num > target的index
    int binarySearch(int l, int r, int target) {
        if(l > r)
            return -1;
        int mid = (l + r) >> 1;
        if(sortedIndex[mid] > target) {
            if(mid == 0 || sortedIndex[mid - 1] <= target)
                return mid;
            return binarySearch(l, mid - 1, target);
        }
        return binarySearch(mid + 1, r, target);
    }
    void update(int index) {
        index += n;
        for(; index > 0; index >>= 1)
            tree[index]++;
    }


    int query(int i, int j) {
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

    public static void main(String[] args) {
        _493 test = new _493();
        System.out.println(test.reversePairs(new int[] {1,3,2,3,1}));
        System.out.println(test.reversePairs(new int[] {2,4,3,5,1}));
    }
}
