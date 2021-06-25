package leetcode;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/19 12:21 下午
 */
public class _418 {

    public static void main(String[] args) {
        _418 test = new _418();
        System.out.println(test.wordsTyping(new String[] {"hello", "world"}, 2, 8));
        System.out.println(test.wordsTyping(new String[] {"a", "bcd", "e"}, 3, 6));
        System.out.println(test.wordsTyping(new String[] {"I", "had", "apple", "pie"}, 4, 5));

    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] length = new int[sentence.length];
        for (int i = 0; i < sentence.length; ++i) {
            length[i] = sentence[i].length();
        }
        int index = 0, times = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = cols; j > 0; ) {
                int size = length[index];
                if (j < cols) {
                    ++size;
                }
                if (size > j) {
                    break;
                } else {
                    j -= size;
                }
                if (++index == length.length) {
                    index = 0;
                    ++times;
                }
            }
        }
        return times;
    }
}
