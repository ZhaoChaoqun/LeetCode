package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _5083 {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("((\\w+ )*)" + first + " " + second + " (\\w+)" + "( \\w+)*");
        Matcher matcher = pattern.matcher(text);
        while (matcher.matches()) {
            result.add(0, matcher.group(3));
            text = text.substring(0, matcher.start(3) - 1);
            matcher = pattern.matcher(text);
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {

        _5083 test = new _5083();
        System.out.println(Arrays.toString(test.findOcurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(test.findOcurrences("we will we will rock you", "we", "will")));
    }
}
