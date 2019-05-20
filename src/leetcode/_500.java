package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _500 {

    public static void main(String[] args) {
        System.out.println('a' - 'A');
        System.out.println(Arrays.toString(new _500().findWords(new String[] {"Hello", "Alaska", "Dad", "Peace"})));
    }

    public String[] findWords(String[] words) {
        int[] array = new int[] {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3,0,0,0,0,0,0,2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> list = new ArrayList<>();
        for(String word : words) {
            char[] chars = word.toCharArray();
            int level = array[chars[0] - 'A'];
            int i = 1;
            for(; i < chars.length; i++)
                if(array[chars[i] - 'A'] != level)
                    break;
            if(i == chars.length)
                list.add(word);
        }
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }
}
