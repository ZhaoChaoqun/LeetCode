package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _5083_2 {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        String[] words = text.split(" ");
        for(int i = 2; i < words.length; i++) {
            if(words[i-2].equals(first) && words[i-1].equals(second))
                result.add(words[i]);
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {

        _5083_2 test = new _5083_2();
        System.out.println(Arrays.toString(test.findOcurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(test.findOcurrences("we will we will rock you", "we", "will")));
    }
}
