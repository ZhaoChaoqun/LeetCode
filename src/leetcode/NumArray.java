package leetcode;

public class NumArray {

    int[] array;
    int size;
    public NumArray(int[] nums) {
        int n = nums.length;
        size = Integer.highestOneBit(n);
        if(size < n)
            size <<= 1;
        array = new int[size << 1];
        for (int i = 0; i < n; i++)
            array[size + i] = nums[i];
        for (int i = size - 1; i > 0; i--) {
            array[i] = array[i << 1] + array[(i << 1) + 1];
        }
    }

    public void update(int i, int val) {
        int diff = val - array[size + i];
        for(i += size; i > 0; i >>= 1) {
            array[i] += diff;
        }
    }


    public int sumRange(int i, int j) {
        int sum = 0;
        for(int left = i + size, right = j + size; left <= right; left >>= 1, right >>= 1) {
            if((left & 1) == 1) {
                sum += array[left++];
            }
            if((right & 1) == 0) {
                sum += array[right--];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-28, -39, 53, 65, 11, -56, -65, -39, -43, 97};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(5, 6));
        numArray.update(9, 27);
        System.out.println(numArray.sumRange(2, 3));
        System.out.println(numArray.sumRange(6, 7));
        numArray.update(1, -82);
        numArray.update(3, -72);
        System.out.println(numArray.sumRange(3, 7));
        System.out.println(numArray.sumRange(1, 8));
        numArray.update(1, 13);
        numArray.update(4, -67);
    }
}
