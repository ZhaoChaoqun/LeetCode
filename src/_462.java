import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _462 {

    public static void main(String[] args) {
//        System.out.println(new _462().minMoves2(new int[]{1,2,3}));
        System.out.println(new _462().minMoves2(new int[]{203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143}));
//        []
    }
    Map<Integer, Long> map = new HashMap<>();
    public int minMoves2(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums.length == 2) return Math.abs(nums[0] - nums[1]);
        Arrays.sort(nums);
        return (int) binarySearch(0, nums.length - 1, nums);
    }

    private long binarySearch(int left, int right, int[] nums) {
        if(left == right) return moves(nums, left);
        int mid = (left + right) >> 1;
        long leftMoves = moves(nums, left);
        long rightMoves = moves(nums, right);
        if(leftMoves <= rightMoves)
            return binarySearch(left, mid, nums);
        return binarySearch(mid == left ? mid + 1 : mid, right, nums);
    }
    private long moves(int[] nums, int i) {
        if(map.containsKey(i))
            return map.get(i);
        long moves = 0;
        for(int j = 0; j < nums.length; j++)
            moves += Math.abs(nums[i] - nums[j]);
        map.put(i, moves);
        return moves;
    }
}
