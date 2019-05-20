package leetcode;

public class _709 {
    public static void main(String[] args) {
        _709 test = new _709();
        System.out.println(test.toLowerCase("Hello"));
        System.out.println(test.toLowerCase("here"));
        System.out.println(test.toLowerCase("LOVELY"));
    }

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] >= 'A' && chars[i] <= 'Z')
                chars[i] += 32;
        }
        return new String(chars);
    }
}
