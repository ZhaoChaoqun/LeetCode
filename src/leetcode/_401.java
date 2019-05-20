package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _401 {


    public static void main(String[] args) {
        System.out.println(new _401().readBinaryWatch(1));
    }

    List<String> minute(int num) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 60; i++) {
            if(Integer.bitCount(i) == num)
                result.add(String.format("%02d", i));
        }
        return result;
    }
    List<String> hour(int num) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 12; i++) {
            if(Integer.bitCount(i) == num)
                result.add(String.format("%d", i));
        }
        return result;
    }

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        int i = 0;
        if(num > 6)
            i = num - 6;
//        11的二进制最多3个1
        for(; i <= num && i < 4; i++) {
            for(String hour : hour(i))
                for(String minute: minute(num - i))
                    result.add(hour + ":" + minute);
        }
        return result;
    }
}
