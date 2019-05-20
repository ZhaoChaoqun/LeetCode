package leetcode;

public class _704 {
    public static void main(String[] args) {
        _704 test = new _704();
//        System.out.println(test.search(new int[] {-1,0,3,5,9,12}, 9));
//        System.out.println(test.search(new int[] {-1,0,3,5,9,12}, 2));
        System.out.println(test.search(new int[] {-1,0,3,5,9,12}, 13));
    }
    public int search(int[] nums, int target) {
        return search(nums, target, 0 , nums.length - 1);
    }
    int search(int[] nums, int target, int left, int right) {
        if(left > right) return -1;
        int mid = (left + right) / 2;
        if(nums[mid] == target)
            return mid;
        if(nums[mid] < target)
            return search(nums, target, mid + 1, right);
        return search(nums, target, left, mid - 1);
    }
}
