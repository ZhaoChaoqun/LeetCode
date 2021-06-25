package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/19 12:21 下午
 */
public class _418_2 {

    public static void main(String[] args) {
        _418_2 test = new _418_2();
        System.out.println(test.wordsTyping(new String[] {"hello", "world"}, 2, 8));
        System.out.println(test.wordsTyping(new String[] {"a", "bcd", "e"}, 3, 6));
        System.out.println(test.wordsTyping(new String[] {"I", "had", "apple", "pie"}, 4, 5));
        System.out.println(test.wordsTyping(new String[] {"a"}, 40000, 50001));

    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] length = new int[sentence.length];
        for (int i = 0; i < sentence.length; ++i) {
            length[i] = sentence[i].length();
        }
        TreeSet<int[]>[] treeSet = new TreeSet[sentence.length];
        for (int i = sentence.length - 1; i >= 0; --i) {
            treeSet[i] = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
            int total = 0;
            for (int j = i; j < sentence.length; ++j) {
                total += length[j] + 1;
                if (total > cols + 1) {
                    break;
                }
                treeSet[i].add(new int[] {total, j});
            }
        }
        int index = 0, times = 0;
        for (int i = 0; i < rows; ++i) {
            int remain = cols + 1;
            int[] chars;
            for (; true; ) {
                chars = treeSet[index].floor(new int[] {remain});
                if (chars == null) {
                    break;
                }
                index = chars[1] + 1;
                if (index == sentence.length) {
                    index = 0;
                    ++times;
                }
                remain -= chars[0];
            }

        }
        return times;
    }
}
