package leetcode;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author 赵超群
 * @Date: 2021/6/25 1:21 下午
 */
public class _97 {
    public static void main(String[] args) {
//        System.out.println(new _97().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
//        System.out.println(new _97().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(new _97().isInterleave("abababababababababababababababababababababababababababababababababababababababababababababababababbb",
                "babababababababababababababababababababababababababababababababababababababababababababababababaaaba",
                "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb"));
    }
    char[] array1;
    char[] array2;
    char[] array3;
    public boolean isInterleave(String s1, String s2, String s3) {
        array1 = s1.toCharArray();
        array2 = s2.toCharArray();
        array3 = s3.toCharArray();
        if (array1.length + array2.length != array3.length) {
            return false;
        }
        return backtracking(0,0,0);
    }
    private boolean backtracking(int i, int j, int k) {
        if (k == array3.length)
            return true;
        if (i < array1.length && array1[i] == array3[k]) {
            if (backtracking(i + 1, j, k + 1))
                return true;
        }
        if (j < array2.length && array2[j] == array3[k]) {
            if (backtracking(i, j + 1, k + 1))
                return true;
        }
        return false;
    }
}
