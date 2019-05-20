package leetcode;

public class _824 {


    public static void main(String[] args) {
        _824 test = new _824();
        System.out.println(test.toGoatLatin("i speak Goat Latin"));
        System.out.println("imaa peaksmaaa oatGmaaaa atinLmaaaaa");
        System.out.println(test.toGoatLatin("i speak Goat Latin").equals("imaa peaksmaaa oatGmaaaa atinLmaaaaa"));
        System.out.println(test.toGoatLatin("The quick brown fox jumped over the lazy dog"));
        System.out.println("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa");
        System.out.println(test.toGoatLatin("The quick brown fox jumped over the lazy dog").equals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));
    }

    public String toGoatLatin(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        int count = 1;
        char consonant = 'a';
        if (chars[0] != 'a' && chars[0] != 'e' && chars[0] != 'i' && chars[0] != 'o' && chars[0] != 'u' &&
                chars[0] != 'A' && chars[0] != 'E' && chars[0] != 'I' && chars[0] != 'O' && chars[0] != 'U') {
            consonant = chars[0];
        } else
            sb.append(chars[0]);
        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                if (consonant != 'a') {
                    sb.append(consonant);
                }
                sb.append('m');
                for (int j = 0; j <= count; j++)
                    sb.append('a');
                ++count;
                if (i + 1 < chars.length) {
                    switch (chars[i + 1]) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                        case 'A':
                        case 'E':
                        case 'I':
                        case 'O':
                        case 'U':
                            consonant = 'a';
                            break;
                        default:
                            consonant = chars[++i];
                    }
                    sb.append(' ');
                }
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
