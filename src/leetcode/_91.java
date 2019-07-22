package leetcode;

public class _91 {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        char[] array = s.toCharArray();
        if(array[0] == '0') return 0;
        int[] end = new int[array.length];
        end[0] = 1;
        for(int i = 1; i < array.length; i++) {
            if(array[i] == '0') {
                if(array[i-1] == '1' || array[i-1] == '2') {
                    if(i > 1) {
                        end[i] = end[i-1] = end[i-2];
                    } else
                        end[i] = end[i-1];
                } else return 0;
            } else {
                if(array[i-1] == '1' || (array[i-1] == '2' && array[i] <= '6')) {
                    end[i] = end[i-1] + (i > 1 ? end[i-2] : 1);
                } else {
                    end[i] = end[i-1];
                }
            }
        }
        return end[array.length - 1];
    }

    public static void main(String[] args) {
        _91 test = new _91();
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
