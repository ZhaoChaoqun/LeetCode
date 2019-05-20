package leetcode;

public class _393 {

    public static void main(String[] args) {
//        System.out.println(new _393().validUtf8(new int[] {197, 130, 1}));
//        System.out.println(new _393().validUtf8(new int[] {235, 140, 4}));
//        System.out.println(new _393().validUtf8(new int[] {145}));
//        System.out.println(new _393().validUtf8(new int[] {230, 136, 145}));
        System.out.println(new _393().validUtf8(new int[]{250, 145, 145, 145, 145}));
    }

    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if ((data[i] & 128) == 0) {
                continue;
            }
            int j = 6;
            for (; j >= 1 && (data[i] >> j & 1) == 1; j--) ;
            if (j == 6 || 6 - j > 3) return false;
            int k = 1;
            for (; k <= 6 - j; k++) {
                if (k + i == data.length) return false;
                if ((data[k + i] >> 7 & 1) != 1 || (data[k + i] >> 6 & 1) != 0)
                    return false;
            }
            i += 6 - j;
        }
        return true;
    }
}
