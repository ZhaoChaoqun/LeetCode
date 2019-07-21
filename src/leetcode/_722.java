package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _722 {

    List<String> result = new ArrayList<>();
    boolean commentBlockInner = false;
    boolean newLine = true;

    private void addToResult(boolean newLine, String value) {
        if(newLine)
            result.add(value);
        else
            result.set(result.size() - 1, result.get(result.size() - 1) + value);
    }
    public List<String> removeComments(String[] source) {
        int from = 0;
        for(int i = 0; i < source.length; i++) {
            String line = source[i];
            if(!commentBlockInner) {
                int doubleSlash = line.indexOf("//", from);
                int commentBlockBegin = line.indexOf("/*", from);
                if(doubleSlash == -1 && commentBlockBegin == -1) {  // 无注释
                    addToResult(newLine, line.substring(from));
                    from = 0;
                    newLine = true;
                    continue;
                }
                if(commentBlockBegin == -1 || doubleSlash != -1 && doubleSlash < commentBlockBegin) {    // 注释行
                    if(doubleSlash != from) {
                        addToResult(newLine, line.substring(from, doubleSlash));
                    }
                    from = 0;
                    newLine = true;
                } else {    // 注释块
                    if(commentBlockBegin != from) {
                        addToResult(newLine, line.substring(from, commentBlockBegin));
                        newLine = false;
                    }
                    commentBlockInner = true;
                    int commentBlockEnd = line.indexOf("*/", commentBlockBegin + 2);
                    if(commentBlockEnd > -1) {
                        commentBlockInner = false;
                        if(commentBlockEnd + 2 < line.length()) {
                            i--;
                            from = commentBlockEnd + 2;
                        } else {
                            from = 0;
                            newLine = true;
                        }
                    }
                }

            } else {
                int commentBlockEnd = line.indexOf("*/", from);
                if(commentBlockEnd > -1) {
                    commentBlockInner = false;
                    if(commentBlockEnd + 2 < line.length()) {
                        i--;
                        from = commentBlockEnd + 2;
                    } else {
                        from = 0;
                        newLine = true;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String[] source = new String[] {"/*/dadb/*/aec*////*//*ee*//*//b*////*badbda//*bbacdbbd*//ceb//*cdd//**//de*////*",
                "ec//*//*eebd/*/*//*////*ea/*/bc*//cbdacbeadcac/*/cee*//bcdcdde*//adabeaccdd//*"};
        _722 test = new _722();
        System.out.println(test.removeComments(source));
    }
}
