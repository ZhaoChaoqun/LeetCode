package leetcode;

public class _424 {

    public int characterReplacement(String s, int k) {
        if(k >= s.length() - 1) return s.length();
        char[] c = s.toCharArray();
        int[] frequency = new int[26];
        int l = 0, r = 0;
        // c[l~r-1]是替换k次后，'A' + maxIndex字串中出现次数最多的字符。
        int max = r - l + 1;
        for(int maxIndex = 0, count = 0; r < c.length; r++) {
            // count <= k，右移r，扩大窗口
            if(count <= k) {
                for(; r < c.length; r++) {
                    if(maxIndex == c[r] - 'A') {    // c[r]是当前出现最多次的字符
                        frequency[maxIndex]++;
                    } else if(frequency[c[r] - 'A'] == frequency[maxIndex]) {   // c[r]是当前比maxIndex出现多1次的字符。
                        maxIndex = c[r] - 'A';
                        frequency[maxIndex]++;
                    } else {
                        frequency[c[r] - 'A']++;
                        if(++count > k)
                            break;
                    }
                }
                max = Math.max(max, r - l);
            }
            // frequency > count，多了1次，移动l，缩小窗口
            for(; l < c.length; l++) {
                if(c[l] - 'A' != maxIndex) {    // 被替换字符，count--
                    count--;
                    frequency[c[l++] - 'A']--;
                    break;
                } else {
                    int anotherMaxIndex = 0;
                    for(; anotherMaxIndex < 26; anotherMaxIndex++) {
                        if(frequency[anotherMaxIndex] == frequency[maxIndex] && anotherMaxIndex != maxIndex)
                            break;
                    }
                    if(anotherMaxIndex != 26) { // 若存在其他maxIndex
                        maxIndex = anotherMaxIndex;
                        count--;
                        frequency[c[l++] - 'A']--;
                        break;
                    } else {
                        frequency[maxIndex]--;
                    }

                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        _424 test = new _424();
        System.out.println(test.characterReplacement("ABAB", 2));
        System.out.println(test.characterReplacement("AABABBA", 1));
        System.out.println(test.characterReplacement("AABA", 0));
        System.out.println(test.characterReplacement("ABAA", 0));
        System.out.println(test.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
    }
}
