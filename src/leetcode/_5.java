package leetcode;

public class _5 {

    public static void main(String[] args) {
        _5 test = new _5();
        System.out.println(test.longestPalindrome("cg"));
//        System.out.println(test.longestPalindrome(""));
    }

    public String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        if (length == 0) return "";
        int a, b, max= 0, maxIndex = length / 2, model = 1;

        for (int mid = length / 2, i = 1; mid + 1 >= max && mid <= length - max; i++) {
            a = 1;
            b = 0;
            for (; a <= mid && a < length - mid && array[mid - a] == array[mid + a]; a++) ;
            if (a > max) {
                maxIndex = mid;
                model = 1;
                max = a;
            }
            for (; b <= mid && b < length - 1 - mid && array[mid - b] == array[mid + 1 + b]; b++) ;
            if (b >= max) {
                maxIndex = mid;
                model = 3;
                max = b;
            }
            mid = mid >= length / 2 ? mid - i : mid + i;
        }
        return s.substring(maxIndex - max + (model & 1), maxIndex + max + (model >> 1 & 1));
    }
}
