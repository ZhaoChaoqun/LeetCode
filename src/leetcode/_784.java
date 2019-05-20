package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _784 {

    public static void main(String[] args) {
        _784 test = new _784();
        System.out.println(test.letterCasePermutation("a1b2"));
        System.out.println(test.letterCasePermutation("A1B2"));
        System.out.println(test.letterCasePermutation("3z4"));
        System.out.println(test.letterCasePermutation("3Z4"));
        System.out.println(test.letterCasePermutation(""));
    }

    public List<String> letterCasePermutation(String s) {
        List<char[]> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length];
        System.arraycopy(chars, 0, newChars, 0, chars.length);
        list.add(newChars);
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] >= 'a' && chars[j] <= 'z') {
                int size = list.size();
                for(int i = 0; i < size; i++) {
                    newChars = new char[chars.length];
                    System.arraycopy(list.get(i), 0, newChars, 0, chars.length);
                    newChars[j] -= 32;
                    list.add(newChars);
                }
            } else if (chars[j] >= 'A' && chars[j] <= 'Z') {
                int size = list.size();
                for(int i = 0; i < size; i++) {
                    newChars = new char[chars.length];
                    System.arraycopy(list.get(i), 0, newChars, 0, chars.length);
                    newChars[j] += 32;
                    list.add(newChars);
                }
            }
        }
        List<String> result = new ArrayList<>(list.size());
        for (char[] item : list)
            result.add(new String(item));
        return result;
    }

}
