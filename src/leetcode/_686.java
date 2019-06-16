package leetcode;

public class _686 {
    public int repeatedStringMatch(String a, String b) {
        if(a.contains(b)) return 1;
        int aLength = a.length();
        int bLength = b.length();
        int result = Integer.MAX_VALUE;
        for(int i = 0; i <= Math.min(aLength, bLength); i++) {
            // b的前缀是否等于a的后缀
            if(b.substring(0, i).equals(a.substring(aLength - i))) {
                int count = i == 0 ? 0 : 1;
                for(; i < bLength; i += aLength) {
                    if(b.substring(i, Math.min(i + aLength, bLength)).equals(a.substring(0, Math.min(aLength, bLength - i))))
                        count++;
                    else
                        break;
                }
                if(i >= bLength) {
                    if(count == 1) return count;
                    result = Math.min(count, result);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        _686 test = new _686();
//        System.out.println(test.repeatedStringMatch("abc", "abcabcabc"));
//        System.out.println(test.repeatedStringMatch("abc", "bcabcabcabca"));
//        System.out.println(test.repeatedStringMatch("abcd", "cdabcdab"));
//        System.out.println(test.repeatedStringMatch("abcd", "dabcdab"));
//        System.out.println(test.repeatedStringMatch("abc", "cabcabca"));
//        System.out.println(test.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba"));
//        System.out.println(test.repeatedStringMatch("bb", "bbbbbbb"));
//        System.out.println(test.repeatedStringMatch("abaabaa", "abaababaab"));
//        System.out.println(test.repeatedStringMatch("abc", "aabcbabcc"));
//        System.out.println(test.repeatedStringMatch("abab", "aba"));
        System.out.println(test.repeatedStringMatch("abcd", "bc"));
    }
}
