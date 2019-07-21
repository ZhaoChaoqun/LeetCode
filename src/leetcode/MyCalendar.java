package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    List<int[]> list = new ArrayList<>();
    public MyCalendar() {
    }
    private int binarySearch(int start, int left, int right) {
        if(left >= right) return left;
        int mid = (left + right) >>> 1;
        int[] item = list.get(mid);
        if((mid == 0 || list.get(mid - 1)[0] < start) && (item[0] >= start))
            return mid;
        if(item[0] >= start) {
            return binarySearch(start, left, mid);
        }
        return binarySearch(start, mid + 1, right);
    }
    public boolean book(int start, int end) {
        if(list.isEmpty()) {
            list.add(new int[] {start, end});
            return true;
        }
        int index = binarySearch(start, 0, list.size());
        if(index < list.size() && (list.get(index)[0] == start || end > list.get(index)[0]))
            return false;
        if(index > 0 && list.get(index - 1)[1] > start)
            return false;
        list.add(index, new int[] {start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // returns true
        System.out.println(myCalendar.book(15, 25)); // returns false
        System.out.println(myCalendar.book(20, 30)); // returns true

    }
}
