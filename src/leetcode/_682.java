package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _682 {

    public static void main(String[] args) {
        _682 test = new _682();
        System.out.println(test.calPoints(new String[] {"5","2","C","D","+"}));
        System.out.println(test.calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
    }
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        for(String op : ops) {
            if ("+".equals(op)) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else if ("D".equals(op)) {
                list.add(list.get(list.size() - 1) * 2);
            } else if ("C".equals(op)) {
                list.remove(list.size() - 1);
            } else {
                list.add(Integer.valueOf(op));
            }
        }
        int sum = 0;
        for(Integer score : list)
            sum += score;
        return sum;
    }
}
