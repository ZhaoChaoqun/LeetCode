package leetcode;

public class _164 {
    public static void main(String[] args) {
        _164 test = new _164();
        System.out.println(test.maximumGap(new int[] {3,6,9,1}));
    }
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int maxVal = nums[0];
        for(int i = 0; i < nums.length; i++)
            maxVal = Math.max(nums[i], maxVal);

        int exp = 1;                                 // 1, 10, 100, 1000 ...
        int radix = 10;                              // base 10 system
        int[] aux = new int[nums.length];
        /* LSD Radix Sort */
        for (; maxVal / exp > 0; exp *= 10) {                   // Go through all digits from LSD to MSD
            int[] count = new int[radix];
            for (int i = 0; i < nums.length; i++)    // Counting sort
                count[(nums[i] / exp) % 10]++;
            for (int i = 1; i < count.length; i++)   // you could also use partial_sum()
                count[i] += count[i - 1];
            for (int i = nums.length - 1; i >= 0; i--)
                aux[--count[(nums[i] / exp) % 10]] = nums[i];
            System.arraycopy(aux, 0, nums, 0, nums.length);
        }

        int maxGap = 0;
        for (int i = 0; i < nums.length - 1; i++)
            maxGap = Math.max(nums[i + 1] - nums[i], maxGap);
        return maxGap;
    }
}
