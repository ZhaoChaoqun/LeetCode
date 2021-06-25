package leetcode;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/19 12:21 下午
 */
public class _418_4 {

    public static void main(String[] args) {
        _418_4 test = new _418_4();
        System.out.println(test.wordsTyping(new String[] {"hello", "world"}, 2, 8));
        System.out.println(test.wordsTyping(new String[] {"a", "bcd", "e"}, 3, 6));
        System.out.println(test.wordsTyping(new String[] {"I", "had", "apple", "pie"}, 4, 5));
        System.out.println(test.wordsTyping(new String[] {"a"}, 40000, 50001));

    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int totalLength = sentence.length - 1;
        for (int i = 0; i < sentence.length; ++i) {
            totalLength += sentence[i].length();
        }
//        System.out.println(totalLength);
        if (cols % (totalLength + 1) == 0) {
            return rows * cols / (totalLength + 1);
        }
        if (cols % (totalLength + 1) == totalLength) {
            return rows * (cols / (totalLength + 1) + 1);
        }
        // 从第i个词开始，至行尾，可以发下几遍句子
        int[] times = new int[sentence.length];
        // 到行末尾时，下一个词的index
        int[] next = new int[sentence.length];
        for (int i = 0; i < sentence.length; ++i) {
            int length = cols + 1;
            for (int j = i; true;) {
                length -= 1 + sentence[j].length();
                // 到达行尾时，更新下一行开始时的sequence index
                if (length < 0) {
                    next[i] = j;
                    break;
                }
                if (++j == sentence.length) {
                    ++times[i];
                    j = 0;
                }
            }
        }
//        System.out.println(Arrays.toString(times));
//        System.out.println(Arrays.toString(next));
        int count = 0;
        int index = 0;
        for (int i = 0; i < rows; ++i) {
            count += times[index];
            index = next[index];
        }
        return count;
    }
}
