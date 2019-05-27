package leetcode;

public class _424_2 {

    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        char[] c = s.toCharArray();
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[c[end] - 'A']);
            if (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            } else
                maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        _424_2 test = new _424_2();
        System.out.println(test.characterReplacement("ABAB", 2));
        System.out.println(test.characterReplacement("AABABBA", 1));
        System.out.println(test.characterReplacement("AABA", 0));
        System.out.println(test.characterReplacement("ABAA", 0));
        System.out.println(test.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
    }
}
