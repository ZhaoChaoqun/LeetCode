package leetcode;

import java.util.LinkedList;

// 不使用正则替换，效率最高的做法
public class _388_3 {

    public static void main(String[] args) {
        System.out.println(new _388_3().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(new _388_3().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(new _388_3().lengthLongestPath("a.ext"));
        System.out.println(new _388_3().lengthLongestPath("file name with  space.txt"));
        System.out.println(new _388_3().lengthLongestPath("a\n\tb.txt\na2\n\tb2.txt"));
        System.out.println(new _388_3().lengthLongestPath("dir\n    file.txt"));
        System.out.println(new _388_3().lengthLongestPath("dir\n        file.txt"));
    }

    public int lengthLongestPath(String input) {
        if (input.indexOf('.') == -1)
            return 0;
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
                int count = 0;
                if(chars[i + 1] == '\t') {
                    count++;
                    i += 1;
                } else if(chars[i + 1] == ' ' && i + 4 < chars.length && chars[i+1] == ' ' && chars[i+2] == ' ' && chars[i+3] == ' ' && chars[i+4] == ' ') {
                    // 其实这样写有bug，仅替换\n后的4个空格，如果\n后有x组连续4空格，没有判断是否可以替换x组
                    count++;
                    i += 4;
                } else {
                    i++;
                }
                for (; count + i < chars.length && chars[i + count] == '\t'; count++);
                if (count > stack.size()) {
                    stack.push(stack.peek() + i - start + 1);
                } else {
                    for (int j = stack.size() - count; j > 0; j--)
                        stack.pop();
                }
                start = i + count;
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
