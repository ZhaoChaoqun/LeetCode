package leetcode;

public class _740_2 {

    public int deleteAndEarn(int[] nums) {
        int[] array = new int[10001];
        int max = 1;
        for(int num : nums) {
            max = Math.max(max, num);
            array[num]++;
        }
        array[1] = array[1];
        for(int i = 2; i <= max; i++)
            array[i] = Math.max(array[i-1], array[i] * i + array[i-2]);
        return array[max];
    }

    public static void main(String[] args) {
        _740_2 test = new _740_2();
        System.out.println(test.deleteAndEarn(new int[] {3, 4, 2}));
        System.out.println(test.deleteAndEarn(new int[] {2, 2, 3, 3, 3, 4}));
        System.out.println(test.deleteAndEarn(new int[] {8,10,4,9,1,3,5,9,4,10}));
    }
}
