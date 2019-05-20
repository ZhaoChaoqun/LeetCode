package leetcode;

public class _423 {

    public static void main(String[] args) {
        _423 test = new _423();
        System.out.println('s' - 'a');
        System.out.println('i' - 'a');
//        System.out.println(test.originalDigits("owoztneoer"));
//        System.out.println(test.originalDigits("fviefuro"));
    }

    public String originalDigits(String s) {
        char[] chars = s.toCharArray();
        int[] array = new int[10];
        int[] charArray = new int[26];
        for (char c : chars) {
            if (c == 'z') {
                array[0]++;
                charArray['e' - 'a']--;
//                charArray['r' - 'a']--;
                charArray['o' - 'a']--;
            } else if (c == 'w') {
                array[2]++;
                charArray['t' - 'a']--;
                charArray['o' - 'a']--;
            } else if (c == 'x') {
                array[6]++;
                charArray['s' - 'a']--;
                charArray['i' - 'a']--;
            } else if (c == 'g') {
                array[8]++;
                charArray['e' - 'a']--;
                charArray['i' - 'a']--;
//                charArray['h' - 'a']--;
                charArray['t' - 'a']--;
            } else if (c == 'u') {
                array[4]++;
                charArray['f' - 'a']--;
                charArray['o' - 'a']--;
//                charArray['r' - 'a']--;
            } else {
                charArray[c - 'a']++;
            }
        }
        int seven = charArray['s' - 'a'];
        array[7] = seven;
//        charArray['s' - 'a'] -= seven;
        charArray['e' - 'a'] -= 2 * seven;
//        charArray['v' - 'a'] -= seven;
        charArray['n' - 'a'] -= seven;


        int five = charArray['f' - 'a'];
        array[5] = five;
//        charArray['f' - 'a'] -= five;
        charArray['i' - 'a'] -= five;
//        charArray['v' - 'a'] -= five;
        charArray['e' - 'a'] -= five;

        int three = charArray['t' - 'a'];
        array[3] = three;
//        charArray['t' - 'a'] -= three;
//        charArray['h' - 'a'] -= three;
//        charArray['r' - 'a'] -= three;
        charArray['e' - 'a'] -= 2 * three;

        int one = charArray['o' - 'a'];
        array[1] = one;
//        charArray['o' - 'a'] -= one;
        charArray['n' - 'a'] -= one;
        charArray['e' - 'a'] -= one;
        array[9] = charArray['i' - 'a'];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < array[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
