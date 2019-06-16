package leetcode;

public class _686_2 {

    public int repeatedStringMatch(String a, String b) {
        int aLength = a.length(), bLength = b.length();
        int i = 1;
        for(; i * aLength < bLength; i++);
        StringBuilder sb = new StringBuilder(a);
        for(int j = i - 1; j > 0; j--)
            sb.append(a);
        if(sb.indexOf(b) != -1)
            return i;
        sb.append(a);
        if(sb.indexOf(b) != -1)
            return i + 1;
        return -1;
    }

    public static void main(String[] args) {
        _686_2 test = new _686_2();
        System.out.println(test.repeatedStringMatch("abc", "abcabcabc"));
//        System.out.println(test.repeatedStringMatch("abc", "bcabcabcabca"));
        System.out.println(test.repeatedStringMatch("abcd", "cdabcdab"));
//        System.out.println(test.repeatedStringMatch("abcd", "dabcdab"));
//        System.out.println(test.repeatedStringMatch("abc", "cabcabca"));
//        System.out.println(test.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba"));
//        System.out.println(test.repeatedStringMatch("bb", "bbbbbbb"));
//        System.out.println(test.repeatedStringMatch("abaabaa", "abaababaab"));
//        System.out.println(test.repeatedStringMatch("abc", "aabcbabcc"));
//        System.out.println(test.repeatedStringMatch("abab", "aba"));
//        System.out.println(test.repeatedStringMatch("abcd", "bc"));
    }
}
