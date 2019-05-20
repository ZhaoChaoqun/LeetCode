package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhaochaoqun on 2017/6/20.
 */
public class TagValidator {

    static Pattern pattern = Pattern.compile("^<([A-Z]+)>([a-zA-Z0-9<>/!\\[\\] ]+)</\\1>$");
    static Pattern contentPattern = Pattern.compile("^([a-zA-Z0-9<>/!\\[\\] ]*)(<!\\[CDATA\\[[a-zA-Z0-9<>/!\\[\\] ]*\\]\\]>)*([a-zA-Z0-9<>/!\\[\\] ]+)*$");

    public static boolean isValid(String code) {
        Matcher matcher = pattern.matcher(code);
        if(matcher.matches()) {
            return isSubValid(matcher.group(2));
        }
        return false;
    }

    private static boolean isSubValid(String code) {
        Matcher matcher = pattern.matcher(code);
        if (matcher.matches()) {
            return isSubValid(matcher.group(2));
        } else {
            if("".equals(code))
                return false;
            matcher = contentPattern.matcher(code);
            return false;
        }
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^<([A-Z]+)>([a-zA-Z0-9<>/!\\[\\] ]+)</\\1>$");
        Matcher matcher = pattern.matcher("<DIV><ABC></DIV></ABC>");
        System.out.println(matcher.matches());
        if(matcher.matches()) {
            System.out.println(matcher.group(2));
        }
    }
}
