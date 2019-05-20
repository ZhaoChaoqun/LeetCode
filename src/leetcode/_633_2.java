package leetcode;

public class _633_2 {

    public static void main(String[] args) {
        _633_2 test = new _633_2();
        System.out.println(test.judgeSquareSum(2));
        System.out.println(test.judgeSquareSum(4));
        System.out.println(test.judgeSquareSum(42));
    }

    public boolean judgeSquareSum(int c) {
        for(int tmp, i = 0, j = (int) Math.sqrt(c); i <= j;) {
            tmp = i * i + j * j;
            if(tmp == c)
                return true;
            if(tmp < c)
                i++;
            else j--;
        }
        return false;
    }
}
