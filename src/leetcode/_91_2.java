package leetcode;

public class _91_2 {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        char[] array = s.toCharArray();
        if(array[0] == '0') return 0;
        int prev = 1, prevPrev = 1;
        for(int i = 1; i < array.length; i++) {
            int tmp = prev;
            if(array[i] == '0') {
                if(array[i-1] == '1' || array[i-1] == '2') {
                    if(i > 1) {
                        prev = prevPrev;
                    }
                } else return 0;
            } else {
                if(array[i-1] == '1' || (array[i-1] == '2' && array[i] <= '6')) {
                    prev += (i > 1 ? prevPrev : 1);
                }
            }
            prevPrev = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        _91_2 test = new _91_2();
//        System.out.println(test.numDecodings("12"));
//        System.out.println(test.numDecodings("226"));
//        System.out.println(test.numDecodings("10"));
//        System.out.println(test.numDecodings("27"));
//        System.out.println(test.numDecodings("99"));
//        System.out.println(test.numDecodings("110"));
//        System.out.println(test.numDecodings("1212"));
//        System.out.println(test.numDecodings("101"));
        System.out.println(test.numDecodings("1010"));
        System.out.println(test.numDecodings("611"));
    }
}
