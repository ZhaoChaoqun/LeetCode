package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _659_2 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,4,5};
        _659_2 test = new _659_2();
        System.out.println(test.isPossible(nums));
        nums = new int[] {1,2,3,3,4,4,5,5};
        System.out.println(test.isPossible(nums));

    }
    public boolean isPossible(int[] nums) {
        if(nums.length < 3)
            return false;
        List<List<Integer>> list = new ArrayList<>();
        // list中的最后子数组，last subArray
        List<Integer> last = new ArrayList<>();
        last.add(nums[0]);
        list.add(last);
        for(int i = 1; i < nums.length; i++) {
            boolean added = false;
            for(int j = list.size() - 1; j >= 0; j--) {
                last = list.get(j);
                if(nums[i] == last.get(last.size() - 1) + 1) {
                    last.add(nums[i]);
                    added = true;
                    break;
                } else if(nums[i] > last.get(last.size() - 1) + 1) {
                    break;
                }
            }
            if(!added) {
                last = new ArrayList<>();
                last.add(nums[i]);
                list.add(last);
            }
        }
        for(List<Integer> item : list)
            if(item.size() < 3)
                return false;
        return true;
    }
}
