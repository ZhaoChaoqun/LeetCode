package leetcode;

public class _665 {


    public static void main(String[] args) {
        _665 test = new _665();
        System.out.println(test.checkPossibility(new int[] {4,2,3}));
        System.out.println(test.checkPossibility(new int[] {4,2,1}));
        System.out.println(test.checkPossibility(new int[] {8,9,10,1,2,3,4,5,6,7}));
    }
    public boolean checkPossibility(int[] nums) {
        int happened = 0, from = 0;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if(++happened == 2)
                    return false;
            }
        }
        return true;
    }
}
