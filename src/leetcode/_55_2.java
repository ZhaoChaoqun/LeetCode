package leetcode;

import java.io.*;

public class _55_2 {

    public static void main(String[] args) {
        _55_2 test = new _55_2();
        System.out.println(test.canJump(new int[]{0}));
//        System.out.println(test.canJump(new int[] {2,3,1,1,4}));
//        System.out.println(test.canJump(new int[] {3,2,1,0,4}));
        BufferedReader fw = null;
        String str = null;
        try {
            fw = new BufferedReader(new FileReader(new File("/Users/zhaochaoqun/Desktop/test")));
            str = fw.readLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] strArray = str.split(",");
        int[] nums = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++)
            nums[i] = Integer.parseInt(strArray[i]);
        long begin = System.currentTimeMillis();
        System.out.println(test.canJump(nums));
        System.out.println(System.currentTimeMillis() - begin);
    }


    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0)
                return false;
            nums[i + 1] = Math.max(nums[i] - 1, nums[i + 1]);
        }
        return nums[nums.length - 2] > 0;
    }
}
