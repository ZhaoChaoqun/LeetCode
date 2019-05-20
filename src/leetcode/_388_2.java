package leetcode;

import java.util.LinkedList;

// 使用正则替换，并且纯String操作，效率较低
public class _388_2 {

    public static void main(String[] args) {
        System.out.println(new _388_2().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(new _388_2().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(new _388_2().lengthLongestPath("a.ext"));
        System.out.println(new _388_2().lengthLongestPath("file name with  space.txt"));
        System.out.println(new _388_2().lengthLongestPath("a\n\tb.txt\na2\n\tb2.txt"));
        System.out.println(new _388_2().lengthLongestPath("dir\n    file.txt"));
        System.out.println(new _388_2().lengthLongestPath("dir\n        file.txt"));
    }

    public int lengthLongestPath(String input) {
        if (input.indexOf('.') == -1)
            return 0;
        // 将4个空格替换成\t，方便后续处理
        input = input.replaceAll("\n    ", "\n\t");
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int index = 0; index < input.length(); ) {
            int next = input.indexOf("\n", index);
            if (next == -1) {
                if (new String(input.toCharArray(), index, input.length() - index).indexOf('.') != -1) {
                    int fileSize = input.length() - index + 1;
                    if (!stack.isEmpty())
                        fileSize += stack.peek();
                    return Math.max(max, fileSize) - 1;
                } else
                    return max - 1;
            }
            // next - index + 1: next-index，表示目录名长度，+1表示'/'
            if (stack.isEmpty())
                stack.push(next - index + 1);
            else
                stack.push(stack.peek() + next - index + 1);
            if (new String(input.toCharArray(), index, next - index).indexOf('.') != -1)
                max = Math.max(max, stack.peek());

            int i = next + 1;
            for (; i < input.length() && input.charAt(i) == '\t'; i++) ;
            // count存\n后\t的个数，count等于stack的size表示：\t后的字符串是子目录或文件
            // count大于stack的size表示：\t后的目录是上层目录
            // count小于stack的size表示：\t后的字符串是兄弟目录

            int count = i - next - 1;
            if (count == stack.size()) {
//                continue;
            } else if (count > stack.size()) {
                stack.push(stack.peek() + next - index + 1);
            } else {
                for (int j = stack.size() - count; j > 0; j--)
                    stack.pop();
//                stack.push(stack.peek() + next - index);
            }
            index = next + 1 + count;
        }
        return 0;

    }
}
