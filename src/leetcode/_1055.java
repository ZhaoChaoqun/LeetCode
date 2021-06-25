package leetcode;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/21 11:34 上午
 */
public class _1055 {
    public static void main(String[] args) {
        _1055 test = new _1055();
        System.out.println(test.shortestWay("abc", "abcbc"));
        System.out.println(test.shortestWay("abc", "acdbc"));
        System.out.println(test.shortestWay("xyz", "xzyxz"));
    }

    public int shortestWay(String source, String target) {
        int M = source.length(), N = target.length();
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();
        int count = 0;
        for (int i = 0; i < N;) {
            int startI = i;
            for (int j = 0; j < M && i < N; ++j) {
                if (sourceArray[j] == targetArray[i]) {
                    ++i;
                }
            }
            if (startI == i) {
                return -1;
            }
            ++count;
        }
        return count;
    }
}
