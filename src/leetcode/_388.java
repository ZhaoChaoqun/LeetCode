package leetcode;

import java.util.LinkedList;

// 使用正则替换将4个空格替换成\t，方便后续处理 String转成char[]，提升效率
public class _388 {

    public static void main(String[] args) {
        System.out.println(new _388().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(new _388().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(new _388().lengthLongestPath("a.ext"));
        System.out.println(new _388().lengthLongestPath("file name with  space.txt"));
        System.out.println(new _388().lengthLongestPath("a\n\tb.txt\na2\n\tb2.txt"));
        System.out.println(new _388().lengthLongestPath("dir\n    file.txt"));
        System.out.println(new _388().lengthLongestPath("dir\n        file.txt"));
    }

    public int lengthLongestPath(String input) {
        if (input.indexOf('.') == -1)
            return 0;
        // 将4个空格替换成\t，方便后续处理
        input = input.replaceAll("\n    ", "\n\t");
        // String转成char[]，提升效率
        char[] chars = input.toCharArray();
        boolean isFile = false;
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\n') {
                if (isFile) {
                    isFile = false;
                    int fileLength = i - start;
                    if (!stack.isEmpty())
                        fileLength += stack.peek();
                    max = Math.max(max, fileLength);
                }
                // next - index + 1: next-index，表示目录名长度，+1表示'/'
                if (stack.isEmpty()) {
                    stack.push(i - start + 1);
                } else {
                    stack.push(stack.peek() + i - start + 1);
                }
                // count存\n后\t的个数，count等于stack的size表示：\t后的字符串是子目录或文件
                // count大于stack的size表示：\t后的目录是上层目录
                // count小于stack的size表示：\t后的字符串是兄弟目录
                int count = 1;
                for (; count + i < chars.length && chars[i + count] == '\t'; count++) ;
                if (--count > stack.size()) {
                    stack.push(stack.peek() + i - start + 1);
                } else {
                    for (int j = stack.size() - count; j > 0; j--)
                        stack.pop();
                }
                i += count;
                start = i + 1;
            } else if (chars[i] == '.') {
                isFile = true;
            }
        }
        // 处理字符串结尾
        if (isFile) {
            int fileLength = chars.length - start;
            if (!stack.isEmpty())
                fileLength += stack.peek();
            return Math.max(max, fileLength);
        }
        return max;

    }
}
