package leetcode;

public class _762 {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for(int i = L; i <= R; i++) {
            System.out.println("i=" + i + "count=" + Integer.bitCount(i) + isPrime(Integer.bitCount(i)));
            if(isPrime(Integer.bitCount(i)))
                count++;
        }
        return count;
    }

    private boolean isPrime(int num) {
        if(num == 1) return false;
        for(int j = 2; j <= num >> 1; j ++)
            if(num % j == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _762().countPrimeSetBits(244, 269));
    }
}
