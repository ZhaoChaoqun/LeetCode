package leetcode;

public class _457 {

    public boolean circularArrayLoop(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                int[] visit = new int[nums.length];
                for(int j = i, step = 1; true; step++) {
                    if(nums[j] <= 0 || visit[j] == 1)
                        break;
                    visit[j] = 1;
                    j += nums[j];
                    j %= nums.length;
                    if(j == i) {
                        if(step > 1) {
                            return true;
                        }
                        break;
                    }
                }
            } else if(nums[i] < 0) {
                int[] visit = new int[nums.length];
                for(int j = i, step = 1; true; step++) {
                    if(nums[j] >= 0 || visit[j] == 1)
                        break;
                    visit[j] = 1;
                    j += nums[j];
                    while (j < 0)
                        j += nums.length;
                    if(j == i) {
                        if(step > 1) {
                            return true;
                        }
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _457 test = new _457();
//        System.out.println(test.circularArrayLoop(new int[] {2,-1,1,2,2}));
//        System.out.println(test.circularArrayLoop(new int[] {-1,2}));
//        System.out.println(test.circularArrayLoop(new int[] {-2,1,-1,-2,-2}));
//        System.out.println(test.circularArrayLoop(new int[] {-1,-2,-3,-4,-5}));
        System.out.println(-5 % 5);
    }
}
