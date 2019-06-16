package leetcode;
public class NumArray2 {

    int[] array;
    int n;
    public NumArray2(int[] nums) {
        n = nums.length;
        array = new int[n << 1];
        for (int i = 0; i < n; i++)
            array[n + i] = nums[i];
        for (int i = n - 1; i > 0; i--) {
            array[i] = array[i << 1] + array[(i << 1) + 1];
        }
    }

    public void update(int i, int val) {
        int diff = val - array[n + i];
        for(i += n; i > 0; i >>= 1) {
            array[i] += diff;
        }
    }


    public int sumRange(int i, int j) {
        int sum = 0;
        for(int left = i + n, right = j + n; left <= right; left >>= 1, right >>= 1) {
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
        NumArray2 numArray = new NumArray2(nums);
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
