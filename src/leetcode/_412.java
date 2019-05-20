package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _412 {

    public static void main(String[] args) {
        _412 test = new _412();
        System.out.println(test.fizzBuzz(15));
    }
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0) {
                if(i % 5 == 0) {
                    result.add("FizzBuzz");
                } else
                    result.add("Fizz");
            } else if(i % 5 == 0) {
                result.add("Buzz");
            } else
                result.add(Integer.toString(i));
        }
        return result;
    }
}
