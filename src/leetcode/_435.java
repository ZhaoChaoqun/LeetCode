package leetcode;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class _435 {

    public static void main(String[] args) {
        _435 test = new _435();
        System.out.println(test.eraseOverlapIntervals(new Interval[] {new Interval(1,2), new Interval(2,3), new Interval(3,4), new Interval(1,3)}));
        System.out.println(test.eraseOverlapIntervals(new Interval[] {new Interval(1,2), new Interval(1,2), new Interval(1,2)}));
        System.out.println(test.eraseOverlapIntervals(new Interval[] {new Interval(1,2), new Interval(2,3)}));

    }
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        int count = 0;
        for(int index = 0; index < intervals.length;) {
            int i = index + 1;
            for(; i < intervals.length && intervals[i].start < intervals[index].end; i++);
            count += i - index - 1;
            index = i;
        }
        return count;
    }

}
