package leetcode;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/19 12:21 下午
 */
public class _418_3 {

    public static void main(String[] args) {
        _418_3 test = new _418_3();
        System.out.println(test.wordsTyping(new String[] {"hello", "world"}, 2, 8));
        System.out.println(test.wordsTyping(new String[] {"a", "bcd", "e"}, 3, 6));
        System.out.println(test.wordsTyping(new String[] {"I", "had", "apple", "pie"}, 4, 5));
        System.out.println(test.wordsTyping(new String[] {"a"}, 40000, 50001));

    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        // 从第 i 个词开始 这一行能放下几遍句子
        int[] dp = new int[sentence.length];
        // 从第 i 个词开始 放下dp[i]遍句子后 变为第几个词
        int[] next = new int[sentence.length];

        for (int i = 0; i < sentence.length; ++i) {
            int count = 0;
            int ptr = i;
            int cur = cols;
            while (cur >= sentence[ptr].length()) {
                cur -= sentence[ptr].length() + 1;
                ++ptr;
                if (ptr == sentence.length) {
                    ++count;
                    ptr = 0;
                }
            }
            dp[i] = count;
            next[i] = ptr;
        }

        int count = 0;
        int cur = 0;
        for (int i = 0; i < rows; ++i) {
            count += dp[cur];
            cur = next[cur];
        }
        return count;
    }
}
