package leetcode;

public class _215_2 {

    public int findKthLargest(int[] nums, int k) {
        return recursive(nums, 0, nums.length - 1, nums.length - k);
    }
    private int recursive(int[] nums, int left, int right, int target) {
        for(int i = left + 1, j = right; ;) {
            for(; i <= right && nums[i] < nums[left]; i++);
            for(; j > left && nums[j] > nums[left]; j--);
            if(j < i) {
                if(j == target) {
                    return nums[left];
                }
                exchange(nums, left, j);
                if(j < target) {
                    return recursive(nums, j + 1, right, target);
                }
                return recursive(nums, left, j - 1, target);
            }
            exchange(nums, i, j);
            i++;
            j--;
        }
    }
    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        _215_2 test = new _215_2();
        System.out.println(test.findKthLargest(new int[] {4,2,6,3,5,7,1}, 2));
        System.out.println(test.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        System.out.println(test.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }

}
