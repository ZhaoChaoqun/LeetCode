package leetcode;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/20 1:54 下午
 */
public class Demo {
    public static void main(String[] args) {
        int a = 0, i = 0, j = 0;
        for (int k = 0; k < 3; ++k) {
            LABEL_1:
            for (i = 0; i < 10; i++) {
                for (j = 0; j < 10; j++) {
                    a = j * i;
                    if (a == 5) {
                        break LABEL_1;
                    }
                }
            }
        }

        System.out.println(String.format("i=%d, j=%d", i, j));
    }

}
