package leetcode;

public class _405 {
    public static void main(String[] args) {
        _405 test = new _405();
        for(int i = Integer.MIN_VALUE; i <= 0; i += 1000)
            if(!Integer.toHexString(i).equals(test.toHex(i))) {
                System.out.println(i);
        }
        for(int i = 0; i >= 0; i += 1000)
            if(!Integer.toHexString(i).equals(test.toHex(i))) {
                System.out.println(i);
            }
        System.out.println("success");
    }

    public String toHex(int num) {
        if(num == 0) return "0";
        if(num < 0) {
            char[] positive = toHex(-num - 1).toCharArray();
            char[] chars = new char[8];
            System.arraycopy(positive, 0, chars, 8 - positive.length, positive.length);
            for(int i = 0; i < 8 - positive.length; i++)
                if(chars[i] == 0)
                    chars[i] = 'f';
            for(int i = 8 - positive.length; i < 8; i++) {
                if(chars[i] >= '0' && chars[i] <= '9') {
                    int value = 15 - chars[i] + '0';
                    if(value < 10)
                        chars[i] = (char) (value + '0');
                    else
                        chars[i] = (char) (87 + value);
                } else {
                    chars[i] = (char) ('0' + 'f' - chars[i]);
                }
            }
            return new String(chars);
        }
        StringBuilder sb = new StringBuilder();
        for(;num != 0; num /= 16) {
            int value = num % 16;
            if(value < 10)
                sb.insert(0, value);
            else
                sb.insert(0, (char) (87 + value));
        }
        return sb.toString();
    }


}
