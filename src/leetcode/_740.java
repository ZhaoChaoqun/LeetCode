package leetcode;

public class _740 {

    public int deleteAndEarn(int[] nums) {
        int[] array = new int[10001];
        for(int num : nums)
            array[num]++;
        array[1] = array[1];
        for(int i = 2; i <= 10000; i++)
            array[i] = Math.max(array[i-1], array[i] * i + array[i-2]);
        return array[10000];
    }

    public static void main(String[] args) {
        _740 test = new _740();
        System.out.println(test.deleteAndEarn(new int[] {3, 4, 2}));
        System.out.println(test.deleteAndEarn(new int[] {2, 2, 3, 3, 3, 4}));
        System.out.println(test.deleteAndEarn(new int[] {8,10,4,9,1,3,5,9,4,10}));
    }
}
